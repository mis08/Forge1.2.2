package com.tntmodders.tutorial;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class ClientProxy implements CommonProxy {
	public void registerRenderes() {
		RenderingRegistry.registerEntityRenderingHandler(EntityExpArrow.class,RenderExpArrow::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityDrillingArrow.class,RenderDrillingArrow::new);
		
	}

	public void registerRenderThings() {
	}

}