public class QuantityMeasurementApp {

    // Inner class for Feet
    static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || !(obj instanceof Feet)) return false;

            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Inner class for Inches
    static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || !(obj instanceof Inches)) return false;

            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Method to demonstrate Feet equality
    public static void demonstrateFeetEquality() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        Feet f3 = new Feet(2.0);

        System.out.println("Feet तुलना:");
        System.out.println("1.0 ft vs 1.0 ft: " + f1.equals(f2)); // true
        System.out.println("1.0 ft vs 2.0 ft: " + f1.equals(f3)); // false
        System.out.println();
    }

    // Method to demonstrate Inches equality
    public static void demonstrateInchesEquality() {
        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(1.0);
        Inches i3 = new Inches(2.0);

        System.out.println("Inches तुलना:");
        System.out.println("1.0 in vs 1.0 in: " + i1.equals(i2)); // true
        System.out.println("1.0 in vs 2.0 in: " + i1.equals(i3)); // false
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}