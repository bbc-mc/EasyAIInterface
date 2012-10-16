package bbc_mc.EasyAIInterface;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.mod_EasyAIInterface;

public class EAI_Item_CTRL_IF_HPLow extends EAI_ItemBase {
    
    protected EAI_Item_CTRL_IF_HPLow(int par1) {
        // automatically inserted
        super(par1);
        this.setHasSubtypes(true);
        this.setItemName("EAI_CTRL_IF_HPLow");
        this.setMaxStackSize(1);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        if (entity.getHealth() < entity.getMaxHealth() / 2) {
            mod_EasyAIInterface.getInstance().mod.debugPrint("[EAI_CTRL_IF_HPLow] HP Low == true");
            return this.returnTrue();
        }
        
        return this.returnFalse();
    }
    
    // 右クリック動作により、設定値変更を行う
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        int nextDamage = par1ItemStack.getItemDamage() + 1;
        if (par1ItemStack.getMaxDamage() < nextDamage) {
            nextDamage = 0;
        }
        par1ItemStack.setItemDamage(nextDamage);
        return par1ItemStack;
    }
    
    @Override
    public int getIconFromDamage(int par1) {
        return iconIndex;
    }
    
    /*
    @Override
    public void addInformation(ItemStack par1ItemStack, List par2List) {
        par2List.add(StatCollector.translateToLocal("bbc_mc.EasyAIInterface.item.EAI_CTRL_IF_HPLow.line1"));
        par2List.add(StatCollector.translateToLocal("bbc_mc.EasyAIInterface.item.EAI_CTRL_IF_HPLow.line2"));
        par2List.add(StatCollector.translateToLocal("bbc_mc.EasyAIInterface.item.EAI_CTRL_IF_HPLow.line3"));
        par2List.add(StatCollector.translateToLocal("bbc_mc.EasyAIInterface.item.EAI_CTRL_IF_HPLow.line4"));
    }
    */
}
