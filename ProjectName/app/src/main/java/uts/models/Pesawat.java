package uts.models;

public class Pesawat extends SkyVehicle implements Kargoable{
    private boolean isPesawatTempur;
    private int jumlahRoda;
    public Pesawat(int capacity, String nama, boolean isPesawatTempur, int jumlahRoda){
        super(capacity, nama, BahanBakar.AVTUR);
        this.isPesawatTempur = isPesawatTempur;
        this.jumlahRoda = jumlahRoda;
    }

    public boolean getBooleanPesawatTempur(){
        return this.isPesawatTempur;
    }

    @Override
    public String getDetails(){
        return "Pesawat " + super.getNama() + super.getDetails() + ", Jumlah Roda: " + this.jumlahRoda;
    }

    @Override
    public void loadKargo() {
        System.out.println("Telah melakukan load kargo di ...");
    }

    @Override
    public void unloadKargo() {
        System.out.println("Telah melakukan unload kargo di ...");
    }

    public int getJumlahRoda() {
        return jumlahRoda;
    }

    public void setJumlahRoda(int jumlahRoda) {
        this.jumlahRoda = jumlahRoda;
    }

    public boolean isIsPesawatTempur() {
        return isPesawatTempur;
    }

    public void setIsPesawatTempur(boolean isPesawatTempur) {
        this.isPesawatTempur = isPesawatTempur;
    }
}
