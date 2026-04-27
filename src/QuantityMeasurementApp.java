public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // Conversion
        System.out.println(
            new Length(1.0, Length.LengthUnit.FEET)
                .convertTo(Length.LengthUnit.INCHES)
        );

        // Equality
        System.out.println(
            new Length(36.0, Length.LengthUnit.INCHES)
                .equals(new Length(1.0, Length.LengthUnit.YARDS))
        );

        // Addition (same unit)
        System.out.println(
            new Length(1.0, Length.LengthUnit.FEET)
                .add(new Length(12.0, Length.LengthUnit.INCHES))
        );

        // Addition (target unit)
        System.out.println(
            new Length(1.0, Length.LengthUnit.FEET)
                .add(new Length(12.0, Length.LengthUnit.INCHES),
                     Length.LengthUnit.FEET)
        );

        System.out.println(
            new Length(1.0, Length.LengthUnit.FEET)
                .add(new Length(12.0, Length.LengthUnit.INCHES),
                     Length.LengthUnit.INCHES)
        );

        // Yards example
        System.out.println(
            new Length(1.0, Length.LengthUnit.YARDS)
                .add(new Length(3.0, Length.LengthUnit.FEET),
                     Length.LengthUnit.YARDS)
        );

        // CM example
        System.out.println(
            new Length(2.54, Length.LengthUnit.CENTIMETERS)
                .convertTo(Length.LengthUnit.INCHES)
        );

        // Edge cases
        System.out.println(
            new Length(5.0, Length.LengthUnit.FEET)
                .add(new Length(0.0, Length.LengthUnit.INCHES),
                     Length.LengthUnit.FEET)
        );

        System.out.println(
            new Length(5.0, Length.LengthUnit.FEET)
                .add(new Length(-2.0, Length.LengthUnit.FEET),
                     Length.LengthUnit.INCHES)
        );
    }
}