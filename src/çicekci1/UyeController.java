/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package çicekci1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import çicekci1.Data.Musteri;
import çicekci1.DataBase.MusteriDAO;

/**
 * FXML Controller class
 *
 * @author RABİA
 */
public class UyeController implements Initializable {

    @FXML
    private TextArea txt_adres;
    @FXML
    private AnchorPane anc_pane2;
    @FXML
    private TextField txt_isim1;
    @FXML
    private TextField txt_sifre1;
    @FXML
    private TextField txt_telefon1;
    @FXML
    private TextField txt_mail1;
    @FXML
    private Button btn_kaydet1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Tiklandi_kaydet1(ActionEvent event) { 
        
        MusteriDAO musteriDAO = new MusteriDAO();
        
        musteriDAO.insertItem(musteriOlustur());
        
        Stage stage = (Stage)btn_kaydet1.getScene().getWindow(); // stage nesnesini olustur
        
        stage.close(); //stage'i kapat 
        
    }
    
    
    private Musteri musteriOlustur(){  //1.adım
        Musteri m = new Musteri();

        m.setIsim(txt_isim1.getText());
        m.setSifre(txt_sifre1.getText());
        m.setTelefon(txt_telefon1.getText());
        m.setMail(txt_mail1.getText());
        m.setAdres(txt_adres.getText());
        
        return m;
    }
}



