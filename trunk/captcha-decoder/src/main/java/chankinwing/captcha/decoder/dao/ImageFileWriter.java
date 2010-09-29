package chankinwing.captcha.decoder.dao;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Singleton;

@Singleton
public class ImageFileWriter implements IWritable {
	private final Log logger = LogFactory.getLog(getClass());

	@Override
	public void write(BufferedImage srcImage, String formatName, File target) {
		try {
			ImageIO.write(srcImage, formatName, target);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
