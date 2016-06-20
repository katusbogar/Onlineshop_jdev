package model;

public class ProductDO {
    public ProductDO() {
        super();
    }
    
    private int product_ID;
    private String description;

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}


