    package minggu6.models;

public abstract class Staff extends User{
    private String nik;

    public Staff(String nik, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon, UserType userType){ // UserType userType ini cuman buat nurunin dari abstract class User
        super(nama, tempatLahir, tanggalLahir, alamat, telepon, userType); // Karena disini manggil constructor dari class User, jadi harus diisi semua parameternya, walaupun null
        this.nik = nik;
    }

    public String getNik(){
        return nik;
    }
    public void setNik(String nik){
        this.nik = nik;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" +
               "NIK: " + nik;
    }
}
