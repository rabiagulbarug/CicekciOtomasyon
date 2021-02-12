/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package çicekci1;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import çicekci1.Data.Musteri;
import çicekci1.Data.Personel;
import çicekci1.Data.Siparis;
import çicekci1.Data.Stok;
import çicekci1.DataBase.MusteriDAO;
import çicekci1.DataBase.PersonelDAO;
import çicekci1.DataBase.SiparisDAO;
import çicekci1.DataBase.StokDAO;

/**
 * FXML Controller class
 *
 * @author RABİA
 */
public class CicekController implements Initializable {

    @FXML
    private TableView<Stok> tble_veriler;
    private TableColumn<?, ?> kln_isim;
    @FXML
    private TableColumn<?, ?> kln_urun;
    @FXML
    private TableColumn<?, ?> kln_brm;
    @FXML
    private TableColumn<?, ?> kln_fyt;

    @FXML
    private Slider sldr_brm;
    private int birim = 100;
    @FXML
    private Label lbl_brm;

    private HashMap<String, Integer> cicek_sayisi;
    @FXML
    private Label lbl_urunadı;
    @FXML
    private Label lbl_urunmık;
    @FXML
    private Button btn_urunekle;
    @FXML
    private Button btn_urunguncelle;
    @FXML
    private Button btn_urungetir;
    @FXML
    private TextField txt_isim;
    @FXML
    private TextField txt_adrs;
    @FXML
    private Label lbl_isim;
    @FXML
    private Label lbl_soyisim;
    @FXML
    private Label lbl_tlfn;
    @FXML
    private Label lbl_adrs;
    @FXML
    private Tab tab_siparis;
    @FXML
    private Tab tab_stok;
    @FXML
    private Tab tab_musteri;
    @FXML
    private TextField txt_telefon;
    @FXML
    private Button btn_pkaydet;
    @FXML
    private TextField txt_urunad;
    @FXML
    private TextField txt_urunmıktar;

    @FXML
    private TextField txt_fiyat;
    @FXML
    private TextField txt_sifre;
    @FXML
    private TextField txt_urunıd;
    @FXML
    private Label lbl_isim1;
    @FXML
    private Label lbl_urunid;
    @FXML
    private Label lbl_soyisim1;
    @FXML
    private Label lbl_tlfn1;
    @FXML
    private Label lbl_adrs1;
    @FXML
    private Button btn_mkaydet;
    @FXML
    private Label lbl_isim11;
    @FXML
    private Label lbl_isim12;
    @FXML
    private Label lbl_isim13;
    @FXML
    private Label siparis_lbl_fiyat;
    @FXML
    private TextField txt_mail;
    @FXML
    private Tab tab_pyonetimi;
    @FXML
    private Tab tab_sipyonetimi;
    @FXML
    private TableView<Personel> table_personel;
    @FXML
    private TableColumn<?, ?> kln_personelID;
    @FXML
    private TableColumn<?, ?> kln_kullaniciad;
    @FXML
    private TableColumn<?, ?> kln_telefonno;
    @FXML
    private TableColumn<?, ?> kln_adres;
    @FXML
    private TableColumn<?, ?> kln_mail;
    @FXML
    private TableColumn<?, ?> kln_maas;
    @FXML
    private TableColumn<?, ?> kln_izinsayisi;
    @FXML
    private TableColumn<?, ?> kln_sip_siparisid;
    @FXML
    private TableColumn<?, ?> kln_sip_urunid;
    @FXML
    private TableColumn<?, ?> kln_sip_adet;
    @FXML
    private TableColumn<?, ?> kln_sip_musteri;
    @FXML
    private TableColumn<?, ?> kln_sip_musteri_id;
    @FXML
    private TableColumn<?, ?> kln_sip_musteri_adres;
    @FXML
    private TableColumn<?, ?> kln_sip_musteri_telefon;
    @FXML
    private TableColumn<?, ?> kln_sip_musteri_mail;
    @FXML
    private Tab tab_stok1;
    @FXML
    private TableView<Stok> table_stok;  //2. kez stok yazdım
    @FXML
    private TableView<Siparis> table_sip_yönetimi;  //2. kez stok yazdım
    @FXML
    private TableColumn<?, ?> kln_urunID;
    @FXML
    private TableColumn<?, ?> kln_urunad;
    @FXML
    private TableColumn<?, ?> kln_urunadet;
    @FXML
    private AnchorPane anc_siparis;
    @FXML
    private AnchorPane anc_stok;
    @FXML
    private AnchorPane anc_musteri;
    @FXML
    private Tab tab_personel;
    @FXML
    private AnchorPane anc_personel;

