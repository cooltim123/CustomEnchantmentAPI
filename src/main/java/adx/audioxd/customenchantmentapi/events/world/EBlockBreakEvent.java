package adx.audioxd.customenchantmentapi.events.world;


import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.ItemStack;

import adx.audioxd.customenchantmentapi.enchantment.event.extra.EnchantmentEventWithOwnerAndItem;

public class EBlockBreakEvent extends EnchantmentEventWithOwnerAndItem implements Cancellable {
	private Block block;
	public Block getBlock() {
		return block;
	}

	private int ExpToDrop = 0;
	public int getExpToDrop() {
		return ExpToDrop;
	}
	public void setExpToDrop(int expToDrop) {
		ExpToDrop = expToDrop;
	}

	private boolean cancelled = false;
	public boolean isCancelled() {
		return cancelled;
	}
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public EBlockBreakEvent(int lvl, ItemStack item, LivingEntity owner, Block block, int exp) {
		super(lvl, owner, item);
		this.block = block;
		this.ExpToDrop = exp;
	}

}
