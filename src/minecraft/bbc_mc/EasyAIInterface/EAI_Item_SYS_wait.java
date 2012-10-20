package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.mod_EasyAIInterface;

public class EAI_Item_SYS_wait extends EAI_ItemBase {
    
    protected EAI_Item_SYS_wait(int par1) {
        super(par1);
        this.setItemName("EAI_SYS_wait");
        this.setItemTypeBranching(false);
        this.setMaxDamage(0);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        mod_EasyAIInterface.getInstance().mod.debugPrint("[" + this.getItemName() + "] start ");
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        // do nothing. go next tip.
        return this.returnTrue();
    }
    
}
