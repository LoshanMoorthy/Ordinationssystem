package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    // TODO

    private ArrayList<Dosis> doser = new ArrayList<>();
    private LocalTime tidspunkt;
    private int mængde;


    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, LocalTime tidspunkt, int mængde) {
        super(startDen,slutDen, laegemiddel);
        this.tidspunkt = tidspunkt;
        this.mængde = mængde;

    }

    public void opretDosis(LocalTime tid, double antal) {
        // TODO
        Dosis dosis = new Dosis(tidspunkt,mængde);
        doser.add(dosis);

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
        for(Dosis d : doser){

        }
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }
}
