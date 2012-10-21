package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.mod_EasyAIInterface;

/**
 * AI チップ: HP が半分以下かどうかを返す
 * 
 * @author bbc_mc
 */
public class EAI_Item_CTRL_IF_HPLow extends EAI_ItemBase {
    
    protected EAI_Item_CTRL_IF_HPLow(int par1) {
        super(par1);
        this.setItemName("EAI_CTRL_IF_HPLow");
        this.setItemTypeBranching(true);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_CTRL_IF_HPLow] " + this.returnTrue() + " : " + this.returnFalse() + "[" + slotnum);
        
        if (entity.getHealth() < entity.getMaxHealth() / 2) {
            mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_CTRL_IF_HPLow] HP Low == true");
            return this.returnTrue();
        }
        
        return this.returnFalse();
    }
}
