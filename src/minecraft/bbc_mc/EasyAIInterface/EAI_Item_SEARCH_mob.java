package bbc_mc.EasyAIInterface;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.mod_EasyAIInterface;
import bbc_mc.EasyAIInterface.util.SorterDistanceToEntity;

/**
 * AI チップ: 周辺の Mob を探索し、ターゲット変数へ格納する
 * 
 * @author bbc_mc
 */
public class EAI_Item_SEARCH_mob extends EAI_ItemBase {
    
    protected EAI_Item_SEARCH_mob(int par1) {
        super(par1);
        this.setItemName("EAI_SEARCH_mob");
        this.setItemTypeBranching(true);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_SEARCH_mob] " + this.returnTrue() + " : " + this.returnFalse() + "[" + slotnum);
        
        double range = 20D;// search range
        List list = entity.worldObj.getEntitiesWithinAABBExcludingEntity(entity, entity.boundingBox.expand(range, 4D, range));
        Collections.sort(list, new SorterDistanceToEntity(entity));
        Iterator iterator = list.iterator();
        ItemStack currentItemStack = inventory.getStackInSlot(slotnum);
        if (currentItemStack != null) {
            while (iterator.hasNext()) {
                Object obj = iterator.next();
                if (this.isTargetMobClassFromDamage(((Entity) obj), currentItemStack.getItemDamage())) {
                    manager.memory.target.setTarget((EntityMob) obj);
                    return this.returnTrue();
                }
            }
        }
        return this.returnFalse();
        
    }
    
    // =====================================================
    // TODO: dummy code.
    private boolean isTargetMobClassFromDamage(Entity target, int damage) {
        int type = damage / 8;
        if (((type & 0x1) != 0) && target instanceof EntityZombie) {
            return true;
        }
        return false;
    }
}
