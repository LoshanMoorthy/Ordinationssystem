package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination{
    private Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
        this.doser = doser;
    }


    public Dosis[] getDosis() {
        return doser;
    }

    public Dosis createDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);

        return dosis;
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
