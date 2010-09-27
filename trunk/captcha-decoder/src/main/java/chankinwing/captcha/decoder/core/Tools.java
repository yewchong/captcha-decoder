package chankinwing.captcha.decoder.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class Tools {
	public static void writeImageToFile(String imgFile, BufferedImage bi) {

		Iterator<ImageWriter> writers = ImageIO
				.getImageWritersByFormatName(imgFile.substring(imgFile.lastIndexOf('.') + 1));
		ImageWriter writer = (ImageWriter) writers.next();

		File f = new File(imgFile);
		ImageOutputStream ios;

		try {
			ios = ImageIO.createImageOutputStream(f);
			writer.setOutput(ios);
			writer.write(bi);
			ios.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static int pixelConvert(int pixel) {
		int result = 0;

		// ?��?R/G/B
		int r = (pixel >> 16) & 0xff;
		int g = (pixel >> 8) & 0xff;
		int b = (pixel) & 0xff;

		// 默认黑色
		result = 0xff000000;

		int tmp = r * r + g * g + b * b;
		if (tmp > 3 * 128 * 128) {
			// ?�色，全F
			result += 0x00ffffff;
		}

		return result;
	}

	public static BufferedImage getImage(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
		}

		return image;
	}

	public static BufferedImage[] getCheckCodes(BufferedImage image) {
		BufferedImage checkCode[] = new BufferedImage[4];
		int height = image.getHeight();
		int width = image.getWidth();
		checkCode[0] = image.getSubimage(0 * (width / checkCode.length), 0, width / checkCode.length, height);
		checkCode[1] = image.getSubimage(1 * (width / checkCode.length) + 1, 0, width / checkCode.length - 1, height);
		checkCode[2] = image.getSubimage(2 * (width / checkCode.length), 0, width / checkCode.length - 3, height);
		checkCode[3] = image.getSubimage(3 * (width / checkCode.length) - 2, 0, width / checkCode.length, height);

		return checkCode;
	}
}
