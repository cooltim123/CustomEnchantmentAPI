package adx.audioxd.customenchantmentapi.events.world;


import adx.audioxd.customenchantmentapi.enchantment.event.extra.EnchantmentEventWithOwnerAndItem;
import adx.audioxd.customenchantmentapi.events.inventory.hand.enums.HandType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class EInteractEvent extends EnchantmentEventWithOwnerAndItem implements Cancellable {
	private final HandType handType;
	private boolean cancelled = false;
	private Action action;
	private BlockFace blockFace;
	private Block clickedBlock;

	public EInteractEvent(int lvl, ItemStack item, LivingEntity owner, Action action, BlockFace blockFace,
	                      Block clickedBlock, HandType handType) {
		super(lvl, owner, item);
		this.action = action;
		this.blockFace = blockFace;
		this.clickedBlock = clickedBlock;
		this.handType = handType;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public Action getAction() {
		return action;
	}

	public BlockFace getBlockFace() {
		return blockFace;
	}

	public Block getClickedBlock() {
		return clickedBlock;
	}

	public HandType getHandType() {
		return handType;
	}
}
