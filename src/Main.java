import java.util.Scanner;
import java.util.Arrays;
class Tidur{
    static public void tidur() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Terjadi kesalahan saat menunggu.");
        }
    }
}

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String garis="---------------------------------------------";
    static String garisDua="====================================";

    static String[][] anggota = {
            {"Adam Wahyu H", "202359201009"},
            {"Plorentina Fidelis P", "202359201005"},
            {"Nathan Alvino F", "20235920100"}
    };
    public static void main(String[] args) {
        while (true) {
            System.out.println(garisDua);
            System.out.println("Selamat Datang di Tugas Kelompok 1");
            System.out.println("============   Menu  ===============");
            System.out.println("1. Permainan Logika");
            System.out.println("2. Kalkulator Sederhana ");
            System.out.println("3. Casting Varible ");
            System.out.println(garis);
            System.out.println("Ketik \"daftar\" untuk melihat daftar anggota.");
            System.out.println("Ketik \"info\" untuk link Repo Github.");
            System.out.println("Ketik \"exit\" untuk keluar.");
            System.out.print(": ");
            String optIn = scanner.nextLine();

            if (optIn.equalsIgnoreCase("exit")) {
                System.out.println("Bye!");
                scanner.close();
                break;
            }
            else if (optIn.equalsIgnoreCase("daftar")) {
                int no = 1;
                System.out.println(garis);
                System.out.print("========== Nama Nama Anggota ============\n");
                for (int y = 0; y < anggota.length; y -= -1) {
                    System.out.print(no +". ");
                    for (int z = 0; z < anggota[y].length; z -= -1) {
                        System.out.print( anggota[y][z] + " ");
                    }
                    System.out.println();
                    no++;
                }
                Tidur.tidur();
                continue;
            } else if (optIn.equalsIgnoreCase("info")) {
                System.out.println(garis);
                System.out.print("Tugas sudah saya Upload di: \nhttps://github.com/adamwahyuh/tugas-kelompok-1-java\n");
                System.out.println(garis);
                Tidur.tidur();
                continue;
            }

            if (optIn.equals("1") || optIn.equalsIgnoreCase("a"))  {
                LogicOperator.main(null);
            }
            else if (optIn.equals("2") || optIn.equalsIgnoreCase("b")){
                Kalkulator.main(null);
            }else if (optIn.equals("3") || optIn.equalsIgnoreCase("c")){
                CastingVariable.main(null);
            }
            else {
                System.out.println("Ngarang aja, itu ada di menu pilih!");
            }
        }

    }
}

class LogicOperator {
    public static void main(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);

            System.out.println("🏰 Kamu terjebak di dalam penjara bawah tanah!");
            System.out.println("Kamu hanya bisa membawa **dua** barang untuk membantumu melarikan diri.");
            System.out.println("Pilih dengan bijak!");
            System.out.println("\nApakah anda ingin lanjut ?");
            System.out.print("Type exit untuk keluar dan type apa saja untuk lanjut : ");
            String exi = scanner.nextLine().trim().toLowerCase();
            System.out.println("\nBarang yang tersedia: tali, obor, kunci, pembuka kunci, emas");
            System.out.print("Pilih barang pertama: ");
            String item1 = scanner.nextLine().trim().toLowerCase();

            System.out.print("Pilih barang kedua: ");
            String item2 = scanner.nextLine().trim().toLowerCase();

            if (exi.equalsIgnoreCase("exit")){
                System.out.println("Kembali ke Main Menu...");
                Tidur.tidur();
                break;
            } else{
                boolean punyaTali = item1.equals("tali") || item2.equals("tali");
                boolean punyaObor = item1.equals("obor") || item2.equals("obor");
                boolean punyaKunci = item1.equals("kunci") || item2.equals("kunci");
                boolean punyaPembukaKunci = item1.equals("pembuka kunci") || item2.equals("pembuka kunci");
                boolean mengambilEmas = item1.equals("emas") || item2.equals("emas");

                boolean bisaKabur = (punyaTali && punyaObor) || (punyaKunci || punyaPembukaKunci);
                boolean gagalKabur = !bisaKabur || mengambilEmas;

                System.out.println("\n🔎 Menilai pilihanmu...");

                if (gagalKabur) {
                    if (mengambilEmas) {
                        System.out.println("💰 Emas itu adalah jebakan! Para penjaga menangkapmu. Kamu kalah.");
                    } else {
                        System.out.println("🚪 Pilihanmu tidak cukup untuk melarikan diri. Kamu tetap terjebak!");
                    }
                } else {
                    System.out.println("✨ Selamat! Kamu berhasil melarikan diri dari penjara bawah tanah.");
                }
            }


        }
    }
}

class Kalkulator {
    static double tambah(double a, double b) {
        return a + b;
    }

    static double kurang(double a, double b) {
        return a - b;
    }

    static double kali(double a, double b) {
        return a * b;
    }

