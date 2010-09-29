package chankinwing.captcha.decoder.recognizer;

import java.awt.image.BufferedImage;

public interface IRecognizable {
	public String recognize(BufferedImage image);
}
