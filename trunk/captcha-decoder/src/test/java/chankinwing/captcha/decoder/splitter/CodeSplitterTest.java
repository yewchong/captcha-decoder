package chankinwing.captcha.decoder.splitter;

import java.awt.image.BufferedImage;
import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chankinwing.captcha.decoder.dao.ImageFileReader;
import chankinwing.captcha.decoder.dao.ImageFileReaderModule;
import chankinwing.captcha.decoder.dao.ImageFileWriter;
import chankinwing.captcha.decoder.dao.ImageFileWriterModule;
import chankinwing.captcha.decoder.filter.ImageFilter;
import chankinwing.captcha.decoder.filter.UstSportsFacilityBookingImageFilterModule;
import chankinwing.captcha.decoder.util.Constant;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CodeSplitterTest {

	private static final Log logger = LogFactory.getLog(CodeSplitterTest.class);

	private static final int VALIDATION_CODE_LENGTH = 6;
	private static final String OUTPUT_FORMAT = "jpg";

	public static void main(String args[]) {

		Injector injector = Guice.createInjector(new ImageFileReaderModule(),
				new ImageFileWriterModule(), new UstSportsFacilityBookingImageFilterModule(),
				new CodeSplitterModule());

		ImageFileReader reader = injector.getInstance(ImageFileReader.class);
		ImageFileWriter writer = injector.getInstance(ImageFileWriter.class);
		ImageFilter filter = injector.getInstance(ImageFilter.class);
		CodeSplitter splitter = injector.getInstance(CodeSplitter.class);

		BufferedImage vImage = reader.read(new File(Constant.PATH_FOLDER_ORIGINAL + "src8.jpg"));
		BufferedImage filteredImage = filter.filter(vImage);
		BufferedImage[] splitImages = splitter.split(filteredImage, VALIDATION_CODE_LENGTH);
		for (int i = 0; i < VALIDATION_CODE_LENGTH; i++) {
			if (splitImages[i] != null) {
				writer.write(splitImages[i], OUTPUT_FORMAT, new File(Constant.PATH_FOLDER_SPLIT
						+ "char" + i + "." + OUTPUT_FORMAT));
			}
		}
	}
}
