
public class QuantityMeasurementApp {

    /**
     * Equality check
     */
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        boolean result = l1.equals(l2);
        System.out.println("Comparing: " + l1 + " and " + l2 + " -> " + result);
        return result;
    }

    /**
     * Comparison using values
     */
    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        return demonstrateLengthEquality(l1, l2);
    }

    /**
     * Conversion using raw values
     */
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit) {

        if (fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        Length length = new Length(value, fromUnit);
        Length result = length.convertTo(toUnit);

        System.out.println("convert(" + value + ", " + fromUnit + ", " + toUnit + ") -> " + result);
        return result;
    }

    /**
     * Conversion using object (method overloading)
     */
    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit) {

        if (length == null || toUnit == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        Length result = length.convertTo(toUnit);
        System.out.println("convert(" + length + ", " + toUnit + ") -> " + result);

        return result;
    }

    /**
     * Main method
     */
    public static void main(String[] args) {

        // Equality checks
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                                   12.0, Length.LengthUnit.INCHES);

        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                                   3.0, Length.LengthUnit.FEET);

        demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETERS,
                                   0.393701, Length.LengthUnit.INCHES);

        // Conversions
        demonstrateLengthConversion(1.0, Length.LengthUnit.FEET,
                                   Length.LengthUnit.INCHES);

        demonstrateLengthConversion(3.0, Length.LengthUnit.YARDS,
                                   Length.LengthUnit.FEET);

        demonstrateLengthConversion(36.0, Length.LengthUnit.INCHES,
                                   Length.LengthUnit.YARDS);

        demonstrateLengthConversion(1.0, Length.LengthUnit.CENTIMETERS,
                                   Length.LengthUnit.INCHES);

        demonstrateLengthConversion(0.0, Length.LengthUnit.FEET,
                                   Length.LengthUnit.INCHES);

        // Object-based conversion
        Length l = new Length(2.0, Length.LengthUnit.YARDS);
        demonstrateLengthConversion(l, Length.LengthUnit.FEET);
    }
}