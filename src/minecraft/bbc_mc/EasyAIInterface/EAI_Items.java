package bbc_mc.EasyAIInterface;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.mod_EasyAIInterface;
import bbc_mc.EasyAIInterface.item.EAI_Item_CTRL_IF_EnemyNearby;
import bbc_mc.EasyAIInterface.item.EAI_Item_CTRL_IF_HPLow;
import bbc_mc.EasyAIInterface.item.EAI_Item_CTRL_IF_ItemInItemInventory;
import bbc_mc.EasyAIInterface.item.EAI_Item_CTRL_IF_ItemInventoryFull;
import bbc_mc.EasyAIInterface.item.EAI_Item_SEARCH_block;
import bbc_mc.EasyAIInterface.item.EAI_Item_SEARCH_darkPoint;
import bbc_mc.EasyAIInterface.item.EAI_Item_SEARCH_enemy;
import bbc_mc.EasyAIInterface.item.EAI_Item_SEARCH_item;
import bbc_mc.EasyAIInterface.item.EAI_Item_SEARCH_master;
import bbc_mc.EasyAIInterface.item.EAI_Item_SEARCH_mob;
import bbc_mc.EasyAIInterface.item.EAI_Item_SEARCH_tree;
import bbc_mc.EasyAIInterface.item.EAI_Item_SYS_noop;
import bbc_mc.EasyAIInterface.item.EAI_Item_SYS_return;
import bbc_mc.EasyAIInterface.item.EAI_Item_SYS_start;
import bbc_mc.EasyAIInterface.item.EAI_Item_SYS_wait;
import bbc_mc.EasyAIInterface.item.EAI_Item_TASK_attackByRangedWeapon;
import bbc_mc.EasyAIInterface.item.EAI_Item_TASK_attackOnCollide;
import bbc_mc.EasyAIInterface.item.EAI_Item_TASK_eatFood;
import bbc_mc.EasyAIInterface.item.EAI_Item_TASK_move2target;
import bbc_mc.EasyAIInterface.item.EAI_Item_TASK_pickupItem;
import bbc_mc.EasyAIInterface.item.EAI_Item_TASK_playSound;
import bbc_mc.EasyAIInterface.item.EAI_Item_TASK_swim;
import bbc_mc.EasyAIInterface.item.EAI_Item_TASK_useItemToTarget;
import bbc_mc.EasyAIInterface.item.EAI_Item_WORK_cutTree;

/**
 * MOD が Load された時の Item に関する登録処理を行うクラス
 * 
 * Item 登録とレシピ登録を行う。また addEAIItem 関数を利用して EAI_ItemBase を継承する AI チップの登録を行う
 * 
 * @author bbc_mc
 */
public class EAI_Items {
    // Map of EAI_Items
    private Map<String, Item> itemlist = new HashMap();
    
    // Base class
    private EasyAIInterface mod;
    
    // Instance of Items
    private Item Item_CTRL_IF_EnemyNearby;
    private Item Item_CTRL_IF_HPLow;
    private Item Item_CTRL_IF_ItemInItemInventory;
    private Item Item_CTRL_IF_ItemInventoryFull;
    
    private Item Item_SEARCH_block;
    private Item Item_SEARCH_darkPoint;
    private Item Item_SEARCH_enemy;
    private Item Item_SEARCH_item;
    private Item Item_SEARCH_master;
    private Item Item_SEARCH_mob;
    private Item Item_SEARCH_tree;
    
    private Item Item_SYS_noop;
    private Item Item_SYS_return;
    private Item Item_SYS_start;
    private Item Item_SYS_wait;
    
    private Item Item_TASK_attackByRangedWeapon;
    private Item Item_TASK_attackOnCollide;
    private Item Item_TASK_eatFood;
    private Item Item_TASK_move2target;
    private Item Item_TASK_pickupItem;
    private Item Item_TASK_playSound;
    private Item Item_TASK_swim;
    private Item Item_TASK_useItemToTarget;
    
    private Item Item_WORK_cutTree;
    
