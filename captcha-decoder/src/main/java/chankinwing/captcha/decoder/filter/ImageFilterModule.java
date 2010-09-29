package chankinwing.captcha.decoder.filter;

import com.google.inject.Binder;
import com.google.inject.Module;

public class ImageFilterModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(ImageFilter.class);

	}

}
