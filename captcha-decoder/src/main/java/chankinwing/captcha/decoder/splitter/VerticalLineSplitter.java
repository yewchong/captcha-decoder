package chankinwing.captcha.decoder.splitter;

import java.awt.image.BufferedImage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Singleton;

@Singleton
public class VerticalLineSplitter implements ISplittable {
	private final Log logger = LogFactory.getLog(getClass());
	private final static int COLOR_BLACK = -16777216;
	private final static int COLOR_WHITE = -1;
	private final static int MAX_CHAR_WIDTH = 25;

	public BufferedImage[] split(BufferedImage filteredImage, int length) {
		logger.info("===ImageSplitter===");
		BufferedImage splitImage[] = new BufferedImage[length];
		int width = filteredImage.getWidth();
		int height = filteredImage.getHeight();

		int count = 0;
		int startX = 0;
		int endX = 0;
		boolean isStarted = false;
		boolean isPreviousLineBlank = true;
		boolean isThisLineBlank = true;

		// Unimplemented better approach
		/*
		 * Use recursive call to look up the leftest and rightest edge each character
		 * --------------
		 * ------up------
		 * -left---right-
		 * -----down-----
		 * --------------
		 */

		for (int x = 0; x < width; x++) {

			// To solve two characters places on the same vertical line, set a max width on the word
			// if( isStarted ) {
			// int charWidth = x - startX;
			// if( charWidth > MAX_CHAR_WIDTH ) {
			// isThisLineBlank = !isPreviousLineBlank;
			// }
			// }

			// split the last chip if reach end of width
			// if (x == (width - 1)) {
			// isThisLineBlank = !isPreviousLineBlank;
			// }

			// check vertical line difference to split character
			if (isPreviousLineBlank != isThisLineBlank) {
				if (!isStarted) {
					startX = x;
					isStarted = true;
				} else {
					endX = x;
					logger.debug("char(" + startX + ", " + endX + ")");
					if (count < length) {
						splitImage[count++] = filteredImage.getSubimage(startX, 0, endX - startX,
								height);
					} else {
						break;
					}
					isStarted = false;
				}
				isPreviousLineBlank = isThisLineBlank;
				isThisLineBlank = true;
			}
			for (int y = 0; y < height; y++) {
				int rgbPixel = filteredImage.getRGB(x, y);
				logger.trace("point(" + x + ", " + y + ")" + ", RGB: " + rgbPixel);
				if (rgbPixel == COLOR_BLACK) {
					isThisLineBlank = false;
					break;
				}
				isThisLineBlank = true;
			}
		}
		return splitImage;
	}
}
