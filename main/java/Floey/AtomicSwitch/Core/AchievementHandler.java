package Floey.AtomicSwitch.Core;

import Floey.AtomicSwitch.GameObjects.GameObjects;
import com.google.common.collect.ImmutableList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public final class AchievementHandler
{
   // public final static Achievement mineFlower = new Achievement("achievement.mineEssence", "mineEssence", 0, 0, GameObjects.blockAtomiccus, null).initIndependentStat().registerStat().setSpecial();
    public final static Achievement Atomic_Stone = new Achievement("achievement.Atomic_Stone", "Atomic_Stone", 0, 0, GameObjects.itemAtomicstone, null).initIndependentStat().registerStat();
    public final static Achievement mineEssenceO = new Achievement("achievement.mineEssenceO", "mineEssenceO", 2, 0, GameObjects.itemSoulEssenceO, null).initIndependentStat().registerStat();
    public final static Achievement mineEssenceL = new Achievement("achievement.mineEssenceL", "mineEssenceL", 2, 2, GameObjects.itemSoulEssenceL, mineEssenceO).registerStat();
    public final static Achievement mineEssenceJ = new Achievement("achievement.mineEssenceJ", "mineEssenceJ", 2, 4, GameObjects.itemSoulEssenceJ, mineEssenceL).registerStat();
    public final static Achievement coval_dust = new Achievement("achievement.coval_dust", "coval_dust", -2, 0, new ItemStack(GameObjects.itemCovalLow,15), null).initIndependentStat().registerStat();
    public final static Achievement covaldustmedium = new Achievement("achievement.covaldustmedium", "covaldustmedium", -2, 2, new ItemStack(GameObjects.itemCovalMedium,10), null).registerStat();
    public final static Achievement covaldusthigh = new Achievement("achievement.covaldusthigh", "covaldusthigh", -2, 4, new ItemStack(GameObjects.itemCovalHigh,5), null).initIndependentStat().registerStat();
    //public final static Achievement lifeheart = new Achievement("achievement.lifeheart", "lifeheart", -3, 0,GameObjects.itemLifeHeart, null).initIndependentStat().registerStat();
    //public final static Achievement lifeheartmk2 = new Achievement("achievement.lifeheartmk2", "lifeheartmk2", -3, 2, GameObjects.itemLifeHeartMK2, lifeheart).registerStat();
    //public final static Achievement lifeheartmk3 = new Achievement("achievement.lifeheartmk3", "lifeheartmk3", -3, 4, GameObjects.itemLifeHeartMK3, lifeheartmk2).registerStat();



    public static ImmutableList<Achievement> list = ImmutableList.of(
            Atomic_Stone, mineEssenceO,mineEssenceL,mineEssenceJ,//mineFlower,
            coval_dust,covaldustmedium,covaldusthigh//,lifeheart,lifeheartmk2,lifeheartmk3

    );
    public static void init()
    {
        AchievementPage.registerAchievementPage(new AchievementPage("Atomic Switch", list.toArray(new Achievement[list.size()])));
    }

    public static Achievement getAchievementForItem(ItemStack stack)
    {
        if (stack == null)
        {
            return null;
        }

        for (Achievement ach : list)
        {
            ItemStack s = ach.theItemStack;

            if (s.getItem() == stack.getItem() && s.getItemDamage() == stack.getItemDamage())
            {
                return ach;
            }
        }

        return null;
    }

    @SubscribeEvent
    public void onItemCrafted(PlayerEvent.ItemCraftedEvent event)
    {
        for (Item item : AchievementsRegistry.craftinglist)
        {
            if (event.crafting != null && event.crafting.getItem() == item)
            {
                Achievement achievement = AchievementsRegistry.getAchievementForItem(event.crafting.getItem());

                if (achievement != null)
                {
                    event.player.addStat(achievement, 1);
                }
            }
        }
    }

    @SubscribeEvent
    public void onItemPickedUp(PlayerEvent.ItemPickupEvent event) {
        for (Item item : AchievementsRegistry.pickupList) {
            ItemStack stack = event.pickedUp.getEntityItem();

            if (stack != null && stack.getItem() == item) {
                Achievement achievement = AchievementsRegistry.getAchievementForItem(item);

                if (achievement != null) {
                    event.player.addStat(achievement, 1);
                }
            }
        }
    }
}