    private Object kullanici = null;
    @FXML
    private TextField txt_pisim;
    @FXML
    private TextField txt_psifre;
    @FXML
    private TextField txt_ptelefon;
    @FXML
    private TextField txt_padres;
    @FXML
    private TextField txt_pmail;
    @FXML
    private TextField txt_pmaas;
    
    @FXML
    private Button siparis_btn_yenile;

    private int toplam_fiyat;

    @FXML
    private TextArea txt_pizinsayisi;
    
    @FXML
    private TabPane pnl_main;
    
    @FXML
    private Button btn_siparisKaydet;

    private Personel kullanici_personel = null;
    private Musteri kullanici_musteri = null;

    private Stok secili_stok = null;
    private Personel secili_personel = null;
    private Siparis secili_siparis = null;
    
    private Stok id;

    private ObservableList<Stok> list_stok = null;

    private ObservableList<Personel> list_personel=null;
    private ObservableList<Siparis> list_siparis=null;
    
    private StokDAO stokDAO = null;

    
    private Siparis siparis = null;
    
    /**
     * Initializes the controller class.
     */
    public CicekController(Object kullanici) {
        this.kullanici = kullanici;
        stokDAO = new StokDAO();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        if (kullanici != null) {

            if (kullanici instanceof Personel) {
                kullanici_personel = (Personel) kullanici;
                
                pnl_main.getTabs().remove(tab_siparis);
                pnl_main.getTabs().remove(tab_musteri);
           

                personelGirdi(kullanici_personel);

            } else {
                kullanici_musteri = (Musteri) kullanici;
                
                pnl_main.getTabs().remove(tab_stok1);
                pnl_main.getTabs().remove(tab_pyonetimi);
                pnl_main.getTabs().remove(tab_personel);
                pnl_main.getTabs().remove(tab_stok);
                pnl_main.getTabs().remove(tab_sipyonetimi);
             

                musteriGirdi(kullanici_musteri);
            }

        }

        sldr_brm.valueProperty().addListener((
                ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) -> {
            birim = new_val.intValue();
            lbl_brm.setText(String.format("%d Birim", new_val.intValue()));

        });

        kln_urun.setCellValueFactory(new PropertyValueFactory<>("urun_adi"));
        kln_brm.setCellValueFactory(new PropertyValueFactory<>("adet"));
        kln_fyt.setCellValueFactory(new PropertyValueFactory<>("fiyat"));

        list_stok = FXCollections.observableArrayList();

        stokTabloGuncelle();

        tble_veriler.setItems(list_stok);

        tble_veriler.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1) { // eger sol tikla bir kere tiklandiysa

                toplam_fiyat = 0;

                secili_stok = (Stok) tble_veriler.getSelectionModel().getSelectedItem();

                int adet = (int)sldr_brm.getValue();

                toplam_fiyat = secili_stok.getFiyat() *  adet;

                //Siparis olusturma 
                siparis = new Siparis();
                siparis.setUrun_id(secili_stok.getUrun_id());
                siparis.setAdet(adet);
                siparis.setMusteri_id(kullanici_musteri.getId());
                
                
                
                
                siparis_lbl_fiyat.setText("Toplam Fiyat: " + toplam_fiyat);

            }
        });

        kln_personelID.setCellValueFactory(new PropertyValueFactory<>("id"));
        kln_kullaniciad.setCellValueFactory(new PropertyValueFactory<>("kullanici_adi"));
        kln_telefonno.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        kln_adres.setCellValueFactory(new PropertyValueFactory<>("Adres"));
        kln_mail.setCellValueFactory(new PropertyValueFactory<>("Mail"));
        kln_maas.setCellValueFactory(new PropertyValueFactory<>("Maas"));
        kln_izinsayisi.setCellValueFactory(new PropertyValueFactory<>("izin_sayisi"));

        list_personel = FXCollections.observableArrayList();
        
        personelTabloGuncelle();

        table_personel.setOnMouseClicked((MouseEvent event) -> {

            secili_personel = (Personel) table_personel.getSelectionModel().getSelectedItem();

        });

        kln_urunID.setCellValueFactory(new PropertyValueFactory<>("urun_id"));
        kln_urunad.setCellValueFactory(new PropertyValueFactory<>("urun_adi"));
        kln_urunadet.setCellValueFactory(new PropertyValueFactory<>("adet"));

        table_stok.setItems(list_stok);

        table_stok.setOnMouseClicked((MouseEvent event) -> {

            secili_stok = (Stok) table_stok.getSelectionModel().getSelectedItem();

        });
        
        
        
        kln_sip_siparisid.setCellValueFactory(new PropertyValueFactory<>("siparis_id"));
        kln_sip_urunid.setCellValueFactory(new PropertyValueFactory<>("urun_adi"));
        kln_sip_adet.setCellValueFactory(new PropertyValueFactory<>("adet"));
        kln_sip_musteri.setCellValueFactory(new PropertyValueFactory<>("musteri_adi"));
        kln_sip_musteri_id.setCellValueFactory(new PropertyValueFactory<>("musteri_id"));
        kln_sip_musteri_adres.setCellValueFactory(new PropertyValueFactory<>("musteri_adres"));
        kln_sip_musteri_telefon.setCellValueFactory(new PropertyValueFactory<>("musteri_telefon"));
        kln_sip_musteri_mail.setCellValueFactory(new PropertyValueFactory<>("musteri_mail"));
        
        table_sip_yönetimi.setItems(list_siparis);
        
        list_siparis = FXCollections.observableArrayList();
        
        siparisTabloGuncelle();
        
        


    }
    
    private void siparisTabloGuncelle() {
     list_siparis.clear();
       SiparisDAO siparisDAO = new SiparisDAO();
        list_siparis.addAll(siparisDAO.getItems());
        table_sip_yönetimi.setItems(list_siparis);
        
        
}
    private Siparis siparisBilgiGetir(){
        
        SiparisDAO dao = new SiparisDAO();
        Siparis a = new Siparis();
        
        a.setSiparis_id(Integer.parseInt(kln_sip_siparisid.getText()));
        a.setUrun_id(Integer.parseInt(kln_sip_urunid.getText()));
        a.setAdet(Integer.parseInt(kln_sip_adet.getText()));
        a.setMusteri_id(Integer.parseInt(kln_sip_musteri.getText()));
       
        return a;
    
    }
    
    private void siparisGirdi(Siparis a) {
        
        kln_sip_siparisid.setText(String.valueOf(a.getSiparis_id()));
        kln_sip_urunid.setText(String.valueOf(a.getUrun_id()));
        kln_sip_adet.setText(String.valueOf(a.getAdet()));
        kln_sip_musteri.setText(String.valueOf(a.getMusteri_id()));
        
    }
        
       
    

    private void stokTabloGuncelle() {
        list_stok.clear();
        StokDAO stokDAO = new StokDAO();
        list_stok.addAll(stokDAO.getItems());
    }
    
    private void personelTabloGuncelle() {
        list_personel.clear();
        PersonelDAO personelDAO = new PersonelDAO();
        list_personel.addAll(personelDAO.getItems());
        table_personel.setItems(list_personel);
       
    }


    private void stokGirdi(Stok s) {

        
        txt_urunıd.setText(String.valueOf(s.getUrun_id()));
        txt_urunad.setText(s.getUrun_adi());
        txt_urunmıktar.setText(String.valueOf(s.getAdet()));
        txt_fiyat.setText(String.valueOf(s.getFiyat()));

    }

    private void musteriGirdi(Musteri m) { /// ikinci adım

        txt_isim.setText(m.getIsim());
        txt_sifre.setText(m.getSifre());
        txt_telefon.setText(m.getTelefon());
        txt_mail.setText(m.getMail());
        txt_adrs.setText(m.getAdres());

    }

    private void personelGirdi(Personel p) {

        txt_pisim.setText(p.getKullanici_adi());
        txt_psifre.setText(p.getSifre());
        txt_ptelefon.setText(p.getTelefon());
        txt_padres.setText(p.getAdres());
        txt_pmail.setText(p.getMail());
        txt_pmaas.setText(String.valueOf(p.getMaas()));
        txt_pizinsayisi.setText(String.valueOf(p.getIzin_sayisi()));

    }

    @FXML
    private void Tiklandi_urunguncelle(ActionEvent event) {

        Stok s = stokBilgiGetir();
           
        stokDAO.updateItem(s);
        stokTabloGuncelle();
        
    }
    @FXML
    private void btn_YenileTiklandi(ActionEvent event) {

        siparisTabloGuncelle();
        
    }

    @FXML
    private void Tiklandi_btn_urungetir(ActionEvent event) {

        String veri = txt_urunıd.getText().trim();
        int id = 0;
        if (!veri.isEmpty()) {

            try {
                id = Integer.parseInt(veri);

            } catch (NumberFormatException ex) {
                
                new Alert(Alert.AlertType.WARNING, "Id sadece sayi olabilir", ButtonType.OK).showAndWait();
                 ex.printStackTrace();
            }

            if (id != 0) {
                Stok s = new Stok();
                s.setUrun_id(id);

                Stok s2 = stokDAO.getItem(s);

                stokGirdi(s2);
                
                stokTabloGuncelle();
            }
        } else {

            new Alert(Alert.AlertType.WARNING, "Bilgi getirmek için geçerli bir id giriniz", ButtonType.OK).showAndWait();
        }

    }

    @FXML
    private void Tiklandi_urunekle(ActionEvent event) {

        StokDAO dao = new StokDAO();

        dao.insertItem(stokBilgiGetir());

        stokTabloGuncelle();

        Alert mesaj = new Alert(Alert.AlertType.INFORMATION);
        mesaj.setHeaderText("Kayıt ekleme başarılı !!!");
        mesaj.showAndWait();
    }

    private Personel personelBilgiGetir() {
        Personel p = new Personel();
        p.setId(kullanici_personel.getId());
        p.setKullanici_adi(txt_pisim.getText());
        p.setSifre(txt_psifre.getText());
        p.setTelefon(txt_ptelefon.getText());
        p.setAdres(txt_padres.getText());
        p.setMail(txt_pmail.getText());
        p.setMaas(Integer.parseInt(txt_pmaas.getText()));
        p.setIzin_sayisi(Integer.parseInt(txt_pizinsayisi.getText()));
        p.setRol(kullanici_personel.getRol());

        return p;
    }

    private Musteri musteriBilgiGetir() {  //1.adım
        Musteri m = new Musteri();

        m.setId(kullanici_musteri.getId());
        m.setIsim(txt_isim.getText());
        m.setSifre(txt_sifre.getText());
        m.setTelefon(txt_telefon.getText());
        m.setMail(txt_mail.getText());
        m.setAdres(txt_adrs.getText());

        return m;
    }

    private Stok stokBilgiGetir() {  //1.adım

        Stok s = new Stok();
        if(!txt_urunıd.getText().isEmpty())
            s.setUrun_id(Integer.parseInt(txt_urunıd.getText()));
        
        s.setUrun_adi(txt_urunad.getText());
        s.setAdet(Integer.parseInt(txt_urunmıktar.getText()));
        s.setFiyat(Integer.parseInt(txt_fiyat.getText()));

        return s;
    }

    @FXML
    private void Tiklandi_personelEnter(ActionEvent event) {

        PersonelDAO dao = new PersonelDAO();

        Personel p = personelBilgiGetir();
        
        dao.updateItem(p);
        
        personelTabloGuncelle();
        
        Alert mesaj = new Alert(Alert.AlertType.INFORMATION);
        mesaj.setHeaderText("Tablo Güncellendi");
        mesaj.showAndWait();
        
        
    }

    @FXML
    private void Tiklandi_müsteriEnter(ActionEvent event) {
        MusteriDAO dao = new MusteriDAO();

        dao.updateItem(musteriBilgiGetir());

    }

    @FXML
    private void Tiklandi_siparisKaydet(ActionEvent event) {  // siparis kaydetmek için 
        
        SiparisDAO siparisDAO = new SiparisDAO();
        siparisDAO.insertItem(siparis);
        
        
        
        Alert mesaj = new Alert(Alert.AlertType.INFORMATION);
        mesaj.setHeaderText("Siparis Alındı");
        mesaj.showAndWait();
    }

}
