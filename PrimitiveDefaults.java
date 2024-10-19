public class PrimitiveDefaults {
    byte byteValue;
    short shortValue;
    int intValue;
    long longValue;
    float floatValue;
    double doubleValue;
    char charValue;
    boolean booleanValue;

    public static void main(String[] args) {
        PrimitiveDefaults defaults = new PrimitiveDefaults();

        System.out.println("Default value of byte: " + defaults.byteValue);
        System.out.println("Default value of short: " + defaults.shortValue);
        System.out.println("Default value of int: " + defaults.intValue);
        System.out.println("Default value of long: " + defaults.longValue);
        System.out.println("Default value of float: " + defaults.floatValue);
        System.out.println("Default value of double: " + defaults.doubleValue);
        System.out.println("Default value of char: '" + defaults.charValue + "'");
        System.out.println("Default value of boolean: " + defaults.booleanValue);
    }
}
