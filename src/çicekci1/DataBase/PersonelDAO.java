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
import çicekci1.Data.Personel;

/**
 *
 * @author RABİA
 */
public class PersonelDAO implements IDao<Personel> {
    
    private Connection connection;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    public PersonelDAO() {
        connection = DBConnection.getInstance().getConnection();
    }

    @Override
    public Personel getItem(Personel p) {
        
        try {
            stmt = connection.prepareStatement("SELECT * FROM personel INNER JOIN rol ON personel.RolID = rol.RolID WHERE KullaniciID=?");
            
            
            stmt.setInt(1, p.getId());
            rs = stmt.executeQuery();

            rs.next();

            p.setKullanici_adi(rs.getString("KullaniciAdi"));
            p.setSifre(rs.getString("Sifre"));
            p.setTelefon(rs.getString("TelefonNo"));
            p.setIzin_sayisi(rs.getInt("IzinSayisi"));
            p.setRol(rs.getString("RolAdi"));
            p.setMaas(rs.getInt("Maas"));
            p.setMail(rs.getString("Mail"));  
            p.setAdres(rs.getString("Adres"));
           

            return p;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {
            close();

        }
        
    }

    
    public Personel getItemByMail(String mail,String sifre) {

        try {
            Personel p = new Personel() ;
            stmt = connection.prepareStatement("SELECT * FROM personel INNER JOIN rol ON personel.RolID = rol.RolID WHERE Mail=? AND Sifre=?");

            stmt.setString(1, mail);
            stmt.setString(2, sifre);
            
            rs = stmt.executeQuery();

            rs.next();
            p.setId(rs.getInt("KullaniciID"));
            p.setKullanici_adi(rs.getString("KullaniciAdi"));
            p.setSifre(sifre);
            p.setTelefon(rs.getString("TelefonNo"));
            p.setIzin_sayisi(rs.getInt("IzinSayisi"));
            p.setRol(rs.getString("RolAdi"));
            p.setMaas(rs.getInt("Maas"));
            p.setMail(mail);
            p.setAdres(rs.getString("Adres"));

            return p;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {
            close();

        }

    }
    
    
    @Override
    public void insertItem(Personel item) {
        
        try {
         stmt= connection.prepareStatement("SELECT RolID FROM rol WHERE RolAdi =? ");
         stmt.setString(1,item.getRol());
         rs = stmt.executeQuery();
         rs.next();
         int rol_id = rs.getInt("RolID");
         close();
           
        stmt = connection.prepareStatement("INSERT INTO Personel(KullaniciAdi,Sifre,TelefonNo,IzinSayisi,RolID,Maas,Mail,Adres) VALUES (?,?,?,?,?,?,?,?)");
        
            stmt.setString(1, item.getKullanici_adi());
            stmt.setString(2, item.getSifre());
            stmt.setString(3, item.getTelefon());
            stmt.setInt(4, item.getIzin_sayisi());
            stmt.setInt(5, rol_id);
            stmt.setInt(6, item.getMaas());
            stmt.setString(7, item.getMail());
            stmt.setString(8, item.getAdres());

            
            stmt.executeUpdate();

   
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        
    }

    @Override
    public void deleteItem(Personel item) {
        
        try {
            stmt = connection.prepareStatement("DELETE FROM Personel WHERE KullaniciID=?");

            stmt.setInt(1, item.getId());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }
    

    @Override
    public Personel updateItem(Personel item) {
        try {
            
            stmt = connection.prepareStatement("SELECT RolID FROM rol WHERE RolAdi =? ");
            stmt.setString(1, item.getRol());
            rs = stmt.executeQuery();
            rs.next();

            int rol_id = rs.getInt("RolID");
            close();
            stmt = connection.prepareStatement("UPDATE Personel SET KullaniciAdi=?,Sifre = ?,TelefonNo=?,IzinSayisi=?,RolID=?,Maas=?,Mail=?,Adres=? WHERE KullaniciID = ?");
           
            
            stmt.setString(1, item.getKullanici_adi());
            stmt.setString(2, item.getSifre());
            stmt.setString(3, item.getTelefon());
            stmt.setInt(4, item.getIzin_sayisi());
            stmt.setInt(5, rol_id);
            stmt.setInt(6, item.getMaas());
            stmt.setString(7, item.getMail());
            stmt.setString(8, item.getAdres());
            stmt.setInt(9, item.getId());
            
            
       stmt.executeUpdate();

    }catch (SQLException throwables) {
        
     throwables.printStackTrace();
     return null;
    }finally {
            close();
        }
        return item;
    
    }

    @Override
    public ArrayList<Personel> getItems() {
        Personel p;
        ArrayList<Personel> list = new ArrayList<>();

        try {
            stmt = connection.prepareStatement("SELECT * FROM personel INNER JOIN rol ON personel.RolID = rol.RolID");
            rs = stmt.executeQuery();

            while (rs.next()) {
                p = new Personel();
                p.setId(rs.getInt("KullaniciID"));
                p.setKullanici_adi(rs.getString("KullaniciAdi"));
                p.setSifre(rs.getString("Sifre"));
                p.setTelefon(rs.getString("TelefonNo"));
                p.setIzin_sayisi(rs.getInt("IzinSayisi"));
                p.setRol(rs.getString("RolAdi"));
                p.setMaas(rs.getInt("Maas"));
                p.setMail(rs.getString("Mail"));
                p.setAdres(rs.getString("Adres"));
                
                list.add(p);
                
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
 
    }
    
    public static void main(String[] args) {

        PersonelDAO dao = new PersonelDAO();

      /*  Personel p = new Personel();
        p.setKullanici_adi("zeynep");
        p.setSifre("1234");
        p.setTelefon("123124");
        p.setIzin_sayisi(60);
        p.setRol("İnsan Kaynakları");
        p.setMaas(1500);
        p.setMail("assd");
        p.setAdres("zczv");*/

        
        ArrayList<Personel> list = dao.getItems();
        
        
        for(Personel p : list){
            System.out.println(p.getKullanici_adi());
            System.out.println(p.getMaas());
            System.out.println(p.getRol());
            System.out.println(p.getTelefon());
        }
        
            
        
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
    
}
