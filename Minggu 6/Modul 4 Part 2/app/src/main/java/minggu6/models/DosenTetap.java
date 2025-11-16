package minggu6.models;

import java.util.List;

public class DosenTetap extends Dosen {

    private double salary;

    public DosenTetap(String nik, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon, String departemen, double salary) {
        super(nik, nama, tempatLahir, tanggalLahir, alamat, telepon, departemen, UserType.DOSEN_TETAP);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDosen Tetap\n" +
               "Departemen: " + getDepartemen() + "\n" 
              + "Salary: " + salary + "\n";
    }
}
