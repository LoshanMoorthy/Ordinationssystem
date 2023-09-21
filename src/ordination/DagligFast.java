package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination{
    private Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
        super(startDen, slutDen, laegemiddel);
        this.doser = new Dosis[] {
                new Dosis(LocalTime.of(8, 0), morgenAntal),
                new Dosis(LocalTime.of(12, 0), middagAntal),
                new Dosis(LocalTime.of(18, 0), aftenAntal),
                new Dosis(LocalTime.of(22, 0), natAntal)
        };
    }


    public Dosis[] getDoser () {
        return doser;
    }

    /* * Returnerer den totale dosis der er givet i den periode ordinationen er gyldig
     *
     * @return */

    public double samletDosis() {
        double samletDosis = 0;
        for (int i = 0; i < doser.length; i++) {
            samletDosis += doser[i].getAntal() * antalDage();
        }
        return samletDosis;
    }

     /* * Returnerer den gennemsnitlige dosis givet pr dag i den periode ordinationen er gyldig
     *
     * @return */

    public double doegnDosis() {
        return samletDosis() / antalDage();
    }


     /* * Returnerer ordinationstypen som en String
     *
     * @return */

    public String getType() {
        return "Daglig fast";
    }

}
