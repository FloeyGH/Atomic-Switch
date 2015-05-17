package Floey.AtomicSwitch.Core;

import Floey.AtomicSwitch.GameObjects.GameObjects;
import Floey.AtomicSwitch.World.ASWorldGen;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = AtomicSwitchCore.MODID, name = AtomicSwitchCore.NAME, version = AtomicSwitchCore.VERSION)
public class AtomicSwitchCore
{
    public static final String MODID = "AtomicSwitch";
    public static final String NAME = "Atomic Switch";
    public static final String VERSION = "1.4.7.3";

    @Mod.Instance(MODID)
    public static AtomicSwitchCore instance;

    @SidedProxy(clientSide = "Floey.AtomicSwitch.Core.ClientProxy", serverSide = "Floey.AtomicSwitch.Core.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        GameObjects.Objcs();
        GameObjects.ObjcsCraft();
        GameObjects.ObjcsCraftAtomic();

        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        System.out.println("Load Config");
        config.load();
        config.save();
    }

    @EventHandler
    public void load(FMLPostInitializationEvent event)
    {
        GameRegistry.registerWorldGenerator(new ASWorldGen(), 0);
        AchievementHandler.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

}
