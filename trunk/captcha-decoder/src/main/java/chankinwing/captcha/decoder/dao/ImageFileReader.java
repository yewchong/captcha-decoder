package chankinwing.captcha.decoder.dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Singleton;

@Singleton
public class ImageFileReader implements IReadable<BufferedImage> {
	private final Log logger = LogFactory.getLog(getClass());

	@Override
	public BufferedImage read(File imgFile) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(imgFile);
		} catch (IOException e) {
			logger.error("cannot open image");
		}
		return image;
	}

}
