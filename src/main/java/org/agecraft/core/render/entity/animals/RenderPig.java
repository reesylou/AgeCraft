package org.agecraft.core.render.entity.animals;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderPig extends RenderLiving {

	public static ResourceLocation texture = new ResourceLocation("agecraft", "textures/entity/animals/pig/pig.png");
	
	public RenderPig(ModelBase model1, float f) {
		super(model1, f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
