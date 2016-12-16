/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLag;

import LogikLag.Cupcake;
import LogikLag.Base;
import LogikLag.Top;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JonasSchack
 */
public class CupcakeMapper {
    
        public static List<Base> getBase() throws SQLException, ClassNotFoundException {
        List<Base> base = new ArrayList();
        String sql = "SELECT * FROM base;";

        try {
            Connector DB = Connector.getInstance();
            Statement stmt = DB.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                int BaseID = res.getInt("base_id");
                String BaseName = res.getString("base_name");
                double Price = res.getDouble("price");
                base.add(new Base(BaseID, BaseName, Price));
                
            }
            System.out.println(sql);
        } catch (SQLException ex) {
        }
        return base;
    }
        
        public static List<Top> getTop() throws SQLException, ClassNotFoundException {
        List<Top> top = new ArrayList();
        String sql = "SELECT * FROM top;";

        try {
            Connector DB = Connector.getInstance();
            Statement stmt = DB.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                int TopID = res.getInt("top_id");
                String TopName = res.getString("top_name");
                double Price = res.getDouble("price");
                top.add(new Top(TopID, TopName, Price));
                
            }
            System.out.println(sql);
        } catch (SQLException ex) {
        }
        return top;
    }
        
        public static List<Cupcake> getCupcake() throws SQLException, ClassNotFoundException {
        List<Cupcake> cupcake = new ArrayList();
        String sql = "SELECT * FROM cupcake;";

        try {
            Connector DB = Connector.getInstance();
            Statement stmt = DB.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                int CupcakeID = res.getInt("cupcake_id");
                String CupcakeName = res.getString("cupcake_name");
                String CupcakeDis = res.getString("dis");
                int TopID = res.getInt("top_id");
                int BaseID = res.getInt("base_id");
                double Price = res.getInt("price");
                cupcake.add(new Cupcake(CupcakeID, CupcakeName, CupcakeDis, TopID, BaseID, Price));
                
            }
            System.out.println(sql);
        } catch (SQLException ex) {
        }
        return cupcake;
    }
}
