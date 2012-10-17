package bbc_mc.EasyAIInterface;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.Vec3D;
import net.minecraft.src.mod_EasyAIInterface;

/**
 * Taskチップ : ターゲットへの移動
 * 
 * @author bbc_mc
 */
public class EAI_Item_TASK_move2target extends EAI_ItemBase {
    
    protected EAI_Item_TASK_move2target(int par1) {
        super(par1);
        this.setItemName("EAI_TASK_move2target");
        this.setItemTypeBranching(false);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_TASK_move2target] " + this.returnTrue() + " : " + this.returnFalse() + "[" + slotnum);
        
        if (!manager.memory.hasTarget()) {
            // no target.
            return this.returnFalse();
        } else {
            float speed = entity.getAIMoveSpeed();
            speed = (speed == 0 ? 0.3F : speed);
            if (manager.memory.isEntity()) {
                Entity target = manager.memory.getTargetEntity();
                if (target != null && entity.getNavigator().tryMoveToXYZ(target.posX, target.posY, target.posZ, speed)) {
                    return this.returnTrue();
                } else {
                    return this.returnFalse();
                }
            } else {
                Vec3D targetPos = manager.memory.getTargetPos();
                if (entity.getNavigator().tryMoveToXYZ(targetPos.xCoord, targetPos.yCoord, targetPos.zCoord, speed)) {
                    return this.returnTrue();
                } else {
                    return this.returnFalse();
                }
            }
        }
    }
}