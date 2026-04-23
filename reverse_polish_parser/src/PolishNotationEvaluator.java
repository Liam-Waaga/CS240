public class PolishNotationEvaluator {
    public static double parse(String expression) {

        expression += " ";
        Node<Token> tokens = parse_expr(expression);
        return evaluate_tokens(tokens);

    }

    private static Node<Token> parse_expr(String expr) {
        Tokens op = null;
        Tokens lhs = null;
        Tokens rhs = null;

        Node<Token> toks = null;

        String[] parts = expr.split("\\s+");

        for (int i = 0; i < parts.length; i++) {
            /* turn it into a tree */
            Tokens token = null;
            double val = 0;
            /* grab the token */
            switch (parts[i]) {
                case "+":
                    token = Tokens.OP_PLUS;
                    break;
                case "-":
                    token = Tokens.OP_MINUS;
                    break;
                case "*":
                    token = Tokens.OP_MULT;
                    break;
                case "/":
                    token = Tokens.OP_DIV;
                    break;
                default:
                    try {
                        val = Double.parseDouble(parts[i]);
                    } catch (java.lang.Throwable e) {
                        System.err.printf("invalid token at %d\n", i);
                        continue;
                    }
                    token = Tokens.NUM_FLOAT;
            }

            if (op == null) { /* operator is not set (and comes first) */
                op = token;
                if (!is_op(op)) {
                    new Exception().printStackTrace();
                    System.exit(1);
                }
                toks = new Node<Token>(new Token(op, val), null, null); /* init toks for the first time */
            } else if (lhs == null) {
                lhs = token;
                if (is_op(lhs)) {
                    /* if lhs is an operator, that means that we need to start parsing from here */
                    toks.setLeft(parse_expr(expr.substring(i)));
                    i = toks.getLeft().getEnd_point() + i;
                } else {
                    toks.setLeft(new Node<Token>(new Token(lhs, val), null, null));
                }
            } else if (rhs == null) {
                rhs = token;
                if (is_op(rhs)) {
                    /* if rhs is an operator, that means that we need to start parsing from here */
                    toks.setRight(parse_expr(expr.substring(i)));
                    i = toks.getRight().getEnd_point() + i;
                } else {
                    toks.setRight(new Node<Token>(new Token(rhs, val), null, null));
                }
            } else {
                break;
            }
            toks.setEnd_point(i);
        }
        return toks;

    }

    private static boolean is_op(Tokens tok) {
        return tok == Tokens.OP_PLUS ||
                tok == Tokens.OP_MINUS ||
                tok == Tokens.OP_MULT ||
                tok == Tokens.OP_DIV;
    }

    private static double evaluate_tokens(Node<Token> toks) {
        double left = 0;
        double right = 0;
        if (toks.getLeft() != null) {
            left = evaluate_tokens(toks.getLeft());
        }
        if (toks.getRight() != null) {
            right = evaluate_tokens(toks.getRight());
        }

        switch (toks.getObj().getTok()) {
            /*
             * if this isn't an operator, then it is a number, in which case the expressions
             * value is simply the integer associated with the token
             */
            case Tokens.NUM_FLOAT:
                /* return val */
                return toks.getObj().getValue();
            /* this must be the composition of two expressions and an operator */
            case Tokens.OP_PLUS:
                return left + right;
            case Tokens.OP_MINUS:
                return left - right;
            case Tokens.OP_MULT:
                return left * right;
            case Tokens.OP_DIV:
                return left / right;
            default:
                /* unreachable */
                System.err.println("unreachable");
                return 0;
        }
    }
}