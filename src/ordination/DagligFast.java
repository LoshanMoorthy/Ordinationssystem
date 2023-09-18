package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination{
    private Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Dosis[] doser) {
        super(startDen, slutDen);
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
            samletDosis = antalDage() *
            }


        }
        return samletDosis;
    }

     /* * Returnerer den gennemsnitlige dosis givet pr dag i den periode ordinationen er gyldig
     *
     * @return */

    public double doegnDosis() {
        return 0;
    }


     /* * Returnerer ordinationstypen som en String
     *
     * @return */

    public String getType() {
        return null;
    }

}
