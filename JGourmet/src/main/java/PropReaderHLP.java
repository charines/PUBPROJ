/**
 * Singleton para leitura do arquivo de propriedades
 * 
 * Laboratorio para validacao em aptidao JAVA
 * 
 * 
 * @author Charles Rodrigues
 * @version 1.0, 2/2/2021
 * <pre>
 * https://www.linkedin.com/in/charlesrodrigues/
 * </pre>
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author pc-one
 *
 */
public class PropReaderHLP {

	private static PropReaderHLP instance;
	public String value;

	private PropReaderHLP() {

	}
	
	public String getValue(String value) {
		Properties prop = new Properties();
		InputStream input = getClass().getResourceAsStream("config.properties");
		try {
			prop.load(input);
			String valuetoreturn = prop.getProperty(value).toString();
			input.close();
			return valuetoreturn;
		} catch (IOException e) {
			this.value = "-40001";
		}
		return value;
	}


	public static PropReaderHLP getInstance() {
		if (instance == null) {
			instance = new PropReaderHLP();
		}
		return instance;
	}
}
