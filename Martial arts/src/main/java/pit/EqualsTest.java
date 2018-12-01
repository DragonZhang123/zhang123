package pit;

public class EqualsTest   {
    /**
     * Autoboxing和Unboxing是没法绕过的东西
     * @param args
     */
    public static void main(String[] args) {
        Integer zero = 0;
        Integer thousand = 1000;

        {
            Integer n = 0;
            if (n == zero) {
                System.out.println("n == 0");
            }
        }

        {
            Integer n = 1000;
            if (n == thousand) {
                System.out.println("n == 1000");
            }
        }
        {
            //这个会NPE的
            Integer n = null;
            if (n == 0) {
                System.out.println("n == 0");
            }
        }
    }
}