
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class GajiKaryawan {

    public static void main(String[] args) {
        // try with resources
        try (Scanner input = new Scanner(System.in)) {
            // Format mata uang Rupiah
            NumberFormat rupiah = NumberFormat.getCurrencyInstance(
                    Locale.of("id", "ID")
            );
            rupiah.setMaximumFractionDigits(0);
            rupiah.setMinimumFractionDigits(0);

            // initial variable
            String golongan;
            int jamLembur;
            double gajiPokok, persenLembur, gajiLembur, totalGaji;

            // input variable golongan
            System.out.print("Masukkan golongan karyawan (A/B/C): ");
            golongan = input.next().toUpperCase();

            // input jam kerja
            System.out.print("Masukkan jumlah jam lembur: ");
            jamLembur = input.nextInt();

            // Menentukan gaji pokok - if else
            // if (golongan.equals("A")) {
            //     gajiPokok = 5000000;
            // } else if (golongan.equals("B")) {
            //     gajiPokok = 6500000;
            // } else if (golongan.equals("C")) {
            //     gajiPokok = 9500000;
            // } else {
            //     System.out.println("Golongan karyawan tidak valid.");
            //     input.close();
            //     return;
            // }
            // Menentukan gaji pokok
            switch (golongan) {
                case "A" ->
                    gajiPokok = 5000000;
                case "B" ->
                    gajiPokok = 6500000;
                case "C" ->
                    gajiPokok = 9500000;
                default -> {
                    System.out.println("Golongan karyawan tidak valid.");
                    return;
                }
            }

            // Menentukan persentase gaji lembur
            if (jamLembur == 1) {
                persenLembur = 0.30;
            } else if (jamLembur == 2) {
                persenLembur = 0.32;
            } else if (jamLembur == 3) {
                persenLembur = 0.34;
            } else if (jamLembur == 4) {
                persenLembur = 0.36;
            } else if (jamLembur >= 5) {
                persenLembur = 0.38;
            } else if (jamLembur == 0) {
                persenLembur = 0;
            } else {
                System.out.println("Jumlah jam lembur tidak valid.");
                return;
            }

            // Menghitung total penghasilan
            gajiLembur = gajiPokok * persenLembur;
            totalGaji = gajiPokok + gajiLembur;

            System.out.println("\n===== RINCIAN GAJI KARYAWAN =====");
            System.out.println("Golongan          : " + golongan);
            System.out.println("Gaji Pokok        : " + rupiah.format(gajiPokok));
            System.out.println("Jam Lembur        : " + jamLembur + " jam");
            System.out.println("Gaji Lembur       : " + rupiah.format(gajiLembur));
            System.out.println("Total Penghasilan : " + rupiah.format(totalGaji));

        }
    }
}
