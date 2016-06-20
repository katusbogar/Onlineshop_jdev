package model.unittest;

public class TestSQLString1 {
    public TestSQLString1() {
        super();
    }

    public static void main(String[] args) {
        String userName = "Katalin";
        String password = "Bella3";
        
        String longString = "Select user_name, password from RepCustOrder.Myusers where user_name = '" + userName +"' and password = '" + password +"'";
        System.out.println(longString);
    }
}
