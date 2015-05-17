package Floey.AtomicSwitch.GameObjects;

import Floey.AtomicSwitch.GameObjects.Blocks.BlockAtomiccus;
import Floey.AtomicSwitch.GameObjects.Blocks.BlockCoval;
import Floey.AtomicSwitch.GameObjects.Items.*;
import Floey.AtomicSwitch.GameObjects.Items.Coval.ItemCovalHigh;
import Floey.AtomicSwitch.GameObjects.Items.Coval.ItemCovalLow;
import Floey.AtomicSwitch.GameObjects.Items.Coval.ItemCovalMedium;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class GameObjects
{
    public static final CreativeTabs cTab = new CreativeTab();

    public static Block blockAtomiccus = new BlockAtomiccus().setCreativeTab(cTab);
    public static Block blockCoval = new BlockCoval().setCreativeTab(cTab);

    public static Item itemAtomicstone = new ItemAtomicstone();

    public static Item itemSoulEssenceJ = new ItemSoulEssenceJ();
    public static Item itemSoulEssenceM = new ItemSoulEssenceM();
    public static Item itemSoulEssenceL = new ItemSoulEssenceL();
    public static Item itemSoulEssenceO = new ItemSoulEssenceO();

    public static Item itemCovalLow = new ItemCovalLow();
    public static Item itemCovalMedium = new ItemCovalMedium();
    public static Item itemCovalHigh = new ItemCovalHigh();

    public static Item itemClockDay = new ItemClockDay();
    public static Item itemClockNight = new ItemClockNight();

    public static Item itemLavaAgg = new ItemLavaAgg();
    public static Item itemWaterAgg = new ItemWaterAgg();

    public static Item itemLifeHeart = new ItemLifeHeart();
    public static Item itemLifeHeartMK2 = new ItemLifeHeartMK2();
    public static Item itemLifeHeartMK3 = new ItemLifeHeartMK3();
    public static void Objcs()
    {
        GameRegistry.registerBlock(blockAtomiccus, "BlockAtomiccus");

        GameRegistry.registerItem(itemAtomicstone, "ItemAtomicstone");
        GameRegistry.registerItem(itemLifeHeart, "ItemLifeHeart");
        GameRegistry.registerItem(itemLifeHeartMK2, "ItemLifeHeartMK2");
        GameRegistry.registerItem(itemLifeHeartMK3, "ItemLifeHeartMK3");
        GameRegistry.registerItem(itemClockDay, "ItemClockDay");
        GameRegistry.registerItem(itemClockNight, "ItemClockNight");
        GameRegistry.registerItem(itemLavaAgg, "ItemLavaAgg");
        GameRegistry.registerItem(itemWaterAgg, "ItemWaterAgg");
        GameRegistry.registerItem(itemSoulEssenceM, "ItemSoulEssenceM");
        GameRegistry.registerItem(itemSoulEssenceO, "ItemSoulEssenceO");
        GameRegistry.registerItem(itemSoulEssenceL, "ItemSoulEssenceL");
        GameRegistry.registerItem(itemSoulEssenceJ, "ItemSoulEssenceJ");
        GameRegistry.registerItem(itemCovalLow, "ItemCovalLow");
        GameRegistry.registerItem(itemCovalMedium, "ItemCovalMedium");
        GameRegistry.registerItem(itemCovalHigh, "ItemCovalHigh");
        GameRegistry.registerBlock(blockCoval, ItemBlockCoval.class, "BlockCoval");

    }

    public static void ObjcsCraft()
    {
        GameRegistry.addRecipe(new ItemStack(itemAtomicstone), "beb","fdg","bhb", 'b', new ItemStack(itemCovalHigh), 'e', new ItemStack(itemSoulEssenceJ,1), 'd', Items.diamond,'f', new ItemStack(itemSoulEssenceM,1),'g', new ItemStack(itemSoulEssenceL,1),'h', new ItemStack(itemSoulEssenceO,1));
        GameRegistry.addRecipe(new ItemStack(itemClockDay), "gsg", "scs", "gsg", 's', new ItemStack(itemSoulEssenceJ,1), 'c', Items.clock, 'g', Blocks.glowstone);
        GameRegistry.addRecipe(new ItemStack(itemClockNight), "oso", "scs", "oso", 's', new ItemStack(itemSoulEssenceL,1), 'c', Items.clock, 'o', Blocks.obsidian);
        GameRegistry.addRecipe(new ItemStack(itemLavaAgg), "se ","ele"," ee", 'e', Items.iron_ingot, 'l', Items.lava_bucket,'s', new ItemStack(itemSoulEssenceO,1));
        GameRegistry.addRecipe(new ItemStack(itemWaterAgg), "se ","ele"," ee", 'e', Items.iron_ingot, 'l', Items.water_bucket,'s', new ItemStack(itemSoulEssenceM,1));

        //Soul
        GameRegistry.addRecipe(new ItemStack(itemSoulEssenceO), "se","ee", 'e', new ItemStack(itemCovalLow), 's',  new ItemStack(itemSoulEssenceM,1));
        GameRegistry.addRecipe(new ItemStack(itemSoulEssenceL), "se","ee", 'e', new ItemStack(itemCovalMedium), 's',  new ItemStack(itemSoulEssenceO,1));
        GameRegistry.addRecipe(new ItemStack(itemSoulEssenceJ), "se","ee", 'e', new ItemStack(itemCovalHigh), 's',  new ItemStack(itemSoulEssenceL,1));

        //Coval
        GameRegistry.addShapelessRecipe(new ItemStack(itemCovalLow,15),Items.redstone, new ItemStack(Items.dye,1,2));
        GameRegistry.addShapelessRecipe(new ItemStack(itemCovalMedium,10),Items.redstone, new ItemStack(Items.dye,1,4));
        GameRegistry.addShapelessRecipe(new ItemStack(itemCovalHigh,5), Items.redstone, new ItemStack(Items.dye,1,5));

        //Heart
        GameRegistry.addRecipe(new ItemStack(itemLifeHeart), "hsh", "sas", "hsh", 's', new ItemStack(itemSoulEssenceO,1), 'a', Items.golden_apple, 'h', new ItemStack(itemCovalLow));
        GameRegistry.addRecipe(new ItemStack(itemLifeHeartMK2), "hsh", "sas", "hsh", 's', new ItemStack(itemSoulEssenceL,1), 'a', new ItemStack(itemLifeHeart),'h', new ItemStack(itemCovalMedium));
        GameRegistry.addRecipe(new ItemStack(itemLifeHeartMK3), "hsh", "sas", "hsh", 's', new ItemStack(itemSoulEssenceJ,1), 'a', new ItemStack(itemLifeHeartMK2),'h', new ItemStack(itemCovalHigh));

        //Coval Block
        GameRegistry.addRecipe(new ItemStack(blockCoval), "dd", "dd", 'd', new ItemStack(itemCovalLow));
        GameRegistry.addRecipe(new ItemStack(itemCovalLow,4), "d", 'd', new ItemStack(blockCoval));

        GameRegistry.addRecipe(new ItemStack(blockCoval,1,1), "ff", "ff", 'f', new ItemStack(itemCovalMedium));
        GameRegistry.addRecipe(new ItemStack(itemCovalMedium,4), "f", 'f', new ItemStack(blockCoval,1,1));

        GameRegistry.addRecipe(new ItemStack(blockCoval,1,2), "gg", "gg", 'g', new ItemStack(itemCovalHigh));
        GameRegistry.addRecipe(new ItemStack(itemCovalHigh,4), "g", 'g', new ItemStack(blockCoval,1,2));
    }

    public static void ObjcsCraftAtomic()
    {
        //Wood
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks), new ItemStack(itemAtomicstone),new ItemStack (Items.stick),new ItemStack (Items.stick),new ItemStack (Items.stick),new ItemStack (Items.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.log), new ItemStack(itemAtomicstone), new ItemStack(Blocks.planks), new ItemStack(Blocks.planks), new ItemStack(Blocks.planks), new ItemStack(Blocks.planks));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.log,1,1), new ItemStack(itemAtomicstone), new ItemStack(Blocks.planks,1,1), new ItemStack(Blocks.planks,1,1), new ItemStack(Blocks.planks,1,1), new ItemStack(Blocks.planks,1,1));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.log,1,2), new ItemStack(itemAtomicstone), new ItemStack(Blocks.planks,1,2), new ItemStack(Blocks.planks,1,2), new ItemStack(Blocks.planks,1,2), new ItemStack(Blocks.planks,1,2));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.log,1,3), new ItemStack(itemAtomicstone), new ItemStack(Blocks.planks,1,3), new ItemStack(Blocks.planks,1,3), new ItemStack(Blocks.planks,1,3), new ItemStack(Blocks.planks,1,3));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.log2), new ItemStack(itemAtomicstone), new ItemStack(Blocks.planks,1,4), new ItemStack(Blocks.planks,1,4), new ItemStack(Blocks.planks,1,4), new ItemStack(Blocks.planks,1,4));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.log2,1,1), new ItemStack(itemAtomicstone), new ItemStack(Blocks.planks,1,5), new ItemStack(Blocks.planks,1,5), new ItemStack(Blocks.planks,1,5), new ItemStack(Blocks.planks,1,5));

        //Slaps
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.double_stone_slab), new ItemStack(itemAtomicstone), new ItemStack(Blocks.stone_slab), new ItemStack(Blocks.stone_slab));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stone_slab,2), new ItemStack(itemAtomicstone), new ItemStack(Blocks.double_stone_slab));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sandstone), new ItemStack(itemAtomicstone), new ItemStack(Blocks.stone_slab,1,1), new ItemStack(Blocks.stone_slab,1,1));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stone_slab,2,1), new ItemStack(itemAtomicstone), new ItemStack(Blocks.sandstone));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone), new ItemStack(itemAtomicstone), new ItemStack(Blocks.stone_slab,1,3), new ItemStack(Blocks.stone_slab,1,3));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stone_slab,2,3), new ItemStack(itemAtomicstone), new ItemStack(Blocks.cobblestone));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.brick_block), new ItemStack(itemAtomicstone), new ItemStack(Blocks.stone_slab,1,4), new ItemStack(Blocks.stone_slab,1,4));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stone_slab,2,4), new ItemStack(itemAtomicstone), new ItemStack(Blocks.brick_block));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick), new ItemStack(itemAtomicstone), new ItemStack(Blocks.stone_slab,1,5), new ItemStack(Blocks.stone_slab,1,5));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stone_slab,2,5), new ItemStack(itemAtomicstone), new ItemStack(Blocks.stonebrick));

        //Material
        GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot), new ItemStack(itemAtomicstone), new ItemStack(Items.coal), new ItemStack(Items.coal), new ItemStack(Items.coal), new ItemStack(Items.coal), new ItemStack(Items.coal), new ItemStack(Items.coal), new ItemStack(Items.coal), new ItemStack(Items.coal));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot), new ItemStack(itemAtomicstone), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond), new ItemStack(itemAtomicstone), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_ingot));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald), new ItemStack(itemAtomicstone), new ItemStack(Items.diamond), new ItemStack(Items.diamond));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.redstone), new ItemStack(itemAtomicstone), new ItemStack(Items.glowstone_dust));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.glowstone_dust), new ItemStack(itemAtomicstone), new ItemStack(Items.redstone));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.blaze_rod), new ItemStack(itemAtomicstone), new ItemStack(Items.blaze_powder), new ItemStack(Items.blaze_powder));

        //Coal
        GameRegistry.addShapelessRecipe(new ItemStack(Items.coal), new ItemStack(itemAtomicstone), new ItemStack(Blocks.log), new ItemStack(Blocks.log), new ItemStack(Blocks.log), new ItemStack(Blocks.log));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.coal), new ItemStack(itemAtomicstone), new ItemStack(Blocks.log,1,1), new ItemStack(Blocks.log,1,1), new ItemStack(Blocks.log,1,1), new ItemStack(Blocks.log,1,1));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.coal), new ItemStack(itemAtomicstone), new ItemStack(Blocks.log,1,2), new ItemStack(Blocks.log,1,2), new ItemStack(Blocks.log,1,2), new ItemStack(Blocks.log,1,2));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.coal), new ItemStack(itemAtomicstone), new ItemStack(Blocks.log,1,3), new ItemStack(Blocks.log,1,3), new ItemStack(Blocks.log,1,3), new ItemStack(Blocks.log,1,3));

        GameRegistry.addShapelessRecipe(new ItemStack(Items.coal), new ItemStack(itemAtomicstone), new ItemStack(Blocks.log2), new ItemStack(Blocks.log2), new ItemStack(Blocks.log2), new ItemStack(Blocks.log2));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.coal), new ItemStack(itemAtomicstone), new ItemStack(Blocks.log2,1,1), new ItemStack(Blocks.log2,1,1), new ItemStack(Blocks.log2,1,1), new ItemStack(Blocks.log2,1,1));

        //Natur
        GameRegistry.addShapelessRecipe(new ItemStack(Items.melon_seeds), new ItemStack(itemAtomicstone), new ItemStack(Items.wheat_seeds));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_seeds), new ItemStack(itemAtomicstone), new ItemStack(Items.pumpkin_seeds));

        //Mobs
        GameRegistry.addRecipe(new ItemStack(Items.nether_star), "www", "sss", "es ", 'w', new ItemStack(Items.skull,1,1), 's', Blocks.soul_sand, 'e', itemAtomicstone);

        //Objects
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.dirt), new ItemStack(itemAtomicstone), new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.cobblestone));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.flint), new ItemStack(itemAtomicstone), new ItemStack(Blocks.gravel));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.gravel), new ItemStack(itemAtomicstone), new ItemStack(Items.flint));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sand), new ItemStack(itemAtomicstone), new ItemStack(Blocks.dirt));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.log), new ItemStack(itemAtomicstone), new ItemStack(Blocks.dirt), new ItemStack(Blocks.dirt), new ItemStack(Blocks.dirt), new ItemStack(Blocks.dirt));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.ice), new ItemStack(itemAtomicstone), new ItemStack(Blocks.snow));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.snow), new ItemStack(itemAtomicstone), new ItemStack(Blocks.ice));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sand), new ItemStack(itemAtomicstone), new ItemStack(Blocks.sand, 1,1));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sand, 1,1), new ItemStack(itemAtomicstone), new ItemStack(Blocks.sand));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 4), new ItemStack(itemAtomicstone), new ItemStack(Blocks.wool));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.skull,1,1), new ItemStack(itemAtomicstone), new ItemStack(Items.skull));

        //Agg
        GameRegistry.addShapelessRecipe(new ItemStack(Items.lava_bucket), new ItemStack(Items.bucket), new ItemStack(itemLavaAgg, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.water_bucket),new ItemStack(Items.bucket), new ItemStack(itemWaterAgg,1));
    }
}
