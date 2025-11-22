package quiz2.Models;

public class Kursi extends Furniture{
    private boolean adaSandaran;

    public Kursi(String berat, Bahan bahan, boolean adaSandaran){
        super(berat, bahan);
        this.adaSandaran = adaSandaran;
    }

    public String getAdaSandaran(){
        if(adaSandaran){
            return "Yes";
        } else {
            return "No";
        }
    }

    @Override
    public String getNamaProduk(){
        return "Kursi";
    };

    @Override
    public String toString(){
        return "------------------------\n" + super.toString() 
        + "Ada Sandaran: " + adaSandaran;
    }
}
