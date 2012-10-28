package bbc_mc.EasyAIInterface;

import java.util.List;

import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.mod_EasyAIInterface;
import bbc_mc.EasyAIInterface.util.UtilInventory;

/**
 * AI チップ: Item を拾ってインベントリへ格納する
 * 
 * @author bbc_mc
 */
public class EAI_Item_TASK_pickupItem extends EAI_ItemBase {
    
    protected EAI_Item_TASK_pickupItem(int par1) {
        super(par1);
        this.setItemName("EAI_TASK_pickupItem");
        this.setItemTypeBranching(false);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        super.execute(manager, entity, inventory, slotnum, maxcol);
        mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_TASK_pickupItem] " + this.returnTrue() + " : " + this.returnFalse() + "[" + slotnum);
        
        // ターゲットを認識しており、それはアイテムか
        EntityItem targetItem = (EntityItem) manager.memory.getTargetEntity();
        if (targetItem == null || !(targetItem instanceof EntityItem) || !manager.memory.hasTarget()) {
            return this.returnFalse();
        } else {
            entity.getLookHelper().setLookPositionWithEntity(targetItem, 30F, 30F);
            double distance = entity.getDistanceToEntity(targetItem);
            if (distance > 2.0D) {
                // 十分に接近していないなら、接近する
                float speed = entity.getAIMoveSpeed();
                speed = (speed == 0 ? 0.3F : speed);
                entity.getNavigator().tryMoveToXYZ(targetItem.posX, targetItem.posY, targetItem.posZ, speed);
                return this.returnFalse();
            } else {
                // 十分に接近している場合
                // // 接触しているかどうか判定する
                List list = entity.worldObj.getEntitiesWithinAABB(EntityItem.class, entity.boundingBox.expand(0.5D, 0.5D, 0.5D));
                if (list.contains(targetItem)) {
                    // pickup
                    if (UtilInventory.addItemStackToInventory(inventory, targetItem.item)) {
                        targetItem.setDead();
                        manager.memory.clearTarget();
                        // Sound
                        entity.worldObj.playSoundAtEntity(targetItem, "random.pop", 0.2F,
                                ((entity.getRNG().nextFloat() - entity.getRNG().nextFloat()) * 0.7F + 1.0F) * 2.0F);
                    }
                    
                    return this.returnTrue();
                } else {
                    return this.returnFalse();
                }
            }
        }
    }
}
