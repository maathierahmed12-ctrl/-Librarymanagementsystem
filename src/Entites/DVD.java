package Entites;

public class DVD {
    package Entites;

    public class DVD extends LibraryItem {
        private int duration;

        public DVD(String id, String title, int duration) {
            super(id, title);
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "DVD Details: ID=" + getId() + ", Title=" + getClass() +
                    ", Duration=" + duration + " mins, Status=" + (isAvailable() ? "Available" : "Borrowed");
        }

        @Override
        public String getDetails() {
            return "";
        }
    }
}
