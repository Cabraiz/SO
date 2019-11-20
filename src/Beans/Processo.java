package Beans;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Mateus
 */
public class Processo {

    public int ID;
    public double exe;//(4/20)
    public Timestamp deadline;//(4/20)
    public long createTime;
    public int prior;//(0/3) 

    public long markerTime;

    Random rd = new Random();
    
    //MEMORY
    public int memory;
    public boolean IsWorking;
    public int oldMemory;

    public Processo() {
    }

    public Processo(int ID) {
        this.ID = ID;
        this.exe = rd.nextInt(17) + 4;

        int sec = rd.nextInt(17) + 8;

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Timestamp(System.currentTimeMillis()).getTime());
        cal.add(Calendar.SECOND, sec);

        this.deadline = new Timestamp(cal.getTime().getTime());

        this.prior = rd.nextInt(4);

        this.createTime = new Timestamp(System.currentTimeMillis()).getTime();
        
        //this.memory = rd.nextInt(80) + 32;
        this.memory = rd.nextInt(993) + 32;
        
        this.oldMemory = this.memory;
        
        this.IsWorking = true;
    }
    
    public Processo(Processo p){
        this.ID = p.ID;
        this.memory = p.memory;
        this.IsWorking = p.IsWorking;
        this.oldMemory = p.oldMemory;
    }
    
    public Processo(int ID, double execucao, Timestamp deadline, int prioridade, long createTime, long markerTime,
                                                                int memory , boolean IsWorking, int oldMemory) {
        this.ID = ID;
        this.exe = execucao;
        this.deadline = deadline;
        this.createTime = createTime;
        this.prior = prioridade;
        this.markerTime = markerTime;
        this.memory = memory;
        this.IsWorking = IsWorking;
        this.oldMemory = oldMemory;
        
    }

    
    public Processo(int ID, double execucao, Timestamp deadline, int prioridade, long createTime, int memory,
                                                                             boolean IsWorking, int oldMemory) {
        this.ID = ID;
        this.exe = execucao;
        this.deadline = deadline;
        this.prior = prioridade;
        this.createTime = createTime;
        this.memory = memory;
        this.IsWorking = IsWorking;
        this.oldMemory = oldMemory;
        
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Random getRd() {
        return rd;
    }

    public void setRd(Random rd) {
        this.rd = rd;
    }

    public double getExe() {
        return exe;
    }

    public void setExe(double exe) {
        this.exe = exe;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getPrior() {
        return prior;
    }

    public void setPrior(int prior) {
        this.prior = prior;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public void setPrioridade(int prioridade) {
        this.prior = prioridade;
    }

    public long getMarkerTime() {
        return markerTime;
    }

    public void setMarkerTime(long markerTime) {
        this.markerTime = markerTime;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public boolean isWorking() {
        return IsWorking;
    }

    public void setIsWorking(boolean IsWorking) {
        this.IsWorking = IsWorking;
    }

}
