package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.mod_EasyAIInterface;

public class EAI_Manager {
    public EntityLiving targetEntity;
    public int slot_start;
    
    public EasyAIInterface mod;
    public EAI_Memory memory;
    private int count = 0;
    
    public EAI_Manager(EasyAIInterface mod) {
        this.mod = mod;
        this.memory = new EAI_Memory();
        
        this.slot_start = 0;
        this.targetEntity = null;
    }
    
    /**
     * 
     * 戻り値: slotnum への変更値を返す。実行失敗の場合、-1 を返す
     * 
     * @param entity
     * @param inventory
     * @param slotnum
     * @return new_slotnum
     */
    public int execute(EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        if (count > 0) {
            count--;
            return -1;
        } else {
            count = this.mod.mod_EAI.loopWait;
        }
        //
        ItemStack current = inventory.getStackInSlot(slotnum);
        
        // EAI_Item かどうかを確認。
        if (current == null || !this.mod.items.isEAIItem(current)) {
            mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_Manager] Item is not EAI_ITEM " + current);
            return -1; // 実行失敗
        }
        
        //
        mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_Manager] execute");
        int ret = ((IEAIItem) current.getItem()).execute(this, entity, inventory, slotnum, maxcol);
        
        // 終了前処理
        if (ret == -1) {
            mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_Manager] abort. returned : " + ret);
            return -1;// 実行失敗
        } else if (ret > inventory.getSizeInventory()) {
            mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_Manager] return to 0. reach right end.");
            return this.slot_start; // or -slotnum?
        } else {
            return ret;
        }
    }
}
