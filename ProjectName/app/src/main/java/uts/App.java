
package uts;

import uts.controllers.VehicleController;
import uts.models.repo.VehicleRepository;
import uts.views.VehicleView;

public class App {
    public static void main(String[] args) {
        VehicleRepository VehicleRepository = new VehicleRepository();
        VehicleView VehicleView = new VehicleView();
        VehicleController VehicleController = new VehicleController(VehicleRepository, VehicleView);
        VehicleView.setVehicleController(VehicleController);

        VehicleController.StartMenu();
    }
}
