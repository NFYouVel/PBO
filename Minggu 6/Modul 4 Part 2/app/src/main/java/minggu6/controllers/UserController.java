package minggu6.controllers;

import java.util.ArrayList;

import minggu6.models.Mahasiswa;
import minggu6.models.User;
import minggu6.models.repo.UserRepository;

public class UserController {

    private UserRepository userRepository;

    public UserController(){
        this.userRepository = new UserRepository();
    }

    public ArrayList<User> printMenuByUserData(String nama) {
        return userRepository.printMahasiswaByName(nama);
    }


    // public Mahasiswa get(String nim){
    //     return null;
    // }

    // public void add(String nim, String kodeJurusan, String nama, String tempatLahir, String tanggalLahir, String alamat, String noTelepon){
        
    // }

    // public void update(){
        
    // }

    // public void delete(){
        
    // }
    // public Mahasiswa[] findAll(){
    //     return new Mahasiswa[0];
    // }
}
