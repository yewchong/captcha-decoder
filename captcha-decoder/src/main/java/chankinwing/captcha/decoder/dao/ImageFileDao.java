package chankinwing.captcha.decoder.dao;

import java.awt.image.BufferedImage;
import java.io.File;

import chankinwing.captcha.decoder.image.reader.ImageFileReader;
import chankinwing.captcha.decoder.image.writer.ImageFileWriter;

import com.google.inject.Inject;

public class ImageFileDao {
	@Inject
	private ImageFileReader reader;
	@Inject
	private ImageFileWriter writer;

	public BufferedImage read(File imgFile) {
		return reader.read(imgFile);
	}

	public void write(BufferedImage srcImage, String formatName, File target) {
		writer.write(srcImage, formatName, target);
	}
}
