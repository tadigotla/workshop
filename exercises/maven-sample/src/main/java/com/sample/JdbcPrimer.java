package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import org.h2.Driver;
import java.sql.SQLException;
// import com.mysql.jdbc.Driver;

public class JdbcPrimer {
    public static void main(String[] args) throws SQLException{
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.h2.Driver");
        } catch (Exception e) {
            System.out.println("Failed to load JDBC/ODBC driver.");
        }

        try {
            con = DriverManager.getConnection("jdbc:h2:mem:testDbSample;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE",
                "sa", "");

            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS BOOK "
                        + "  (title VARCHAR(50),"
                        + "   author VARCHAR(50));");

            stmt.executeUpdate("INSERT INTO BOOK(title, author) VALUES ('Bhagavatha', 'Vyasa');");

            ResultSet result = stmt.executeQuery("SELECT title, author FROM BOOK;");
            while(result.next()){
                System.out.println(result.getString("title") + " : " + result.getString("author"));
            }
        } catch (Exception e) {
            System.out.println("problems connecting to the database");
            e.printStackTrace(System.out);
        } finally {
            System.out.println( "Closing Connection");
            if((con != null) && (!con.isClosed()))
                con.close();
        }
    }
}
