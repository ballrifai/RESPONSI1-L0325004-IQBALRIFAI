//L0325004_IqbalRifa'i
package responsi1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LogistikManager {
    ArrayList<BarangBantuan> daftarBarang = new ArrayList<>();

    public void tambahBarang(BarangBantuan barang) {
        daftarBarang.add(barang);
    }

    public void cetakManifes() {
        int totalBarang = daftarBarang.size();
        double totalBerat = 0;

        for (BarangBantuan b : daftarBarang) {
            totalBerat += b.beratKg;
        }

        String armada;
        if (totalBerat < 50) {
            armada = "Mobil Pickup";
        } else {
            armada = "Truk Ekspedisi";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("manifest_pengiriman.txt"))) {
            writer.write("=== MANIFES PENGIRIMAN LOGISTIK 3T ===");
            writer.newLine();
            writer.write("Total Barang : " + totalBarang);
            writer.newLine();
            writer.write("Total Berat  : " + totalBerat + " kg");
            writer.newLine();
            writer.write("Armada       : " + armada);
            writer.newLine();
            writer.write("--------------------------------------");
            writer.newLine();
            writer.write("Daftar Barang:");
            writer.newLine();

            for (BarangBantuan b : daftarBarang) {
                writer.write(b.kodeBarang + " | " + b.namaBarang + " | " + b.kategori + " | " + b.beratKg + " kg");
                writer.newLine();
            }

            System.out.println("Data manifes berhasil diekspor ke manifest_pengiriman.txt");
        } catch (IOException e) {
            System.out.println("Gagal menulis file: " + e.getMessage());
        }
    }
}
