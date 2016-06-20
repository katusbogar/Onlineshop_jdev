package model;

public class EmployeeDO {
    public EmployeeDO() {
        super();
    }
    
    private int employee_ID;
    private String last_name;
    private String first_name;

    public void setEmployee_ID(int employee_ID) {
        this.employee_ID = employee_ID;
    }

    public int getEmployee_ID() {
        return employee_ID;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return first_name;
    }
    
}
