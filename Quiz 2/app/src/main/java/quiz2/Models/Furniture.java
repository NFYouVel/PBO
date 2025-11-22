package quiz2.Models;

public abstract class Furniture {
    private String berat;
    private Bahan bahanUtama;

    public Furniture(String berat, Bahan bahan){
        this.berat = berat;
        this.bahanUtama = bahan;
    }

    public abstract String getNamaProduk();

    @Override
    public String toString(){
        return "Berat: " + berat + "\n"
            +  "Bahan Utama:" + bahanUtama;
    }
}
