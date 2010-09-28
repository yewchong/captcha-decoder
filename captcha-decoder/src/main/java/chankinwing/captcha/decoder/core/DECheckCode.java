package chankinwing.captcha.decoder.core;

import java.awt.image.BufferedImage;

public class DECheckCode {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			BufferedImage image = Tools.getImage("checkCode/check" + i + ".bmp");
			System.out.print("check" + i + ".bmp == ");
			compare(image);
			System.out.println("");
		}
	}

	public static void compare(BufferedImage image) {
		BufferedImage checkCode[] = Tools.getCheckCodes(image);

		for (int t = 0; t < 4; t++) {
			boolean ckFlg = true;
			int num = -1;

			for (int i = 0; i < 10; i++) {
				num = -1;
				ckFlg = true;
				BufferedImage testImage = Tools.getImage("check" + (t + 1) + "/" + i + ".bmp");

				if (testImage == null) {
					continue;
				}

				for (int y = 0; y < checkCode[t].getHeight(); ++y) {
					for (int x = 0; x < checkCode[t].getWidth(); ++x) {
						int expRGB = Tools.pixelConvert(checkCode[t].getRGB(x, y));
						int cmpRGB = Tools.pixelConvert(testImage.getRGB(x, y));
						if (expRGB != cmpRGB) {
							ckFlg = false;
							break;
						}
					}
				}

				if (ckFlg) {
					num = i;
					break;
				}
			}
			if (ckFlg) {
				System.out.print(num);
			} else {
				System.out.print("x");
				Tools.writeImageToFile("C:/temp/studyImg-" + t + ".bmp", checkCode[t]);
			}
		}
	}
}
