package model;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MySQLDatabase {
	private static  MySQLDatabase mySQL = null;
	private  String connectionURL;
	private  String userName;
	private  String password;
	private Connection connectDatabase = null;
	private  MySQLDatabase(String connectionURL, String userName,String password) throws SQLException {
		this.connectionURL=connectionURL;
		this.userName = userName;
		this.password = password;
		
	}
	public synchronized static MySQLDatabase getInstance(String connectionURL, String userName,String password) throws SQLException {

		if (mySQL== null) {
			mySQL  = new MySQLDatabase(connectionURL, userName,password);
		}
		return mySQL;
	}
	//Singleton parttern
	
	public String selectWord(String word) throws SQLException {
		 connectDatabase = DriverManager.getConnection(connectionURL, userName,password);
		Statement stmt = connectDatabase.createStatement();
	    ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_edict WHERE word='"+word+"';");// cau lenh try van 
	    ResultSetMetaData rsmd = rs.getMetaData();
             String m="";
	    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
	        System.out.println(
	            "Column " + i + " [name: " + rsmd.getColumnName(i) + " - type: " + rsmd.getColumnTypeName(i) + "]");
	      }
	      System.out.println("--------------------");
           
	      while (rs.next())
	         m =m+  rs.getString(3)+"\n";;
	      connectDatabase.close();
             m= m.replaceAll("<C>", " ");
             m= m.replaceAll("<F>", " ");
             m= m.replaceAll("<I>", " ");
             m= m.replaceAll("<N>", " ");
             m= m.replaceAll("<Q>", " ");
             m= m.replaceAll("<br />", "\n");
                m= m.replaceAll("</C>", " ");
             m= m.replaceAll("</F>", " ");
             m= m.replaceAll("</I>", " ");
             m= m.replaceAll("</N>", " ");
             m= m.replaceAll("</Q>", " ");
           
              m= m.replaceAll("=", "#");
              System.out.println(m);
            
              return m;
	    }
	public void insertWord(String word,String definition) throws SQLException {
		 connectDatabase = DriverManager.getConnection(connectionURL, userName,password);
		Statement stmt = connectDatabase.createStatement();
	    Integer rs = stmt.executeUpdate("INSERT INTO tbl_edict  (word,detail) VALUES ('"+word+"', '"+definition+"');");// cau lenh try van 
	    System.out.println(rs);
	      connectDatabase.close();
	}
	public void detetetWord(String word,String detail) throws SQLException {
		 connectDatabase = DriverManager.getConnection(connectionURL, userName,password);
		Statement stmt = connectDatabase.createStatement();
                System.out.println("DELETE FROM tbl_edict WHERE word='"+word+"'and detail ='"+detail+"';");
	    int rs = stmt.executeUpdate("DELETE FROM tbl_edict WHERE word='"+word+"';");// cau lenh try van 
	    
	      connectDatabase.close();
	}
	public void updatetWord(String word, String col,String change) throws SQLException {
		connectDatabase = DriverManager.getConnection(connectionURL, userName,password);
		Statement stmt = connectDatabase.createStatement();
	System.out.println("UPDATE entries SET "+ col+" = '"+change+"'WHERE word='"+word+"';");
	    int rs = stmt.executeUpdate("UPDATE entries SET "+ col+" = '"+change+"'WHERE word='"+word+"';");// cau lenh try van 
	    System.out.println(rs);
	      connectDatabase.close();
	}
        public String selectID(String word) throws SQLException {
		 connectDatabase = DriverManager.getConnection(connectionURL, userName,password);
		Statement stmt = connectDatabase.createStatement();
                String m ="";
	    ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_edict WHERE idx='"+word+"';");// cau lenh try van 
	    ResultSetMetaData rsmd = rs.getMetaData();
	    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
	        System.out.println(
	            "Column " + i + " [name: " + rsmd.getColumnName(i) + " - type: " + rsmd.getColumnTypeName(i) + "]");
	      }
	      System.out.println("--------------------");
	      while (rs.next())
	        m=m+  rs.getString(3);
      
	      connectDatabase.close();
               return m;
	    }
        public void updatetID(String word, String col,String change,String detail) throws SQLException {
		connectDatabase = DriverManager.getConnection(connectionURL, userName,password);
		Statement stmt = connectDatabase.createStatement();
	System.out.println("UPDATE tbl_edict SET "+ col+" = '"+change+"'WHERE word='"+word+"' and detail='"+detail+"';");
	    boolean rs = stmt.execute(" UPDATE tbl_edict SET "+ col+" = '"+change+"'WHERE word='"+word+"' and detail='"+detail+"';");// cau lenh try van 
	    System.out.println(rs);
	      connectDatabase.close();
	}
         public ObservableList<String> liketWord(String word) throws SQLException {
             ObservableList<String> items =FXCollections.observableArrayList();
		 connectDatabase = DriverManager.getConnection(connectionURL, userName,password);
		Statement stmt = connectDatabase.createStatement();
                String m ="";
	    ResultSet rs = stmt.executeQuery("SELECT word FROM tbl_edict WHERE word like'"+word+"%' limit 20 ;");// cau lenh try van 
	    ResultSetMetaData rsmd = rs.getMetaData();
	    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
	        System.out.println(
	            "Column " + i + " [name: " + rsmd.getColumnName(i) + " - type: " + rsmd.getColumnTypeName(i) + "]");
	      }
	      System.out.println("--------------------");
	      while (rs.next())
	        items.add(rs.getString(1));
      
	      connectDatabase.close();
              System.out.println(m);
               return items;
	}

       
}
