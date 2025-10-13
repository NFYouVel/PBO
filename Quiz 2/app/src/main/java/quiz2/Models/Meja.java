package quiz2.Models;

public class Meja extends Furniture{
    private int jumlahLaci;

    public Meja(String berat, Bahan bahanUtama, int jumlahLaci){
        super(berat, bahanUtama);
        this.jumlahLaci = jumlahLaci;
    }

    public int getJumlahLaci(){
        return jumlahLaci;
    }

    @Override
    public String getNamaProduk(){
        return "Meja";
    };
}
