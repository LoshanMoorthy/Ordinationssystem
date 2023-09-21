package ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkaevTest {

    @Test
    void DagligSkaev(){
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        Patient patient = new Patient("123457891", "Ole Hansen", 80);
        LocalDate startDen = LocalDate.of(2023,01,10);
        LocalDate slutDen = LocalDate.of(2023,01,12);
        //Act
        DagligSkaev skaev = new DagligSkaev(startDen,slutDen,laegemiddel);

        //Assert
        assertEquals(startDen,skaev.getStartDen());
        assertEquals(slutDen,skaev.getSlutDen());
        assertEquals(laegemiddel,skaev.getLaegemiddel());
    }
    @Test
    void opretDosis() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev skaev = new DagligSkaev(LocalDate.of(2023,9,21), LocalDate.of(2023,9,24), laegemiddel);
        LocalTime tid1 = LocalTime.of(12,30);
        LocalTime tid2 = LocalTime.of(15,0);
        LocalTime tid3 = LocalTime.of(18,0);
        Double antal1 = 3.0;
        Double antal2 = 5.0;
        Double antal3 = 8.0;
        LocalTime[] tid = {tid1,tid2,tid3 };
        double[] antal = {antal1,antal2,antal3};

        //Act
        skaev.opretDosis(tid,antal);

        //Assert
        assertEquals(tid1,skaev.getDoser().get(0).getTid());
        assertEquals(tid2,skaev.getDoser().get(1).getTid());
        assertEquals(tid3,skaev.getDoser().get(2).getTid());
        assertEquals(antal1,skaev.getDoser().get(0).getAntal());
        assertEquals(antal2,skaev.getDoser().get(1).getAntal());
        assertEquals(antal3,skaev.getDoser().get(2).getAntal());
        assertEquals(3,skaev.getDoser().size());
    }

    @Test
    void opretDosis_Exception() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev skaev = new DagligSkaev(LocalDate.of(2023,9,21), LocalDate.of(2023,9,24), laegemiddel);
        LocalTime tid1 = LocalTime.of(12,30);
        LocalTime tid2 = LocalTime.of(15,0);
        LocalTime tid3 = LocalTime.of(18,0);
        Double antal1 = 3.0;
        Double antal2 = 5.0;
        Double antal3 = 8.0;
        Double antal4 = 1.0;
        LocalTime[] tid = {tid1,tid2,tid3};
        double[] antal = {antal1,antal2,antal3,antal4};


        //Act and assert
        assertThrows(Exception.class, () -> skaev.opretDosis(tid,antal), "Forventet besked ift. mismatchende længder af arrays");
    }

    @Test
    void samletDosis_tc1() {
        //Arrange
        Patient patient = new Patient("121256-0512", "Jane Jensen", 82);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev skaev = new DagligSkaev(LocalDate.of(2023,9,19), LocalDate.of(2023,9,21), laegemiddel);
        LocalTime tid1 = LocalTime.of(12,30);
        LocalTime tid2 = LocalTime.of(15,0);
        LocalTime tid3 = LocalTime.of(18,0);
        Double antal1 = 2.0;
        Double antal2 = 3.0;
        Double antal3 = 1.0;
        LocalTime[] tid = {tid1,tid2,tid3 };
        double[] antal = {antal1,antal2,antal3};
        skaev.opretDosis(tid,antal);

        double forventetResultat = 6;
        //Act
        Double resultat = skaev.samletDosis();
        //Assert
        assertEquals(forventetResultat,resultat);
    }

    @Test
    void samletDosis_tc2() {

        Patient patient = new Patient("121256-0512", "Jane Jensen", 82);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev skaev = new DagligSkaev(LocalDate.of(2023,9,19), LocalDate.of(2023,9,21), laegemiddel);
        LocalTime tid1 = LocalTime.of(12,30);
        LocalTime tid2 = LocalTime.of(15,0);
        LocalTime tid3 = LocalTime.of(18,0);
        Double antal1 = 8.0;
        Double antal2 = 5.0;
        Double antal3 = 4.0;
        LocalTime[] tid = {tid1,tid2,tid3 };
        double[] antal = {antal1,antal2,antal3};
        double forventetResultat = 17;
        skaev.opretDosis(tid,antal);
        //Act
        Double resultat = skaev.samletDosis();
        //Assert
        assertEquals(forventetResultat,resultat);
    }

    @Test
    void doegnDosis() {
        //Arrange
        Patient patient = new Patient("121256-0512", "Jane Jensen", 82);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        DagligSkaev skaev = new DagligSkaev(LocalDate.of(2023,9,19), LocalDate.of(2023,9,21), laegemiddel);
        LocalTime tid1 = LocalTime.of(12,30);
        LocalTime tid2 = LocalTime.of(15,0);
        LocalTime tid3 = LocalTime.of(18,0);
        Double antal1 = 10.0;
        Double antal2 = 5.0;
        Double antal3 = 3.0;
        LocalTime[] tid = {tid1,tid2,tid3 };
        double[] antal = {antal1,antal2,antal3};
        double forventetResultat = 6.0;
        skaev.opretDosis(tid,antal);

        //Act
        double resultat = skaev.doegnDosis();
        //Assert
        assertEquals(forventetResultat,resultat);

    }
}