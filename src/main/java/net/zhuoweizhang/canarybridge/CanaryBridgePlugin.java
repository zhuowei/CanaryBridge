package net.zhuoweizhang.canarybridge;

import java.io.File;

import org.spout.api.plugin.CommonPlugin;
import org.spout.api.plugin.PluginDescriptionFile;
public class CanaryBridgePlugin extends CommonPlugin {
	private PluginDescriptionFile pdfFile;

	public File canaryPluginFolder;

	@Override
	public void onDisable() {
		getLogger().info(pdfFile.getFullName() + " has been disabled!");
	}

	@Override
	public void onEnable() {
		canaryPluginFolder = new File(this.getDataFolder(), "plugins");
		if (!canaryPluginFolder.exists()) {
			canaryPluginFolder.mkdirs();
		}
		pdfFile = getDescription();
		getLogger().info(pdfFile.getFullName() + " has been enabled!");
		try {
		Object loader = Class.forName("PluginLoader").getConstructor(CanaryBridgePlugin.class).newInstance(this);
		Class.forName("PluginLoader").getMethod("loadPlugin", String.class).invoke(loader, "WorldEdit");
		Class.forName("PluginLoader").getMethod("enablePlugin", String.class).invoke(loader, "WorldEdit");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
