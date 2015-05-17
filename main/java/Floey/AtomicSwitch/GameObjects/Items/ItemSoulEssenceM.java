package Floey.AtomicSwitch.GameObjects.Items;

import Floey.AtomicSwitch.Core.AchievementHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSoulEssenceM extends ItemAS
{
    public ItemSoulEssenceM(){
        this.setTextureName("atomicswitch:ItemSoulEssenceM");
        this.setUnlocalizedName("ItemSoulEssenceM");
        this.setNoRepair();
        this.setMaxStackSize(1);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
        super.onUpdate(stack, world, entity, par4, par5);
        EntityPlayer player = (EntityPlayer) entity;
        ItemStack equipped = player.getCurrentEquippedItem();
        if(equipped != null && equipped == stack)
            player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 5, 0));
    }
}