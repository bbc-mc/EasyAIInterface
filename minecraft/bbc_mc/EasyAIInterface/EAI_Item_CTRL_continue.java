package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.mod_EasyAIInterface;

public class EAI_Item_CTRL_continue extends EAI_ItemBase {
    
    protected EAI_Item_CTRL_continue(int par1) {
        super(par1);
        this.setHasSubtypes(true);
        this.setItemName("EAI_CTRL_continue");
        this.setMaxStackSize(1);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        mod_EasyAIInterface.getInstance().mod.debugPrint("[" + this.getItemName() + "] continue ");
        return manager.slot_start;
    }
    
}
