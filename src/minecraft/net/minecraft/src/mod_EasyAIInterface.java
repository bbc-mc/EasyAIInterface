package net.minecraft.src;

import java.util.Map;

import net.minecraft.client.Minecraft;
import bbc_mc.EasyAIInterface.EAI_Manager;
import bbc_mc.EasyAIInterface.EasyAIInterface;

public class mod_EasyAIInterface extends BaseMod {
    
    //
    // Settings
    //
    @MLProp
    public static boolean debug_mode = true;
    @MLProp
    public static int loopWait = 4;
    
    // Item:Search (entity)
    @MLProp
    public static int idItem_search_parent = 29001;
    @MLProp
    public static int idItem_search_enemy = 29002;
    @MLProp
    public static int idItem_search_mob = 29003;
    
    // Item:Control. (if,,)
    @MLProp
    public static int idItem_ctrl_if_enemy_nearby = 29101;
    @MLProp
    public static int idItem_ctrl_if_hp_low = 29102;
    @MLProp
    public static int idItem_ctrl_coninue = 29103;
    
    // Item:Task
    @MLProp
    public static int idItem_task_eat_food = 29201;
    @MLProp
    public static int idItem_task_attackOnCollide = 29202;
    @MLProp
    public static int idItem_task_move2target = 29203;
    @MLProp
    public static int idItem_task_playSound = 29204;
    
    // Item:System
    @MLProp
    public static int idItem_sys_return = 29301;
    @MLProp
    public static int idItem_sys_start = 29302;
    
    public final EasyAIInterface mod;
    
    private static mod_EasyAIInterface instance;
    
    public mod_EasyAIInterface() {
        mod = new EasyAIInterface(this);
        instance = this;
    }
    
    @Override
    public String getVersion() {
        return mod.getVersion();
    }
    
    @Override
    public void load() {
        mod.load();
    }
    
    @Override
    public boolean onTickInGame(float partialTick, Minecraft mc) {
        return mod.onTickInGame(partialTick, mc);
    }
    
    @Override
    public void addRenderer(Map map) {
        mod.addRenderer(map);
    }
    
    @Override
    public void keyboardEvent(KeyBinding keybinding) {
        mod.keyboardEvent(keybinding);
    }
    
    @Override
    public void modsLoaded() {
        mod.modsLoaded();
    }
    
    // ====================================================
    public EAI_Manager getManager() {
        return this.mod.getManager();
    }
    
    public static mod_EasyAIInterface getInstance() {
        return instance;
    }
}