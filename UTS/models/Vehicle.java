public abstract class Vehicle {
    private Kargoable bahanBakar;
    private int capacityOrang;
    private String nama;
    private int jumlahRoda;

    public Vehicle (int bahanBakar, int capacity, String nama, int jumlahRoda) {
        this.bahanBakar = bahanBakar;
        this.capacityOrang = capacity;
        this.nama = nama;
        this.jumlahRoda = jumlahRoda;
    }
    
    public abstract String getDetails();

}
