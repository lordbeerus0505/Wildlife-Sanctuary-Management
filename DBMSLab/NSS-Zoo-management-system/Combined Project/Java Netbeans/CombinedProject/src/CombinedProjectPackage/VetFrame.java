/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VetFrame.java
 *
 * Created on 20-Mar-2014, 15:44:09
 */

package CombinedProjectPackage;

import inheritance_folder.Animal;
//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.bson.BsonDocument;
import com.mongodb.MongoClient;
import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.Document;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author fennell.38261
 */

class MongoRetrieve {
    String a;
    String finalString="";
    public void title(Document d)
    {
        String s=(String)d.get("title");
        if(s!=null && s!="")
        { System.out.println("Title:"+s);
                finalString+="<BR>Title:"+s;}
        else{
            System.out.println("No title found");
        }
        
    }
    public void desc(Document d)
    {
       String s=(String)d.get("description");
        if(s!=null && s!="")
        {System.out.println("Description:"+s);
        finalString+="<BR>Description:"+s;
        }        
        else{
            System.out.println("No description found");
        } 
    }
    public void name(Document d)
    {
       String s=(String)d.get("name");
        if(s!=null && s!="")
        {System.out.println("Animal Name:"+s);
        finalString+="<BR>Name:"+s;}
        
        else{
            System.out.println("No name found");
        } 
    }
    public void notes(Document d)
    {
       String s=(String)d.get("notes");
        if(s!=null && s!="")
        {System.out.println("Additonal Notes:"+s);
        finalString+="<BR>Notes:"+s;}
        
        else{
            System.out.println("No additonal notes");
        } 
    }
    public void id(Document d)
    {
        String s=(String)d.get("id");
        if(s!=null && s!="")
        {System.out.println("ID:"+s);
        finalString+="<BR>ID:"+s;
        }
        else{
            System.out.println("No records found");
        } 
        
    }
    public void pres(Document d)
    {
       String s=(String)d.get("prescription");
        if(s!=null && s!="")
        {System.out.println("Prescription:"+s);
        finalString+="<BR>Prescription:"+s+"<BR><BR>";
        }
        else{
            System.out.println("No prescription provided");
        } 
    }
    public void type(Document d)
    {
       String s=(String)d.get("type");
        if(s!=null && s!="")
        {System.out.println("Animal Type:"+s);
        finalString+="<BR>Type:"+s;
        }
        else{
            System.out.println("No type specified");
        } 
    }
    
    
   
}

public class VetFrame extends javax.swing.JFrame {

