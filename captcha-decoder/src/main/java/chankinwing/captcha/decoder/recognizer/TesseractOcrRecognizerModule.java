package chankinwing.captcha.decoder.recognizer;

import com.google.inject.Binder;
import com.google.inject.Module;

public class TesseractOcrRecognizerModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IRecognizable.class).to(TesseractOcrRecognizer.class);
	}

}
