package bbc_mc.EasyAIInterface;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.mod_EasyAIInterface;
import bbc_mc.EasyAIInterface.util.SorterDistanceToEntity;

/**
 * AI チップ: 周辺に落下しているアイテムを探索し、ターゲット変数へ格納する
 * 
 * @author bbc_mc
 */
public class EAI_Item_SEARCH_item extends EAI_ItemBase {
    
    protected EAI_Item_SEARCH_item(int par1) {
        super(par1);
        this.setItemName("EAI_SEARCH_item");
        this.setItemTypeBranching(true);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_SEARCH_item] " + this.returnTrue() + " : " + this.returnFalse() + "[" + slotnum);
        // Find Hostile mob
        
        double range = 20D;// search range
        List list = entity.worldObj.getEntitiesWithinAABB(EntityItem.class, entity.boundingBox.expand(range, 4D, range));
        if (list.size() > 0) {
            Collections.sort(list, new SorterDistanceToEntity(entity));
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Object obj = iterator.next();
                if (obj instanceof EntityItem) {
                    manager.memory.target.setTarget((EntityItem) obj);
                    return this.returnTrue();
                }
            }
        }
        return this.returnFalse();
    }
}
