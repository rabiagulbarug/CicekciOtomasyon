package çicekci1.DataBase;

import çicekci1.Data.Musteri;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MusteriDAO implements IDao<Musteri> {

    private Connection connection;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public MusteriDAO() {
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
    
    public Musteri getItemMusteriByMail(String mail, String sifre){ // bana müsteriyi mailden getir
        try {
            Musteri m = new Musteri();
            stmt = connection.prepareStatement("SELECT * FROM Musteri WHERE Mail=? AND Sifre=?" );
            
            stmt.setString(1, mail);
            stmt.setString(2, sifre);
            
            
            rs = stmt.executeQuery();

            rs.next();
            m.setId(rs.getInt("MusteriID"));
            m.setIsim(rs.getString("Isim"));
            m.setSifre(sifre);
            m.setTelefon(rs.getString("TelefonNo"));
            m.setAdres(rs.getString("Adres"));
            m.setMail(mail);
           
          

            return m;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {
            close();

        }
        
    }

    @Override
    public Musteri getItem(Musteri m) {


        try {
            stmt = connection.prepareStatement("SELECT * FROM Musteri WHERE MusteriID=?");
            stmt.setInt(1, m.getId());
            rs = stmt.executeQuery();

            rs.next();

            m.setIsim(rs.getString("Isim"));
            m.setSifre(rs.getString("Sifre"));
            m.setMail(rs.getString("Mail"));
            m.setTelefon(rs.getString("TelefonNo"));
            m.setAdres(rs.getString("Adres"));


            return m;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {
            close();

        }

    }
    
    
    

    @Override
    public void insertItem(Musteri item) {

        try {
            stmt = connection.prepareStatement("INSERT INTO Musteri(Isim,Sifre,TelefonNo,Mail,Adres) VALUES (?,?,?,?,?)");

            stmt.setString(1, item.getIsim());
            stmt.setString(2, item.getSifre());
            stmt.setString(3, item.getTelefon());
            stmt.setString(4, item.getMail());
            stmt.setString(5, item.getAdres());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }

    }

    @Override
    public void deleteItem(Musteri item) {
        try {
            stmt = connection.prepareStatement("DELETE FROM Musteri WHERE MusteriID=?");

            stmt.setInt(1, item.getId());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }

    }

    @Override
    public Musteri updateItem(Musteri item) {

        try {
            stmt = connection.prepareStatement("UPDATE  Musteri SET Isim=?,Sifre = ?,TelefonNo=?,Adres=?,Mail=? WHERE MusteriID = ?");


            stmt.setString(1, item.getIsim());
            stmt.setString(2, item.getSifre());
            stmt.setString(3, item.getTelefon());
            stmt.setString(4, item.getAdres());
            stmt.setString(5, item.getMail());
            stmt.setInt(6, item.getId());


            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }

        return null;
    }

    @Override
    public ArrayList<Musteri> getItems() {

        Musteri m ;
        ArrayList<Musteri> list = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM Musteri");
            rs = stmt.executeQuery();

            while(rs.next()){
                m = new Musteri();
                m.setId(rs.getInt("MusteriID"));
                m.setIsim(rs.getString("Isim"));
                m.setSifre(rs.getString("Sifre"));
                m.setMail(rs.getString("Mail"));
                m.setTelefon(rs.getString("TelefonNo"));
                m.setAdres(rs.getString("Adres"));

                list.add(m);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {


        MusteriDAO musteri = new MusteriDAO();


        Musteri m = new Musteri();

        m.setId(2);

        Musteri onur = musteri.getItem(m);

        if(onur != null){
            System.out.println(onur.toString());
        }

    }

}
