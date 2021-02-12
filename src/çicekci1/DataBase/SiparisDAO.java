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
import çicekci1.Data.Siparis;

/**
 *
 * @author RABİA
 */
public class SiparisDAO implements IDao<Siparis> {
    
    private Connection connection;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    public SiparisDAO() {
        connection = DBConnection.getInstance().getConnection();
    }


    @Override
    public Siparis getItem(Siparis s) {
        try {
            
            String sql = "SELECT * FROM Siparis s INNER JOIN Stok  ON s.UrunID = Stok.UrunID INNER JOIN Musteri m "
                    + "ON s.MusteriID = m.MusteriID  WHERE SiparisID=?";
            
            stmt = connection.prepareStatement("");
            stmt.setInt(1, s.getSiparis_id());
            rs = stmt.executeQuery();

            rs.next();
            
            s.setSiparis_id(rs.getInt("SiparisID"));
            s.setUrun_id(rs.getInt("UrunID"));
            s.setAdet(rs.getInt("Adet"));
            s.setMusteri_id(rs.getInt("MusteriID"));
            s.setUrun_adi(rs.getString("UrunAdi"));
            s.setMusteri_adi(rs.getString("Isim"));
            s.setMusteri_adres(rs.getString("Adres"));
            s.setMusteri_telefon(rs.getString("TelefonNo"));
            s.setMusteri_mail(rs.getString("Mail"));
         
           

            
            return s;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {
            close(); 
            
        }
    }

    @Override
    public void insertItem(Siparis item) {
        
        try {
            stmt = connection.prepareStatement("INSERT INTO Siparis(UrunID,Adet,MusteriID) VALUES(?,?,?);");

           
            stmt.setInt(1, item.getUrun_id());
            stmt.setInt(2, item.getAdet());
            stmt.setInt(3, item.getMusteri_id());
          

            stmt.executeUpdate();
           

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
          
          close();
        }
 }

    @Override
    public void deleteItem(Siparis item) {
    
        try {
            stmt = connection.prepareStatement("DELETE FROM Siparis WHERE SiparisID=?");

            stmt.setInt(1, item.getSiparis_id());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
          close();
        }
    
    }

    @Override
    public Siparis updateItem(Siparis item) {
        try { 
            stmt = connection.prepareStatement("UPDATE  Siparis SET UrunID = ?,Adet=?, MusteriID= ? WHERE SiparisID = ?");

            stmt.setInt(1, item.getUrun_id());
            stmt.setInt(2, item.getAdet());
            stmt.setInt(3, item.getMusteri_id());
            stmt.setInt(4, item.getSiparis_id());
          

            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();    
        } finally {       
        }       
          return item;  
        }


    @Override
    public ArrayList<Siparis> getItems() {
        
        Siparis s;
        ArrayList<Siparis> list = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM Siparis s INNER JOIN Stok  ON s.UrunID = Stok.UrunID  "
                    + "INNER JOIN Musteri m ON s.MusteriID = m.MusteriID";
            
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                s = new Siparis();
                s.setSiparis_id(rs.getInt("SiparisID"));
                s.setUrun_id(rs.getInt("UrunID"));
                s.setAdet(rs.getInt("Adet"));
                s.setMusteri_id(rs.getInt("MusteriID"));
                s.setUrun_adi(rs.getString("UrunAdi"));
                s.setMusteri_adi(rs.getString("Isim"));
                s.setMusteri_adres(rs.getString("Adres"));
                s.setMusteri_telefon(rs.getString("TelefonNo"));
                s.setMusteri_mail(rs.getString("Mail"));
                list.add(s);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;   
    }
    
 /*
    public static void main(String[] args) {
    
    SiparisDAO dao = new SiparisDAO();  //hata vermiyor?
    Siparis s = new Siparis();
    s.setSiparis_id(2);
    Siparis onur = dao.getItem(s);
    
        System.out.println(onur.getSiparis_id());
        System.out.println(onur.getMusteri_id());
        System.out.println(onur.getUrun_id());
}
*/
  /*   
    public static void main (String[] args ) {
        
        SiparisDAO dao = new SiparisDAO();

    
        ArrayList<Siparis> list = dao.getItems();

    for (Siparis s : list) {
        System.out.println(s.getSiparis_id());   
        System.out.println(s.getUrun_id());
        System.out.println(s.getAdet());
        System.out.println(s.getMusteri_id());
 }
}*/
    
    public static void main(String[] args) {

        SiparisDAO dao = new SiparisDAO();
        Siparis s = new Siparis();
        
       
        s.setSiparis_id(2);
        s.setUrun_id(4);
        s.setAdet(120);
        s.setMusteri_id(2);
        
        
        dao.updateItem(s);        
        
        
    } 
  /*  
   public static void main (String[] args ) {
        
        SiparisDAO dao = new SiparisDAO();  
        Siparis s = new Siparis();
        
        
        s.setUrun_id(3);
        s.setAdet(66);
        s.setMusteri_id(2);
     
       
        
        dao.insertItem(s);
              
    }
*/

    
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
   
}
  

