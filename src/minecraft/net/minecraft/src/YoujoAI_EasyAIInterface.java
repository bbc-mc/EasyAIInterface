package net.minecraft.src;

import java.lang.reflect.Method;
import java.util.List;

import bbc_mc.EasyAIInterface.EAI_Manager;

public class YoujoAI_EasyAIInterface implements IYoujoAI {
    
    private mod_EasyAIInterface mod_EAI;
    private EAI_Manager manager;
    private EntityYoujo youjo;
    
    // Debug message flg.
    private boolean debug_mode = true;
    
    @Override
    public String AIName() {
        return "EasyAIInterface";
    }
    
    @Override
    public void start(EntityYoujo entity) {
        this.youjo = entity;
        List loadedMods = ModLoader.getLoadedMods();
        try {
            Class c = Class.forName("net.minecraft.src.mod_EasyAIInterface");
            Method method = c.getDeclaredMethod("getInstance");
            mod_EAI = (mod_EasyAIInterface) method.invoke(null);
            manager = mod_EAI.getManager();
        } catch (Exception e) {
            e.printStackTrace();
            entity.setYoujoAI(entity.defaultAI);
        }
        
        this.manager.init(entity, entity.inventory, this.manager.findStartTip(entity.inventory), 9);
    }
    
    @Override
    public void excute(EntityYoujo entity) {
        if (this.manager.execute()) {
            debugPrint("AI: slotnum update : " + this.manager.getCurrentSlot());
        } else {
            entity.setYoujoAI(entity.defaultAI);
        }
    }
    
    @Override
    public void end(EntityYoujo entity) {
        
    }
    
    @Override
    public void damege(DamageSource par1DamageSource, int par2) {
        debugPrint(" Youjo HP : " + this.youjo.getHealth());
    }
    
    @Override
    public void fall() {
        
    }
    
    @Override
    public void kill() {
        
    }
    
    @Override
    public void entityCollision(Entity par1Entity) {
    }
    
    @Override
    public void inPortal() {
        
    }
    
    @Override
    public void inWeb() {
    }
    
    //
    private void debugPrint(String str) {
        if (debug_mode) {
            System.out.println(str);
        }
    }
}
