package bbc_mc.EasyAIInterface;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.mod_EasyAIInterface;
import bbc_mc.util.SorterDistanceToEntity;

public class EAI_Item_CTRL_IF_EnemyNearby extends EAI_ItemBase {
    
    private int ret_true;
    private int ret_false;
    
    protected EAI_Item_CTRL_IF_EnemyNearby(int par1) {
        super(par1);
        this.setItemName("EAI_CTRL_IfEnemyNearby");
        this.setItemTypeBranching(true);
    }
    
    @Override
    public int execute(EAI_Manager manager, EntityLiving entity, IInventory inventory, int slotnum, int maxcol) {
        super.execute(manager, entity, inventory, slotnum, maxcol);
        
        mod_EasyAIInterface.getInstance().mod
                .debugPrint("[EAI_CTRL_IfEnemyNearby] " + this.returnTrue() + " : " + this.returnFalse() + "[" + slotnum);
        
        double range = 20D;
        List list = entity.worldObj.getEntitiesWithinAABBExcludingEntity(entity, entity.boundingBox.expand(range, 4D, range));
        Collections.sort(list, new SorterDistanceToEntity(entity));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj instanceof EntityMob && ((EntityMob) obj).getAttackTarget().equals(entity)) {
                return this.returnTrue();
            }
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
        par2List.add(StatCollector.translateToLocal("bbc_mc.EasyAIInterface.item.EAI_CTRL_IfEnemyNearby.line1"));
        par2List.add(StatCollector.translateToLocal("bbc_mc.EasyAIInterface.item.EAI_CTRL_IfEnemyNearby.line2"));
        par2List.add(StatCollector.translateToLocal("bbc_mc.EasyAIInterface.item.EAI_CTRL_IfEnemyNearby.line3"));
        par2List.add(StatCollector.translateToLocal("bbc_mc.EasyAIInterface.item.EAI_CTRL_IfEnemyNearby.line4"));
    }
    */
}
