package ordination;

import controller.Controller;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PNTest {

    @Test
    void test_giv_dosis1() {
        // Act
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 2, 4);
        LocalDate slutDen = LocalDate.of(2021, 2, 7);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 55);
        PN pN = new PN(startDen, slutDen, laegemiddel, 10);
        patient.addOrdination(pN);

        boolean expectedOutput = true;

        //Arrange
        boolean actualOutput = pN.givDosis(LocalDate.of(2021, 2, 4));

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test_giv_dosis2() {
        // Act
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 2, 4);
        LocalDate slutDen = LocalDate.of(2021, 2, 7);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 55);
        PN pN = new PN(startDen, slutDen, laegemiddel, 10);
        patient.addOrdination(pN);

        boolean expectedOutput = true;

        //Arrange
        boolean actualOutput = pN.givDosis(LocalDate.of(2021, 2, 7));

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test_giv_dosis3() {
        // Act
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 2, 4);
        LocalDate slutDen = LocalDate.of(2021, 2, 7);
        Patient patient = new Patient("121256-0512", "Jane Jensen", 55);
        PN pN = new PN(startDen, slutDen, laegemiddel, 10);
        patient.addOrdination(pN);

        boolean expectedOutput = false;

        //Arrange
        boolean actualOutput = pN.givDosis(LocalDate.of(2021, 2, 8));

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test_case_1_pn_constructor() {
        // Act
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 20);
        PN pN = new PN(startDen, slutDen, laegemiddel, 10);

        LocalDate expectedStartDen = LocalDate.of(2021, 1, 10);
        LocalDate expectedSlutDen = LocalDate.of(2021, 1, 20);
        double expectedAntalEnheder = 10;

        // Arrange
        LocalDate actualStartDen = pN.getStartDen();
        LocalDate actualSlutDen = pN.getSlutDen();
        double actualEnheder = pN.getAntalEnheder();
        var actualOutput = pN;


        // Assert
        assertNotNull(actualOutput);
        assertEquals(expectedStartDen, actualStartDen);
        assertEquals(expectedSlutDen, actualSlutDen);
        assertEquals(expectedAntalEnheder, actualEnheder);

    }

    @Test
    void test_case_2_pn_constructor() {
        // Act
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 2, 10);
        LocalDate slutDen = LocalDate.of(2021, 2, 20);
        PN pN = new PN(startDen, slutDen, laegemiddel, 5);

        LocalDate expectedStartDen = LocalDate.of(2021, 2, 10);
        LocalDate expectedSlutDen = LocalDate.of(2021, 2, 20);
        double expectedAntalEnheder = 5;

        // Arrange
        LocalDate actualStartDen = pN.getStartDen();
        LocalDate actualSlutDen = pN.getSlutDen();
        double actualEnheder = pN.getAntalEnheder();
        var actualOutput = pN;


        // Assert
        assertNotNull(actualOutput);
        assertEquals(expectedStartDen, actualStartDen);
        assertEquals(expectedSlutDen, actualSlutDen);
        assertEquals(expectedAntalEnheder, actualEnheder);

    }

    @Test
    void test1_samlet_dosis() {
        // Act
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 2, 10);
        LocalDate slutDen = LocalDate.of(2021, 2, 20);
        double antalEnheder = 5;
        PN pN = new PN(startDen, slutDen, laegemiddel, antalEnheder);

        double expectedOutput = antalEnheder;

        // Arrange
        double actualOutput = pN.samletDosis();

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test2_samlet_dosis() {
        // Act
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 2, 10);
        LocalDate slutDen = LocalDate.of(2021, 2, 27);
        double antalEnheder = 20;
        PN pN = new PN(startDen, slutDen, laegemiddel, antalEnheder);

        double expectedOutput = antalEnheder;

        // Arrange
        double actualOutput = pN.samletDosis();

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test1_doegn_dosis() {
        // Act
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 2, 10);
        LocalDate slutDen = LocalDate.of(2021, 2, 27);
        double antalEnheder = 5;
        PN pN = new PN(startDen, slutDen, laegemiddel, antalEnheder);

        pN.givDosis(LocalDate.of(2021, 2, 11));
        pN.givDosis(LocalDate.of(2021, 2, 15));
        pN.givDosis(LocalDate.of(2021, 2,20));
        pN.givDosis(LocalDate.of(2021, 2, 27));

        double expectedOutput = 1.1111111111111112;

        // Arrange
        double actualOutput = pN.doegnDosis();

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test2_doegn_dosis() {
        // Act
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 2, 10);
        LocalDate slutDen = LocalDate.of(2021, 2, 20);
        double antalEnheder = 5;
        PN pN = new PN(startDen, slutDen, laegemiddel, antalEnheder);

        pN.givDosis(LocalDate.of(2021, 2, 11));
        pN.givDosis(LocalDate.of(2021, 2, 13));
        pN.givDosis(LocalDate.of(2021, 2,15));

        double expectedOutput = 1.36363636363;

        // Arrange
        double actualOutput = pN.doegnDosis();

        // Assert
        assertEquals(expectedOutput, expectedOutput);
    }



}