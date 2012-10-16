package bbc_mc.EasyAIInterface;

import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityLittleMaid;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityYoujo;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.ModLoader;
import net.minecraft.src.mod_EasyAIInterface;

public class EasyAIInterface {
    public mod_EasyAIInterface mod_EAI;
    public EAI_Items items;
    // public EAI_Entities entities;
    public EAI_Localize localize;
    // public EAI_KeyEvent keyEvent;
    
    public boolean isLoaded_MOD_Youjo = false;
    public boolean isLoaded_MOD_LittleMaidMob = false;
    
    public EasyAIInterface(mod_EasyAIInterface mod) {
        this.mod_EAI = mod;
    }
    
    public String getVersion() {
        return null;
    }
    
    public void load() {
        ModLoader.setInGameHook(mod_EAI, true, false);
        
        // register Items and recipe
        items = new EAI_Items(this);
        
        // register Entities
        // add Localization
        localize = new EAI_Localize(this);
        // register keyevent
    }
    
    public boolean onTickInGame(float partialTick, Minecraft mc) {
        return false;
    }
    
    public void addRenderer(Map map) {
        
    }
    
    public void keyboardEvent(KeyBinding keybinding) {
        
    }
    
    public void modsLoaded() {
        if (ModLoader.getLoadedMods().contains("mod_YoujoMod")) {
            this.isLoaded_MOD_Youjo = true;
        } else {
            System.out.println(ModLoader.getLoadedMods());
        }
        if (ModLoader.getLoadedMods().contains("mod_LittleMaidMob")) {
            this.isLoaded_MOD_LittleMaidMob = true;
        } else {
            System.out.println(ModLoader.getLoadedMods());
        }
    }
    
    // =====================================================
    
    public EAI_Manager getManager() {
        return new EAI_Manager(this);
    }
    
    // =====================================================
    public void debugPrint(String str) {
        if (mod_EAI.debug_mode) {
            System.out.println(str);
        }
    }
    
    public boolean isEntityYoujo(EntityLiving entity) {
        if (this.isLoaded_MOD_Youjo) {
            if (entity instanceof EntityYoujo) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isEntityLMM(EntityLiving entity) {
        if (this.isLoaded_MOD_Youjo) {
            if (entity instanceof EntityLittleMaid) {
                return true;
            }
        }
        return false;
    }
}
