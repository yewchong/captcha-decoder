package chankinwing.captcha.decoder.dao;

import java.io.File;

public interface IReadable<T> {
	public T read(File file);
}
