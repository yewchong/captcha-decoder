package chankinwing.captcha.decoder.recognizer;

import chankinwing.captcha.decoder.util.Constant;

import com.google.inject.Binder;
import com.google.inject.Module;

public class AspriseOcrRecognizerModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IRecognizable.class).to(AspriseOcrRecognizer.class);
		binder.bind(String.class).annotatedWith(AspriseOcrLibraryPath.class)
				.toInstance(Constant.PATH_ASPRISE_LIBRARY);
	}

}