    public EAI_Items(EasyAIInterface mod) {
        this.mod = mod;
        
        // Item:Control
        Item_CTRL_IF_EnemyNearby = new EAI_Item_CTRL_IF_EnemyNearby(mod.mod_EAI.idItem_ctrl_if_enemy_nearby - 256);
        Item_CTRL_IF_HPLow = new EAI_Item_CTRL_IF_HPLow(mod.mod_EAI.idItem_ctrl_if_hp_low - 256);
        Item_CTRL_IF_ItemInItemInventory = new EAI_Item_CTRL_IF_ItemInItemInventory(mod.mod_EAI.idItem_ctrl_if_item_in_item_inventory - 256);
        Item_CTRL_IF_ItemInventoryFull = new EAI_Item_CTRL_IF_ItemInventoryFull(mod.mod_EAI.idItem_ctrl_if_item_inventory_full - 256);
        
        // Item:Search
        Item_SEARCH_block = new EAI_Item_SEARCH_block(mod.mod_EAI.idItem_search_block - 256);
        Item_SEARCH_darkPoint = new EAI_Item_SEARCH_darkPoint(mod.mod_EAI.idItem_search_darkPoint - 256);
        Item_SEARCH_enemy = new EAI_Item_SEARCH_enemy(mod.mod_EAI.idItem_search_enemy - 256);
        Item_SEARCH_item = new EAI_Item_SEARCH_item(mod.mod_EAI.idItem_search_item - 256);
        Item_SEARCH_master = new EAI_Item_SEARCH_master(mod.mod_EAI.idItem_search_master - 256);
        Item_SEARCH_mob = new EAI_Item_SEARCH_mob(mod.mod_EAI.idItem_search_mob - 256);
        Item_SEARCH_tree = new EAI_Item_SEARCH_tree(mod.mod_EAI.idItem_search_tree - 256);
        
        // Item:System
        Item_SYS_noop = new EAI_Item_SYS_noop(mod.mod_EAI.idItem_sys_noop - 256);
        Item_SYS_return = new EAI_Item_SYS_return(mod.mod_EAI.idItem_sys_return - 256);
        Item_SYS_start = new EAI_Item_SYS_start(mod.mod_EAI.idItem_sys_start - 256);
        Item_SYS_wait = new EAI_Item_SYS_wait(mod.mod_EAI.idItem_sys_wait - 256);
        
        // Item:Task
        Item_TASK_attackByRangedWeapon = new EAI_Item_TASK_attackByRangedWeapon(mod.mod_EAI.idItem_task_attackByRangedWeapon - 256);
        Item_TASK_attackOnCollide = new EAI_Item_TASK_attackOnCollide(mod.mod_EAI.idItem_task_attackOnCollide - 256);
        Item_TASK_eatFood = new EAI_Item_TASK_eatFood(mod.mod_EAI.idItem_task_eat_food - 256);
        Item_TASK_move2target = new EAI_Item_TASK_move2target(mod.mod_EAI.idItem_task_move2target - 256);
        Item_TASK_pickupItem = new EAI_Item_TASK_pickupItem(mod.mod_EAI.idItem_task_pickupItem - 256);
        Item_TASK_playSound = new EAI_Item_TASK_playSound(mod.mod_EAI.idItem_task_playSound - 256);
        Item_TASK_swim = new EAI_Item_TASK_swim(mod.mod_EAI.idItem_task_swim - 256);
        Item_TASK_useItemToTarget = new EAI_Item_TASK_useItemToTarget(mod.mod_EAI.idItem_task_useItemToTarget - 256);
        
        // Item:Work
        Item_WORK_cutTree = new EAI_Item_WORK_cutTree(mod.mod_EAI.idItem_work_cutTree - 256);
        
        // Recipe (dummy recipe)
        ModLoader.addRecipe(new ItemStack(Item_CTRL_IF_EnemyNearby, 1), new Object[] { " R ", " pR", " p ", Character.valueOf('p'), Block.planks,
                Character.valueOf('R'), Item.redstone });
        ModLoader.addRecipe(new ItemStack(Item_CTRL_IF_HPLow, 1),
                new Object[] { " R ", " bR", " b ", Character.valueOf('b'), Item.bread, Character.valueOf('R'), Item.redstone });
        
        ModLoader.addRecipe(new ItemStack(Item_SEARCH_master, 1),
                new Object[] { " R ", " sR", " s ", Character.valueOf('s'), Item.bread, Character.valueOf('S'), Item.spiderEye });
        ModLoader.addRecipe(new ItemStack(Item_SEARCH_enemy, 1),
                new Object[] { " R ", " sR", " s ", Character.valueOf('s'), Item.sugar, Character.valueOf('S'), Item.spiderEye });
        ModLoader.addRecipe(new ItemStack(Item_SEARCH_mob, 1),
                new Object[] { " R ", " sR", " s ", Character.valueOf('s'), Item.hoeWood, Character.valueOf('S'), Item.spiderEye });
        
        ModLoader.addRecipe(new ItemStack(Item_TASK_eatFood, 1),
                new Object[] { " b ", " hb", " b ", Character.valueOf('b'), Item.bread, Character.valueOf('h'), Item.hoeWood });
        ModLoader.addRecipe(new ItemStack(Item_TASK_attackOnCollide, 1), new Object[] { " a ", " ha", " a ", Character.valueOf('a'), Item.swordWood,
                Character.valueOf('h'), Item.hoeWood });
        ModLoader.addRecipe(new ItemStack(Item_TASK_move2target, 1), new Object[] { " a ", " ha", " a ", Character.valueOf('a'), Item.helmetLeather,
                Character.valueOf('h'), Item.hoeWood });
        
        ModLoader.addRecipe(new ItemStack(Item_SYS_return, 1),
                new Object[] { " R ", " sR", " s ", Character.valueOf('s'), Item.sugar, Character.valueOf('R'), Item.swordStone });
        ModLoader.addRecipe(new ItemStack(Item_SYS_start, 1),
                new Object[] { " R ", " sR", " s ", Character.valueOf('s'), Item.bread, Character.valueOf('R'), Item.swordStone });
        
        // add item to list
        this.addEAIItem("eai.sys.noop", Item_SYS_noop);
        this.addEAIItem("eai.sys.return", Item_SYS_return);
        this.addEAIItem("eai.sys.start", Item_SYS_start);
        this.addEAIItem("eai.sys.wait", Item_SYS_wait);
        
        this.addEAIItem("eai.ctrl.if.enemynearby", Item_CTRL_IF_EnemyNearby);
        this.addEAIItem("eai.ctrl.if.hplow", Item_CTRL_IF_HPLow);
        
        this.addEAIItem("eai.search.block", Item_SEARCH_block);
        this.addEAIItem("eai.search.darkPoint", Item_SEARCH_darkPoint);
        this.addEAIItem("eai.search.enemy", Item_SEARCH_enemy);
        this.addEAIItem("eai.search.item", Item_SEARCH_item);
        this.addEAIItem("eai.search.master", Item_SEARCH_master);
        this.addEAIItem("eai.search.mob", Item_SEARCH_mob);
        
        this.addEAIItem("eai.task.attackByRanged", Item_TASK_attackByRangedWeapon);
        this.addEAIItem("eai.task.attackoncollide", Item_TASK_attackOnCollide);
        this.addEAIItem("eai.task.eatfood", Item_TASK_eatFood);
        this.addEAIItem("eai.task.move2target", Item_TASK_move2target);
        this.addEAIItem("eai.task.pickupItem", Item_TASK_pickupItem);
        this.addEAIItem("eai.task.playSound", Item_TASK_playSound);
        this.addEAIItem("eai.task.swim", Item_TASK_swim);
        this.addEAIItem("eai.task.useItemToTarget", Item_TASK_useItemToTarget);
        
        this.addEAIItem("eai.work.cutTree", Item_WORK_cutTree);
        
        // Load Item texture
        for (Item item : this.itemlist.values()) {
            this.preloadTexture("/bbc_mc/EasyAIInterface/texture/", item, ".png");
        }
        
    }
    
    public boolean isEAIItem(ItemStack itemstack) {
        return itemlist.containsValue(itemstack.getItem());
    }
    
    /**
     * register Item to EAI-Item-Map.
     * 
     * return false if already the name exists.
     * 
     * @param name
     * @param item
     * @return true
     * @return false
     */
    public boolean addEAIItem(String name, Item item) {
        if (this.isEAIItem(new ItemStack(item))) {
            return false;
        } else {
            itemlist.put(name, item);
            return true;
        }
    }
    
    //
    private void preloadTexture(String path, Item item, String footer) {
        mod_EasyAIInterface.getInstance().mod.debugPrint(path + item.getItemName().replace("item.", "") + footer);
        String texture = path + item.getItemName().replace("item.", "") + footer;
        
        int index = ModLoader.addOverride("/terrain.png", texture);
        item.setIconIndex(index);
    }
}
