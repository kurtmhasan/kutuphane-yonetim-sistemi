package kutuphane;

import java.util.ArrayList;
import java.util.Scanner;

 class Kutuphane {
    private static ArrayList<Uye> uyeler = new ArrayList<>();
    private static ArrayList<Kitap> kitaplar = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Kutuphane Yonetim Sistemine Hos Geldiniz");
        boolean cikis = false;

        while (!cikis) {
            System.out.println("\nAna Menu:");
            System.out.println("1. Admin Girisi");
            System.out.println("2. Cikis");
            System.out.print("Seciminizi yapin: ");
            
            int secim = scanner.nextInt();
            scanner.nextLine(); // Enter tusu girdisini temizler

            switch (secim) {
                case 1:
                    adminGirisi();
                    break;
                case 2:
                    cikis = true;
                    System.out.println("Cikis yapiliyor...");
                    break;
                default:
                    System.out.println("Gecersiz secim!");
            }
        }
    }

    private static void adminGirisi() {
        System.out.print("Admin kullanici adi: ");
        String adminKullaniciAdi = scanner.nextLine();
        System.out.print("Admin sifresi: ");
        String adminSifre = scanner.nextLine();

        if (adminKullaniciAdi.equals("hasan") && adminSifre.equals("1234")) {
            System.out.println("Admin girisi basarili!");
            boolean adminCikis = false;

            while (!adminCikis) {
                System.out.println("\nAdmin Menu:");
                System.out.println("1. Uye Islemleri");
                System.out.println("2. Kitap Islemleri");
                System.out.println("3. Ana Menuye Don");
                System.out.print("Seciminizi yapin: ");

                int adminSecim = scanner.nextInt();
                scanner.nextLine(); // Enter tusu girdisini temizler

                switch (adminSecim) {
                    case 1:
                        uyeIslemleri();
                        break;
                    case 2:
                        kitapIslemleri();
                        break;
                    case 3:
                        adminCikis = true;
                        break;
                    default:
                        System.out.println("Gecersiz secim!");
                }
            }
        } else {
            System.out.println("Hatali kullanici adi veya sifre!");
        }
    }

    private static void uyeIslemleri() {
        System.out.println("\nUye Islemleri:");
        System.out.println("1. Uye Ekle");
        System.out.println("2. Uyeleri Listele");
        System.out.println("3. Uye Sil");
        System.out.println("4. Uye Sorgula");
        System.out.println("5. Uye gecmisi Sorgula");
        System.out.print("Seciminizi yapin: ");
        
        int secim = scanner.nextInt();
        scanner.nextLine(); // Enter tusu girdisini temizler
        
        switch (secim) {
            case 1:
                uyeEkle();
                break;
            case 2:
                uyeleriListele();
                break;
            case 3:
                uyeSil();
                break;
            case 4:
                uyeSorgula();
                break;
          case 5:
                uyeGecmisSorgula(); // Üye geçmişini sorgulama
                break;
            default:
                System.out.println("Gecersiz secim!"); // Geçersiz seçenek
        }
    }

    private static void kitapIslemleri() {
        System.out.println("\nKitap Islemleri:");
        System.out.println("1. Kitap Ekle");
        System.out.println("2. Kitaplari Listele");
        System.out.println("3. Kitap sorgu");
        System.out.println("4. Kitap Sil");
        System.out.println("5. Kitap Odunc Al");
        System.out.println("6. Kitap Iade Et");
        System.out.print("Seciminizi yapin: ");
        
        int secim = scanner.nextInt();
        scanner.nextLine(); // Enter tuşu girdisini temizler
        
        switch (secim) {
            case 1:
                kitapEkle(); // Kitap ekleme
                break;
            case 2:
                kitaplariListele(); // Kitapları listeleme
                break;
            case 3:
                kitapSorgula(); // Kitap sorgulama
                break;
            case 4:
                kitapSil(); // Kitap silme
                break;
            case 5:
                kitapOduncAl(); // Kitap ödünç alma
                break;
            case 6:
                kitapIadeEt(); // Kitap iade etme
                break;
            default:
                System.out.println("Gecersiz secim!"); // Geçersiz seçenek
        }
    }

    private static void uyeEkle() {
        System.out.print("Uye ID: ");
        String uyeID = scanner.nextLine();
        System.out.print("Uye Ad: ");
        String uyeAd = scanner.nextLine();
        System.out.print("Uye Telefon: ");
        String uyeTelefon = scanner.nextLine();

        Uye yeniUye = new Uye(uyeID, uyeAd, uyeTelefon);
        uyeler.add(yeniUye);
        System.out.println("Yeni uye basariyla eklendi!");
    }

    private static void uyeleriListele() {
        if (uyeler.isEmpty()) {
            System.out.println("Kayitli uye yok.");
        } else {
            System.out.println("Uyeler:");
            for (Uye uye : uyeler) {
                System.out.println("ID: " + uye.getUyeID() + ", Ad: " + uye.getUyeAd() + ", Telefon: " + uye.getUyeTelefon());
            }
        }
    }

    private static void uyeSil() {
        System.out.print("Silmek istediginiz uye ID'sini girin: ");
        String uyeID = scanner.nextLine();
        Uye uye = findUyeByID(uyeID);
        if (uye != null) {
            uyeler.remove(uye);
            System.out.println("Uye basariyla silindi.");
        } else {
            System.out.println("Uye bulunamadi.");
        }
    }

    private static void uyeSorgula() {
        System.out.print("Uye ID'si ile arama yapin: ");
        String uyeID = scanner.nextLine();
        Uye uye = findUyeByID(uyeID);
        if (uye != null) {
            System.out.println("Uye bulundu: " + uye.getUyeAd() + ", Telefon: " + uye.getUyeTelefon());
        } else {
            System.out.println("Uye bulunamadi.");
        }
    }
    
    private static void uyeGecmisSorgula() {
        System.out.print("Uye ID'si ile arama yapin: ");
        String uyeID = scanner.nextLine();
        Uye uye = findUyeByID(uyeID); // Üye ID ile arama yap
        if (uye != null) {
            uye.gecmisKayitlariniGoster(); // Üye geçmişini göster
        } else {
            System.out.println("Uye bulunamadi."); // Üye bulunamazsa mesaj
        }
    }

    private static Uye findUyeByID(String uyeID) {
        for (Uye uye : uyeler) {
            if (uye.getUyeID().equals(uyeID)) {
                return uye;
            }
        }
        return null;
    }

    private static void kitapEkle() {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Kitap Adi: ");
        String kitapAd = scanner.nextLine();
        System.out.print("Yazar: ");
        String yazar = scanner.nextLine();

        Kitap yeniKitap = new Kitap(isbn, kitapAd, yazar);
        kitaplar.add(yeniKitap);
        System.out.println("Yeni kitap basariyla eklendi!");
    }

    private static void kitaplariListele() {
        if (kitaplar.isEmpty()) {
            System.out.println("Kayitli kitap yok.");
        } else {
            System.out.println("Kitaplar:");
            for (Kitap kitap : kitaplar) {
                System.out.println("ISBN: " + kitap.getIsbn() + ", Ad: " + kitap.getKitapAd() + ", Yazar: " + kitap.getYazar() + ", Mevcut: " + (kitap.isMevcut() ? "Evet" : "Hayir"));
            }
        }
    }
    private static void kitapSorgula() {
        System.out.print("Kitap ISBN'si ile arama yapin: ");
        String isbn = scanner.nextLine();
        Kitap kitap = findKitapByIsbn(isbn); // ISBN ile arama yap
        if (kitap != null) {
            System.out.println("Kitap bulundu: " + kitap.getKitapAd() + ", Yazar: " + kitap.getYazar()+ ", Mevcut: " + (kitap.isMevcut() ? "Evet" : "Hayir")); // Kitap bilgisi
        } else {
            System.out.println("Kitap bulunamadi."); // Kitap bulunamazsa mesaj
        }
    }
    
     private static void kitapSil() {
        System.out.print("Silmek istediginiz itap ISBM'sini girin: ");
        String isbn = scanner.nextLine();
        Kitap kitap = findKitapByIsbn(isbn);
        if (kitap != null) {
            kitaplar.remove(kitap);
            System.out.println("kitap basariyla silindi.");
        } else {
            System.out.println("kitap bulunamadi.");
        }
    }

    private static void kitapOduncAl() {
        System.out.print("Kitap ISBN: ");
        String isbn = scanner.nextLine();
        Kitap kitap = findKitapByIsbn(isbn);
        if (kitap != null && kitap.isMevcut()) {
            System.out.print("Uye ID: ");
            String uyeID = scanner.nextLine();
            Uye uye = findUyeByID(uyeID);
            if (uye != null) {
                kitap.setMevcut(false);
                System.out.println("Kitap basariyla odunc alindi.");
                uye.kitapOduncAl(kitap);
            } else {
                System.out.println("Uye bulunamadi.");
            }
        } else {
            System.out.println("Kitap mevcut degil.");
        }
    }

    private static void kitapIadeEt() {
        System.out.print("Kitap ISBN: ");
        String isbn = scanner.nextLine();
        Kitap kitap = findKitapByIsbn(isbn);
        if (kitap != null && !kitap.isMevcut()) {
            System.out.print("Uye ID: ");
            String uyeID = scanner.nextLine();
            Uye uye = findUyeByID(uyeID);
            if (uye != null && uye.getOduncAlinanKitaplar().contains(kitap)) {
                kitap.setMevcut(true);
                uye.kitapIadeEt(kitap);
                System.out.println("Kitap basariyla iade edildi.");
            } else {
                System.out.println("Uye kitap almis degil.");
            }
        } else {
            System.out.println("Kitap mevcut degil.");
        }
    }

    private static Kitap findKitapByIsbn(String isbn) {
        for (Kitap kitap : kitaplar) {
            if (kitap.getIsbn().equals(isbn)) {
                return kitap;
            }
        }
        return null;
    }
}
