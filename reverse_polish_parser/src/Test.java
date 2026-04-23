/* Liam Waaga */

public class Test {
    public static void main(String[] args) {
        /* ChatGPT Test cases (manually validated) */

        System.out.println(PolishNotationEvaluator.parse("+ 2.0 3.0")); // 5.0
        System.out.println(PolishNotationEvaluator.parse("- 2.0 3.0")); // -1.0
        System.out.println(PolishNotationEvaluator.parse("* 2.0 3.0")); // 6.0
        System.out.println(PolishNotationEvaluator.parse("/ 2.0 3.0")); // 0.666...

        System.out.println(PolishNotationEvaluator.parse("+ 3.5 4.0")); // 7.5
        System.out.println(PolishNotationEvaluator.parse("- 5.5 4.0")); // 1.5
        System.out.println(PolishNotationEvaluator.parse("* 3.5 4.0")); // 14.0
        System.out.println(PolishNotationEvaluator.parse("/ 5.5 4.0")); // 1.375

        System.out.println(PolishNotationEvaluator.parse("+ 4.5 4.5")); // 9.0
        System.out.println(PolishNotationEvaluator.parse("- 4.5 4.5")); // 0.0
        System.out.println(PolishNotationEvaluator.parse("* 4.5 4.5")); // 20.25
        System.out.println(PolishNotationEvaluator.parse("/ 4.5 4.5")); // 1.0

        System.out.println(PolishNotationEvaluator.parse("+ 2.5 8.0")); // 10.5
        System.out.println(PolishNotationEvaluator.parse("- 2.5 8.0")); // -5.5
        System.out.println(PolishNotationEvaluator.parse("* 2.5 8.0")); // 20.0
        System.out.println(PolishNotationEvaluator.parse("/ 2.5 8.0")); // 0.3125

        System.out.println(PolishNotationEvaluator.parse("+ -2.5 2.5")); // 0.0
        System.out.println(PolishNotationEvaluator.parse("- -2.5 2.5")); // -5.0
        System.out.println(PolishNotationEvaluator.parse("* -2.5 2.5")); // -6.25
        System.out.println(PolishNotationEvaluator.parse("/ -2.5 2.5")); // -1.0
    }
}
