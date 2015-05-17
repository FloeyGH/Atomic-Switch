package Floey.AtomicSwitch.GameObjects.Blocks;

import Floey.AtomicSwitch.GameObjects.GameObjects;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.World;

public class BlockAtomiccus extends BlockFlower
{
    public BlockAtomiccus()
    {
        super(0);
        this.setStepSound(soundTypeGrass);
        this.setBlockName("BlockAtomiccus");
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
        {
            ObfuscationReflectionHelper.setPrivateValue(BlockFlower.class, this, new IIcon[1], "field_149861_N");
        }
    }

    @Override
    public IIcon getIcon (IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
    {
        return this.blockIcon;
    }

    @Override
    public IIcon getIcon (int p_149691_1_, int p_149691_2_)
    {
        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons (IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon("atomicswitch:BlockAtomiccus");
    }

   public Item getItemDropped(int par1, Random random, int par3) {
        return GameObjects.itemSoulEssenceM;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        for (int l = 0; l < 3; ++l)
        {
            double d6 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
            double d1 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
            d6 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = p_149734_5_.nextInt(2) * 2 - 1;
            int j1 = p_149734_5_.nextInt(2) * 2 - 1;
            d3 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.125D;
            d4 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.125D;
            d5 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.125D;
            double d2 = (double)p_149734_4_ + 0.5D + 0.25D * (double)j1;
            d5 = (double)(p_149734_5_.nextFloat() * 1.0F * (float)j1);
            double d0 = (double)p_149734_2_ + 0.5D + 0.25D * (double)i1;
            d3 = (double)(p_149734_5_.nextFloat() * 1.0F * (float)i1);
            p_149734_1_.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
        }
    }
}