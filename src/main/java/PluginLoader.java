import java.io.File;

import java.lang.reflect.Constructor;

import java.net.URL;
import java.net.URLClassLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.zhuoweizhang.canarybridge.CanaryBridgePlugin;

public class PluginLoader {

	public enum Hook {
		ARM_SWING,
		ATTACK,
		BAN,
		BLOCK_BROKEN,
		BLOCK_CREATED,
		BLOCK_DESTROYED,
		BLOCK_PHYSICS,
		BLOCK_PLACE,
		BLOCK_RIGHTCLICKED,
		CHAT,
		CHUNK_CREATE,
		CHUNK_LOADED,
		CHUNK_UNLOAD,
		COMMAND,
		COMMAND_CHECK,
		CONNECT,
		COW_MILK
	}

	public enum HookResult {
		ALLOW_ACTION,
		DEFAULT_ACTION,
		PREVENT_ACTION
	}

	private Map<String, Plugin> names = new HashMap<String, Plugin>();

	private List<Plugin> plugins = new ArrayList<Plugin>();

	private final CanaryBridgePlugin bridgePlugin;

	public PluginLoader(CanaryBridgePlugin bridgePlugin) {
		this.bridgePlugin = bridgePlugin;
	}

	public Plugin getPlugin(String name) {
		return names.get(name);
	}

	public boolean loadPlugin(String name) {
		try {
			File file = new File(bridgePlugin.canaryPluginFolder, name + ".jar");
			if (!file.exists()) {
				return false;
			}
			URL[] urls = new URL[] { file.toURI().toURL() };
			ClassLoader loader = new URLClassLoader(urls, getClass().getClassLoader());
			Class<?> main = Class.forName(name, true, loader);
			Class<? extends Plugin> plugin = main.asSubclass(Plugin.class);
			Constructor<? extends Plugin> constructor = plugin.getConstructor();
			Plugin result = constructor.newInstance();
			plugins.add(result);
			names.put(name, result);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void loadPlugins() {
	}

	public void loadPreloadPlugins() {
	}

	public boolean enablePlugin(String name) {
		getPlugin(name).enable();
		return true;
	}
}
