package minggu6.controllers;

import minggu6.models.repo.DosenRepository;

public class DosenController {
    private DosenRepository dosenRepository;

    public DosenController() {
        this.dosenRepository = new DosenRepository();
    }

    public void printTotalJamMengajarDosen(String nik) {
        dosenRepository.getPrintTotalJamMengajarDosen(nik);
    }
}
