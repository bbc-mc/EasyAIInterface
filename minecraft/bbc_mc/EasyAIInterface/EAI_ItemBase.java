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
        public static int getNextSlot(int slotnum, int maxcol, Direction dir) {
            int ret = 0;
            switch (dir) {
                case RIGHT:
                    ret = +1;
                    break;
                case DOWN_RIGHT:
                    ret = +1 + maxcol;
                    break;
                case DOWN:
                    ret = +maxcol;
                    break;
                case DOWN_LEFT:
                    ret = -1 + maxcol;
                    break;
                case LEFT:
                    ret = -1;
                    break;
                case UPPER_LEFT:
                    ret = -1 - maxcol;
                    break;
                case UP:
                    ret = -maxcol;
                    break;
                case UPPER_RIGHT:
                    ret = +1 - maxcol;
                    break;
            }
            if ((slotnum % maxcol) == ((slotnum + ret) % maxcol)) {
                return slotnum + ret;
            } else {
                return -1; // Inventory の壁面に到達。
            }
        }
    }
    
    protected int value_true;
    protected int value_false;
    
    protected EAI_ItemBase(int par1) {
        super(par1);
    }
    
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        this.setReturnValue(slotnum, maxcol);
        // write your code
        
        // return your answer
        return this.returnTrue();
    }
    
    protected void setReturnValue(int slotnum, int maxcol) {
        
        this.value_true = Direction.getNextSlot(slotnum, maxcol, getDirectionTrueFromDamage(slotnum, maxcol));
        this.value_false = Direction.getNextSlot(slotnum, maxcol, getDirectionFalseFromDamage(slotnum, maxcol));
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
