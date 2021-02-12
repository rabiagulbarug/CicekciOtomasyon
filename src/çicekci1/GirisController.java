/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package çicekci1;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import çicekci1.Data.Musteri;
import çicekci1.Data.Personel;
import çicekci1.DataBase.DBConnection;
import çicekci1.DataBase.MusteriDAO;
import çicekci1.DataBase.PersonelDAO;

/**
 * FXML Controller class
 *
 * @author RABİA
 */
public class GirisController implements Initializable {

    @FXML
    private Label lbl_ykullanici;
    @FXML
    private Label lbl_ysifre;
    @FXML
    private TextField txt_ykullanici;
    @FXML
    private Button btn_tgiris;
    @FXML
    private PasswordField pass_sifre;
    @FXML
    private Button btn_uyeol;
    @FXML
    private AnchorPane anc_pane;
    @FXML
    private CheckBox check_personel;
    
    
    private Object kullanici = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    private boolean kullaniciKontrol(String mail, String sifre) {

        if (check_personel.isSelected()) { // personel olarak secilmis ise 
            PersonelDAO personelDAO = new PersonelDAO();// personel dao obj olustur
            Personel p = personelDAO.getItemByMail(mail, sifre); // mail ve sifre ile getir
            if (p != null) // eger null ise yani kosulu saglayan kayit var ise 
            {
                kullanici = p;
                
                
                
                
                
                return true; // true döndür 
            } else {
                return false;
            }
        } else  {  // musteri ise 
            MusteriDAO musteriDAO = new MusteriDAO();
            Musteri m = musteriDAO.getItemMusteriByMail(mail, sifre);

            if (m != null) {
                kullanici = m;
                return true;
            } else {
                return false;
            }

        }

    }

    @FXML
    private void Tiklandi_giris(ActionEvent event) {

        String mail = txt_ykullanici.getText();
        String sifre = pass_sifre.getText();

        if (kullaniciKontrol(mail, sifre)) {

            try {
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("anasyfa.fxml"));
                
                CicekController controller = new CicekController(kullanici);
                
                loader.setController(controller);
                
                Parent root = loader.load(); //fxml dosyası parent referansına yuklendi

                Stage stage = new Stage();//yeni pencere olusturuldu
                stage.setScene(new Scene(root)); // pencerenin icine dosyadaki yerlestirildi
                stage.getScene().getStylesheets().add(getClass().getResource("css3.css").toExternalForm());
                stage.show(); //pencere gosterildi

                Stage stage1 = (Stage) btn_tgiris.getScene().getWindow();// Butonun basıldığı stage çekilir
                stage1.close();// Butonun bulunduğu stage kapatılır. 

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Mail veya Şifre Hatalı", ButtonType.OK).showAndWait();
        }
    }

    @FXML
    private void Tiklandi_uyeol(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("uye.fxml")); //fxml dosyası parent referansına yuklend
            
            Stage stage = new Stage();//yeni pencere olusturuldu
            stage.setScene(new Scene(root)); // pencerenin icine dosyadaki yerlestirildi
            stage.getScene().getStylesheets().add(getClass().getResource("css2.css").toExternalForm());
            stage.show(); //pencere gosterildi

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    

}
/*fx:controller="otomasyon.PanelController"*/