package Floey.AtomicSwitch.GameObjects.Items;

import Floey.AtomicSwitch.GameObjects.GameObjects;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

public class ItemLavaAgg extends ItemAS {
    public ItemLavaAgg() {
        this.setMaxDamage(74);
        this.setUnlocalizedName("ItemLavaAgg");
        this.setMaxStackSize(1);
        this.setNoRepair();
        this.setTextureName("atomicswitch:ItemLavaAgg");
    }
    private Block isFull;

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
        return false;
    }

    @Override
    public boolean getShareTag() {
        return true;
    }

    public boolean hasContainerItem(ItemStack itemstack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemstack) {
        ItemStack stack = itemstack.copy();
        stack.stackSize = 1;
        stack.setItemDamage(stack.getItemDamage() + 1);
        return stack;
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer entity) {
        boolean flag = this.isFull == Blocks.air;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, entity, flag);

        if (movingobjectposition == null) {
            return stack;
        } else {
        }
        if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            int i = movingobjectposition.blockX;
            int j = movingobjectposition.blockY;
            int k = movingobjectposition.blockZ;
            stack.damageItem(1, entity);
            world.playSoundAtEntity(entity, "random.fizz", 1.0F, 1.0F);

            if (!world.canMineBlock(entity, i, j, k)) {
                return stack;
            }

            if (flag) {
                if (!entity.canPlayerEdit(i, j, k, movingobjectposition.sideHit, stack)) {
                    return stack;
                }

                Material material = world.getBlock(i, j, k).getMaterial();
                int l = world.getBlockMetadata(i, j, k);

                if (material == Material.lava && l == 0) {
                    world.setBlockToAir(i, j, k);
                    return this.func_150910_a(stack, entity, GameObjects.itemWaterAgg);
                }
            } else {
                if (this.isFull == Blocks.air) {
                    return new ItemStack(GameObjects.itemWaterAgg);
                }

                if (movingobjectposition.sideHit == 0) {
                    --j;
                }

                if (movingobjectposition.sideHit == 1) {
                    ++j;
                }

                if (movingobjectposition.sideHit == 2) {
                    --k;
                }

                if (movingobjectposition.sideHit == 3) {
                    ++k;
                }

                if (movingobjectposition.sideHit == 4) {
                    --i;
                }

                if (movingobjectposition.sideHit == 5) {
                    ++i;
                }

                if (!entity.canPlayerEdit(i, j, k, movingobjectposition.sideHit, stack)) {
                    return stack;
                }
                placeLava(world, i, j, k);
            }
        }

        return stack;
    }

    private void placeLava(World world, int i, int j, int k) {
        Material material = world.getBlock(i, j, k).getMaterial();
        if (!world.isRemote && !material.isSolid() && !material.isLiquid()) {
            world.func_147480_a(i, j, k, false);
        }
        world.setBlock(i, j, k, Blocks.flowing_lava, 0, 3);
    }

    private ItemStack func_150910_a(ItemStack stack, EntityPlayer entity, Item item) {
        if (entity.capabilities.isCreativeMode) {
            return stack;
        } else if (--stack.stackSize <= 0) {
            return new ItemStack(item);
        } else {
            if (!entity.inventory.addItemStackToInventory(new ItemStack(item))) {
                entity.dropPlayerItemWithRandomChoice(new ItemStack(item, 1, 0), false);
            }

            return stack;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        list.add("\u00A73Right-click to set Lava");

    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
        super.onUpdate(stack, world, entity, par4, par5);
        EntityPlayer player = (EntityPlayer) entity;
        ItemStack equipped = player.getCurrentEquippedItem();
        if (equipped != null && equipped == stack)
            player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5, 0));
    }
}