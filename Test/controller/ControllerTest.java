package controller;

import ordination.*;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void TC1_opretPNOrdination() {
        // Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 2);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double antal = 2;

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);
        });
        assertEquals(exception.getMessage(), "Ugyldige datoer");
    }

    @Test
    void TC2_opretPNOrdination() {
        // Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 2, 4);
        LocalDate slutDen = LocalDate.of(2021, 2, 7);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double antal = 2;

        // Act
        PN faktiskPN = controller.opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);

        // Assert
        assertEquals(startDen, faktiskPN.getStartDen());
        assertEquals(slutDen, faktiskPN.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(faktiskPN));
        assertEquals(laegemiddel, faktiskPN.getLaegemiddel());
        assertEquals(antal, faktiskPN.getAntalEnheder());
    }

    @Test
    void opret_daglig_fast_ordination_test1() {
        // Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 11, 10);
        LocalDate slutDen = LocalDate.of(2021, 11, 2);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double morgenAntal = 2.0;
        double middagAntal = 0.0;
        double aftenAntal = 1.0;
        double natAntal = 0.0;

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.opretDagligFastOrdination(startDen, slutDen, patient, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        });
        assertEquals(exception.getMessage(), "Ugyldige datoer");
    }

    @Test
    void opret_daglig_fast_ordination_test2() {
        // Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 2, 4);
        LocalDate slutDen = LocalDate.of(2021, 2, 7);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double morgenAntal = 2.0;
        double middagAntal = 0.0;
        double aftenAntal = 1.0;
        double natAntal = 0.0;

        // Act
        DagligFast faktiskDagligFast = controller.opretDagligFastOrdination(startDen, slutDen, patient, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);

        // Assert
        assertEquals(startDen, faktiskDagligFast.getStartDen());
        assertEquals(slutDen, faktiskDagligFast.getSlutDen());
        assertTrue(patient.getOrdinationer().contains(faktiskDagligFast));
        assertEquals(laegemiddel, faktiskDagligFast.getLaegemiddel());
    }

    @Test
    void opret_daglig_skaev_ordination_test1() {
        // Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 2, 4);
        LocalDate slutDen = LocalDate.of(2021, 2, 7);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");

        LocalTime[] tid = {LocalTime.of(12, 0), LocalTime.of(12, 40),
                LocalTime.of(16, 0), LocalTime.of(18, 45)};
        double[] antal = {0.5, 1, 2.5, 3};

        // Act
        DagligSkaev dagligSkaev = controller.opretDagligSkaevOrdination(startDen, slutDen, patient, laegemiddel, tid, antal);

        // Assert
        assertNotNull(dagligSkaev);
    }

    @Test
    void opret_daglig_skaev_ordination_test2() {
        // Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 2);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");

        LocalTime[] tid = {LocalTime.of(12, 0), LocalTime.of(12, 40),
                LocalTime.of(16, 0), LocalTime.of(18, 45)};
        double[] antal = {0.5, 1, 2.5, 3};

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.opretDagligSkaevOrdination(startDen, slutDen, patient, laegemiddel, tid, antal);
        });
        assertEquals(exception.getMessage(), "Ugyldige datoer");
    }

    @Test
    void ordinationPNAnvendt_test1() {
        // Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 15);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate dato = LocalDate.of(2021, 1, 9);

        PN ordination = new PN(startDen, slutDen, laegemiddel, 2);

        // Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.ordinationPNAnvendt(ordination, dato);
        });
        assertEquals(exception.getMessage(), "Ugyldige datoer");
    }

    @Test
    void ordinationPNAnvendt_test2() {
        // Arrange
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 15);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate dato = LocalDate.of(2021, 1, 9);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 55);

        PN ordination = new PN(startDen, slutDen, laegemiddel, 2);
        patient.addOrdination(ordination);

        boolean expectedOutput = true;

        // Act
        boolean actualOutput = ordination.givDosis(LocalDate.of(2021, 1, 13));

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void anbefaletDosisPrDoegn_let() {
        // Arrange
        Controller controller = Controller.getController();
        Patient patient = new Patient("121256-0512", "Jane Jensen", 10);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double forventetResultat = laegemiddel.getEnhedPrKgPrDoegnLet();

        // Act
        double resultat = controller.anbefaletDosisPrDoegn(patient, laegemiddel);

        // Assert
        assertEquals(forventetResultat, resultat);
    }

    @Test
    public void anbefaletDosisPrDoegn_normal() {
        // Arrange
        Controller controller = Controller.getController();
        Patient patient = new Patient("121256-0512", "Jane Jensen", 65);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double forventetResultat = laegemiddel.getEnhedPrKgPrDoegnNormal();

        // Act
        double resultat = controller.anbefaletDosisPrDoegn(patient, laegemiddel);

        // Assert
        assertEquals(forventetResultat, resultat);
    }

    @Test
    public void anbefaletDosisPrDoegn_tung() {
        // Arrange
        Controller controller = Controller.getController();
        Patient patient = new Patient("121256-0512", "Jane Jensen", 130);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        double forventetResultat = laegemiddel.getEnhedPrKgPrDoegnTung();

        // Act
        double resultat = controller.anbefaletDosisPrDoegn(patient, laegemiddel);

        // Assert
        assertEquals(forventetResultat, resultat);
    }


    /*
    Vi har desværre haft udfordringer med at få denne test til at fungere korrekt.
    Det er værd at bemærke, at den fungerer som forventet i brugergrænsefladen (GUI),
    men vi har endnu ikke kunnet identificere årsagen til,
    at den ikke fungerer som ønsket her
    */
    @Test
    void antalOrdinationerPrVægtPrLægemiddel() {
        // Arrange
        Controller controller = Controller.getController();
        Storage storage = new Storage();

        LocalDate startDen1 = LocalDate.of(2021, 1, 2);
        LocalDate slutDen1 = LocalDate.of(2021, 1, 10);
        Patient patient1 = new Patient("121256-0512", "Jane Jensen", 63.4);
        Patient patient2 = new Patient("121256-0513", "Ole Hanse", 60);  // Unique CPR
        Patient patient3 = new Patient("121256-0514", "Hans Hansen", 55); // Unique CPR

        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");

        LocalTime[] tid = { LocalTime.of(12, 0), LocalTime.of(12, 40),
                LocalTime.of(16, 0), LocalTime.of(18, 45) };
        double[] antal = { 0.5, 1, 2.5, 3 };

        storage.addLaegemiddel(laegemiddel);
        storage.addPatient(patient1);
        storage.addPatient(patient2);
        storage.addPatient(patient3);

        DagligSkaev dagligSkaev = controller.opretDagligSkaevOrdination(startDen1, slutDen1, patient1, laegemiddel, tid, antal);
        DagligFast dagligFast1 = controller.opretDagligFastOrdination(startDen1, slutDen1, patient2, laegemiddel, 2.0, 1.0, 5.0, 2.0);
        DagligFast dagligFast2 = controller.opretDagligFastOrdination(startDen1, slutDen1, patient3, laegemiddel, 2.0, 1.0, 5.0, 2.0);

        int expectedOutput = 3;

        // Act
        int actualOutput = controller.antalOrdinationerPrVægtPrLægemiddel(40, 70, laegemiddel);

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }
}