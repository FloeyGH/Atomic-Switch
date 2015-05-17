package Floey.AtomicSwitch.GameObjects;

import Floey.AtomicSwitch.Core.AtomicSwitchCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs
{
    public CreativeTab()
    {
        super(AtomicSwitchCore.MODID);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return GameObjects.itemAtomicstone;
    }
}