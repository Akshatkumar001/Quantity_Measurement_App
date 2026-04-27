
public class Length {

    private double value;
    private LengthUnit unit;

    // Base unit = inches
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
        double result = value * unit.getConversionFactor();
        return Math.round(result * 100.0) / 100.0;
    }

    // Convert from inches → target unit
    private double convertFromBaseToTargetUnit(double inches, LengthUnit targetUnit) {
        double result = inches / targetUnit.getConversionFactor();
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
        double converted = convertFromBaseToTargetUnit(base, targetUnit);

        return new Length(converted, targetUnit);
    }

    /**
     * UC6: Add and return in THIS unit
     */
    public Length add(Length thatLength) {
        return addAndConvert(thatLength, this.unit);
    }

    /**
     * ✅ UC7: Add and return in TARGET unit
     */
    public Length add(Length thatLength, LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        return addAndConvert(thatLength, targetUnit);
    }

    /**
     * Core reusable logic
     */
    private Length addAndConvert(Length thatLength, LengthUnit targetUnit) {
        if (thatLength == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }

        // Step 1: convert both to inches
        double thisInches = this.convertToBaseUnit();
        double thatInches = thatLength.convertToBaseUnit();

        // Step 2: add
        double sumInches = thisInches + thatInches;

        // Step 3: convert to target unit
        double resultValue = convertFromBaseToTargetUnit(sumInches, targetUnit);

        // Step 4: return new object
        return new Length(resultValue, targetUnit);
    }

    @Override
    public String toString() {
        return String.format("Quantity(%.2f, %s)", value, unit);
    }
}