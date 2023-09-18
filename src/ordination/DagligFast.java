package ordination;

import java.time.LocalTime;

public class DagligFast {
    private final Dosis[] doser = new Dosis[4];

    public Dosis[] getDosis() {
        return doser;
    }

    public Dosis createDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        doser.add(person);
        return person;
    }
}