    public boolean check(Document d,String s)
    {
        String str=(String)d.get("id");
//        System.out.print(str);
        
        if(str!=null){
        if(str.contains(s.toUpperCase()) )
        {
//            System.out.println("hello world");
           return true;
        }
        }
        return false;
    }
     public void search_by_id(String s)
    {
         MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("zoo");

        MongoCollection<Document> col = database.getCollection("zoo");
        MongoRetrieve obj=new MongoRetrieve();
        try{
            MongoCursor<Document> cur = col.find().iterator();
            while (cur.hasNext()) {

                Document doc = cur.next();
                if(check(doc,s)){
                 Info.setVisible(false);
//Info.setText("Further Veterinary Information Available");
                retrieve.setVisible(true);
                
                System.out.println("The following are the data available for the name provided");
                obj.id(doc);
                obj.name(doc);
                obj.type(doc);
                obj.title(doc);
                obj.desc(doc);
                obj.notes(doc);
                obj.pres(doc);
                System.out.println(obj.finalString);
                MongoOp.setText(String.valueOf("<html>Testing<BR>\n"+obj.finalString+"</html>"));
                
                }
                else
                {
                    Info.setVisible(true);
//Info.setText("Further Veterinary Information Available");
                retrieve.setVisible(false);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        mongoClient.close();
    }
     
    private PreparedStatement prest;
    Animal A = new Animal();
    /** Creates new form VetFrame */
    public VetFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        VetTable = new javax.swing.JTable();
        VetSearch = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        VetCBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        VetIDSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        AnimalName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AnimalType = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        Title = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Description = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Notes = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Prescription = new javax.swing.JTextField();
        Submit = new javax.swing.JButton();
        Mongo = new javax.swing.JLabel();
        Info = new javax.swing.JLabel();
        retrieve = new javax.swing.JButton();
        MongoOp = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        Close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        VetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(VetTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 710, 320);

        VetSearch.setText("Search");
        VetSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VetSearchActionPerformed(evt);
            }
        });
        getContentPane().add(VetSearch);
        VetSearch.setBounds(20, 400, 120, 23);

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 400, 120, 23);

        VetCBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "animal", "records" }));
        VetCBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VetCBox1ActionPerformed(evt);
            }
        });
        VetCBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VetCBox1KeyPressed(evt);
            }
        });
        getContentPane().add(VetCBox1);
        VetCBox1.setBounds(30, 20, 160, 20);

        jLabel1.setText("Animal ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 20, 60, 20);
        getContentPane().add(VetIDSearch);
        VetIDSearch.setBounds(270, 20, 100, 20);

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(580, 400, 110, 23);

        jButton3.setText("Veterinary Form ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(300, 400, 140, 23);

        jLabel3.setText("Animal Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 50, 100, 14);

        AnimalName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnimalNameActionPerformed(evt);
            }
        });
        getContentPane().add(AnimalName);
        AnimalName.setBounds(130, 50, 100, 20);

        jLabel4.setText("Type");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 80, 100, 14);

        AnimalType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mammal", "Amphibian", "Bird", "Reptile","Invertebrate" }));
        AnimalType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnimalTypeActionPerformed(evt);
            }
        });
        getContentPane().add(AnimalType);
        AnimalType.setBounds(130, 80, 100, 20);

        jLabel5.setText("Title");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 110, 100, 14);
        getContentPane().add(Title);
        Title.setBounds(130, 110, 100, 20);

        jLabel6.setText("Description");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 140, 100, 14);
        getContentPane().add(Description);
        Description.setBounds(130, 140, 100, 20);

        jLabel7.setText("Notes");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 170, 100, 14);
        getContentPane().add(Notes);
        Notes.setBounds(130, 170, 100, 20);

        jLabel8.setText("Prescription");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 200, 100, 14);
        getContentPane().add(Prescription);
        Prescription.setBounds(130, 200, 100, 20);

        Submit.setText("Submit Form");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        getContentPane().add(Submit);
        Submit.setBounds(80, 240, 110, 23);

        Mongo.setText("jLabel10");
        getContentPane().add(Mongo);
        Mongo.setBounds(170, 70, 350, 140);

        Info.setText("No further information added by the vet.");
        getContentPane().add(Info);
        Info.setBounds(410, 20, 260, 20);

        retrieve.setText("Retrieve Further Information");
        retrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrieveActionPerformed(evt);
            }
        });
        getContentPane().add(retrieve);
        retrieve.setBounds(480, 20, 220, 23);

        MongoOp.setText("jLabel2");
        MongoOp.setAutoscrolls(true);
        getContentPane().add(MongoOp);
        MongoOp.setBounds(140, 60, 480, 280);

        jButton4.setText("jButton4");
        getContentPane().add(jButton4);
        jButton4.setBounds(310, 400, 73, 23);

        Close.setText("Close Additional Information");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        getContentPane().add(Close);
        Close.setBounds(250, 360, 250, 23);

        setSize(new java.awt.Dimension(754, 471));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void VetCBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VetCBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VetCBox1ActionPerformed

    private void VetSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VetSearchActionPerformed

          String url = "jdbc:mysql://localhost:3306/";
