package bbc_mc.EasyAIInterface;

import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.ModLoader;
import net.minecraft.src.mod_EasyAIInterface;

/**
 * EasyAIInterface のメインクラス
 * 
 * @author bbc_mc
 */
public class EasyAIInterface {
    // mod_ クラスインスタンスへの参照を保持
    public mod_EasyAIInterface mod_EAI;
    // EAI_Items 管理クラスへの参照
    public EAI_Items items;
    // EAI_Localize クラスへの参照を保持
    public EAI_Localize localize;
    
    // YoujoMOD との連携用フラグ
    public boolean isLoaded_MOD_Youjo = false;
    
    public EasyAIInterface(mod_EasyAIInterface mod) {
        this.mod_EAI = mod;
    }
    
    public String getVersion() {
        return "1.2.5-1.0.0";
    }
    
    public void load() {
        ModLoader.setInGameHook(mod_EAI, true, false);
        
        // register Items and recipe
        items = new EAI_Items(this);
        
        // add Localization
        localize = new EAI_Localize(this);
    }
    
    public boolean onTickInGame(float partialTick, Minecraft mc) {
        return false;
    }
    
    public void addRenderer(Map map) {
    }
    
    public void keyboardEvent(KeyBinding keybinding) {
    }
    
    public void modsLoaded() {
    }
    
    // =====================================================
    
    public EAI_Manager getManager() {
        return new EAI_Manager(this);
    }
    
    public void debugPrint(String str) {
        if (mod_EAI.debug_mode) {
            System.out.println(str);
        }
    }
}
