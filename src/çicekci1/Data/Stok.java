package çicekci1.Data;

public class Stok {

    private int urun_id,adet,fiyat;

    private String urun_adi;

    public Stok(int urun_id, int adet, int fiyat, String urun_adi) {
        this.urun_id = urun_id;
        this.adet = adet;
        this.fiyat = fiyat;
        this.urun_adi = urun_adi;
    }

    public Stok() {
       
   
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

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

 
}
