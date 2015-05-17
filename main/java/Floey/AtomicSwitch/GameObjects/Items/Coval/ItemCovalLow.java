package Floey.AtomicSwitch.GameObjects.Items.Coval;

import Floey.AtomicSwitch.Core.AchievementHandler;
import Floey.AtomicSwitch.GameObjects.Items.ItemAS;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCovalLow extends ItemAS
{
    public ItemCovalLow(){
        this.setTextureName("atomicswitch:low");
        this.setUnlocalizedName("coval_dust_low");
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player)
    {
        super.onCreated(stack, world, player);

        if (!world.isRemote)
        {
            player.addStat(AchievementHandler.coval_dust, 1);
        }
    }
}
