package chankinwing.captcha.decoder.filter;

import java.awt.image.BufferedImage;
import java.io.File;

import chankinwing.captcha.decoder.dao.ImageFileReader;
import chankinwing.captcha.decoder.dao.ImageFileReaderModule;
import chankinwing.captcha.decoder.dao.ImageFileWriter;
import chankinwing.captcha.decoder.dao.ImageFileWriterModule;
import chankinwing.captcha.decoder.util.Constant;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ImageFilterTest {

	public static void main(String args[]) {
		Injector injector = Guice.createInjector(new ImageFilterModule(),
				new ImageFileReaderModule(), new ImageFileWriterModule());
		ImageFileReader reader = injector.getInstance(ImageFileReader.class);
		ImageFileWriter writer = injector.getInstance(ImageFileWriter.class);
		ImageFilter filter = injector.getInstance(ImageFilter.class);

		BufferedImage image = reader.read(new File(Constant.PATH_IMG_FOLDER + "src1.jpg"));
		image = filter.filter(image);
		writer.write(image, "JPG", new File(Constant.PATH_IMG_FOLDER + "filter1.jpg"));
	}
}
