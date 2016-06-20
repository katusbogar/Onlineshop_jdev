package model;

public class JobDO {
    public JobDO() {
        super();
    }
    
    private int job_ID;
    private String function;

    public void setJob_ID(int job_ID) {
        this.job_ID = job_ID;
    }

    public int getJob_ID() {
        return job_ID;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }
}
