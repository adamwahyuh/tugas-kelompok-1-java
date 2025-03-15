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
    static String[][] anggota = {
            {"Adam Wahyu H", "202359201009"},
            {"Plorentina Fidelis P", "202359201005"},
            {"Nathan Alvino F", "20235920100"}
    };

    public static void main(String[] args) {
        while (true) {
            System.out.print("Selamat Datang di Tugas Kelompok 1 \n===== MENU UTAMA =====\n");
            System.out.println("1. Permainan Logika (Melarikan diri dari penjara) - Nathan");
            System.out.println("2. Kalkulator Kelompok 1 - Adam & Ploren");
            System.out.println("Ketik \"daftar\" untuk keluar.");
            System.out.println("Ketik \"exit\" untuk keluar.");
            System.out.print(": ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                System.out.println("Bye!");
                break;
            }
            else if (choice.equalsIgnoreCase("daftar")) {
                System.out.print("Nama Nama Kelompok\n");
                for (int y = 0; y < anggota.length; y -= -1) {
                    for (int z = 0; z < anggota[y].length; z -= -1) {
                        System.out.print(anggota[y][z] + " ");
                    }
                    System.out.println();
                }
                Tidur.tidur();
                continue;
            }

            if (choice.equals("1") || choice.equalsIgnoreCase("a"))  {
                LogicOperator.main(null);
            }
            else if (choice.equals("2") || choice.equalsIgnoreCase("b")){
                Kalkulator.main(null);
            }
            else {
                System.out.println("Ngarang aja, itu ada di menu pilih!");
            }
        }

    }
}

class LogicOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🏰 Kamu terjebak di dalam penjara bawah tanah!");
        System.out.println("Kamu hanya bisa membawa **dua** barang untuk membantumu melarikan diri.");
        System.out.println("Pilih dengan bijak!");

        System.out.println("\nBarang yang tersedia: tali, obor, kunci, pembuka kunci, emas");
        System.out.print("Pilih barang pertama: ");
        String item1 = scanner.nextLine().trim().toLowerCase();

        System.out.print("Pilih barang kedua: ");
        String item2 = scanner.nextLine().trim().toLowerCase();

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

class Kalkulator {
    static int tambah(int a, int b) {
        return a + b;
    }

    static int kurang(int a, int b) {
        return a - b;
    }

    static int kali(int a, int b) {
        return a * b;
    }

    static int bagi(int a, int b) {
        return a / b;
    }

    static int modulus(int a, int b) {
        return a % b;
    }


    public static void main(String[] args) {
        Scanner opt = new Scanner(System.in);

        String[] pilihan = {"1", "2", "3", "4", "5", "a", "b", "c", "d", "e", "A", "B", "C", "D", "E"};

        while (true) {
            System.out.print("Selamat datang di Kalkulator Kelompok 1\nApa yang ingin kamu lakukan: \n1. +\n2. -\n3.*\n4. /\n5. %\nKetik \"exit\" untuk exit\nKetik \"daftar\" untuk melihat daftar anggota\n: ");
            String optIn = opt.nextLine();

            if (optIn.equalsIgnoreCase("exit")) {
                System.out.print("Bye!");
                break;
            }
            int a, b, result;

            if (!Arrays.asList(pilihan).contains(optIn)) {
                System.out.println("Tidak ada Pilihannya!");
                Tidur.tidur();
                continue;
            }

            while (true) {
                System.out.print("Angka Pertama : ");
                if (opt.hasNextInt()) {
                    a = opt.nextInt();
                    opt.nextLine();
                    break;
                } else {
                    System.out.print("Masukkan angka!\n");
                    opt.next();
                }
            }
            while (true) {
                System.out.print("Angka Kedua : ");
                if (opt.hasNextInt()) {
                    b = opt.nextInt();
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
