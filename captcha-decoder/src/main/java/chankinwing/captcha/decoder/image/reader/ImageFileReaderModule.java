package chankinwing.captcha.decoder.image.reader;

import chankinwing.captcha.decoder.image.writer.IWritable;
import chankinwing.captcha.decoder.image.writer.ImageFileWriter;

import com.google.inject.Binder;
import com.google.inject.Module;

public class ImageFileReaderModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IWritable.class).to(ImageFileWriter.class);

	}

}
