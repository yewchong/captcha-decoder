package chankinwing.captcha.decoder.dao;

import java.awt.image.BufferedImage;
import java.io.File;

import chankinwing.captcha.decoder.util.Constant;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ImageFileReadWriteTest {

	private static final String OUTPUT_FORMAT = "BMP";

	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new ImageFileReaderModule(), new ImageFileWriterModule());
		ImageFileReader reader = injector.getInstance(ImageFileReader.class);
		ImageFileWriter writer = injector.getInstance(ImageFileWriter.class);

		BufferedImage image = reader.read(new File(Constant.PATH_FOLDER_IMG + "src1.jpg"));
		writer.write(image, OUTPUT_FORMAT, new File(Constant.PATH_FOLDER_IMG + "out1.bmp"));

	}
}
