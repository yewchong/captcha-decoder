package chankinwing.captcha.decoder.splitter;

import java.awt.image.BufferedImage;

public interface ISplittable {
	public BufferedImage[] split(BufferedImage image, int length);
}
