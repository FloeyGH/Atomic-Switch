package Floey.AtomicSwitch.GameObjects.Items;

import Floey.AtomicSwitch.Core.AchievementHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSoulEssenceJ extends ItemAS
{
    public ItemSoulEssenceJ(){
        this.setTextureName("atomicswitch:ItemSoulEssenceJ");
        this.setUnlocalizedName("ItemSoulEssenceJ");
        this.setNoRepair();
        this.setMaxStackSize(1);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
        super.onUpdate(stack, world, entity, par4, par5);
        EntityPlayer player = (EntityPlayer) entity;
        ItemStack equipped = player.getCurrentEquippedItem();
        if(equipped != null && equipped == stack)
            player.addPotionEffect(new PotionEffect(Potion.jump.id, 5, 0));
    }
    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player)
    {
        super.onCreated(stack, world, player);

        if (!world.isRemote)
        {
            player.addStat(AchievementHandler.mineEssenceJ, 1);
        }
    }
}
