package chankinwing.captcha.decoder.filter;

import com.google.inject.Binder;
import com.google.inject.Module;

public class UstSportsFacilityBookingImageFilterModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(ImageFilter.class);
		binder.bind(Integer.class).annotatedWith(FilterUpperThreshold.class).toInstance(0);
		binder.bind(Integer.class).annotatedWith(FilterLowerThreshold.class).toInstance(-4500000);
	}

}
