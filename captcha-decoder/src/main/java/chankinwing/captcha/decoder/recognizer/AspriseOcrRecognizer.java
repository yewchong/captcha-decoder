package chankinwing.captcha.decoder.recognizer;

import java.awt.image.BufferedImage;

import com.asprise.util.ocr.OCR;
import com.google.inject.Singleton;

@Singleton
public class AspriseOcrRecognizer implements IRecognizable {

	@Override
	public String recognize(BufferedImage image) {
		return new OCR().recognizeCharacters(image);
	}

}
