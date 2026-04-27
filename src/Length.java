public class Length {

    private double value;
    private LengthUnit unit;

    // ✅ Enum kept INSIDE to avoid separate file issues
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double convertToBaseUnit(double value) {
            double result = value * conversionFactor;
            return Math.round(result * 100.0) / 100.0;
        }

        public double convertFromBaseUnit(double baseValue) {
            double result = baseValue / conversionFactor;
            return Math.round(result * 100.0) / 100.0;
        }
    }

    // Constructor
    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    // Convert
    public Length convertTo(LengthUnit targetUnit) {
        double base = unit.convertToBaseUnit(value);
        double result = targetUnit.convertFromBaseUnit(base);
        return new Length(result, targetUnit);
    }

    // Add (same unit as first object)
    public Length add(Length other) {
        return add(other, this.unit);
    }

    // Add with target unit
    public Length add(Length other, LengthUnit targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double sum = thisBase + otherBase;

        double result = targetUnit.convertFromBaseUnit(sum);

        return new Length(result, targetUnit);
    }

    // Equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;

        Length other = (Length) obj;

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        return thisBase == otherBase;
    }

    @Override
    public String toString() {
        return String.format("Quantity(%.2f, %s)", value, unit);
    }
}