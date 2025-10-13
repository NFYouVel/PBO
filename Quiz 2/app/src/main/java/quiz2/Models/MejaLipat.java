package quiz2.Models;

public class MejaLipat extends Meja implements Lipatable{
    
    public MejaLipat( String berat, Bahan bahanUtama, int jumlahLaci) {
        super(berat, bahanUtama, jumlahLaci);
    }
    
    @Override
    public String getNamaProduk(){
        return "Meja Lipat";
    };

    @Override
    public String Lipat(){
        return "Bisa Dilipat";
    }
    
}
