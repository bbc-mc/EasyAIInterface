package net.minecraft.src;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import bbc_mc.EasyAIInterface.EAI_Manager;

public class YoujoAI_EasyAIInterface implements IYoujoAI {
    
    private int slotnum;
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
        
        slotnum = 0;
    }
    
    @Override
    public void excute(EntityYoujo entity) {
        if (slotnum < 0 || entity.inventory.getSizeInventory() < slotnum) {
            entity.setYoujoAI(entity.defaultAI);
        } else {
            int ret = this.manager.execute(entity, entity.inventory, slotnum, 9);
            if (ret >= 0) {
                slotnum = ret;
                debugPrint("AI: slotnum update : " + slotnum);
            }
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
        this.manager.memory.EAI_event_onDamege = new Date();
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
