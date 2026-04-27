
public class Length {

    // Instance variables
    private double value;
    private LengthUnit unit;

    // Enum for units (base unit = inches)
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // Constructor
    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (inches)
    private double convertToBaseUnit() {
        double result = this.value * this.unit.getConversionFactor();
        return Math.round(result * 100.0) / 100.0; // round to 2 decimals
    }

    // Compare two Length objects
    public boolean compare(Length that) {
        return this.convertToBaseUnit() == that.convertToBaseUnit();
    }

    // Override equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Length that = (Length) obj;
        return this.compare(that);
    }

    // For debugging (optional)
    @Override
    public String toString() {
        return value + " " + unit;
    }
}