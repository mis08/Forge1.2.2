package com.tntmodders.tutorial;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = "aluminiummod", version = "2.0", name = "AluminiumMod")
public class AluminiumMod {
	
	@Instance("aluminiummod")
	public static AluminiumMod instance;
	

    public static Item ALUMINIUM;
    public static Item EXPBOW;
    public static Item EXPARROW;
    public static Item DRILLINGARROW;
    
 	@SidedProxy(clientSide = "com.tntmodders.tutorial.ClientProxy",serverSide = "com.tntmodders.tutorial.ServerProxy")   
    public static CommonProxy proxy; 

    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	ALUMINIUM =new ItemAluminium().setUnlocalizedName("aluminium").setRegistryName(new ResourceLocation("aluminiummod","aluminium"));
    	EXPBOW = new ExpBow().setUnlocalizedName("expbow").setRegistryName(new ResourceLocation("aluminiummod","expbow"));
    	EXPARROW = new ExpArrow().setUnlocalizedName("exparrow").setRegistryName(new ResourceLocation("aluminiummod","exparrow"));
    	DRILLINGARROW = new DrillingArrow().setUnlocalizedName("drillingarrow").setRegistryName(new ResourceLocation("aluminiummod","drillingarrow"));
    	
    	EntityRegistry.registerModEntity(new ResourceLocation("aluminiummod","entityexparrow"),EntityTippedExpArrow.class, "exparrow", 3, this, 64, 5, true);
    	EntityRegistry.registerModEntity(new ResourceLocation("aluminiummod","entitydrillingarrow"), EntityTippedDrillingArrow.class, "drillingarrow", 4, this, 64, 20, true);
    	proxy.registerRenderes();
    	MinecraftForge.EVENT_BUS.register(this);
    	proxy.registerRenderThings();

    
    	
    	ForgeRegistries.ITEMS.register(ALUMINIUM);
    	ForgeRegistries.ITEMS.register(EXPBOW);
    	ForgeRegistries.ITEMS.register(EXPARROW);
    	ForgeRegistries.ITEMS.register(DRILLINGARROW);
    	
    	if(event.getSide().isClient()) {
    		registerModels();
    	}
    }
   
    @SideOnly(Side.CLIENT)
    public void registerModels() {
    	net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(ALUMINIUM, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation("aluminiummod:aluminium","inventory"));
       	net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(EXPBOW, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation("aluminiummod:expbow","inventory"));
       	net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(EXPARROW, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation("aluminiummod:exparrow","inventory"));
       	net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(DRILLINGARROW, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation("aluminiummod:drillingarrow","inventory"));
       	
       	
    }
    

    
}