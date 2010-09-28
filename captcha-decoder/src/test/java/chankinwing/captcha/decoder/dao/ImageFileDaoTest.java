package chankinwing.captcha.decoder.dao;

import java.awt.image.BufferedImage;
import java.io.File;

import chankinwing.captcha.decoder.util.Constant;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ImageFileDaoTest {
	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new ImageFileReaderModule());
		ImageFileDao imageFileDao = injector.getInstance(ImageFileDao.class);

		BufferedImage image = imageFileDao.read(new File(Constant.PATH_IMG_FOLDER + "src0.bmp"));
		imageFileDao.write(image, new File(Constant.PATH_IMG_FOLDER + "out0.bmp"));

	}
}
