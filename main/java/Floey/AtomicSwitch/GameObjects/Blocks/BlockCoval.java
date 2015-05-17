package Floey.AtomicSwitch.GameObjects.Blocks;

import Floey.AtomicSwitch.GameObjects.GameObjects;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import java.util.List;
import java.util.Random;

public class BlockCoval extends BlockFalling
{
    @SideOnly(Side.CLIENT)
    private IIcon icons[];

    public BlockCoval()
    {
        super(Material.sand);
        this.setBlockName("block_coval");
        this.setCreativeTab(GameObjects.cTab);
        this.setHardness(0.2f);
        this.setStepSound(soundTypeSand);
    }

    @Override
    public int damageDropped(int meta)
    {
            return meta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs cTab, List list)
    {
        for (int i = 0; i < 3; i++)
        {
            list.add(new ItemStack(item , 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        icons = new IIcon[3];

        for (int i = 0; i < 3; i++)
        {
            icons[i] = register.registerIcon("atomicswitch:coval_"+i);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return icons[MathHelper.clamp_int(meta, 0, 2)];
    }

}