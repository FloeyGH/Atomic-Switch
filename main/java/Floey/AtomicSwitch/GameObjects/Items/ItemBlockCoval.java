package Floey.AtomicSwitch.GameObjects.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCoval extends ItemBlock
{
    public ItemBlockCoval(Block block)
    {
        super(block);
        this.setMaxDamage(0);
        this.hasSubtypes = true;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        switch (stack.getItemDamage())
        {
            case 0:
                return "tile.block_coval_1";
            case 1:
                return "tile.block_coval_2";
            case 2:
                return "tile.block_coval_3";
            default:
                return "tile.block_coval_null";
        }
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }
}