package Floey.AtomicSwitch.GameObjects.Items.Coval;

import Floey.AtomicSwitch.Core.AchievementHandler;
import Floey.AtomicSwitch.GameObjects.Items.ItemAS;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCovalMedium extends ItemAS
{
    public ItemCovalMedium(){
    this.setUnlocalizedName("coval_dust_medium");
        this.setTextureName("atomicswitch:medium");
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player)
    {
        super.onCreated(stack, world, player);

        if (!world.isRemote)
        {
            player.addStat(AchievementHandler.covaldustmedium, 1);
        }
    }
}
