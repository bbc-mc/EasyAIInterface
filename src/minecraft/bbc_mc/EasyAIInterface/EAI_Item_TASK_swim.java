package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.mod_EasyAIInterface;

public class EAI_Item_TASK_swim extends EAI_ItemBase {
    
    protected EAI_Item_TASK_swim(int par1) {
        super(par1);
        this.setItemName("EAI_TASK_swim");
        this.setItemTypeBranching(false);
        this.setMaxDamage(0);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_TASK_swim] " + this.returnTrue() + " : " + this.returnFalse() + "[" + slotnum);
        return this.returnTrue();
    }
}