String dbName = "zoodb";
String driver = "com.mysql.jdbc.Driver";
String userName = "root";
String password = "abhiram";

     if (VetCBox1.getSelectedItem().equals("animal"))
      {
      try
      {
            Class.forName(driver).newInstance();
            Connection conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Database Connection Successful");

            // Set Up SQL
            String sql = "SELECT * FROM animal WHERE ANIMAL_ID LIKE ?";

            // Excute Query and send result set to rs
            prest = conn.prepareStatement(sql);
            prest.setString(1,VetIDSearch.getText());

            ResultSet rs = prest.executeQuery();

            //Retrieve by column name
            VetTable.setModel(DbUtils.resultSetToTableModel(rs));

            rs.close();
            prest.close();

            // Close the connection to the database
            conn.close();
        }
            catch (Exception e)
            {
            e.printStackTrace();
            }
        }

      else if (VetCBox1.getSelectedItem().equals("records"))
      {
      try
      {
            Class.forName(driver).newInstance();
            Connection conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Database Connection Successful");

            // Set Up SQL
            String sql = "SELECT * FROM records WHERE RECORD_ID LIKE ?";

            // Excute Query and send result set to rs
            prest = conn.prepareStatement(sql);
            prest.setString(1,VetIDSearch.getText());

            ResultSet rs = prest.executeQuery();

            //Retrieve by column name
            VetTable.setModel(DbUtils.resultSetToTableModel(rs));

            rs.close();
            prest.close();

            // Close the connection to the database
            conn.close();
            }
            catch (Exception e)
            {
            e.printStackTrace();
            }
        }
    MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase database = mongoClient.getDatabase("zoo");

    MongoCollection<Document> col = database.getCollection("zoo");
    //MongoRetrieve obj=new MongoRetrieve();
    search_by_id(VetIDSearch.getText());

    }//GEN-LAST:event_VetSearchActionPerformed

    private void VetCBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VetCBox1KeyPressed
    
    if (evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER)

    if (VetCBox1.getSelectedItem().equals("animal"))
    {
    VetIDSearch.setVisible(true);
    jLabel1.setVisible(true);
    }

    else if (VetCBox1.getSelectedItem().equals("records"))
    {
    VetIDSearch.setVisible(true);
    jLabel1.setVisible(true);
    }



    }//GEN-LAST:event_VetCBox1KeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    retrieve.setVisible(false);
    MongoOp.setVisible(false);
    Close.setVisible(false);
    jButton4.setVisible(false);
        VetIDSearch.setVisible(true);
    jLabel1.setVisible(true);
    AnimalName.setVisible(false);
    Mongo.setVisible(false);
    jLabel3.setVisible(false);
    AnimalType.setVisible(false);
    jLabel4.setVisible(false);
    Title.setVisible(false);
    jLabel5.setVisible(false);
    Description.setVisible(false);
    jLabel6.setVisible(false);
    Notes.setVisible(false);
    jLabel7.setVisible(false);
    Prescription.setVisible(false);
    jLabel8.setVisible(false);
    Submit.setVisible(false);
    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          String url = "jdbc:mysql://localhost:3306/";
