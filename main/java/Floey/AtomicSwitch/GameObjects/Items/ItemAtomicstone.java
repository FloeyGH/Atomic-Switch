package Floey.AtomicSwitch.GameObjects.Items;

import Floey.AtomicSwitch.Core.AchievementHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemAtomicstone extends ItemAS
{
    public ItemAtomicstone(){
        super();
        this.setTextureName("atomicswitch:ItemAtomicstone");
        this.setUnlocalizedName("ItemAtomicstone");
        this.setMaxStackSize(1);
        this.setNoRepair();
        this.setMaxDamage(99);

    }
    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack)
    {
        return false;
    }

    @Override
    public boolean getShareTag()
    {
        return true;
    }

    public boolean hasContainerItem(ItemStack itemstack)
    {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemstack)
    {
        ItemStack stack = itemstack.copy();
        stack.stackSize = 1;
        return stack;
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
        list.add("\u00A73The Core of the Mod");
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player)
    {
        super.onCreated(stack, world, player);

        if (!world.isRemote)
        {
            player.addStat(AchievementHandler.Atomic_Stone, 1);
        }
    }
}


