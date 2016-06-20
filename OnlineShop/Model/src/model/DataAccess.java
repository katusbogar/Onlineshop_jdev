package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class DataAccess {
    public DataAccess() {   //CONSTRUCTOR
        super();            //WHY?
    }

    //http://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html
    //IMPORT THESE LIBRARIES!!!
    Connection con = null;   
    Statement st = null;
    ResultSet rs = null;

    //DB connection string and user properties
    String url = "jdbc:oracle:thin:@10.0.0.128:1521/xe";   //????????????????????????
    String user = "RepCustOrder";
    String pw = "RepCustOrder";

    //EMPLOYEEDO
    public List<EmployeeDO> getEmployees()  {       //return value the List

        rs = null;
        //stroring resultset records in a LiST
        ArrayList<EmployeeDO>myEmployees = new ArrayList<EmployeeDO>();
        
        //Checking if driver is available for ORACLE DBS
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//if this happens
        } catch (ClassNotFoundException e) {//this will handle it
            System.out.println("Where is your Oracle driver?");
            e.printStackTrace();
            //return null;
        }
        
        try{
            //establishing connection
            con = DriverManager.getConnection(url, user, pw);
            
            //create a statement
            st = con.createStatement();
            
            //execute the statement
            rs = st.executeQuery("Select employee_id, last_name, first_name from Employee");
            
            //process resultset, resultset like an array
            while(rs.next()){
                //resultset dissapers after connection has closed -> need for LIST!!!!
                //System.out.println(rs.getInt("employee_id") + " " + rs.getString("last_name") + " " + rs.getString("first_name") );
                //takes out the resultset and create a new employee object and add it to the List
                EmployeeDO e = new EmployeeDO();
                e.setEmployee_ID(rs.getInt("employee_id"));
                e.setLast_name(rs.getString("last_name"));
                e.setFirst_name(rs.getString("first_name"));
                
                myEmployees.add(e);
            }
        
        }catch(SQLException ex){
            ex.printStackTrace();
         
         //close connection!!!! IMPORTANT!! -> MEMORY LEAK   
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    
        return myEmployees;
        }
    
    
    // returns employees where department id > paramDepartmentnumber
    public List<EmployeeDO> getEmployees(int depNo, int depNo2)  {       //return value the List

        rs = null;
        ArrayList<EmployeeDO>myEmployees = new ArrayList<EmployeeDO>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle driver?");
            e.printStackTrace();

        }
        
        try{
            
            con = DriverManager.getConnection(url, user, pw);
            st = con.createStatement();
            
            //SELECT employee_id, last_name, first_name from employee where department_id Between 13 and 19;
            rs = st.executeQuery("Select employee_id, last_name, first_name from Employee where department_id between " + depNo +"AND " + depNo2);
            
            while(rs.next()){
               
                EmployeeDO e = new EmployeeDO();
                e.setEmployee_ID(rs.getInt("employee_id"));
                e.setLast_name(rs.getString("last_name"));
                e.setFirst_name(rs.getString("first_name"));
                
                myEmployees.add(e);
            }
        
        }catch(SQLException ex){
            ex.printStackTrace();
         
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    
        return myEmployees;
        }
    
    
    
    
    
    
    
    
    
    
    
    
    //CUSTOMERDO
    public List<CustomerDO> getCustomers()  {       //return value the List

        rs = null;
        //stroring resultset records in a LiST
        ArrayList<CustomerDO>myCustomers = new ArrayList<CustomerDO>();
        
        //Checking if driver is available for ORACLE DBS
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//if this happens
        } catch (ClassNotFoundException e) {//this will handle it
            System.out.println("Where is your Oracle driver?");
            e.printStackTrace();
            //return null;
        }
        
        try{
            //establishing connection
            con = DriverManager.getConnection(url, user, pw);
            
            //create a statement
            st = con.createStatement();
            
            //execute the statement
            rs = st.executeQuery("Select customer_ID, name, address, city from Customer");
            
            //process resultset, resultset like an array
            while(rs.next()){
                //resultset dissapers after connection has closed -> need for LIST!!!!
                //System.out.println(rs.getInt("customer_ID") + " " + rs.getString("name") + " " + rs.getString("address") + " " + rs.getString("city"));
                //takes out the resultset and create a new customer object and add it to the List
                CustomerDO c = new CustomerDO();
                c.setCustomer_ID(rs.getInt("customer_ID"));
                c.setName(rs.getString("name"));
                c.setAddress(rs.getString("address"));
                c.setCity(rs.getString("city"));
                
                myCustomers.add(c);
            }
        
        }catch(SQLException ex){
            ex.printStackTrace();
         
         //close connection!!!! IMPORTANT!! -> MEMORY LEAK   
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    
        return myCustomers;
        }
    
    
    
    //PRODUCTDO
    public List<ProductDO> getProducts()  {  

        rs = null;
        ArrayList<ProductDO>myProducts = new ArrayList<ProductDO>();
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle driver?");
            e.printStackTrace();
        }
        
        try{
            con = DriverManager.getConnection(url, user, pw);
            st = con.createStatement();
            rs = st.executeQuery("Select product_ID, description from Product");
      
            while(rs.next()){
                ProductDO p = new ProductDO();
                p.setProduct_ID(rs.getInt("product_ID"));
                p.setDescription(rs.getString("description"));
                myProducts.add(p);
            }
        
        }catch(SQLException ex){
            ex.printStackTrace();

        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    
        return myProducts;
        }
    
    
    
    //JOBDO
    public List<JobDO> getJobs()  {  

        rs = null;
        ArrayList<JobDO>myJobs = new ArrayList<JobDO>();
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle driver?");
            e.printStackTrace();
        }
        
        try{
            con = DriverManager.getConnection(url, user, pw);
            st = con.createStatement();
            rs = st.executeQuery("Select job_ID, function from Job");
      
            while(rs.next()){
                JobDO j = new JobDO();
                j.setJob_ID(rs.getInt("job_ID"));
                j.setFunction(rs.getString("function"));
                myJobs.add(j);
            }
        
        }catch(SQLException ex){
            ex.printStackTrace();

        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    
        return myJobs;
        }
    
    
    
    
    //AUTHENTICATE
    public boolean authenticate(String userName, String password)  {  
      
        //rs = null;
        //rs = st.executeQuery("Select user_name, password from RepCustOrder.Myusers where user_name = '" + userName +"' and password = '" + password +"'");
        boolean loginOK = false;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC driver?");
            e.printStackTrace();
            //return loginOK;
        }
        
        try{
            con = DriverManager.getConnection(url, user, pw);
            st = con.createStatement();
            //SELECT user_name, password from Myusers where user_name = 'Katalin' AND password = 'Bella3';
            //rs = st.executeQuery("Select user_name, password from Myusers where user_name = '" + userName +"' and password = '" + password +"'");
            
            String longString = "Select user_name, password from Myusers where user_name = '" + userName +"' and password = '" + password +"'";
            //System.out.println(longString);
            rs = st.executeQuery(longString);
            
            
            
            
            while(rs.next()){
               
                loginOK = true;
            }
        
            
        }catch(SQLException ex){
            System.out.println("SQL exception");
            ex.printStackTrace();

        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    
        return loginOK;
    }
    
    
    
    
    //SIGNUP
    public boolean signUp(String userName, String password)  {  
      
        
        boolean signUp = false;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC driver?");
            e.printStackTrace();
        }
        
        try{
            con = DriverManager.getConnection(url, user, pw);
            st = con.createStatement();
                        
            String sql = "INSERT INTO MYUSERS (User_Name, Password) VALUES ('"  + userName  + "', '" + password + "')";
            st.executeUpdate(sql);
            
            //while(rs.next()){
               
                signUp = true;
           // }
        
            
        }catch(SQLException ex){
            System.out.println("SQL exception");
            ex.printStackTrace();

        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    
        return signUp;
    }
    
 
}
