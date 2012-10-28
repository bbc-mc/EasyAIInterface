package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.Vec3D;
import net.minecraft.src.mod_EasyAIInterface;
import bbc_mc.EasyAIInterface.util.UtilPosition;

public class EAI_Item_SEARCH_block extends EAI_ItemBase {
    
    private double searchRangeX = 20D;
    private double searchRangeY = 4D;
    private double searchRangeZ = 20D;
    
    protected EAI_Item_SEARCH_block(int par1) {
        super(par1);
        this.setItemName("EAI_SEARCH_block");
        this.setItemTypeBranching(true);
        this.setMaxDamage(0);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_SEARCH_block] " + this.returnTrue() + " : " + this.returnFalse() + "[" + slotnum);
        
        // target Block を指定されていると仮定
        // TODO: Implement UI to set targetBlock by ingame Player（GUI?
        int targetBlockID = 100;
        
        UtilPosition pos = new UtilPosition(entity);
        Vec3D targetBlockPos = pos.searchNearestTargetBlock(entity.worldObj, targetBlockID, 10, 3, 10);
        if (targetBlockPos != null) {
            manager.memory.setTarget(targetBlockPos.xCoord, targetBlockPos.yCoord, targetBlockPos.zCoord);
            return this.returnTrue();
        } else {
            return this.returnFalse();
        }
    }
}
