package bbc_mc.EasyAIInterface;

import java.util.Date;

/**
 * Class to hold Event and time when it happened.
 * 
 * @author bbc_mc
 */
public class EAI_Memory {
    public Date EAI_event_onStart;
    public Date EAI_event_onDamege;
    public Date EAI_event_onEntityCollision;
    
    public void setDateNow(Date target) {
        target = new Date();
    }
}
