package chankinwing.captcha.decoder.splitter;

import com.google.inject.Binder;
import com.google.inject.Module;

public class OcrSplitterModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(ISplittable.class).to(OcrSplitter.class);
	}

}
