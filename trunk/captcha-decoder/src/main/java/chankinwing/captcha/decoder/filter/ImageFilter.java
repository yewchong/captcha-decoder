package chankinwing.captcha.decoder.filter;

import java.awt.image.BufferedImage;

import chankinwing.captcha.decoder.util.Constant;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ImageFilter {

	private final int FILTER_UPPER_THRESHOLD;
	private final int FILTER_LOWER_THRESHOLD;

	@Inject
	public ImageFilter(@FilterUpperThreshold int upper, @FilterLowerThreshold int lower) {
		FILTER_UPPER_THRESHOLD = upper;
		FILTER_LOWER_THRESHOLD = lower;
	}

	public BufferedImage filter(BufferedImage image) {
		BufferedImage filteredImage = image;
		int width = image.getWidth();
		int height = image.getHeight();

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int rgbPixel = filteredImage.getRGB(x, y);
				// turn grey background to white, code text to black
				if (rgbPixel > FILTER_LOWER_THRESHOLD && rgbPixel < FILTER_UPPER_THRESHOLD) {
					filteredImage.setRGB(x, y, Constant.COLOR_WHITE);
				} else {
					filteredImage.setRGB(x, y, Constant.COLOR_BLACK);
				}
			}
		}
		return filteredImage;
	}
}
