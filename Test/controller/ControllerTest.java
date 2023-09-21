package controller;


import ordination.DagligFast;
import ordination.Laegemiddel;
import ordination.PN;
import ordination.Patient;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;


class ControllerTest {

    @Test
    void TC1_opretPNOrdination() {

        //Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 2);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double antal = 2;

        //Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);
        });
        assertEquals(exception.getMessage(), "Ugyldige datoer");
    }

    @Test
    void TC2_opretPNOrdination() {

        //Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 2, 4);
        LocalDate slutDen = LocalDate.of(2021, 2, 7);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double antal = 2;

        //Act
        PN faktiskPN = controller.opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);

        //Assert
        assertEquals(startDen, faktiskPN.getStartDen());
        assertEquals(slutDen, faktiskPN.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(faktiskPN));
        assertEquals(laegemiddel, faktiskPN.getLaegemiddel());
        assertEquals(antal, faktiskPN.getAntalEnheder());
    }

    @Test
    void opret_daglig_fast_ordination_test1() {

        //Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 11, 10);
        LocalDate slutDen = LocalDate.of(2021, 11, 2);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double morgenAntal = 2.0;
        double middagAntal = 0.0;
        double aftenAntal = 1.0;
        double natAntal = 0.0;

        //Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.opretDagligFastOrdination(startDen, slutDen, patient, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        });
        assertEquals(exception.getMessage(), "Ugyldige datoer");
    }

    @Test
    void opret_daglig_fast_ordination_test2() {

        //Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 2, 4);
        LocalDate slutDen = LocalDate.of(2021, 2, 7);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double morgenAntal = 2.0;
        double middagAntal = 0.0;
        double aftenAntal = 1.0;
        double natAntal = 0.0;

        //Act
        DagligFast faktiskDagligFast = controller.opretDagligFastOrdination(startDen, slutDen, patient, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);

        //Assert
        assertEquals(startDen, faktiskDagligFast.getStartDen());
        assertEquals(slutDen, faktiskDagligFast.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(faktiskDagligFast));
        assertEquals(laegemiddel, faktiskDagligFast.getLaegemiddel());
    }

    @Test
    void opret_daglig_skaev_ordination_test1() {

    }

    @Test
    void opret_daglig_skaev_ordination_test2() {

    }
}
