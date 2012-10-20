package bbc_mc.EasyAIInterface;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.mod_EasyAIInterface;

public class EAI_Item_TASK_attackByRangedWeapon extends EAI_ItemBase {
    
    protected EAI_Item_TASK_attackByRangedWeapon(int par1) {
        super(par1);
        this.setItemName("EAI_TASK_attackByRangedWeapon");
        this.setItemTypeBranching(false);
        this.setMaxDamage(0);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_TASK_attackByRangedWeapon] " + this.returnTrue() + " : " + this.returnFalse() + "["
                + slotnum);
        if (!manager.memory.hasTarget()) {
            return this.returnFalse();
        }
        
        // IF entity has rangedWeapon
        // if(entity.getHeldItem())
        
        Entity target = manager.memory.getTargetEntity();
        double distance = entity.getDistanceToEntity(target);
        int damage = 1;
        // nearby enough
        if (distance < 2.0D) {
            target.attackEntityFrom(DamageSource.causeMobDamage(entity), damage);
            return this.returnTrue();
        } else {
            return this.returnFalse();
        }
    }
}
