package minggu6.Models;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaMagister extends Mahasiswa {
    private List<MatKulAmbil> matakuliahDiambil;

    public MahasiswaMagister(String nim, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon, String kodeJurusan) {
        super(nim, nama, tempatLahir, tanggalLahir, alamat, telepon, kodeJurusan);
        this.matakuliahDiambil = new ArrayList<>();
    }

    public List<MatKulAmbil> getMatakuliahDiambil(){
        return matakuliahDiambil;
    }
    
    public void addMatakuliahDiambil(MatKulAmbil inputMatakuliahDiambil){
        this.matakuliahDiambil.add(inputMatakuliahDiambil);
    }

    @Override
    public String toString(){
        return super.toString() + "\n" +
               "Matakuliah Diambil: " + matakuliahDiambil;
    }
}
