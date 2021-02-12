/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package çicekci1.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import çicekci1.Data.Stok;

/**
 *
 * @author RABİA
 */
public class StokDAO implements IDao<Stok> {
    
        private Connection connection;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    public StokDAO() {
        connection = DBConnection.getInstance().getConnection();
    }
    
    private void close() {

        try {

            if (rs != null && !rs.isClosed()) {
                stmt.close();
            }
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    
    @Override
    public Stok getItem(Stok k) {
        
        try {
            stmt = connection.prepareStatement("SELECT * FROM Stok WHERE UrunID= ? ");
            stmt.setInt(1, k.getUrun_id());
            rs = stmt.executeQuery();

            rs.next();
            
            k.setUrun_id(rs.getInt("UrunID"));
            k.setUrun_adi(rs.getString("UrunAdi"));
            k.setAdet(rs.getInt("UrunAdet"));
            k.setFiyat(rs.getInt("Fiyat"));
       
        
            return k;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {

        }
    
    }

    @Override
    public void insertItem(Stok item) {
        
        try {
            stmt = connection.prepareStatement("INSERT INTO Stok (UrunAdi,UrunAdet,Fiyat) VALUES(?,?,?);");

            stmt.setString(1, item.getUrun_adi());
            stmt.setInt(2, item.getAdet());
            stmt.setInt(3, item.getFiyat());
       

        stmt.executeUpdate();
        
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
        
    }

    @Override
    public void deleteItem(Stok item) {
        try {
            stmt = connection.prepareStatement("DELETE FROM Stok WHERE UrunID=?");

            stmt.setInt(1, item.getUrun_id());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
         close();  
        }
      
    
    }

    @Override
    public Stok updateItem(Stok item) {
        try {
            stmt = connection.prepareStatement("UPDATE  Stok SET UrunAdet=?, Fiyat=?, UrunAdi=? WHERE UrunID = ?");
       
            
           
            stmt.setInt(1, item.getAdet());
            stmt.setInt(2, item.getFiyat());
            stmt.setString(3, item.getUrun_adi());
            stmt.setInt(4, item.getUrun_id());
            
            
        
       
        stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
         close();
        }

        return null;       
        }

    @Override
    public ArrayList<Stok> getItems() {
        Stok k ;
        ArrayList<Stok> list = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement("SELECT * FROM Stok");
            rs = stmt.executeQuery();

            while (rs.next()) {
       
                k = new Stok(); 
                k.setUrun_id(rs.getInt("UrunID"));
                k.setUrun_adi(rs.getString("UrunAdi"));
                k.setAdet(rs.getInt("UrunAdet"));
                k.setFiyat(rs.getInt("Fiyat"));
        
               
   
                list.add(k);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
     
        
    }
    
  /*  public static void main(String[] args) {
        
        StokDAO dao = new StokDAO();
        Stok k = new Stok();
       
        k.setUrun_id(2);
        
        Stok onur = dao.getItem(k);
        
        System.out.println(onur.getUrun_id());
        System.out.println(onur.getUrun_adi());
        System.out.println(onur.getAdet());
        System.out.println(onur.getFiyat());
    
 
}*/
  
    /*public static void main(String[] args) {

        StokDAO dao = new StokDAO();
        Stok k = new Stok();
     
       
        k.setUrun_adi("Lale");
        k.setAdet(100);
        k.setFiyat(10);

        dao.insertItem(k);

    }*/
    
  /*
    public static void main(String[] args) {

        StokDAO dao = new StokDAO();
        Stok k = new Stok();

        k.setAdet(200);
        k.setFiyat(20);
        k.setUrun_adi("Menekşe");
        k.setUrun_id(3);
        
 
        dao.updateItem(k);        
  

    }
*/
    
  /*
    public static void main(String[] args) {

       StokDAO dao = new StokDAO();
       
       ArrayList<Stok> list = dao.getItems();
       
    for(Stok k : list) {
     

        System.out.println(k.getUrun_adi());
        System.out.println(k.getAdet());
        System.out.println(k.getFiyat());
        
        
    }      
   } 
    */
}
    
     

