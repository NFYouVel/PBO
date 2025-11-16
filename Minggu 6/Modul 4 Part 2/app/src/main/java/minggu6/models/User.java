package minggu6.models;

public abstract class User {
    private String nama;
    private String tempatLahir;
    private String tanggalLahir;
    private String alamat;
    private String telepon;
    private UserType userType;

    public User(String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon, UserType userType){
        this.nama = nama;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
        this.telepon = telepon;
        this.userType = userType;
    }

    public void setNama(String nama){
        this.nama = nama;
    }
    public void setTempatLahir(String tempatLahir){
        this.tempatLahir = tempatLahir;
    }
    public void setTanggalLahir(String tanggalLahir){
        this.tanggalLahir = tanggalLahir;
    }
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    public void setTelepon(String telepon){
        this.telepon = telepon;
    }


    public String getTempatTanggalLahir(){
        return tempatLahir + ", " + tanggalLahir;
    }
    public String getNama(){
        return nama;
    }
    public String getTempatLahir(){
        return tempatLahir;
    }
    public String getTanggalLahir(){
        return tanggalLahir;
    }
    public String getAlamat(){
        return alamat;
    }
    public String getTelepon(){
        return telepon;
    }

    @Override
    public String toString(){
        return "Nama: " + nama + "\n" +
               "Tempat, Tanggal Lahir: " + getTempatTanggalLahir() + "\n" +
               "Alamat: " + alamat + "\n" +
               "Telepon: " + telepon + "\n" +
               "Tipe User: " + userType;
    }
}


