package controller;


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
}
