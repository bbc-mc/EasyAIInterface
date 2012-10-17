package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.mod_EasyAIInterface;

// TODO: this is dummy code.
public class EAI_Item_TASK_playSound extends EAI_ItemBase {
    
    protected EAI_Item_TASK_playSound(int par1) {
        super(par1);
        this.setItemName("EAI_TASK_playSound");
        this.setItemTypeBranching(false);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_TASK_playSound] " + this.returnTrue() + " : " + this.returnFalse() + "[" + slotnum);
        
        // get 0-7 value from Damage
        int num = inventory.getStackInSlot(slotnum).getItemDamage() / 8;
        
        return this.returnTrue();
    }
}
