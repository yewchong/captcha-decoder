package chankinwing.captcha.decoder.recognizer;

import java.awt.image.BufferedImage;

import chankinwing.captcha.decoder.util.Constant;

import com.asprise.util.ocr.OCR;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class AspriseOcrRecognizer implements IRecognizable {

	@Inject
	public AspriseOcrRecognizer(@AspriseOcrLibraryPath String libPath) {
		// OCR.setLibraryPath(libPath);
	}

	@Override
	public String recognize(BufferedImage image) {
		return new OCR().recognizeCharacters(image).trim().toLowerCase().replaceAll(" ", "");
	}
}
