package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.mod_EasyAIInterface;

public class EAI_Item_SYS_start extends EAI_ItemBase {
    
    protected EAI_Item_SYS_start(int par1) {
        super(par1);
        this.setItemName("EAI_SYS_start");
        this.setItemTypeBranching(false);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        mod_EasyAIInterface.getInstance().mod.debugPrint("[" + this.getItemName() + "] start ");
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        return this.returnTrue();
    }
    
}