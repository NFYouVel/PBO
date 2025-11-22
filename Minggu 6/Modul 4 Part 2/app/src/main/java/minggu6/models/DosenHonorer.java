package minggu6.models;

public class DosenHonorer extends Dosen {

    private double honorsks;
    
    public DosenHonorer(String nik, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon, String departemen, double salary) {
        super(nik, nama, tempatLahir, tanggalLahir, alamat, telepon, departemen, UserType.DOSEN_HONORER);
        this.honorsks = salary;
    }

    public double getHonorSKS() {
        return honorsks;
    }

    public void setHonorSKS(double salary) {
        this.honorsks = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDosen Honorer\n" +
               "Departemen: " + getDepartemen() + "\n" 
              + "Honor SKS: " + honorsks + "\n"
               + "Mata Kuliah Ajar: " + getMatkulAjar().toString();
    }
}
