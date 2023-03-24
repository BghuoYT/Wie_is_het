package be.kdg.projectbasis.model.highscore;


    public class Player {
        private final String username;
        private final String voornaam;
        private final String achternaam;
        private final String email;
        private int wins;

        public Player(String username, String voornaam, String achternaam,String email, int wins) {
            this.username = username;
            this.voornaam = voornaam;
            this.achternaam = achternaam;
            this.email = email;
            this.wins = wins;
        }

        public String getUsername() {
            return username;
        }

        public String getVoornaam() {
            return voornaam;
        }

        public String getAchternaam() {
            return achternaam;
        }

        public String getEmail() {
            return email;
        }

        public int getWins() {
            return wins;
        }

        public void addWin() {
            wins++;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }
    }