String dbName = "zoodb";
String driver = "com.mysql.jdbc.Driver";
String userName = "root";
String password = "abhiram";

          try
          {
          Class.forName(driver).newInstance();
          Connection conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
          System.out.println("Database Connection Successful");

          // Set Up SQL
        String sql = " UPDATE animal set ANIMAL_NAME = ?, ANIMAL_TYPE = ?, "
                    + " GENDER = ?, DOB = ?, DIET_TYPE = ?, DIET = ?, STATUS = ?, HEALTH= ?, "
                    +" SPACE_REQUIRED_ACRES = ? WHERE ANIMAL_ID = ? ";

        //A.setAnimal_ID(AnimalSearchTable.getValueAt(0, 1).toString());
        A.setAnimal_ID(A.getAnimal_ID());
        A.setAnimal_Name(VetTable.getValueAt(0, 1).toString());
        A.setAnimal_Type(VetTable.getValueAt(0, 2).toString());
        A.setGender(VetTable.getValueAt(0, 3).toString());
        A.setDOB(VetTable.getValueAt(0, 4).toString());
        A.setDiet_Type(VetTable.getValueAt(0, 5).toString());
        A.setDiet(VetTable.getValueAt(0, 6).toString());
        A.setStatus(VetTable.getValueAt(0, 7).toString());
        A.setHealth(VetTable.getValueAt(0, 8).toString());
        A.setSpace_Required_Acres(Integer.parseInt(VetTable.getValueAt(0, 9).toString()));
        
        //System.out.println(VetTable.getValueAt(0, 1).toString());
        //System.out.println(VetTable.getValueAt(0, 2).toString());
        //System.out.println(VetTable.getValueAt(0, 3).toString());
          // Excute Query and send result set to rs
          prest = conn.prepareStatement(sql);

          //prest.setString(1, A.getAnimal_ID());

          prest.setString(1, A.getAnimal_Name());
          prest.setString(2, A.getAnimal_Type());
          prest.setString(3, A.getGender());
          prest.setString(4, A.getDOB());
          prest.setString(5, A.getDiet_Type());
          prest.setString(6, A.getDiet());
          prest.setString(7, A.getStatus());
          prest.setString(8, A.getHealth());
          prest.setInt(9, A.getSpace_Required_Acres());
          prest.setString(10, VetIDSearch.getText());
        //  System.out.println(A.getAnimal_Name());
        //System.out.println(A.getAnimal_Type());
        //System.out.println(A.getGender());

          prest.executeUpdate();
          JOptionPane.showMessageDialog(rootPane, "Update Successfull!");

          // Close the connection to the database
          conn.close();
          prest.close();
          }

          //catch (SQLException s)
          //{
          //System.out.println("SQL statement is not executed!");
          //JOptionPane.showMessageDialog(rootPane, "Update NOT Successfull!");
          //}

          catch (Exception e)
          {
          e.printStackTrace();
          }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Login Frame0= new Login();
        Frame0.setVisible(true);

        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
setSize(new java.awt.Dimension(300, 400));
    VetIDSearch.setVisible(false);
    VetCBox1.setVisible(false);
    VetTable.setVisible(false);
    jScrollPane1.setVisible(false);
    jLabel1.setVisible(false);
    jButton1.setVisible(false);
    jButton2.setVisible(false);
    jButton3.setVisible(false);
    VetSearch.setVisible(false);
    VetTable.setVisible(false);
    AnimalName.setVisible(true);
    jLabel3.setVisible(true);
    AnimalType.setVisible(true);
    jLabel4.setVisible(true);
    Title.setVisible(true);
    jLabel5.setVisible(true);
    Description.setVisible(true);
    jLabel6.setVisible(true);
    Notes.setVisible(true);
    jLabel7.setVisible(true);
    Prescription.setVisible(true);
    jLabel8.setVisible(true);
    Submit.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void AnimalTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnimalTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnimalTypeActionPerformed

    private void AnimalNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnimalNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnimalNameActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
String name=AnimalName.getText();
String type=(String)AnimalType.getSelectedItem();
String title=Title.getText();
String desc=Description.getText();
String notes=Notes.getText();
String pres=Prescription.getText();
String id=VetIDSearch.getText();
MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("zoo");

        
        List<Document> writes = new ArrayList();

        MongoCollection<Document> zooCol = database.getCollection("zoo");

        Document d1 = new Document();//_id is now a unix epoch time stamp so will be unique no matter what.
        //The set of 5 attributes present in the tables. This allows for a GUI based input.
        d1.append("id", id);
        d1.append("name", name.toUpperCase());
        d1.append("type",type.toUpperCase());
        d1.append("title", title);
        d1.append("description", desc);
        d1.append("notes", notes);
        d1.append("prescription",pres);
        writes.add(d1);
        System.out.println("Successfully added the entry to the database");
        

        zooCol.insertMany(writes);
        mongoClient.close();

