package adx.audioxd.customenchantmentapi.config.option;


import adx.audioxd.customenchantmentapi.config.Config;

public class BooleanOption {
	private final String path;
	private boolean value;

	// Constructor
	public BooleanOption(String path, boolean value) {
		this.path = path;
		this.value = value;
	}

	public final void loadIfExist(Config config) {
		loadIfExist(config, this);
	}

	public static void loadIfExist(Config config, BooleanOption option) {
		if(config.getConfig().isSet(option.getPath())) {
			option.setValue(config.getConfig().getBoolean(option.getPath()));
		} else {
			save(config, option);
			config.save();
		}
	}

	public String getPath() {
		return path;
	}

	public static void save(Config config, BooleanOption option) {
		config.getConfig().set(option.getPath(), option.getValue());
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public final void save(Config config) {
		save(config, this);
	}


	@Override
	public final boolean equals(Object o) {
		if(o == this) return true;
		if(o == null || getClass() != o.getClass()) return false;
		BooleanOption other = (BooleanOption) o;
		return getPath().equalsIgnoreCase(other.getPath());
	}
}
