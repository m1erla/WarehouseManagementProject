package DepoProje;


import java.util.*;


public class Method {
    static Scanner input = new Scanner(System.in);
    static Map<String, UrunlerPojo> urunlerListesi = new HashMap<>();
    static Set<Map.Entry<String, UrunlerPojo>> urunDetaylari = urunlerListesi.entrySet();
    static Set<String> idNumaralari = urunlerListesi.keySet();
        public static void urunTanimlama() {
            System.out.println("-".repeat(20) + "Urun Tanimlama Sayfasi" + "-".repeat(20));

            String urunIsmi = "";
            String uretici = "";
            int miktar = 0;
            String birim = "";

            boolean validInput = false;

            while (!validInput) {
                System.out.println("Tanimlama yapmak istediginiz urunun Ismini giriniz:");
                urunIsmi = input.nextLine().trim();
                if (urunIsmi.isEmpty() || urunIsmi.contains(" ") || !urunIsmi.matches("[A-Za-z]+")) {
                    System.out.println("Girmis oldugunuz Urun Ismi istenilen kriterlere uygun degildir. Tekrar deneyiniz.");
                    continue;
                }
                validInput = true;
            }

            validInput = false;
            while (!validInput) {
                System.out.println("Tanimlama yapmak istediginiz urunun Ureticisini giriniz:");
                uretici = input.nextLine().trim();
                if (uretici.isEmpty() || uretici.contains(" ") || !uretici.matches("[A-Za-z]+")) {
                    System.out.println("Girmis oldugunuz Uretici istenilen kriterlere uygun degildir. Tekrar deneyiniz.");
                    continue;
                }
                validInput = true;
            }

            validInput = false;
            while (!validInput) {
                System.out.println("Tanimlama yapmak istediginiz urunun miktarini giriniz:");
                String miktarStr = input.nextLine().trim();
                if (miktarStr.isEmpty() || miktarStr.contains(" ")) {
                    System.out.println("Girmis oldugunuz Miktar istenilen kriterlere uygun degildir. Tekrar deneyiniz.");
                    continue;
                }
                try {
                    miktar = Integer.parseInt(miktarStr);
                    if (miktar >= 0) {
                        validInput = true;
                    } else {
                        System.out.println("Girmis oldugunuz Miktar istenilen kriterlere uygun degildir. Tekrar deneyiniz.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Miktar değeri sayısal bir değer olmalıdır. Tekrar deneyiniz.");
                }
            }

            validInput = false;
            while (!validInput) {
                System.out.println("Tanimlama yapmak istediginiz urunun birimini giriniz:");
                birim = input.nextLine().trim();
                if (birim.isEmpty() || birim.contains(" ") || !birim.matches("[A-Za-z]+")) {
                    System.out.println("Girmis oldugunuz Birim istenilen kriterlere uygun degildir. Tekrar deneyiniz.");
                    continue;
                }
                validInput = true;
                int idx = (int) (Math.random() * 300);
                String id = String.valueOf(idx);

                String raf = null;

                UrunlerPojo urunObje = new UrunlerPojo(id, urunIsmi, uretici, miktar, birim, raf);
                urunlerListesi.put(id, urunObje);
                urunListeleme();
            }
        }

   public static void miktarGuncelleme() {

        System.out.println("-".repeat(20) + "Miktar Guncelleme Sayfasi" + "-".repeat(20));
        System.out.println("Eklemek Istediginiz urunun ID numarasini  giriniz.");
        String girilenId = input.next();
        UrunlerPojo guncellemeObje = urunlerListesi.get(girilenId);

        if (idNumaralari.contains(girilenId)) {

            System.out.println("Guncelleme yapmak istediginiz urun miktarini giriniz");
            int guncellenecekMiktar = input.nextInt();
            if (!(guncellenecekMiktar <= 0)) {

                guncellemeObje.setMiktar(guncellemeObje.getMiktar() + guncellenecekMiktar);

                System.out.println("Urun miktariniz basari ile guncellenmistir.");
                urunListeleme();

                System.out.println("Depo giris paneline girmek icin 1'ye basiniz");

                String tercih = input.next();
                if (tercih.equals("1")) {
                    Depo_Giris_Paneli.girisPaneli();
                } else {
                    System.out.println("Yanlis secim yaptiniz");
                }
            } else {
                System.out.println("Depomuzda cikis yapmak istediginiz kadar urun bulunmamaktadir.");
            }
        } else {
            System.out.println("Miktar Guncelleme yapmak istediginiz urune ait id depomuzda bulunmamaktadir.");
            System.out.println("Urun Miktar Guncellemeye devam etmek icin 1'e basiniz\n " +
                    "Depo gris paneline girmek icin 2'ye basiniz\n");
            String sss = input.next();
            if (sss.equals("1")) {
                miktarGuncelleme();
            } else {
                Depo_Giris_Paneli.girisPaneli();
            }
        }
    }

    public static void rafGuncelleme() {
        System.out.println("-".repeat(20) + "Raf Guncelleme Sayfasi" + "-".repeat(20));
        System.out.println("Raf guncellemek  istediginiz urununun ID numarasini giriniz.");
        String girilenId1 = input.next();
        UrunlerPojo rafObje = urunlerListesi.get(girilenId1);

        if (idNumaralari.contains(girilenId1)) {

            if (Integer.valueOf(girilenId1) > 0 && Integer.valueOf(girilenId1) < 101) {
                rafObje.setRaf("raf1");
            } else if (Integer.valueOf(girilenId1) > 100 && Integer.valueOf(girilenId1) < 201) {
                rafObje.setRaf("raf2");
            } else if (Integer.valueOf(girilenId1) > 200 && Integer.valueOf(girilenId1) < 301) {
                rafObje.setRaf("raf3");
            }

            System.out.println("Urununuz raflarimizda  basari ile guncellenmistir.");
            urunListeleme();
            System.out.println("Depo giris paneline girmek icin 1'ye basiniz.");

            String tercih = input.next();
            if (tercih.equals("1")) {
                Depo_Giris_Paneli.girisPaneli();
            } else {
                System.out.println("Yanlis secim yaptiniz");
            }
        } else {
            System.out.println("Raf Guncelleme yapmak istediginiz ID'ye ait urun  depomuzda bulunmamaktadir.");
            System.out.println("Raf Guncellemeye devam etmek icin 1'e basiniz\n " +
                    "Depo gris paneline girmek icin 2'ye basiniz\n");
            String sss = input.next();
            if (sss.equals("1")) {
                rafGuncelleme();
            } else {
                System.out.println("Hatali secim yaptiniz");
                Depo_Giris_Paneli.girisPaneli();

            }
        }
    }

    public static void urunCikisi() {
            System.out.println("-".repeat(20) + "Urun Cikis Sayfasi" + "-".repeat(20));
            System.out.println("Cikis yapmak istediginiz urunun ID numarasini giriniz:");
            String cikisId = input.next();

            if (!idNumaralari.contains(cikisId)) {
                System.out.println("Girdiginiz ID'ye ait urun depomuzda bulunmamaktadir.");
                System.out.println("Cikis islemine devam etmek icin 1'e, depo giris paneline donmek icin 2'ye basiniz:");

                String tercih = input.next();
                if (tercih.equals("1")) {
                    urunCikisi();
                } else if (tercih.equals("2")) {
                    Depo_Giris_Paneli.girisPaneli();
                } else {
                    System.out.println("Gecersiz secim yaptiniz.");
                    Depo_Giris_Paneli.girisPaneli();
                }
            } else {
                UrunlerPojo cikisObje = urunlerListesi.get(cikisId);

                System.out.println("Cikis yapmak istediginiz urun miktarini giriniz:");
                while (!input.hasNextInt()) {
                    System.out.println("Gecersiz giris. Sadece sayisal deger giriniz.");
                    input.next();
                }
                int cikarilacakMiktar = input.nextInt();

                if (cikisObje.getMiktar() >= cikarilacakMiktar) {
                    cikisObje.setMiktar(cikisObje.getMiktar() - cikarilacakMiktar);

                    System.out.println("Urun cikis isleminiz basariyla gerceklestirilmistir.");
                    urunListeleme();

                    System.out.println("Depo giris paneline girmek icin 1'e basiniz:");
                    String tercih = input.next();
                    if (tercih.equals("1")) {
                        Depo_Giris_Paneli.girisPaneli();
                    } else {
                        System.out.println("Yanlis secim yaptiniz.");
                    }
                } else {
                    System.out.println("Depomuzda cikis yapmak istediginiz kadar urun bulunmamaktadir.");
                    urunCikisi();
                }
            }
        }


    public static void urunListeleme() {

        System.out.printf("%-20s %-19s %-19s %-19s %-19s %-15s\n", "id", "UrunIsmi", "Uretici", "Miktar", "Birim", "Raf");
        System.out.println("-".repeat(120));

        for (Map.Entry<String, UrunlerPojo> w : urunDetaylari) {
            String key = w.getKey();

            System.out.printf("%-20s %-19s %-19s %-19s %-19s %-15s\n", key, urunlerListesi.get(key).getUrunIsmi(), urunlerListesi.get(key).getUretici(),
                    urunlerListesi.get(key).getMiktar(), urunlerListesi.get(key).getBirim(), urunlerListesi.get(key).getRaf());

        }
        System.out.println("Urun tanimlamaya devam etmek icin 1'e basiniz \n" +
                "Urun listenizi tekrar gormek icin 2' ye basiniz\n " +
                "Depo giris paneline girmek icin 3'ye basiniz\n");

        String tercih = input.next();
        if (tercih.equals("1")) {
            urunTanimlama();
        } else if (tercih.equals("2")) {
            urunListeleme();
        } else if (tercih.equals("3")) {
            Depo_Giris_Paneli.girisPaneli();
        } else {
            System.out.println("Hatali secim yaptiniz");
            Depo_Giris_Paneli.girisPaneli();

        }
    }


    public static void cikis() {
        System.out.println("Depo islemleri uygulamasini kullandiginiz icin tesekkur ederiz\n" +
                "Iyi Gunler Dileriz");

    }

}
