public class Monitor {
    String nama;
    double harga;
    int ukuranLayar;

    public Monitor(String nama, double harga, int ukuranLayar){
        this.nama = nama;
        this.harga = harga;
        this.ukuranLayar = ukuranLayar;
    }

    // Method untuk cetak
    @Override
    public String toString() {
        return nama + ", Harga: USD" + harga + ", Ukuran Layar: " + ukuranLayar + " inch";
    }
}