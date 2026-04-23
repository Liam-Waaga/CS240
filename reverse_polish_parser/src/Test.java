/* Liam Waaga */


public class Test {
    public static void main(String[] args) {
        /* ChatGPT Test cases (manually validated) */
        System.out.println("+ 2 3 => expected=5.0, actual=" + PolishNotationEvaluator.parse("+ 2 3"));
        System.out.println("- 5 1 => expected=4.0, actual=" + PolishNotationEvaluator.parse("- 5 1"));
        System.out.println("* 3 4 => expected=12.0, actual=" + PolishNotationEvaluator.parse("* 3 4"));
        System.out.println("/ 8 2 => expected=4.0, actual=" + PolishNotationEvaluator.parse("/ 8 2"));
        System.out.println("+ 2 * 3 4 => expected=14.0, actual=" + PolishNotationEvaluator.parse("+ 2 * 3 4"));
        System.out.println("- * 5 2 3 => expected=7.0, actual=" + PolishNotationEvaluator.parse("- * 5 2 3"));
        System.out.println("* + 1 2 3 => expected=9.0, actual=" + PolishNotationEvaluator.parse("* + 1 2 3"));
        System.out.println("/ 8 + 2 2 => expected=2.0, actual=" + PolishNotationEvaluator.parse("/ 8 + 2 2"));
        System.out.println("+ * 2 3 * 4 5 => expected=26.0, actual=" + PolishNotationEvaluator.parse("+ * 2 3 * 4 5"));
        System.out.println("- + 7 2 * 3 2 => expected=3.0, actual=" + PolishNotationEvaluator.parse("- + 7 2 * 3 2"));
        System.out.println("* - 9 4 + 2 3 => expected=25.0, actual=" + PolishNotationEvaluator.parse("* - 9 4 + 2 3"));
        System.out.println("/ * 8 2 + 2 2 => expected=4.0, actual=" + PolishNotationEvaluator.parse("/ * 8 2 + 2 2"));
        System.out.println("+ 3 * 2 * 2 2 => expected=11.0, actual=" + PolishNotationEvaluator.parse("+ 3 * 2 * 2 2"));
        System.out.println("- * + 1 2 3 4 => expected=5.0, actual=" + PolishNotationEvaluator.parse("- * + 1 2 3 4"));
        System.out.println("* + * 1 2 3 4 => expected=20.0, actual=" + PolishNotationEvaluator.parse("* + * 1 2 3 4"));
        System.out.println("/ + 8 * 2 2 4 => expected=3.0, actual=" + PolishNotationEvaluator.parse("/ + 8 * 2 2 4"));
        System.out.println("+ * + 1 2 3 * 4 5 => expected=29.0, actual=" + PolishNotationEvaluator.parse("+ * + 1 2 3 * 4 5"));
        System.out.println("- + * 2 3 4 * 1 2 => expected=8.0, actual=" + PolishNotationEvaluator.parse("- + * 2 3 4 * 1 2"));
        System.out.println("* - + 9 1 2 + 3 4 => expected=56.0, actual=" + PolishNotationEvaluator.parse("* - + 9 1 2 + 3 4"));
        System.out.println("/ * + 2 2 3 + 4 4 => expected=1.5, actual=" + PolishNotationEvaluator.parse("/ * + 2 2 3 + 4 4"));
    }
}
