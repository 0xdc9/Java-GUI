package latihan_gui_tufa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

    public class connect {
        
        public Connection con;
        public ResultSet rs;
        public Statement st;
        public ResultSetMetaData rsm;
        public PreparedStatement ps;
        
        public connect(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/latihan_gui", "root", "root");
                st = con.createStatement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public ResultSet execute(String query) {
            try {
                rs = st.executeQuery(query);
                rsm = rs.getMetaData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(rsm);
            return rs;
            
        }

}