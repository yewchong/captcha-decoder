package chankinwing.captcha.decoder.image.reader;

import java.awt.image.BufferedImage;
import java.io.File;

public interface IReadable {
	public BufferedImage read(File file);
}
