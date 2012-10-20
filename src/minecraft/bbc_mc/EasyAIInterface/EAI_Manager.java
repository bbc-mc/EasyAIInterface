package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.mod_EasyAIInterface;

/**
 * AI チップ処理クラス
 * 
 * 登録されたインベントリ内を参照し、認識している currentSlot にある AI チップを実行する
 * 
 * @author bbc_mc
 */
public class EAI_Manager {
    
    public int slot_start;
    
    private EntityLiving parentEntity;
    private IInventory inventory;
    private int currentSlot;
    private int maxcol;
    private boolean flg_init;
    
    public EasyAIInterface mod;
    public EAI_Memory memory;
    private int count = 0;
    
    public EAI_Manager(EasyAIInterface mod) {
        this.mod = mod;
        this.memory = new EAI_Memory();
        
        this.slot_start = 0;
        
        this.flg_init = false;
    }
    
    public void init(EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        this.parentEntity = entity;
        this.inventory = inventory;
        this.currentSlot = slotnum;
        this.maxcol = maxcol;
        this.flg_init = true;
    }
    
    public int getCurrentSlot() {
        return this.currentSlot;
    }
    
    public void setCurrentSlot(int slot) {
        if (0 <= slot && slot < this.inventory.getSizeInventory()) {
            this.currentSlot = slot;
        }
    }
    
    public boolean execute() {
        if (!this.flg_init) {
            this.mod.debugPrint("[EAI_Manager] Not yet Initialized");
            return false; // abort
        }
        if (count > 0) {
            count--;
            return true; // continue
        } else {
            count = this.mod.mod_EAI.loopWait;
        }
        
        if (this.currentSlot < 0 || this.inventory.getSizeInventory() < this.currentSlot) {
            this.mod.debugPrint("[EAI_Manager] slotnum is out of range. abort. : " + this.currentSlot);
            return false; // abort
        }
        
        //
        ItemStack currentSlotItem = inventory.getStackInSlot(this.currentSlot);
        
        // EAI_Item かどうかを確認。
        if (currentSlotItem == null || !this.mod.items.isEAIItem(currentSlotItem)) {
            this.mod.debugPrint("[EAI_Manager] Item is not EAI_ITEM " + currentSlotItem);
            return false; // abort
        }
        
        //
        mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_Manager] execute");
        int ret = ((EAI_ItemBase) currentSlotItem.getItem()).execute(this, this.parentEntity, this.inventory, this.currentSlot, this.maxcol);
        
        // 終了前処理
        if (ret == -1) {
            this.mod.debugPrint("[EAI_Manager] returned : " + ret + " " + ((EAI_ItemBase) currentSlotItem.getItem()).getItemName());
            this.currentSlot = this.slot_start;
            return true; // manager が認識している start チップへ戻る
        } else if (ret > this.inventory.getSizeInventory()) {
            this.mod.debugPrint("[EAI_Manager] return to 0. reach right end.");
            this.currentSlot = this.slot_start;
            return true; // manager が認識している start チップへ戻る
        } else {
            this.currentSlot = ret;
            return true;
        }
    }
    
    public int findStartTip(IInventory inventory) {
        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack stack = inventory.getStackInSlot(i);
            if (stack != null && this.mod.items.isEAIItem(stack) && (stack.getItem() instanceof EAI_Item_SYS_start)) {
                return i;
            }
        }
        return -1;
    }
}
