package chankinwing.captcha.decoder.dao;

import java.awt.image.BufferedImage;
import java.io.File;

public interface IReadable {
	public BufferedImage read(File file);
}
