package çicekci1.Data;

public class Siparis {

 
    private int siparis_id, urun_id , adet , musteri_id ;
    private String urun_adi,musteri_adi,musteri_adres,musteri_telefon,musteri_mail;

    public String getMusteri_adres() {
        return musteri_adres;
    }

    public void setMusteri_adres(String musteri_adres) {
        this.musteri_adres = musteri_adres;
    }

    public String getMusteri_telefon() {
        return musteri_telefon;
    }

    public void setMusteri_telefon(String musteri_telefon_musteri) {
        this.musteri_telefon = musteri_telefon_musteri;
    }

    public String getMusteri_mail() {
        return musteri_mail;
    }

    public void setMusteri_mail(String musteri_mail) {
        this.musteri_mail = musteri_mail;
    }
   

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public String getMusteri_adi() {
        return musteri_adi;
    }

    public void setMusteri_adi(String musteri_adi) {
        this.musteri_adi = musteri_adi;
    }

    public Siparis(int siparis_id, int urun_id, int adet, int musteri_id) {
        this.siparis_id = siparis_id;
        this.urun_id = urun_id;
        this.adet = adet;
        this.musteri_id = musteri_id;
    }

    public Siparis() {
    
    }

    public int getSiparis_id() {
        return siparis_id;
    }

    public void setSiparis_id(int siparis_id) {
        this.siparis_id = siparis_id;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }
}
