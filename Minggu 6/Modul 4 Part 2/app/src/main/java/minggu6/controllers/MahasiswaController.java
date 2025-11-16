package minggu6.controllers;

import minggu6.models.repo.MahasiswaRepository;

public class MahasiswaController {
    private MahasiswaRepository mahasiswaRepository;

    public MahasiswaController(){
        this.mahasiswaRepository = new MahasiswaRepository();
    }

    public void printNAMahasiswa(String nim, String kode_mk){
        mahasiswaRepository.printNAFromOneMahasiswa(nim, kode_mk);
    }
    public void printNAMahasiswa(String nim){
        mahasiswaRepository.printNAFromOneMahasiswa(nim);
    }
    public void printNAAllMahasiswa(String kode_mk){
        mahasiswaRepository.printNAFromAllMahasiswa(kode_mk);
    }

    public void checkBelowMinimumCriteria(String kode_mk){
        mahasiswaRepository.checkBelowMinimumCriteria(kode_mk);
    }

    public void printTotalPresensiByNIM(String nim){
        mahasiswaRepository.printTotalPresensiByNIM(nim);
    }
}
