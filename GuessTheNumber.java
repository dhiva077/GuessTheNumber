import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean mainLagi = true;
        int totalScore = 0;

        System.out.println("╔═════════════════════════╗");
        System.out.println("║" + "\033[1;33m" + "  GUESS THE NUMBER GAME!   " + "\033[0m" + "║");
        System.out.println("╚═════════════════════════╝");

        while (mainLagi) {
            System.out.println("\n\033[1;34mPilih Tingkat Kesulitan:\033[0m");
            System.out.println("1. Mudah (1 - 50)");
            System.out.println("2. Sedang (1 - 100)");
            System.out.println("3. Sulit (1 - 200)");
            System.out.print("Pilihan Anda: ");
            int pilihan = scanner.nextInt();

            int maxNumber = 0;
            if (pilihan == 1) {
                maxNumber = 50;
            } else if (pilihan == 2) {
                maxNumber = 100;
            } else if (pilihan == 3) {
                maxNumber = 200;
            } else {
                System.out.println("\033[1;31mPilihan tidak valid! Mulai dari awal.\033[0m");
                continue;
            }

            int targetNumber = random.nextInt(maxNumber) + 1;
            int percobaan = 0;
            boolean menang = false;

            System.out.println("\033[1;36mTebak angka antara 1 dan " + maxNumber + "!\033[0m");

            while (!menang) {
                System.out.print("\033[1;35mMasukkan tebakan Anda: \033[0m");
                int tebakan = scanner.nextInt();
                percobaan++;

                if (tebakan == targetNumber) {
                    System.out.println("\033[1;32mSelamat! Anda menebak dengan benar dalam " + percobaan + " percobaan.\033[0m");

                    // Memberikan poin berdasarkan jumlah percobaan
                    int score = (maxNumber / percobaan) * 10;
                    totalScore += score;
                    System.out.println("\033[1;33mPoin yang Anda peroleh: " + score + "\033[0m");
                    menang = true;
                } else if (tebakan < targetNumber) {
                    System.out.println("\033[1;34mAngka terlalu kecil! Coba lagi.\033[0m");
                } else {
                    System.out.println("\033[1;31mAngka terlalu besar! Coba lagi.\033[0m");
                }
            }

            System.out.print("\033[1;35mApakah Anda ingin bermain lagi? (y/n): \033[0m");
            String ulang = scanner.next().trim().toLowerCase();

            if (!ulang.equals("y")) {
                mainLagi = false;
            }
        }

        System.out.println("\033[1;33mTotal Skor Anda: " + totalScore + "\033[0m");
        System.out.println("\033[1;32mTerima kasih sudah bermain! Sampai jumpa! 🎯\033[0m");

        scanner.close();
    }
}