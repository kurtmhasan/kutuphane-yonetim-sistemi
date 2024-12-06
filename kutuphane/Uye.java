package kutuphane;

import java.util.ArrayList;
import java.util.Date;
public class Uye {
    private String uyeID;  // Üye kimliği
    private String uyeAd;  // Üye adı
    private String uyeTelefon;  // Üye telefon numarası
    private ArrayList<Kitap> oduncAlinanKitaplar;  // Üyenin ödünç aldığı kitaplar
    private ArrayList<String> gecmisKayitlari;  // Üyenin geçmiş ödünç ve iade kayıtları

    // Constructor: Yeni bir üye oluşturur
    public Uye(String uyeID, String uyeAd, String uyeTelefon) {
        this.uyeID = uyeID;
        this.uyeAd = uyeAd;
        this.uyeTelefon = uyeTelefon;
        this.oduncAlinanKitaplar = new ArrayList<>();  // Kitap ödünç alma işlemleri için liste başlatılır
        this.gecmisKayitlari = new ArrayList<>();  // Geçmiş kayıtları tutacak liste başlatılır
    }

    // Getter metodu: Üye ID'sini döner
    public String getUyeID() {
        return uyeID;
    }

    // Getter metodu: Üye adını döner
    public String getUyeAd() {
        return uyeAd;
    }

    // Getter metodu: Üye telefon numarasını döner
    public String getUyeTelefon() {
        return uyeTelefon;
    }

    // Kitap ödünç alma işlemi
    public void kitapOduncAl(Kitap kitap) {
        oduncAlinanKitaplar.add(kitap);  // Kitap, ödünç alınan kitaplar listesine eklenir
        gecmisKayitlari.add("Kitap: " + kitap.getKitapAd() + " | Odunc alindi: " + new Date());  // Geçmiş kaydı eklenir
    }

    // Kitap iade etme işlemi
    public void kitapIadeEt(Kitap kitap) {
        oduncAlinanKitaplar.remove(kitap);  // Kitap, ödünç alınan kitaplar listesinden çıkarılır
        gecmisKayitlari.add("Kitap: " + kitap.getKitapAd() + " | Iade edildi: " + new Date());  // Geçmiş kaydı eklenir
    }

    // Ödünç alınan kitapları döner
    public ArrayList<Kitap> getOduncAlinanKitaplar() {
        return oduncAlinanKitaplar;
    }

    // Üyenin geçmiş ödünç ve iade kayıtlarını gösterir
    public void gecmisKayitlariniGoster() {
        if (gecmisKayitlari.isEmpty()) {  // Eğer geçmiş kayıtlar boşsa
            System.out.println("Bu uyeye ait gecmis kayit bulunmamaktadir.");
        } else {
            System.out.println("Gecmis Kayitlari:");
            for (String kayit : gecmisKayitlari) {
                System.out.println(kayit);  // Her bir kaydı ekrana yazdırır
            }
        }
    }
}
