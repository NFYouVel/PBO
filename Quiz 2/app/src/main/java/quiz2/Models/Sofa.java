package quiz2.Models;

public class Sofa extends Furniture {
    private int jumlahDudukan;

    public Sofa(String berat, Bahan bahanUtama, int jumlahDudukan) {
        super(berat, bahanUtama);
        this.jumlahDudukan = jumlahDudukan;
    }

    @Override
    public String getNamaProduk() {
        return "Sofa";
    }
    
}
