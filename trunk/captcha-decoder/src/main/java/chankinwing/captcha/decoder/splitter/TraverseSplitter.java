package chankinwing.captcha.decoder.splitter;

import java.awt.image.BufferedImage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Singleton;

@Singleton
public class TraverseSplitter implements ISplittable {

	private final Log logger = LogFactory.getLog(getClass());

	private final static int COLOR_BLACK = -16777216;
	// private final static int COLOR_WHITE = -1;

	private BufferedImage processingImage;
	private boolean[][] isTraverse;

	private int startX = 0;
	private int endX = 0;
	private int width = 0;
	private int height = 0;

	public BufferedImage[] split(BufferedImage filteredImage, int length) {
		logger.info("===ImageSplitter===");
		BufferedImage splitImage[] = new BufferedImage[length];
		processingImage = filteredImage;

		width = filteredImage.getWidth();
		height = filteredImage.getHeight();

		int count = 0;

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int rgbPixel = filteredImage.getRGB(x, y);
				if (rgbPixel == COLOR_BLACK) {
					clear();
					startX = x;
					endX = x;
					startX = traverseLeft(x, y);
					endX = traverseRight(x, y);
					if (count < length) {
						if (endX - startX > 0) {
							splitImage[count++] = filteredImage.getSubimage(startX, 0, endX
									- startX, height);
						}
					} else {
						break;
					}
					// prevent x out of bound
					if (endX + 1 < width) {
						x = endX + 1;
					}
				}
			}
		}
		return splitImage;
	}

	private int traverseLeft(int x, int y) {
		isTraverse[x][y] = true;
		if (x < startX) {
			startX = x;
		}
		// upper
		if (y > 0) {
			if ((processingImage.getRGB(x, y - 1) == COLOR_BLACK) && (!isTraverse[x][y - 1])) {
				traverseLeft(x, y - 1);
			}
		}
		// lower
		if (y < height - 1) {
			if ((processingImage.getRGB(x, y + 1) == COLOR_BLACK) && (!isTraverse[x][y + 1])) {
				traverseLeft(x, y + 1);
			}
		}
		// left
		if (x > 0) {
			if ((processingImage.getRGB(x - 1, y) == COLOR_BLACK) && (!isTraverse[x - 1][y])) {
				traverseLeft(x - 1, y);
			}
		}
		return startX;
	}

	private int traverseRight(int x, int y) {
		isTraverse[x][y] = true;
		if (x > endX) {
			endX = x;
		}
		// upper
		if (y > 0) {
			if ((processingImage.getRGB(x, y - 1) == COLOR_BLACK) && (!isTraverse[x][y - 1])) {
				traverseRight(x, y - 1);
			}
		}
		// lower
		if (y < height - 1) {
			if ((processingImage.getRGB(x, y + 1) == COLOR_BLACK) && (!isTraverse[x][y + 1])) {
				traverseRight(x, y + 1);
			}
		}
		// right
		if (x < width - 1) {
			if ((processingImage.getRGB(x + 1, y) == COLOR_BLACK) && (!isTraverse[x + 1][y])) {
				traverseRight(x + 1, y);
			}
		}
		return endX;
	}

	private void clear() {
		isTraverse = new boolean[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				isTraverse[i][j] = false;
			}
		}
	}
}
