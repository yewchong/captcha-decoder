package chankinwing.captcha.decoder.filter;

import java.awt.image.BufferedImage;
import java.io.File;

import chankinwing.captcha.decoder.image.reader.IReadable;
import chankinwing.captcha.decoder.image.reader.ImageFileReaderModule;
import chankinwing.captcha.decoder.image.writer.IWritable;
import chankinwing.captcha.decoder.image.writer.ImageFileWriterModule;
import chankinwing.captcha.decoder.util.Constant;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ImageFilterTest {

	public static void main(String args[]) {
		Injector injector = Guice.createInjector(new UstSportsFacilityBookingImageFilterModule(),
				new ImageFileReaderModule(), new ImageFileWriterModule());
		IReadable reader = injector.getInstance(IReadable.class);
		IWritable writer = injector.getInstance(IWritable.class);
		ImageFilter filter = injector.getInstance(ImageFilter.class);

		for (int i = 0; i < 15; i++) {
			BufferedImage image = reader.read(new File(Constant.PATH_FOLDER_ORIGINAL + "src" + i
					+ ".jpg"));
			image = filter.filter(image);
			writer.write(image, "JPG", new File(Constant.PATH_FOLDER_FILTERED + "filter" + i
					+ ".jpg"));
		}
	}
}
