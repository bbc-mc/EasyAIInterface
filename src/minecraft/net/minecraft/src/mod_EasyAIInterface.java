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
    public static boolean debug_mode = false;
    @MLProp
    public static int loopWait = 4;
    
    // Item:Search
    @MLProp
    public static int idItem_search_block = 29001;
    @MLProp
    public static int idItem_search_master = 29002;
    @MLProp
    public static int idItem_search_enemy = 29003;
    @MLProp
    public static int idItem_search_mob = 29004;
    @MLProp
    public static int idItem_search_item = 29005;
    
    // Item:Control. (if,,)
    @MLProp
    public static int idItem_ctrl_if_enemy_nearby = 29101;
    @MLProp
    public static int idItem_ctrl_if_hp_low = 29102;
    
    // Item:Task
    @MLProp
    public static int idItem_task_attackByRangedWeapon = 29201;
    @MLProp
    public static int idItem_task_attackOnCollide = 29202;
    @MLProp
    public static int idItem_task_eat_food = 29203;
    @MLProp
    public static int idItem_task_move2target = 29204;
    @MLProp
    public static int idItem_task_playSound = 29205;
    @MLProp
    public static int idItem_task_swim = 29206;
    @MLProp
    public static int idItem_task_pickupItem = 29207;
    
    // Item:System
    @MLProp
    public static int idItem_sys_return = 29301;
    @MLProp
    public static int idItem_sys_start = 29302;
    @MLProp
    public static int idItem_sys_wait = 29303;
    
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