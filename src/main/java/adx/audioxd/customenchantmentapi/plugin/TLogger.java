package adx.audioxd.customenchantmentapi.plugin;


import adx.audioxd.customenchantmentapi.CustomEnchantmentAPI;
import adx.audioxd.customenchantmentapi.utils.GameLogger;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import java.util.logging.Level;

public class TLogger extends GameLogger {
	private final Plugin plugin;
	private boolean PUBLIC = true;
	public boolean isPublic() { return PUBLIC; }
	public <T extends TLogger>T setPublic(boolean isPublic) {
		PUBLIC = isPublic;
		return (T) this;
	}

	// Constructor
	public TLogger(Plugin plugin) {
		this.plugin = plugin;
	}

	public void log(Level ll, String message) {
		CustomEnchantmentAPI.getCEAPILogger().log(ll, "<" + plugin.getName() + ">: " + message);
		if(PUBLIC) plugin.getLogger().log(ll, message);
	}

	public void preEnabled(boolean enabled) {
		if(enabled) {
			PluginDescriptionFile p = plugin.getDescription();
			info(p.getName() + " Version: " + p.getVersion() + " Is being Enabled!");
		} else {
			PluginDescriptionFile p = plugin.getDescription();
			info(p.getName() + " Version: " + p.getVersion() + " Is being Disabled!");
		}
	}
	public void enabled(boolean enabled) {
		if(enabled) {
			PluginDescriptionFile p = plugin.getDescription();
			info(p.getName() + " Version: " + p.getVersion() + " Has ben Enabled!");
		} else {
			PluginDescriptionFile p = plugin.getDescription();
			info(p.getName() + " Version: " + p.getVersion() + " Has ben Disabled!");
		}
	}
}
