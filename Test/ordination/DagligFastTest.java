package ordination;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;


class DagligFastTest {


    @Test
    void TC1_DagligFast_Constructor() {


        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        double morgenAntal = 2.0;
        double middagAntal = 0.0;
        double aftenAntal = 1.0;
        double natAntal = 0.0;


        DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);


        //Assert
        assertNotNull(dagligFast);
        assertEquals(startDen, dagligFast.getStartDen());
        assertEquals(slutDen, dagligFast.getSlutDen());
        assertEquals(laegemiddel, dagligFast.getLaegemiddel());
    }


    @Test
    void TC2_DagligFast_Constructor() {


        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        double morgenAntal = 4.0;
        double middagAntal = 3.0;
        double aftenAntal = 2.0;
        double natAntal = 1.0;


        DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);


        //Assert
        assertNotNull(dagligFast);
        assertEquals(startDen, dagligFast.getStartDen());
        assertEquals(slutDen, dagligFast.getSlutDen());
        assertEquals(laegemiddel, dagligFast.getLaegemiddel());
    }


    @Test
    void TC3_DagligFast_Constructor() {


        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        double morgenAntal = 1.0;
        double middagAntal = 2.0;
        double aftenAntal = 3.0;
        double natAntal = 4.0;


        DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);


        //Assert
        assertNotNull(dagligFast);
        assertEquals(startDen, dagligFast.getStartDen());
        assertEquals(slutDen, dagligFast.getSlutDen());
        assertEquals(laegemiddel, dagligFast.getLaegemiddel());


    }


   @Test
   void TC1_getDoser_Dosis1(){

       //Arrange
       Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
       Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
       LocalDate startDen = LocalDate.of(2021, 1, 10);
       LocalDate slutDen = LocalDate.of(2021, 1, 12);
       double morgenAntal = 2.0;
       double middagAntal = 0.0;
       double aftenAntal = 1.0;
       double natAntal = 0.0;

       Dosis morgenDosis;
       Dosis middagDosis;
       Dosis aftenDosis;
       Dosis natDosis;
       Dosis[] doser = new Dosis[] {
               morgenDosis = new Dosis(LocalTime.of(8, 0), morgenAntal),
               middagDosis = new Dosis(LocalTime.of(12, 0), middagAntal),
               aftenDosis = new Dosis(LocalTime.of(18, 0), aftenAntal),
               natDosis = new Dosis(LocalTime.of(22, 0), natAntal)
       };


       DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);


       //Assert
       assertTrue(Arrays.asList(doser).contains(morgenDosis));
       assertTrue(Arrays.asList(doser).contains(middagDosis));
       assertTrue(Arrays.asList(doser).contains(aftenDosis));
       assertTrue(Arrays.asList(doser).contains(natDosis));
   }


    @Test
    void TC1_SamletDosis1() {


        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        double morgenAntal = 2.0;
        double middagAntal = 0.0;
        double aftenAntal = 1.0;
        double natAntal = 0.0;


        DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        double expectedOutput = 9;


        //Act
        double actualOutput = dagligFast.samletDosis();


        //Assert
        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    void TC2_SamletDosis2() {


        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        double morgenAntal = 1.0;
        double middagAntal = 2.0;
        double aftenAntal = 0.0;
        double natAntal = 1.0;


        DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        double expectedOutput = 12;


        //Act
        double actualOutput = dagligFast.samletDosis();


        //Assert
        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    void TC3_SamletDosis3() {


        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        double morgenAntal = 1.0;
        double middagAntal = 2.0;
        double aftenAntal = 3.0;
        double natAntal = 4.0;


        DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        double expectedOutput = 30;


        //Act
        double actualOutput = dagligFast.samletDosis();


        //Assert
        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    void TC4_SamletDosis4() {


        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        double morgenAntal = 2.0;
        double middagAntal = 2.0;
        double aftenAntal = 2.0;
        double natAntal = 2.0;


        DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        double expectedOutput = 24;


        //Act
        double actualOutput = dagligFast.samletDosis();


        //Assert
        assertEquals(expectedOutput, actualOutput);
    }




    @Test
    void TC1_DoegnDosis1(){


        //Arrange
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        double morgenAntal = 2.0;
        double middagAntal = 0.0;
        double aftenAntal = 1.0;
        double natAntal = 0.0;


        DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        double expectedOutput = 3;


        //Act
        double actualOutput = dagligFast.doegnDosis();


        //Assert
        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    void TC2_DoegnDosis2(){


        //Arrange
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        double morgenAntal = 1.0;
        double middagAntal = 2.0;
        double aftenAntal = 0.0;
        double natAntal = 1.0;


        DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        double expectedOutput = 4;


        //Act
        double actualOutput = dagligFast.doegnDosis();


        //Assert
        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    void TC3_DoegnDosis3(){


        //Arrange
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        double morgenAntal = 1.0;
        double middagAntal = 2.0;
        double aftenAntal = 3.0;
        double natAntal = 4.0;


        DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        double expectedOutput = 10;


        //Act
        double actualOutput = dagligFast.doegnDosis();


        //Assert
        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    void TC4_DoegnDosis4(){


        //Arrange
        Patient patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2021, 1, 12);
        double morgenAntal = 2.0;
        double middagAntal = 2.0;
        double aftenAntal = 2.0;
        double natAntal = 2.0;


        DagligFast dagligFast = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        double expectedOutput = 8;


        //Act
        double actualOutput = dagligFast.doegnDosis();


        //Assert
        assertEquals(expectedOutput, actualOutput);
    }




}
