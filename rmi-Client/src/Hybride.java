public class Hybride extends Voiture{
    
    private String capaciteMoteurElectrique;

    public Hybride(String marque,int prix,String capactieMoteurElectrique) {
        super(marque,prix);
        this.capaciteMoteurElectrique = capactieMoteurElectrique;
    }

    public String getCapaciteMoteurElectrique() {
        return capaciteMoteurElectrique;
    }

    public void setCapaciteMoteurElectrique(String capaciteMoteurElectrique) {
        this.capaciteMoteurElectrique = capaciteMoteurElectrique;
    }

    @Override
    public String toString() {
        return "Hybride [capaciteMoteurElectrique=" + capaciteMoteurElectrique
                + ", marque=" + marque + ", prix=" + prix + "]";
    }

    
    
    
    
    

}
