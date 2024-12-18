// Nama: Muhammad Aklilul Hikam
// NIM: 244107060059
// Kelas: SIB 1C
// Absen: 13
import java.util.Scanner;

public class UAS1C13 {
    static String[] namaTim13 = new String[6];
    static int[][] skorTim13 = new int[6][2];
    static int[] totalSkor13 = new int[6];
    static int jumlahTim13 = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("===== SISTEM TURNAMEN =====");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara Turnamen");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    inputDataTim(scanner);
                    break;
                case 2:
                    tampilkanTabelSkor();
                    break;
                case 3:
                    tentukanJuara();
                    break;
                case 4:
                    System.out.println("Terima kasih, sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);
    }

    static void inputDataTim(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Masukkan nama tim: ");
        namaTim13[jumlahTim13] = scanner.nextLine();

        int skorLevel1, skorLevel2;
        while (true) {
            System.out.print("Masukkan skor Level 1: ");
            skorLevel1 = scanner.nextInt();
            if (skorLevel1 < 0) {
                System.out.println("Skor tidak boleh negatif. Silakan ulangi!");
            } else if (skorLevel1 < 35) {
                skorLevel1 = 0;
                System.out.println("Skor Level 1 kurang dari 35, dianggap 0.");
                break;
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Masukkan skor Level 2: ");
            skorLevel2 = scanner.nextInt();
            if (skorLevel2 < 0) {
                System.out.println("Skor tidak boleh negatif. Silakan ulangi!");
            } else {
                break;
            }
        }

        int bonus13 = 0;
        if (skorLevel1 > 50 && skorLevel2 > 50) {
            bonus13 = 13;
            System.out.println("Bonus 13 poin diberikan karena skor Level 1 dan Level 2 di atas 50!");
        }

        skorTim13[jumlahTim13][0] = skorLevel1;
        skorTim13[jumlahTim13][1] = skorLevel2;

        totalSkor13[jumlahTim13] = skorLevel1 + skorLevel2 + bonus13;

        System.out.println("Data tim berhasil ditambahkan.\n");
        jumlahTim13++;
    }

    static void tampilkanTabelSkor() {
        if (jumlahTim13 == 0) {
            System.out.println("Belum ada data tim.\n");
            return;
        }

        System.out.println("===== TABEL SKOR =====");
        System.out.printf("%-15s %-10s %-10s %-10s%n", "Nama Tim", "Level 1", "Level 2", "Total Skor");
        for (int i = 0; i < jumlahTim13; i++) {
            int total13 = totalSkor13[i];
            if (total13 % 2 == 0) {
                total13 -= 15;
            }

            System.out.printf("%-15s %-10d %-10d %-10d%n", namaTim13[i], skorTim13[i][0], skorTim13[i][1], total13);
        }
        System.out.println();
    }

    static void tentukanJuara() {
        if (jumlahTim13 == 0) {
            System.out.println("Belum ada tim untuk ditentukan juara.\n");
            return;
        }

        int juara13 = 0;
        boolean seri13 = false;

        for (int i = 1; i < jumlahTim13; i++) {
            if (totalSkor13[i] > totalSkor13[juara13]) {
                juara13 = i;
                seri13 = false;
            } else if (totalSkor13[i] == totalSkor13[juara13]) {
                if (skorTim13[i][1] > skorTim13[juara13][1]) {
                    juara13 = i;
                    seri13 = false;
                } else if (skorTim13[i][1] == skorTim13[juara13][1]) {
                    seri13 = true;
                }
            }
        }

        if (seri13) {
            System.out.println("Turnamen berakhir seri. Tim terbaik adalah HIKAM.");
        } else {
            System.out.println("Selamat kepada tim \"" + namaTim13[juara13] + "\" yang memenangkan turnamen!");
        }
        System.out.println();
    }
}