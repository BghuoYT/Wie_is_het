package be.kdg.projectbasis.model.character.Enums;

public enum Haarlengte {
    kaal, kort, middelang , lang;
    public boolean matches(String question) {
        return question.contains(name().toLowerCase());
    }
}
