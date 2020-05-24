package id.ac.pointearth;

public class MainModel {
    Integer Gambar;
    String Deskripsi;

    public MainModel (Integer Gambar, String Deskripsi){
        this.Gambar = Gambar;
        this.Deskripsi = Deskripsi;
    }

    public Integer getGambar() {
        return Gambar;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }
}
