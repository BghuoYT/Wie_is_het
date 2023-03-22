package be.kdg.projectbasis.model.spelbeurten;

import java.util.ArrayList;

    public class ComputerQuestions {
        // Een lijst met vragen die de computer kan stellen
        private final ArrayList<String> questions;
        private ArrayList<String> usedQuestions;


        public ComputerQuestions() {
            questions = new ArrayList<String>();
            // Voeg vragen toe aan de lijst
            questions.add("Is het karakter een man?");
            questions.add("Is het karakter een vrouw?");
            questions.add("Heeft het karakter blond haar?");
            questions.add("heeft het karakter bruin haar?");
            questions.add("heeft het karakter rood haar?");
            questions.add("heeft het karakter zwart haar?");
            questions.add("heeft het karakter groen haar?");
            questions.add("heeft het karakter kort haar?");
            questions.add("heeft het karakter middellang haar?");
            questions.add("heeft het karakter lang haar?");
            questions.add("heeft het karakter krullen?");
            questions.add("heeft het karakter golvend haar?");
            questions.add("heeft het karakter stijl haar?");
            questions.add("heeft het karakter een bril?");
            questions.add("heeft het karakter een hoed?");
            questions.add("heeft het karakter een pet?");
            questions.add("heeft het karakter oorbellen?");
            questions.add("heeft het karakter een halsketting?");
            questions.add("heeft het karakter geen accesoires?");
            questions.add("heeft het karakter een baard?");
            questions.add("heeft het karakter een snor?");
            questions.add("heeft het karakter geen gezichtsbeharing?");
            questions.add("heeft het karakter blauwe ogen?");
            questions.add("heeft het karakter bruine ogen?");
            questions.add("heeft het karakter groene ogen?");
            questions.add("heeft het karakter grijze ogen?");
        }

        // Een methode om een willekeurige vraag uit de lijst te selecteren, zonder herhaling van vragen
        public String getRandomQuestion() {
            usedQuestions = new ArrayList<String>();
            int index;
            do {
                index = (int) (Math.random() * questions.size());
            } while (usedQuestions.contains(questions.get(index)));
            usedQuestions.add(questions.get(index));
            return questions.get(index);
        }
    }

