/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;

/**
 *
 * @author fennell.38261
 */
import java.sql.*;
import java.util.Properties;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3308/";
String dbName = "wildlifesanctuary";
String driver = "com.mysql.jdbc.Driver";
String userName = "root";
String dbpassword = "";
try {
// loading driver
Class.forName(driver);
// Connection set up with database named as user
Connection con = DriverManager.getConnection(url+dbName,userName,dbpassword);
           
              // Connection con = d.connect(url,prop);
         if(con==null)   {
            System.out.println("connection failed");
            return;
        }
         else
             System.out.println("Connection Successful");
        DatabaseMetaData dm =con.getMetaData();
        String dbversion=dm.getDatabaseProductVersion();
        String dbname=dm.getDatabaseProductName();
        System.out.println("name:"+dbname);
        System.out.println("version:"+dbversion);

          Statement stat =con.createStatement();

          String sql ="SELECT * FROM ANIMAL";

          ResultSet rs =stat.executeQuery(sql);

          while(rs.next()){

          String ANIMAL_ID =rs.getString("ANIMAL_ID");
          String ANIMAL_NAME =rs.getString("ANIMAL_NAME");
          String ANIMAL_TYPE =rs.getString("ANIMAL_TYPE");
          String GENDER =rs.getString("GENDER");
          Date DOB =rs.getDate("DOB");
          //Date REG_DATE =rs.getDate("REGDATE");
          String DIET_TYPE =rs.getString("DIET_TYPE");
          String DIET =rs.getString("DIET");
          String STATUS =rs.getString("STATUS");
          String HEALTH =rs.getString("HEALTH");
          int SPACE_REQUIRED_ACRES =rs.getInt("SPACE_REQUIRED_ACRES");



          System.out.println("ANIMAL ID: "+ANIMAL_ID + "\tANIMAL NAME: "+ANIMAL_NAME + "\tANIMAL TYPE: "+ANIMAL_TYPE + "\tGENDER: "+GENDER + "\tDOB: "+DOB  + "\tDIET TYPE: "+DIET_TYPE + "\tDIET: "+DIET + "\tSTATUS: "+STATUS + "\tHEALTH: "+HEALTH + "\tSPACE REQUIRED ACRES: "+SPACE_REQUIRED_ACRES);

          }
          con.close();
          } catch (Exception e) {
          e.printStackTrace();
          }
          }


    }


