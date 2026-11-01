import java.util.Scanner;

public class GajiKaryawan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] gaji = {5000000, 6500000, 9500000};
        int[] lembur = {30, 32, 34, 36, 38};

        System.out.print("Masukkan golongan (A/B/C): ");
        String golongan = input.next().toUpperCase();

        System.out.print("Masukkan jumlah jam lembur: ");
        int jamLembur = input.nextInt();

        int indeksGaji;
        if (golongan.equals("A")) {
            indeksGaji = 0;
        } else if (golongan.equals("B")) {
            indeksGaji = 1;
        } else if (golongan.equals("C")) {
            indeksGaji = 2;
        } else {
            System.out.println("Golongan tidak valid.");
            input.close();
            return;
        }

        if (jamLembur < 0) {
            System.out.println("Jam lembur tidak boleh negatif.");
            input.close();
            return;
        }

        double gajiPokok = gaji[indeksGaji];
        int persenLembur = 0;

        if (jamLembur == 1) {
            persenLembur = lembur[0];
        } else if (jamLembur == 2) {
            persenLembur = lembur[1];
        } else if (jamLembur == 3) {
            persenLembur = lembur[2];
        } else if (jamLembur == 4) {
            persenLembur = lembur[3];
        } else if (jamLembur >= 5) {
            persenLembur = lembur[4];
        }

        double gajiLembur = gajiPokok * persenLembur / 100;
        double totalGaji = gajiPokok + gajiLembur;

        System.out.println("\n=== HASIL PERHITUNGAN GAJI ===");
        System.out.println("Golongan       : " + golongan);
        System.out.println("Jam lembur     : " + jamLembur);
        System.out.printf("Gaji pokok     : Rp%,.0f%n", gajiPokok);
        System.out.println("Persen lembur  : " + persenLembur + "%");
        System.out.printf("Gaji lembur    : Rp%,.0f%n", gajiLembur);
        System.out.printf("Total gaji     : Rp%,.0f%n", totalGaji);

        input.close();
    }
}
