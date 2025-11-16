package minggu6.models;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaMagister extends Mahasiswa {
    private List<MatKulAmbil> matakuliahDiambil;
    private String judulPenelitian;

    public MahasiswaMagister(String nim, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon, String kodeJurusan, String judulPenelitian){ 
        super(nim, nama, tempatLahir, tanggalLahir, alamat, telepon, kodeJurusan);
        this.judulPenelitian = judulPenelitian;
        this.matakuliahDiambil = new ArrayList<>();
    }

    public List<MatKulAmbil> getMatakuliahDiambil(){
        return matakuliahDiambil;
    }
    
    public void addMatakuliahDiambil(MatKulAmbil inputMatakuliahDiambil){
        this.matakuliahDiambil.add(inputMatakuliahDiambil);
    }

    public String getJudulPenelitian(){
        return judulPenelitian;
    }   
    public void setJudulPenelitian(String judulPenelitian){
        this.judulPenelitian = judulPenelitian;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" +
               "Matakuliah Diambil: " + matakuliahDiambil;
    }
}
