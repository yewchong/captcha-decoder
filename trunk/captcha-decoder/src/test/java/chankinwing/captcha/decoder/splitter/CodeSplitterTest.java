package chankinwing.captcha.decoder.splitter;

import java.awt.image.BufferedImage;
import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chankinwing.captcha.decoder.dao.ImageFileReader;
import chankinwing.captcha.decoder.dao.ImageFileReaderModule;
import chankinwing.captcha.decoder.dao.ImageFileWriter;
import chankinwing.captcha.decoder.dao.ImageFileWriterModule;
import chankinwing.captcha.decoder.util.Constant;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CodeSplitterTest {

	private static final Log logger = LogFactory.getLog(CodeSplitterTest.class);

	private static final int VALIDATION_CODE_LENGTH = 4;
	private static final String OUTPUT_FORMAT = "BMP";

	public static void main(String args[]) {

		Injector injector = Guice.createInjector(new ImageFileReaderModule(),
				new ImageFileWriterModule(), new CodeSplitterModule());

		ImageFileReader reader = injector.getInstance(ImageFileReader.class);
		ImageFileWriter writer = injector.getInstance(ImageFileWriter.class);
		CodeSplitter splitter = injector.getInstance(CodeSplitter.class);

		BufferedImage vImage = reader.read(new File(Constant.PATH_IMG_FOLDER + "src1.jpg"));
		logger.debug(vImage.getRGB(1, 1));
		vImage.setRGB(1, 1, 0);
		logger.debug(vImage.getRGB(15, 15));
		vImage.setRGB(15, 15, 0);
		logger.debug(vImage.getRGB(35, 15));
		vImage.setRGB(35, 15, 0xFFFFFF);
		logger.debug(vImage.getRGB(40, 15));
		vImage.setRGB(40, 15, 0);
		writer.write(vImage, OUTPUT_FORMAT, new File(Constant.PATH_IMG_FOLDER + "spiltter1.jpg"));
//		BufferedImage[] chips = splitter.split(vImage, VALIDATION_CODE_LENGTH);
//		for (int i = 0; i < VALIDATION_CODE_LENGTH; i++) {
//			writer.write(chips[i], OUTPUT_FORMAT, new File(Constant.PATH_IMG_FOLDER + "out" + i
//					+ ".bmp"));
//		}
	}
}
