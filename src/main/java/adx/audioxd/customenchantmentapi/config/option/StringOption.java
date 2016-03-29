package adx.audioxd.customenchantmentapi.config.option;


import org.bukkit.ChatColor;
import adx.audioxd.customenchantmentapi.config.Config;

public class StringOption {
	private final String path;
	private String value;

	public String getPath() {
		return path;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public StringOption(String path, String value) {
		this.path = path;
		this.value = value;
	}

	public final String format(String... o) {
		String out = String.format(value, (Object[]) o);
		return ChatColor.translateAlternateColorCodes('�', out);
	}

	public final void loadIfExist(Config config) {
		loadIfExist(config, this);
	}

	public static final void loadIfExist(Config config, StringOption option) {
		if (config.getConfig().isSet(option.getPath())) {
			option.setValue(config.getConfig().getString(option.getPath()));
		} else {
			save(config, option);
			config.save();
		}
	}

	public final void save(Config config) {
		save(config, this);
	}

	public static final void save(Config config, StringOption option) {
		config.getConfig().set(option.getPath(), option.getValue());
	}
}
