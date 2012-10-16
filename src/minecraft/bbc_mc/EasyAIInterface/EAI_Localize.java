package bbc_mc.EasyAIInterface;

import net.minecraft.src.ModLoader;

public class EAI_Localize {
    private EasyAIInterface mod;
    
    public EAI_Localize(EasyAIInterface mod) {
        this.mod = mod;
        
        // Control
        this.addLocalization("item.EAI_CTRL_IfEnemyNearby.name", "ControlTip:IF_EnemyNearby", "制御チップ:敵が近くに居る時");
        this.addLocalization("item.EAI_CTRL_IF_HPLow.name", "ControlTip:IF_HPLow", "制御チップ:HPが残り少ない時");
        this.addLocalization("item.EAI_CTRL_continue.name", "ControlTip:continue", "制御チップ:最初から実行");
        // search
        this.addLocalization("item.EAI_SEARCH_master.name", "SearchTip:master", "探索チップ:主人を探索");
        this.addLocalization("item.EAI_SEARCH_enemy.name", "SearchTip:enemy", "探索チップ:敵を探索");
        this.addLocalization("item.EAI_SEARCH_mob.name", "SearchTip:mob", "探索チップ:Mobを探索");
        
        // Task
        this.addLocalization("item.EAI_TASK_eatFood.name", "TaskTip:eatFood", "実行チップ:食事してHP回復");
        this.addLocalization("item.EAI_TASK_attackOnCollide.name", "TaskTip:attackOnCollide", "実行チップ:Targetを近接攻撃");
        this.addLocalization("item.EAI_TASK_move2target.name", "TaskTip:move2target", "実行チップ:Target へ移動");
    }
    
    private void addLocalization(String target, String str_en_US, String str_ja_JP) {
        ModLoader.addLocalization(target, "en_US", str_en_US);
        ModLoader.addLocalization(target, "ja_JP", str_ja_JP);
    }
    
    private void addInformation(String target, String lang, String line1, String line2, String line3, String line4) {
        ModLoader.addLocalization(target, lang, line1);
        ModLoader.addLocalization(target, lang, line2);
        ModLoader.addLocalization(target, lang, line3);
        ModLoader.addLocalization(target, lang, line4);
    }
}