    static double bagi(double a, double b) {
        return a / b;
    }

    static double modulus(double a, double b) {
        return a % b;
    }


    public static void main(String[] args) {
        Scanner opt = new Scanner(System.in);

        String[] pilihan = {"1", "2", "3", "4", "5", "a", "b", "c", "d", "e", "A", "B", "C", "D", "E"};

        while (true) {
            System.out.print("Selamat datang di Kalkulator Kelompok 1\nApa yang ingin kamu lakukan: \n1. +\n2. -\n3.*\n4. /\n5. %\nKetik \"exit\" untuk exit\n: ");
            String optIn = opt.nextLine();

            if (optIn.equalsIgnoreCase("exit")) {
                System.out.println("Kembali ke main menu...");
                Tidur.tidur();
                break;
            }
            double a, b, result;

            if (!Arrays.asList(pilihan).contains(optIn)) {
                System.out.println("Tidak ada Pilihannya!");
                Tidur.tidur();
                continue;
            }

            while (true) {
                System.out.print("Angka Pertama : ");
                if (opt.hasNextDouble()) {
                    a = opt.nextDouble();
                    opt.nextLine();
                    break;
                } else {
                    System.out.print("Masukkan angka!\n");
                    opt.next();
                }
            }
            while (true) {
                System.out.print("Angka Kedua : ");
                if (opt.hasNextDouble()) {
                    b = opt.nextDouble();
                    opt.nextLine();
                    break;
                } else {
                    System.out.print("Masukkan angka!\n");
                    opt.next();
                }
            }

            result = 0;
            if (optIn.equals("1") || optIn.equals("+") || optIn.equals("a") || optIn.equals("A")) {
                result = tambah(a, b);
            } else if (optIn.equals("2") || optIn.equals("-") || optIn.equals("b") || optIn.equals("B")) {
                result = kurang(a, b);
            } else if (optIn.equals("3") || optIn.equals("*") || optIn.equals("c") || optIn.equals("C")) {
                result = kali(a, b);
            } else if (optIn.equals("4") || optIn.equals("/") || optIn.equals("d") || optIn.equals("D")) {
                if (b == 0) {
                    System.out.print("Tidak bisa dihitung dengan 0\n");
                    continue;
                } else {
                    result = bagi(a, b);
                }
            } else if (optIn.equals("5") || optIn.equals("%") || optIn.equals("e") || optIn.equals("E")) {
                if (b == 0) {
                    System.out.print("Tidak bisa dihitung dengan 0\n");
                    continue;
                } else {
                    result = modulus(a, b);
                }
            } else {
                System.out.print("Tidak ada!");
                opt.close();
                return;
            }

            System.out.println("Jawabannya : " + result);
            Tidur.tidur();
        }
    }
}
class CastingVariable {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCasting variable Double ke Integer");
            System.out.println("Apa yang ingin kamu lakukan?");
            System.out.println("1. Bilangan Pecahan ke Bilangan Bulat");
            System.out.println("2. Bilangan Bulat ke Bilangan Pecahan");
            System.out.println(Main.garis);
            System.out.println("Ketik \"exit\" untuk keluar");
            System.out.print(": ");

            String pilihan = scan.nextLine().trim();

            if (pilihan.equalsIgnoreCase("exit")) {
                System.out.println("Kembali ke main menu...");
                Tidur.tidur();
                return;
            }

            if (pilihan.equals("1")) {
                doubleToInteger();
            } else if (pilihan.equals("2")) {
                integerToDouble();
            } else {
                System.out.println("Pilihan tidak ada");
            }
        }
    }

    static public void doubleToInteger() {
        while (true) {
            System.out.print("Masukkan bilangan pecahan Anda \nketik \"exit\" untuk keluar\n> ");
            String input = scan.next();
            scan.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Kembali ke menu...");
                Tidur.tidur();
                return;
            }

            try {
                // dari string convert ke double
                double bilanganPecahan = Double.parseDouble(input);
                // dari doble convert ke int
                int bilanganBulat = (int) bilanganPecahan;
                System.out.println("Angka anda menjadi: " + bilanganBulat);
                Tidur.tidur();
                continue;
            } catch (NumberFormatException e) {
                System.out.println("Input yang anda masukan salah!");
            }
        }
    }

    static public void integerToDouble() {
        while (true) {
            System.out.print("Masukkan bilangan Bulat Anda \nketik \"exit\" untuk keluar\n> ");
            String input = scan.next();
            scan.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Kembali ke menu...");
                Tidur.tidur();
                return;
            }

            try {
                int bilanganBulat = Integer.parseInt(input);
                double bilanganPecahan = (double) bilanganBulat;
                System.out.println("Angka anda menjadi: " + bilanganPecahan);
                Tidur.tidur();
                continue;
            } catch (NumberFormatException e) {
                System.out.println("Input yang anda masukan salah!");
            }
        }
    }
}
