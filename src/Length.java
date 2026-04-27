
public class Length {

    private double value;
    private LengthUnit unit;

    // Enum (base unit = inches)
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

    // Convert to inches (base unit)
    private double convertToBaseUnit() {
        double result = this.value * this.unit.getConversionFactor();
        return Math.round(result * 100.0) / 100.0;
    }

    // Compare
    private boolean compare(Length that) {
        return this.convertToBaseUnit() == that.convertToBaseUnit();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length that = (Length) o;
        return compare(that);
    }

    // Convert to another unit
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base = convertToBaseUnit();
        double converted = base / targetUnit.getConversionFactor();
        converted = Math.round(converted * 100.0) / 100.0;

        return new Length(converted, targetUnit);
    }

    /**
     * ✅ UC6: ADD METHOD
     */
    public Length add(Length thatLength) {
        if (thatLength == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }

        // Step 1: convert both to inches
        double thisInches = this.convertToBaseUnit();
        double thatInches = thatLength.convertToBaseUnit();

        // Step 2: add
        double sumInches = thisInches + thatInches;

        // Step 3: convert back to THIS unit
        double resultValue = convertFromBaseToTargetUnit(sumInches, this.unit);

        // Step 4: return new object
        return new Length(resultValue, this.unit);
    }

    /**
     * Helper method (used in add + convertTo)
     */
    private double convertFromBaseToTargetUnit(double inches, LengthUnit targetUnit) {
        double result = inches / targetUnit.getConversionFactor();
        return Math.round(result * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("Quantity(%.2f, %s)", value, unit);
    }
}