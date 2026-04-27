
public class QuantityMeasurementApp {

    // Method to demonstrate equality
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        boolean result = l1.equals(l2);
        System.out.println("Comparing: " + l1 + " and " + l2 + " -> " + result);
        return result;
    }

    // Generic comparison method
    public static void demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        demonstrateLengthEquality(l1, l2);
    }

    public static void main(String[] args) {

        // Feet ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                                   12.0, Length.LengthUnit.INCHES);

        // Yards ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                                   36.0, Length.LengthUnit.INCHES);

        // Yards ↔ Feet
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                                   3.0, Length.LengthUnit.FEET);

        // CM ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETERS,
                                   0.393701, Length.LengthUnit.INCHES);

        // CM ↔ CM
        demonstrateLengthComparison(2.0, Length.LengthUnit.CENTIMETERS,
                                   2.0, Length.LengthUnit.CENTIMETERS);

        // Yards ↔ Yards
        demonstrateLengthComparison(2.0, Length.LengthUnit.YARDS,
                                   2.0, Length.LengthUnit.YARDS);

        // CM ↔ Inches (bigger value)
        demonstrateLengthComparison(100.0, Length.LengthUnit.CENTIMETERS,
                                   39.3701, Length.LengthUnit.INCHES);
    }
}