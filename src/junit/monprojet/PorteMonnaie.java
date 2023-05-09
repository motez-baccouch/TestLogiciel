package junit.monprojet;

import java.util.HashMap;

public class PorteMonnaie {

    private HashMap<String, Integer> contenu;

    public HashMap<String, Integer> getContenu() {
        return contenu;
    }

    public PorteMonnaie() {
        contenu = new HashMap<String, Integer>();
    }

    public void ajouteSomme(SommeArgent sa) {
        int quantite = sa.getQuantite();
        String unite = sa.getUnite();

        contenu.put(unite, contenu.getOrDefault(unite, 0) + quantite);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PorteMonnaie)) {
            return false;
        }

        PorteMonnaie other = (PorteMonnaie) obj;
        return this.contenu.equals(other.contenu);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String unite : contenu.keySet()) {
            sb.append(contenu.get(unite)).append(" ").append(unite).append(", ");
        }
        return sb.toString();
    }
}