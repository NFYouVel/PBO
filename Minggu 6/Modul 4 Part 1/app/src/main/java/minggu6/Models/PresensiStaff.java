package minggu6.Models;

public class PresensiStaff extends Presensi {
    private int jam;

    public PresensiStaff(String tanggal, int status, int jam){
        super(tanggal, status);
        this.jam = jam;
    }
    
    public int getJam(){
        return jam;
    }
    public void setJam(int jam){
        this.jam = jam;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" +
               "Jam: " + jam + " Jam";
    }   
    
}
