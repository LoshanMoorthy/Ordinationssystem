package ordination;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

class DagligFastTest {


    @Test
    void test_samlet_dosis1() {

        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        double morgenAntal = 2.0;
        double middagAntal = 0.0;
        double aftenAntal = 1.0;
        double natAntal = 0.0;

        DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        double expectedOutput = (morgenAntal + middagAntal + aftenAntal + natAntal) * dagligFast.antalDage();

        //Act
        double actualOutput = dagligFast.samletDosis();

        //Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test_samlet_dosis2() {

        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        double morgenAntal = 1.0;
        double middagAntal = 2.0;
        double aftenAntal = 0.0;
        double natAntal = 1.0;

        DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        double expectedOutput = (morgenAntal + middagAntal + aftenAntal + natAntal) * dagligFast.antalDage();

        //Act
        double actualOutput = dagligFast.samletDosis();

        //Assert
        assertEquals(expectedOutput, actualOutput);
    }
}