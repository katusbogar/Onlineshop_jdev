package model.unittest;

import model.DataAccess;

public class TestInsertSql {
    public TestInsertSql() {
        super();
    }

    public static void main(String[] args) {
        
        String userName = "Krisztina";
        String password = "Bogyo";
        
       
        String sql = "INSERT INTO MYUSERS (User_Name, Password) VALUES ('"  + userName  + "', '" + password + "')";
        //String longString = "Select user_name, password from RepCustOrder.Myusers where user_name = '" + userName +"' and password = '" + password +"'";
        System.out.println(sql);
        
    }
}
