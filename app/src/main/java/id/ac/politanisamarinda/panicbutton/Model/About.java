package id.ac.politanisamarinda.panicbutton.Model;

public class About {
    private int imageResource;
    private String nama;
    private String tanggalLahir;
    private String alamat;
    private String socialMedia;

    public About(int imageResource, String nama, String tanggalLahir, String alamat, String socialMedia) {
        this.imageResource = imageResource;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
        this.socialMedia = socialMedia;
    }

    public String getSocialMedia() {
        return socialMedia;
    }
    public String getNama() {
        return nama;
    }
    public String getAlamat(){
        return alamat;
    }
    public String getTanggalLahir() {
        return tanggalLahir;
    }
    public int getImageResource() {
        return imageResource;
    }
}
