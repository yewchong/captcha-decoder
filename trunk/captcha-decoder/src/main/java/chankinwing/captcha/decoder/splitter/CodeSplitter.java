package chankinwing.captcha.decoder.splitter;

import java.awt.image.BufferedImage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Singleton;

@Singleton
public class CodeSplitter {
	private final Log logger = LogFactory.getLog(getClass());

	public BufferedImage[] split(BufferedImage image, int length) {
		logger.info("===ImageSplitter===");

		BufferedImage validationImage[] = new BufferedImage[length];
		int height = image.getHeight();
		int width = image.getWidth();

		logger.debug("height: " + height);
		logger.debug("width: " + width);

//		for (int i = 0; i < length; i++) {
//			validationImage[i] = image.getSubimage(i * (width / validationImage.length), i, width
//					/ validationImage.length, height);
//		}

		return validationImage;
	}
}
