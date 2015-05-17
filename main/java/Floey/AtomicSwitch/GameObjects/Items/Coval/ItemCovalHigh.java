package Floey.AtomicSwitch.GameObjects.Items.Coval;

import Floey.AtomicSwitch.Core.AchievementHandler;
import Floey.AtomicSwitch.GameObjects.Items.ItemAS;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCovalHigh extends ItemAS
{
    public ItemCovalHigh(){
        this.setTextureName("atomicswitch:high");
        this.setUnlocalizedName("coval_dust_high");

    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player)
    {
        super.onCreated(stack, world, player);

        if (!world.isRemote)
        {
            player.addStat(AchievementHandler.covaldusthigh, 1);
        }
    }
}
