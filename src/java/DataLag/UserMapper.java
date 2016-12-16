/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLag;

import LogikLag.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JonasSchack
 */
public class UserMapper {
    
    public static List<User> getUser() throws SQLException, ClassNotFoundException {
        List<User> user = new ArrayList();
        String sql = "SELECT * FROM user;";

        try {
            Connector DB = Connector.getInstance();
            Statement stmt = DB.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                int ID = res.getInt("id");
                String UserName = res.getString("username");
                String Password = res.getString("password");
                double Balance = res.getInt("balance");
                user.add(new User(UserName, Password, Balance, ID));
                
            }
            System.out.println(sql);
        } catch (SQLException ex) {
        }
        return user;
    }

    public static void updateBalance(User u, int id) throws ClassNotFoundException {

        double Balance = u.getBalance();

        String sql = "UPDATE user SET balance='" + Balance + "' WHERE id= '" + id + "';";
        try {
            PreparedStatement stmt = Connector.prepare(sql);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Balance raised");
            } else {
                System.out.println("Balance has no change");
            }

        } catch (SQLException ex) {
            System.out.println("Element not inserted: " + ex.getMessage());
        }
   }
}
