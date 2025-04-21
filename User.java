public class User {
        private String name;
        private int attempts;
        private int score; // You can implement scoring logic later

        public User() {
            this.attempts = 0;
            this.score = 0;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAttempts() {
            return attempts;
        }

        public void incrementAttempts() {
            this.attempts++;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

