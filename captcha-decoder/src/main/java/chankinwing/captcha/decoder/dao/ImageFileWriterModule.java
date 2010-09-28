package chankinwing.captcha.decoder.dao;

import com.google.inject.Binder;
import com.google.inject.Module;

public class ImageFileWriterModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IReadable.class).to(ImageFileReader.class);

	}

}
