package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;

public class EAI_Item_TASK_attackOnCollide extends EAI_ItemBase {
    
    protected EAI_Item_TASK_attackOnCollide(int par1) {
        // automatically inserted
        super(par1);
        this.setHasSubtypes(true);
        this.setItemName("EAI_TASK_attackOnCollide");
        this.setMaxStackSize(1);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        return 0;
    }
    
}
