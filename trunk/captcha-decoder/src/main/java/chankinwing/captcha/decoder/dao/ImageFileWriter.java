package chankinwing.captcha.decoder.dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Singleton;

@Singleton
public class ImageFileWriter implements IWritable<BufferedImage> {
	private final Log logger = LogFactory.getLog(getClass());

	@Override
	public void write(BufferedImage srcImage, File target) {
		try {
			ImageIO.write(srcImage, "BMP", target);
		} catch (IOException e) {
			logger.error("cannot create image");
		}
	}
}
