
import java.io.Serializable;

public class Voiture implements Serializable {
    protected String marque;

    protected int prix;

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Voiture() {
        super();
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Voiture [marque=" + marque + ", prix=" + prix + "]";
    }

    public Voiture(String marque, int prix) {
        super();
        this.marque = marque;
        this.prix = prix;
    }

}
