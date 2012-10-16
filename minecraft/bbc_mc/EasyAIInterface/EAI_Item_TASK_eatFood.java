package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.mod_EasyAIInterface;
import bbc_mc.util.UtilInventory;

public class EAI_Item_TASK_eatFood extends EAI_ItemBase {
    
    protected EAI_Item_TASK_eatFood(int par1) {
        super(par1);
        this.setHasSubtypes(true);
        this.setItemName("EAI_TASK_eatFood");
        this.setMaxStackSize(1);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        // 食べ物を持ってたら食べる。次へ進む
        //
        // ロジックをなるだけ壊さないように、検索は後ろから
        for (int i = inventory.getSizeInventory() - 1; i > 0; i--) {
            ItemStack stack = inventory.getStackInSlot(i);
            if (stack != null && stack.getItem() instanceof ItemFood) {
                UtilInventory.decrStackSize(inventory, i, 1); // アイテムを 1 つ減らす
                ItemFood food = (ItemFood) stack.getItem();
                
                entity.worldObj.playSoundEffect(entity.posX, entity.posY, entity.posZ, "random.eat", 0.5F,
                        entity.worldObj.rand.nextFloat() * 0.1F + 0.9F);
                
                entity.setEating(true);
                entity.setEntityHealth(entity.getHealth() + 1); // HP を 1 回復する
                mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_TASK_eatFood] Eat Food " + stack);
                
                return this.returnTrue();
            }
        }
        return this.returnFalse();
    }
    
}
