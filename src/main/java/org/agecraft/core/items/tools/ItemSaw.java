package org.agecraft.core.items.tools;

import net.minecraft.item.ItemStack;
import codechicken.microblock.Saw;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSaw extends ItemTool implements Saw {

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldRotateAroundWhenRendering() {
		return true;
	}

	@Override
	public int getCuttingStrength(ItemStack stack) {
		return getToolHarvestLevel(stack);
	}

	@Override
	public int getMaxCuttingStrength() {
		return 10;
	}
}
