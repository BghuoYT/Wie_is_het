package be.kdg.projectbasis.model.character;
import be.kdg.projectbasis.model.character.Enums.*;

public class Character {
    private final String naam;
    private final HaarKleur haarKleur;
    private final Accessoires accessoire;
    private final Haarlengte haarlengte;
    private final Geslacht geslacht;
    private final HaarStijl haarStijl;
    private final Oogkleur oogkleur;
    private final Hoofddeksel hoofddeksel;
    private final Gezichtsbeharing gezichtsbeharing;

    public Character(String naam, Geslacht geslacht, Oogkleur oogkleur, HaarKleur haarKleur, Haarlengte haarlengte, HaarStijl haarStijl, Gezichtsbeharing gezichtsbeharing, Hoofddeksel hoofddeksel, Accessoires accessoire) {
        this.naam = naam;
        this.geslacht = geslacht;
        this.oogkleur = oogkleur;
        this.haarKleur = haarKleur;
        this.haarlengte = haarlengte;
        this.haarStijl = haarStijl;
        this.gezichtsbeharing = gezichtsbeharing;
        this.hoofddeksel = hoofddeksel;
        this.accessoire = accessoire;
    }

    public String getNaam() {
        return naam;
    }

    public HaarKleur getHaarKleur() {
        return haarKleur;
    }

    public Accessoires getAccessoires() {
        return accessoire;
    }

    public Haarlengte getHaarlengte() {
        return haarlengte;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public HaarStijl getHaarStijl() {
        return haarStijl;
    }

    public Oogkleur getOogkleur() {
        return oogkleur;
    }

    public Hoofddeksel getHoofddeksel() {
        return hoofddeksel;
    }

    public Gezichtsbeharing getGezichtsbeharing() {
        return gezichtsbeharing;
    }


    public boolean matches(String question) {
        // Gebruik de vraag van de speler om te bepalen of het karakter aan de eigenschap voldoet
        if (question.contains("man") || question.contains("vrouw")) {
            return geslacht.matches(question);
        } else if ((question.contains("blond") || question.contains("bruin") || question.contains("zwart") || question.contains("blonde") || question.contains("bruine") || question.contains("zwarte") || question.contains("rood")|| question.contains("rode")) && (question.contains("haar") || question.contains("haren"))) {
            return haarKleur.matches(question);
        } else if (question.contains("lang") || question.contains("kort") || question.contains("middellang") || question.contains("kaal")) {
            return haarlengte.matches(question);
        } else if ((question.contains("blauw") || question.contains("blauwe")|| question.contains("bruine") || question.contains("bruin") || question.contains("groene")|| question.contains("groen")|| question.contains("grijze")|| question.contains("grijs")) && (question.contains("oog") || question.contains("ogen"))) {
            return oogkleur.matches(question);
        } else if (question.contains("baard") || question.contains("snor")) {
            return gezichtsbeharing.matches(question);
        } else if (question.contains("hoed") || question.contains("pet") || question.contains("geen hoofddeksel")) {
            return hoofddeksel.matches(question);
        } else if (question.contains("bril") || question.contains("zonnebril") || question.contains("geen accesoires")) {
            return accessoire.matches(question);
        } else if (question.contains("krullen") || question.contains("stijl") || question.contains("kaal") || question.contains("golvend")) {
            return haarStijl.matches(question);
        } else {
            System.out.println("Dit is geen geldige vraag");
            return false;
        }
    }
}
