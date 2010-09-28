package chankinwing.captcha.decoder.dao;

import java.io.File;

public interface IWritable<T> {
	public void write(T t, File target);
}