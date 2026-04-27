

/**
 * A generic class for representing and comparing lengths in different units.
 * Base unit: inches
 */
public class Length {

    private double value;
    private LengthUnit unit;

    /**
     * Supported units with conversion factors relative to inches
     */
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

    /**
     * Convert to base unit (inches)
     */
    private double convertToBaseUnit() {
        double result = this.value * this.unit.getConversionFactor();
        return Math.round(result * 100.0) / 100.0;
    }

    /**
     * Compare two Length objects
     */
    private boolean compare(Length that) {
        return this.convertToBaseUnit() == that.convertToBaseUnit();
    }

    /**
     * Equality override
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Length that = (Length) obj;
        return compare(that);
    }

    /**
     * Convert to target unit
     */
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        // Step 1: convert to inches
        double baseValue = this.convertToBaseUnit();

        // Step 2: convert to target unit
        double convertedValue = baseValue / targetUnit.getConversionFactor();

        // Step 3: round
        convertedValue = Math.round(convertedValue * 100.0) / 100.0;

        return new Length(convertedValue, targetUnit);
    }

    /**
     * String representation
     */
    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}