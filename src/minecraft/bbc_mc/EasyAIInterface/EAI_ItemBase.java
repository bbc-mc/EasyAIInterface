package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;

public abstract class EAI_ItemBase extends Item {
    
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
                    if ((slotnum - 1) % maxcol == 0) {
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
    
    protected EAI_ItemBase(int par1) {
        super(par1);
    }
    
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        this.setReturnValue(inventory, slotnum, maxcol);
        // write your code
        
        // return your answer
        return this.returnTrue();
    }
    
    protected void setReturnValue(IInventory inventory, int slotnum, int maxcol) {
        
        this.value_true = Direction.getNextSlot(inventory, slotnum, maxcol, getDirectionTrueFromDamage(slotnum, maxcol));
        this.value_false = Direction.getNextSlot(inventory, slotnum, maxcol, getDirectionFalseFromDamage(slotnum, maxcol));
    }
    
    protected int returnTrue() {
        return this.value_true;
    }
    
    protected int returnFalse() {
        return this.value_false;
    }
    
    //
    // treat ItemDamage => Direction convert
    //
    /**
     * TODO: this is dummy implementation. return appropriate value from ItemDamge.
     */
    protected Direction getDirectionTrueFromDamage(int slotnum, int maxcol) {
        return Direction.DOWN;
    }
    
    /**
     * TODO: this is dummy implementation. return appropriate value from ItemDamge.
     */
    protected Direction getDirectionFalseFromDamage(int slotnum, int maxcol) {
        return Direction.RIGHT;
    }
}
