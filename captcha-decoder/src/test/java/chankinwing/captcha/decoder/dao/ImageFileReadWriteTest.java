package chankinwing.captcha.decoder.dao;

import java.awt.image.BufferedImage;
import java.io.File;

import chankinwing.captcha.decoder.image.reader.IReadable;
import chankinwing.captcha.decoder.image.reader.ImageFileReaderModule;
import chankinwing.captcha.decoder.image.writer.IWritable;
import chankinwing.captcha.decoder.image.writer.ImageFileWriterModule;
import chankinwing.captcha.decoder.util.Constant;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ImageFileReadWriteTest {

	private static final String OUTPUT_FORMAT = "jpg";

	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new ImageFileReaderModule(),
				new ImageFileWriterModule());
		IReadable reader = injector.getInstance(IReadable.class);
		IWritable writer = injector.getInstance(IWritable.class);

		BufferedImage image = reader.read(new File(Constant.PATH_FOLDER_ORIGINAL + "src0.jpg"));
		writer.write(image, OUTPUT_FORMAT, new File(Constant.PATH_FOLDER_PROCESSED + "processed1.jpg"));

	}
}
