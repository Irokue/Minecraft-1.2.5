package net.minecraft.src;

public class ItemMinecart extends Item
{
    public int minecartType;

    public ItemMinecart(int par1, int par2)
    {
        super(par1);
        maxStackSize = 1;
        minecartType = par2;
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS !
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7)
    {
        int i = par3World.getBlockId(par4, par5, par6);

        if (BlockRail.isRailBlock(i))
        {
            if (!par3World.isRemote)
            {
                par3World.spawnEntityInWorld(new EntityMinecart(par3World, (float)par4 + 0.5F, (float)par5 + 0.5F, (float)par6 + 0.5F, minecartType));
            }

            par1ItemStack.stackSize--;
            return true;
        }
        else
        {
            return false;
        }
    }
}
