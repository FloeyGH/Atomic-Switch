package Floey.AtomicSwitch.Core;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.stats.Achievement;

import java.util.ArrayList;
import java.util.List;

public class AchievementsRegistry
{
    public final static List<Item> craftinglist = new ArrayList();
    public final static List<Item> pickupList = new ArrayList();

    public static void init()
    {
        addItemsToCraftingList();
        addItemsToPickupList();
    }

    public static void addItemsToCraftingList()
    {

    }

    public static void addItemsToPickupList()
    {

    }

    public static Achievement getAchievementForItem(Item item)
    {
        return null;
    }

    public static Achievement getAchievementForBlock(Block block)
    {
        return null;
    }
}