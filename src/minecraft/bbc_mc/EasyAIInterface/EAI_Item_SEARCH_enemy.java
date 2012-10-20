package bbc_mc.EasyAIInterface;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.IMob;
import net.minecraft.src.mod_EasyAIInterface;
import bbc_mc.EasyAIInterface.util.SorterDistanceToEntity;

public class EAI_Item_SEARCH_enemy extends EAI_ItemBase {
    
    protected EAI_Item_SEARCH_enemy(int par1) {
        super(par1);
        this.setItemName("EAI_SEARCH_enemy");
        this.setItemTypeBranching(true);
        this.setMaxDamage(0);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_SEARCH_enemy] " + this.returnTrue() + " : " + this.returnFalse() + "[" + slotnum);
        // Find Hostile mob
        
        double range = 20D;// search range
        List list = entity.worldObj.getEntitiesWithinAABBExcludingEntity(entity, entity.boundingBox.expand(range, 4D, range));
        Collections.sort(list, new SorterDistanceToEntity(entity));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj instanceof IMob && ((EntityLiving) obj).getAttackTarget() != null && ((EntityLiving) obj).getAttackTarget().equals(entity)) {
                manager.memory.target.setTarget((EntityLiving) obj);
                return this.returnTrue();
            }
        }
        return this.returnFalse();
    }
}
