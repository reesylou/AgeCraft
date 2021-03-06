package org.agecraft.core.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.agecraft.ACUtil;
import org.agecraft.core.gui.InventoryCraftMatrix;

public abstract class RecipeShapeless extends RecipeSimple {

	public ArrayList<ItemStack> input;
	public ItemStack output;
	
	public RecipeShapeless(ItemStack output, Object... input) {
		super();
		this.output = output;
		
		this.input = new ArrayList<ItemStack>();
		for(int i = 0; i < input.length; i++) {
			if(input[i] instanceof ItemStack) {
				this.input.add((ItemStack) input[i]);
			} else if(input[i] instanceof Block) {
				this.input.add(new ItemStack((Block) input[i]));
			} else if(input[i] instanceof Item) {
				this.input.add(new ItemStack((Item) input[i]));
			}
		}
	}
	
	public boolean matches(InventoryCraftMatrix inventory) {
		ArrayList<ItemStack> list = new ArrayList<ItemStack>(input);
		for(int i = 0; i < inventory.width; i++) {
			for(int j = 0; j < inventory.height; j++) {
				ItemStack stack = inventory.getStackInRowAndColumn(i, j);
				if(stack != null) {
					boolean flag = false;
					Iterator<ItemStack> iterator = list.iterator();
					while(iterator.hasNext()) {
						ItemStack currentStack = iterator.next();
						if(ACUtil.areItemStacksEqualNoSize(stack, currentStack)) {
							flag = true;
							list.remove(currentStack);
							break;
						}
					}
					if(!flag) {
						return false;
					}
				}
			}
		}
		return list.isEmpty();
	}
	
	@Override
	public List<WrappedStack> getInput() {
		return WrappedStack.createList(input);
	}

	@Override
	public List<WrappedStack> getOutput() {
		return WrappedStack.createList(output);
	}

	@Override
	public int getRecipeSize() {
		return input.size();
	}
}