System.out.println("Name: "+name+"\tType: "+type+"\tTitle: "+title+ "\tDescription: "+desc+"\tNotes: "+notes+"\tPrescription: "+pres);
        
        setSize(new java.awt.Dimension(754, 471));
retrieve.setVisible(false);
        VetCBox1.setVisible(true);
VetTable.setVisible(true);
VetIDSearch.setVisible(true);
jScrollPane1.setVisible(true);
    jLabel1.setVisible(true);
    jButton1.setVisible(true);
    jButton2.setVisible(true);
    jButton3.setVisible(true);
    VetSearch.setVisible(true);
    VetTable.setVisible(true);
    AnimalName.setVisible(false);
    jLabel3.setVisible(false);
    AnimalType.setVisible(false);
    jLabel4.setVisible(false);
    Title.setVisible(false);
    jLabel5.setVisible(false);
    Description.setVisible(false);
    jLabel6.setVisible(false);
    Notes.setVisible(false);
    jLabel7.setVisible(false);
    Prescription.setVisible(false);
    jLabel8.setVisible(false);
    Submit.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_SubmitActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
       MongoOp.setVisible(false);
       Close.setVisible(false);
retrieve.setVisible(false);
        VetCBox1.setVisible(true);
VetTable.setVisible(true);
VetIDSearch.setVisible(true);
jScrollPane1.setVisible(true);
    jLabel1.setVisible(true);
    jButton1.setVisible(true);
    jButton2.setVisible(true);
    jButton3.setVisible(true);
    VetSearch.setVisible(true);
    VetTable.setVisible(true);
    AnimalName.setVisible(false);
    jLabel3.setVisible(false);
    AnimalType.setVisible(false);
    jLabel4.setVisible(false);
    Title.setVisible(false);
    jLabel5.setVisible(false);
    Description.setVisible(false);
    jLabel6.setVisible(false);
    Notes.setVisible(false);
    jLabel7.setVisible(false);
    Prescription.setVisible(false);
    jLabel8.setVisible(false);
    Submit.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_CloseActionPerformed

    private void retrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrieveActionPerformed
MongoOp.setVisible(true);     
Close.setVisible(true);
retrieve.setVisible(false);
        VetCBox1.setVisible(false);
VetTable.setVisible(false);
VetIDSearch.setVisible(false);
jScrollPane1.setVisible(false);
    jLabel1.setVisible(false);
    jButton1.setVisible(false);
    jButton2.setVisible(false);
    jButton3.setVisible(false);
    VetSearch.setVisible(false);
    VetTable.setVisible(false);
    AnimalName.setVisible(false);
    jLabel3.setVisible(false);
    AnimalType.setVisible(false);
    jLabel4.setVisible(false);
    Title.setVisible(false);
    jLabel5.setVisible(false);
    Description.setVisible(false);
    jLabel6.setVisible(false);
    Notes.setVisible(false);
    jLabel7.setVisible(false);
    Prescription.setVisible(false);
    jLabel8.setVisible(false);
    Submit.setVisible(false);

// TODO add your handling code here:
    }//GEN-LAST:event_retrieveActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VetFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnimalName;
    private javax.swing.JComboBox<String> AnimalType;
    private javax.swing.JButton Close;
    private javax.swing.JTextField Description;
    private javax.swing.JLabel Info;
    private javax.swing.JLabel Mongo;
    private javax.swing.JLabel MongoOp;
    private javax.swing.JTextField Notes;
    private javax.swing.JTextField Prescription;
    private javax.swing.JButton Submit;
    private javax.swing.JTextField Title;
    private javax.swing.JComboBox VetCBox1;
    private javax.swing.JTextField VetIDSearch;
    private javax.swing.JButton VetSearch;
    private javax.swing.JTable VetTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JButton retrieve;
    // End of variables declaration//GEN-END:variables

}
