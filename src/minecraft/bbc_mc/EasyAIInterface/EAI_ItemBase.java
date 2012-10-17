package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EAI_ItemBase extends Item {
    
    public enum Direction {
        RIGHT, //
        DOWN_RIGHT, //
        DOWN, //
        DOWN_LEFT, //
        LEFT, //
        UPPER_LEFT, //
        UP, //
        UPPER_RIGHT;
        public static int getNextSlot(IInventory inventory, int slotnum, int maxcol, Direction dir) {
            int ret = 0;
            switch (dir) {
                case RIGHT:
                    ret = +1;
                    if ((slotnum + 1) % maxcol == 0) {
                        return -1;
                    }
                    break;
                case DOWN_RIGHT:
                    ret = +1 + maxcol;
                    if ((slotnum - 1) % maxcol == 0) {
                        return -1;
                    }
                    if (inventory.getSizeInventory() - slotnum < maxcol) {
                        return -1;
                    }
                    break;
                case DOWN:
                    ret = +maxcol;
                    if (inventory.getSizeInventory() - slotnum < maxcol) {
                        return -1;
                    }
                    break;
                case DOWN_LEFT:
                    ret = -1 + maxcol;
                    if (inventory.getSizeInventory() - slotnum < maxcol) {
                        return -1;
                    }
                    break;
                case LEFT:
                    ret = -1;
                    if (slotnum % maxcol == 0) {
                        return -1;
                    }
                    break;
                case UPPER_LEFT:
                    ret = -1 - maxcol;
                    if (slotnum % maxcol == 0) {
                        return -1;
                    }
                    if (slotnum < maxcol) {
                        return -1;
                    }
                    break;
                case UP:
                    ret = -maxcol;
                    if (slotnum < maxcol) {
                        return -1;
                    }
                    break;
                case UPPER_RIGHT:
                    ret = +1 - maxcol;
                    if ((slotnum - 1) % maxcol == 0) {
                        return -1;
                    }
                    if (slotnum < maxcol) {
                        return -1;
                    }
                    break;
            }
            return slotnum + ret;
        }
    }
    
    protected int value_true;
    protected int value_false;
    protected boolean isBranchingItem;
    
    protected EAI_ItemBase(int par1) {
        super(par1);
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
        this.setMaxDamage(64);
        this.isBranchingItem = false;
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        int currentDamage = par1ItemStack.getItemDamage();
        par1ItemStack.setItemDamage((currentDamage + 1) % par1ItemStack.getMaxDamage());
        System.out.println(par1ItemStack.getItemDamage());
        return par1ItemStack;
    }
    
    @Override
    public int getIconFromDamage(int par1) {
        int i = MathHelper.clamp_int(par1, 0, 63);
        return iconIndex + (i % 8) * 16 + i / 8;
    }
    
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        this.setReturnValue(inventory, slotnum, maxcol);
        // write your code
        
        // return your answer
        return this.returnTrue();
    }
    
    protected void setReturnValue(IInventory inventory, int slotnum, int maxcol) {
        
        this.value_true = Direction.getNextSlot(inventory, slotnum, maxcol, getDirectionTrueFromDamage(inventory, slotnum));
        this.value_false = Direction.getNextSlot(inventory, slotnum, maxcol, getDirectionFalseFromDamage(inventory, slotnum));
    }
    
    protected int returnTrue() {
        return this.value_true;
    }
    
    protected int returnFalse() {
        if (this.isBranchingItem) {
            return this.value_false;
        } else {
            return this.value_true;
        }
    }
    
    //
    // treat ItemDamage => Direction convert
    //
    // 下 3bit 000111
    protected Direction getDirectionTrueFromDamage(IInventory inventory, int slotnum) {
        int currentDamage = inventory.getStackInSlot(slotnum).getItemDamage() % 8;
        return Direction.values()[currentDamage];
    }
    
    // 上 3 bit 111000
    protected Direction getDirectionFalseFromDamage(IInventory inventory, int slotnum) {
        int currentDamage = inventory.getStackInSlot(slotnum).getItemDamage() / 8;
        return Direction.values()[currentDamage];
    }
    
    protected void setItemTypeBranching(boolean flg) {
        this.isBranchingItem = flg;
    }
}
