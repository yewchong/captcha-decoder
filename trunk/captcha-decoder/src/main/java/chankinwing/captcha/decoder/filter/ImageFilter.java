package chankinwing.captcha.decoder.filter;

import java.awt.image.BufferedImage;

import com.google.inject.Singleton;

@Singleton
public class ImageFilter {

	private static final int FILTER_UPPER_THRESHOLD = 0;
	private static final int FILTER_LOWER_THRESHOLD = -5000000;

	public BufferedImage filter(BufferedImage image) {
		BufferedImage filteredImage = image;
		int width = image.getWidth();
		int height = image.getHeight();

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int rgbPixel = filteredImage.getRGB(x, y);
				// grey background
				if (rgbPixel > FILTER_LOWER_THRESHOLD && rgbPixel < FILTER_UPPER_THRESHOLD) {
					filteredImage.setRGB(x, y, 0xFFFFFF);
				} else {
					filteredImage.setRGB(x, y, 0x000000);
				}
			}
		}
		return filteredImage;
	}
}
