//L0325004_IqbalRifa'i
package responsi1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LogistikManager manager = new LogistikManager();
        boolean running = true;

        while (running) {
            System.out.println("\n=== SISTEM LOGISTIK BANTUAN 3T ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Selesai dan Cetak Manifes");
            System.out.print("Pilih menu: ");
            String pilihan = input.nextLine();

            if (pilihan.equals("1")) {

                try {
                    System.out.print("Kode Barang (diawali EDX-): ");
                    String kode = input.nextLine();

                    // Validasi kode harus diawali EDX-
                    if (!kode.startsWith("EDX-")) {
                        throw new IllegalArgumentException("Kode barang harus diawali EDX-");
                    }

                    System.out.print("Nama Barang: ");
                    String nama = input.nextLine();

                    System.out.print("Kategori (contoh: Elektronik, Buku): ");
                    String kategori = input.nextLine();

                    System.out.print("Berat (kg): ");
                    double berat = Double.parseDouble(input.nextLine());
    
                    if (berat <= 0) {
                        throw new BeratInvalidException("Berat barang harus lebih dari 0 kg");
                    }

                    manager.tambahBarang(new BarangBantuan(kode, nama, kategori, berat));
                    System.out.println("Barang berhasil ditambahkan!");

                } catch (IllegalArgumentException e) {
                    System.out.println("Galat: " + e.getMessage() + ". Silakan ulangi input.");
                } catch (BeratInvalidException e) {
                    System.out.println("Galat: " + e.getMessage() + ". Silakan ulangi input.");
                } catch (Exception e) {
                    System.out.println("Galat: Berat harus berupa angka desimal. Silakan ulangi input.");
                } finally {
                    System.out.println("Pemeriksaan input selesai.");
                }

            } else if (pilihan.equals("2")) {
                manager.cetakManifes();
                running = false;
            } else {
                System.out.println("Pilihan tidak valid, silakan pilih 1 atau 2.");
            }
        }

        input.close();
    }
}
