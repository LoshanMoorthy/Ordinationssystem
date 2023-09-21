package ordination;

import java.time.LocalDate;
import java.util.ArrayList;

public class PN extends Ordination {

    private double antalEnheder;
    private ArrayList<LocalDate> givetDosis = new ArrayList<>();
    private int antalGangeGivet;

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double antalEnheder) {
        super(startDen, slutDen, laegemiddel);
        this.antalEnheder = antalEnheder;

    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */

    public boolean givDosis(LocalDate givesDen) {
        if (givesDen.isAfter(getStartDen()) && givesDen.isBefore(getSlutDen()) || givesDen.isEqual(getStartDen()) || givesDen.isEqual(getSlutDen())) {
            givetDosis.add(givesDen);
            antalGangeGivet++;
            return true;
        }
        return false;
    }

    public double doegnDosis() {
        return (antalGangeGivet * antalEnheder) / (antalDage());
    }

    @Override
    public String getType() {
        return null;
    }


    public double samletDosis() {
        return antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        return antalGangeGivet;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
