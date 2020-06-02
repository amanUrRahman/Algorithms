package fileUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtils {

	public static Properties config = null;
	public InputStream fis = null;

	public FileUtils(String filePath) throws IOException {
		config = new Properties();
		fis = new FileInputStream(filePath);
		config.load(fis);

	}

	public String getSelectedBrowser() throws IOException {
		return String.valueOf(config.getProperty("browser"));
	}

	public String getSelectedUrl() throws IOException {
		return String.valueOf(config.getProperty("url"));
	}

}
