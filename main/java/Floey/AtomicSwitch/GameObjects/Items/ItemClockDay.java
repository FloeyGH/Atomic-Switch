package Floey.AtomicSwitch.GameObjects.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemClockDay extends ItemAS {
    public ItemClockDay() {
        this.setTextureName("atomicswitch:ItemClockDay");
        this.setUnlocalizedName("ItemClockDay");
        this.setMaxStackSize(1);
        this.setMaxDamage(24);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
            boolean consumed = player.inventory.consumeInventoryItem(Item.getItemFromBlock(Blocks.glowstone));

            if (consumed) {
                world.setWorldTime(0010);
                itemstack.damageItem(1, player);
                world.playSoundAtEntity(player, "portal.travel", 0.5F, 1.0F);
            }
        return itemstack;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.rare;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack, int pass) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        list.add("\u00A73Right-click to change the Time");
        list.add("\u00A73and you need Glowstone in your Inventory");

    }
}
