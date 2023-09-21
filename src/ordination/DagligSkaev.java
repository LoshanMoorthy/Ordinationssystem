package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

    private ArrayList<Dosis> doser = new ArrayList<>();
    private LocalTime[] tidspunkt;
    private int[] mængde;

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen,slutDen, laegemiddel);

    }

    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(doser);
    }

    public void opretDosis(LocalTime[] tid, double[] antal) {
        if (tid.length != antal.length) {
            throw new RuntimeException("Mængden af antal og tid skal være den samme");
        }

        for (int i = 0; i < tid.length; i++) {
            Dosis dosis = new Dosis(tid[i], antal[i]);
            doser.add(dosis);
        }
    }

    @Override
    public double samletDosis() {
        double samlet = 0;
        for(Dosis d : doser){
            samlet += d.getAntal();
        }
        return samlet;
    }

    @Override
    public double doegnDosis() {
        return samletDosis() / antalDage();
    }

    @Override
    public String getType() {
        return null;
    }
}
