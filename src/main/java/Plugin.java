import java.io.File;
/** Represents a hMod/CanaryMod plugin. */
public abstract class Plugin {
	public abstract void disable();

	public abstract void enable();

	public File getDirectory() {
		return null;
	}

	public File getFile(String filetype) {
		return null;
	}

	public String getName() {
		return "";
	}

	public PropertiesFile getPropertiesFile() {
		return null;
	}

	public PropertiesFile getPropertiesFile(String filename) {
		return null;
	}

	public File getTxtFile() {
		return null;
	}

	public File getTxtFile(String filename) {
		return null;
	}

	public void initialize() {
	}

	public boolean isEnabled() {
		return true;
	}

	public void setName(String name) {
	}

	public boolean toggleEnabled() {
		return true;
	}

}
