package model;

 //Customer table
public class CustomerDO {  
    public CustomerDO() {
        super();
    }
    //column mapping from Customer table to Java object field
    private int customer_ID;
    private String name;
    private String address;
    private String city;

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
  


}
