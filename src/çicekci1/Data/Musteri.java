package çicekci1.Data;

public class Musteri {

    private int id;



    private String isim;
    private String sifre;
    private String telefon;
    private String adres;
    private String mail;



    public Musteri() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();


        sb.append(getId()).append("\n");
        sb.append(getIsim()).append("\n");
        sb.append(getMail()).append("\n");
        sb.append(getSifre()).append("\n");
        sb.append(getTelefon()).append("\n");
        sb.append(getAdres()).append("\n");

        return sb.toString();
    }
}
