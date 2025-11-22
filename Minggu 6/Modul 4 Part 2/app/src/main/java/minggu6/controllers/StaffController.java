package minggu6.controllers;

import minggu6.models.repo.StaffRepository;

public class StaffController {
    private StaffRepository staffRepository;

    public StaffController() {
        this.staffRepository = new StaffRepository();
    }

    public void printGajiStaff(String nik) {
        staffRepository.printGajiStaff(nik);
    }
}
