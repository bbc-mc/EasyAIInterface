package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityTameable;
import net.minecraft.src.EntityYoujo;
import net.minecraft.src.IInventory;
import net.minecraft.src.mod_EasyAIInterface;

public class EAI_Item_SEARCH_master extends EAI_ItemBase {
    
    protected EAI_Item_SEARCH_master(int par1) {
        super(par1);
        this.setItemName("EAI_SEARCH_master");
        this.setItemTypeBranching(true);
        this.setMaxDamage(0);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_SEARCH_master] " + this.returnTrue() + " : " + this.returnFalse() + "[" + slotnum);
        
        if (entity instanceof EntityTameable) {
            manager.memory.setTarget(((EntityTameable) entity).getOwner());
            return this.returnTrue();
        } else if (entity instanceof EntityYoujo) {
            manager.memory.setTarget(((EntityYoujo) entity).targetPlayer);
            return this.returnTrue();
        }
        /*
         else if ( entity instanceof EntityLittleMaid){

         }
         */
        else {
            manager.memory.setTarget(null);
            return this.returnFalse();
        }
    }
}
