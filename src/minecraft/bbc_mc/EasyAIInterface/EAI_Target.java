package bbc_mc.EasyAIInterface;

import net.minecraft.src.Entity;
import net.minecraft.src.Vec3D;

/**
 * 選択したターゲットの情報を保持するクラス
 * 
 * ターゲットが Entity の場合と座標の場合に対応する
 * 
 * @author bbc_mc
 */
public class EAI_Target {
    
    private Vec3D targetPos;
    private Entity targetEntity;
    
    public EAI_Target() {
        this.targetPos = null;
        this.targetEntity = null;
    }
    
    public void setTarget(Entity targetEntity) {
        this.targetEntity = targetEntity;
        if (targetEntity != null) {
            this.targetPos = Vec3D.createVectorHelper(targetEntity.posX, targetEntity.posY, targetEntity.posZ);
        } else {
            this.targetPos = null;
        }
    }
    
    public void setTarget(double posX, double posY, double posZ) {
        this.targetEntity = null;
        this.targetPos = Vec3D.createVectorHelper(targetEntity.posX, targetEntity.posY, targetEntity.posZ);
    }
    
    public Entity getTargetEntity() {
        return this.targetEntity;
    }
    
    public Vec3D getTargetPos() {
        return this.targetPos;
    }
    
    public boolean isEntity() {
        return (this.targetEntity != null && !this.targetEntity.isDead);
    }
    
    public boolean hasTarget() {
        return (this.targetEntity != null || this.targetPos != null);
    }
}
