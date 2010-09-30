package chankinwing.captcha.decoder.image.writer;

import chankinwing.captcha.decoder.image.reader.IReadable;
import chankinwing.captcha.decoder.image.reader.ImageFileReader;

import com.google.inject.Binder;
import com.google.inject.Module;

public class ImageFileWriterModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IReadable.class).to(ImageFileReader.class);

	}

}
