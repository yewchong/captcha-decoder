package chankinwing.captcha.decoder.recognizer;

import java.awt.image.BufferedImage;

import chankinwing.captcha.decoder.ocr.TesseractOcr;

import com.asprise.util.ocr.OCR;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class TesseractOcrRecognizer implements IRecognizable {
	private final TesseractOcr ocr;

	@Inject
	public TesseractOcrRecognizer( TesseractOcr ocr ) {
		this.ocr = ocr;
	}

	@Override
	public String recognize(BufferedImage image) {
		return "";
	}
}
