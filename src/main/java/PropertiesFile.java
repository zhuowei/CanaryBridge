public class PropertiesFile {

	public PropertiesFile(String fileName) {
	}

	public void load() {
	}

	public void save() {
	}

	public String getString(String key) {
		return getString(key, null);
	}

	public String getString(String key, String value) {
		return value;
	}

	public boolean getBoolean(String key) {
		return Boolean.parseBoolean(getString(key));
	}

	public boolean getBoolean(String key, boolean value) {
		return Boolean.parseBoolean(getString(key, Boolean.toString(value)));
	}

	public int getInt(String key) {
		return Integer.parseInt(getString(key));
	}

	public int getInt(String key, int value) {
		return Integer.parseInt(getString(key, Integer.toString(value)));
	}

	public double getDouble(String key) {
		return Double.parseDouble(getString(key));
	}

	public double getDouble(String key, double val) {
		return Double.parseDouble(getString(key, Double.toString(val)));
	}

}
