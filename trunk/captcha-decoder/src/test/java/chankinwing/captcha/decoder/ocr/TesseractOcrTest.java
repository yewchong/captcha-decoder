package chankinwing.captcha.decoder.ocr;

import java.io.File;

import chankinwing.captcha.decoder.util.Constant;

public class TesseractOcrTest {
	private static TesseractOcr ocr = new TesseractOcr();

	public static void main(String[] args) {
		try {
			ocr.recognizeText(new File(Constant.PATH_FOLDER_ORIGINAL + "src1"), "jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
