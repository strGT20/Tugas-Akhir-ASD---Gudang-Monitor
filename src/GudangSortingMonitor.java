import java.util.*;

public class GudangSortingMonitor {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        LinkedList<Monitor> listMonitor = new LinkedList<>();

        muatGudangAwal(listMonitor);

        boolean running = true;

        while (running) {
            System.out.println("========= GUDANG MONITOR =========");
            System.out.println("Menu : ");
            System.out.println("1. Tambah monitor ke gudang");
            System.out.println("2. Urutkan berdasarkan nama (Bubble Sort)");
            System.out.println("3. Urutkan berdasarkan harga (Insertion Sort)");
            System.out.println("4. Urutkan berdasarkan ukuran layar (Insertion Sort)");
            System.out.println("5. Tampilkan daftar monitor di gudang");
            System.out.println("0. Keluar\n");
            System.out.print("Pilih menu: ");
            
            int pilihanMenu = inp.nextInt();
            inp.nextLine();
            System.out.println();

            switch (pilihanMenu) {
                case 1:
                    System.out.print("Masukkan nama monitor: ");
                    String nama = inp.nextLine();
                    System.out.print("Masukkan harga monitor (USD): ");
                    double harga = inp.nextDouble();
                    System.out.print("Masukkan ukuran layar (inch): ");
                    int ukuran = inp.nextInt();

                    listMonitor.add(new Monitor(nama, harga, ukuran));
                    System.out.println("\nMonitor baru berhasil masuk gudang!");
                    break;

                case 2:
                    bubbleSortNama(listMonitor);
                    System.out.println("Monitor diurutkan berdasarkan nama:");
                    cetakDaftarMonitor(listMonitor);
                    break;

                case 3:
                    System.out.print("Urutkan berdasarkan harga (1: Ascending, 2: Descending): ");
                    int sortHarga = inp.nextInt();
                    insertionSortHarga(listMonitor, sortHarga == 2);
                    System.out.println("Monitor diurutkan berdasarkan harga:");
                    cetakDaftarMonitor(listMonitor);
                    break;

                case 4:
                    System.out.print("Urutkan berdasarkan ukuran layar (1: Ascending, 2: Descending): ");
                    int sortUkuran = inp.nextInt();
                    insertionSortUkuranLayar(listMonitor, sortUkuran == 2);
                    System.out.println("Monitor diurutkan berdasarkan ukuran layar:");
                    cetakDaftarMonitor(listMonitor);
                    break;

                case 5:
                    System.out.println("Daftar monitor di gudang:");
                    cetakDaftarMonitor(listMonitor);
                    break;

                case 0:
                    running = false;
                    System.out.println("Terima kasih udah pakai!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Coba menu lain.");
            }

            System.out.println();
        }

        inp.close();
    }

    // Bubble Sort untuk nama
    private static void bubbleSortNama(List<Monitor> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).nama.compareTo(list.get(j + 1).nama) > 0) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

    // Insertion Sort untuk harga
    private static void insertionSortHarga(List<Monitor> list, boolean descending) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Monitor key = list.get(i);
            int j = i - 1;

            while (j >= 0 && (descending ? list.get(j).harga < key.harga : list.get(j).harga > key.harga)) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    // Insertion Sort untuk ukuran layar
    private static void insertionSortUkuranLayar(List<Monitor> list, boolean descending) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Monitor key = list.get(i);
            int j = i - 1;

            while (j >= 0 && (descending ? list.get(j).ukuranLayar < key.ukuranLayar : list.get(j).ukuranLayar > key.ukuranLayar)) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    // Load barang di gudang
    public static void muatGudangAwal(LinkedList<Monitor> listMonitor) {
        if (listMonitor.isEmpty()) {
            listMonitor.add(new Monitor("Samsung Odyssey G9", 1200.0, 49));
            listMonitor.add(new Monitor("Xiaomi G24i", 100.0, 24));
            listMonitor.add(new Monitor("Skyworth H24G30F", 120.0, 24));
            listMonitor.add(new Monitor("Lenovo R25i-30", 150.0, 24));
        }
    }

    // Mencetak daftar monitor
    private static void cetakDaftarMonitor(List<Monitor> list) {
        if (list.isEmpty()) {
            System.out.println("Belum ada monitor di gudang.");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
