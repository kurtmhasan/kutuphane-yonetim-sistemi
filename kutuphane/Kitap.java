package kutuphane;
public class Kitap {
    private String isbn;
    private String kitapAd;
    private String yazar;
    private boolean mevcut;

    public Kitap(String isbn, String kitapAd, String yazar) {
        this.isbn = isbn;
        this.kitapAd = kitapAd;
        this.yazar = yazar;
        this.mevcut = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getKitapAd() {
        return kitapAd;
    }

    public String getYazar() {
        return yazar;
    }

    public boolean isMevcut() {
        return mevcut;
    }

    public void setMevcut(boolean mevcut) {
        this.mevcut = mevcut;
    }
}
