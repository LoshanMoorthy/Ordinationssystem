package controller;


import ordination.DagligSkaev;
import ordination.Laegemiddel;
import ordination.PN;
import ordination.Patient;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;


class ControllerTest {


    @Test
    void TC1_opretPNOrdination() {
        //Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021,1, 10);
        LocalDate slutDen = LocalDate.of(2021,1, 2);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double antal = 2;


        //Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {controller.opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);
        });
        assertEquals(exception.getMessage(), "Ugyldige datoer");
    }
    @Test
    void TC2_opretPNOrdination() {
        //Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021,2, 4);
        LocalDate slutDen = LocalDate.of(2021,2, 7);
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
    void opret_daeglig_skaev_ordination_test1() {
        // Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021,2, 4);
        LocalDate slutDen = LocalDate.of(2021,2, 7);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");

        LocalTime[] tid = { LocalTime.of(12, 0), LocalTime.of(12, 40),
                LocalTime.of(16, 0), LocalTime.of(18, 45) };
        double[] antal = { 0.5, 1, 2.5, 3 };

        // Act
        DagligSkaev dagligSkaev = controller.opretDagligSkaevOrdination(startDen, slutDen, patient, laegemiddel, tid, antal);


        // Assert
        assertNotNull(dagligSkaev);

    }

    @Test
    void opret_daeglig_skaev_ordination_test2() {
        //Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021,1, 10);
        LocalDate slutDen = LocalDate.of(2021,1, 2);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");

        LocalTime[] tid = { LocalTime.of(12, 0), LocalTime.of(12, 40),
                LocalTime.of(16, 0), LocalTime.of(18, 45) };
        double[] antal = { 0.5, 1, 2.5, 3 };


        //Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {controller.opretDagligSkaevOrdination(startDen, slutDen, patient, laegemiddel, tid, antal);
        });
        assertEquals(exception.getMessage(), "Ugyldige datoer");
    }
}
