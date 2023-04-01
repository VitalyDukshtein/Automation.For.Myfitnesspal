package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps {

         /*
         #######################################################################################
         Method Name: startConnection
         Method Description: This method connects to the SQL Database
         Method Parameters: String
         Method Return: -
         #######################################################################################
         */
    public static void startConnection(String dbURL, String email, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, email, pass);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, see Details: " + e);
        }
    }

    /*
         #######################################################################################
         Method Name: endConnection
         Method Description: This method disconnects from the SQL Database
         Method Parameters: -
         Method Return: -
         #######################################################################################
         */

    public static void endConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error Occurred while closing DB, see Details: " + e);
        }
    }
}
