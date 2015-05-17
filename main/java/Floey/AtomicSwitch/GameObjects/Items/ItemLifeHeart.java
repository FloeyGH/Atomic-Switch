package Floey.AtomicSwitch.GameObjects.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

public class ItemLifeHeart extends ItemAS
{
    public ItemLifeHeart(){
        this.setTextureName("atomicswitch:ItemLifeHeart");
        this.setUnlocalizedName("ItemLifeHeart");
        this.setNoRepair();
        this.setMaxDamage(64);
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        player.heal(3);
        stack.damageItem(1, player);

        return stack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        list.add("\u00A73Right-click to Healing");

    }
}
