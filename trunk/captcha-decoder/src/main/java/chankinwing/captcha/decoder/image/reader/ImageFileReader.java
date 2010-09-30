package chankinwing.captcha.decoder.image.reader;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.google.inject.Singleton;

@Singleton
public class ImageFileReader implements IReadable {
	private final Log logger = LogFactory.getLog(getClass());

	@Override
	public BufferedImage read(File imgFile) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(imgFile);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return image;
	}

}
