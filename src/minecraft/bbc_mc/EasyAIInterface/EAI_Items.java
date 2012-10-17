package bbc_mc.EasyAIInterface;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class EAI_Items {
    // Map of EAI_Items
    private Map<String, Item> itemlist = new HashMap();
    
    // Base class
    private EasyAIInterface mod;
    
    // Instance of Items
    private Item Item_SYS_return;
    private Item Item_SYS_start;
    
    private Item Item_CTRL_IF_EnemyNearby;
    private Item Item_CTRL_IF_HPLow;
    
    private Item Item_SEARCH_master;
    private Item Item_SEARCH_enemy;
    private Item Item_SEARCH_mob;
    
    private Item Item_TASK_eatFood;
    private Item Item_TASK_attackOnCollide;
    private Item Item_TASK_move2target;
    private Item Item_TASK_playSound;
    
    public EAI_Items(EasyAIInterface mod) {
        this.mod = mod;
        
        // Item:Control
        Item_CTRL_IF_EnemyNearby = new EAI_Item_CTRL_IF_EnemyNearby(mod.mod_EAI.idItem_ctrl_if_enemy_nearby - 256);
        Item_CTRL_IF_HPLow = new EAI_Item_CTRL_IF_HPLow(mod.mod_EAI.idItem_ctrl_if_hp_low - 256);
        
        // Item:Search
        Item_SEARCH_master = new EAI_Item_SEARCH_master(mod.mod_EAI.idItem_search_parent - 256);
        Item_SEARCH_enemy = new EAI_Item_SEARCH_enemy(mod.mod_EAI.idItem_search_enemy - 256);
        Item_SEARCH_mob = new EAI_Item_SEARCH_mob(mod.mod_EAI.idItem_search_mob - 256);
        
        // Item:Task
        Item_TASK_eatFood = new EAI_Item_TASK_eatFood(mod.mod_EAI.idItem_task_eat_food - 256);
        Item_TASK_attackOnCollide = new EAI_Item_TASK_attackOnCollide(mod.mod_EAI.idItem_task_attackOnCollide - 256);
        Item_TASK_move2target = new EAI_Item_TASK_move2target(mod.mod_EAI.idItem_task_move2target - 256);
        Item_TASK_playSound = new EAI_Item_TASK_playSound(mod.mod_EAI.idItem_task_playSound - 256);
        
        // Item:System
        Item_SYS_return = new EAI_Item_SYS_return(mod.mod_EAI.idItem_sys_return - 256);
        Item_SYS_start = new EAI_Item_SYS_start(mod.mod_EAI.idItem_sys_start - 256);
        
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
        this.addEAIItem("eai.ctrl.if.enemynearby", Item_CTRL_IF_EnemyNearby);
        this.addEAIItem("eai.ctrl.if.hplow", Item_CTRL_IF_HPLow);
        this.addEAIItem("eai.search.master", Item_SEARCH_master);
        this.addEAIItem("eai.search.enemy", Item_SEARCH_enemy);
        this.addEAIItem("eai.search.mob", Item_SEARCH_mob);
        this.addEAIItem("eai.task.eatfood", Item_TASK_eatFood);
        this.addEAIItem("eai.task.attackoncollide", Item_TASK_attackOnCollide);
        this.addEAIItem("eai.task.move2target", Item_TASK_move2target);
        this.addEAIItem("eai.sys.return", Item_SYS_return);
        this.addEAIItem("eai.sys.start", Item_SYS_start);
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
}
