package chankinwing.captcha.decoder.image.writer;

import java.awt.image.BufferedImage;
import java.io.File;

public interface IWritable {
	public void write(BufferedImage image, String format, File target);
}
