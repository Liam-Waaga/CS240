public class PolishNotationEvaluator {
    public static double parse(String expression) {

        Node<Tokens> tokens = parse_expr(expression);
        return evaluate_tokens(tokens);

    }

    private static Node<Tokens> parse_expr(String expr) {
        Tokens op = null;
        Tokens lhs = null;
        Tokens rhs = null;

        Node<Tokens> toks = null;

        for (int i = 0; i < expr.length(); i++) {
            /* turn it into a tree */
            Tokens token = null;
            /* grab the token */
            switch (expr.charAt(i)) {
                case '+':
                    token = Tokens.OP_PLUS;
                    break;
                case '-':
                    token = Tokens.OP_MINUS;
                    break;
                case '*':
                    token = Tokens.OP_MULT;
                    break;
                case '/':
                    token = Tokens.OP_DIV;
                    break;
                case '0':
                    token = Tokens.NUM_ZERO;
                    break;
                case '1':
                    token = Tokens.NUM_ONE;
                    break;
                case '2':
                    token = Tokens.NUM_TWO;
                    break;
                case '3':
                    token = Tokens.NUM_THREE;
                    break;
                case '4':
                    token = Tokens.NUM_FOUR;
                    break;
                case '5':
                    token = Tokens.NUM_FIVE;
                    break;
                case '6':
                    token = Tokens.NUM_SIX;
                    break;
                case '7':
                    token = Tokens.NUM_SEVEN;
                    break;
                case '8':
                    token = Tokens.NUM_EIGHT;
                    break;
                case '9':
                    token = Tokens.NUM_NINE;
                    break;
                case ' ':
                    continue;
                default:
                    System.err.println("Invalid token");
                    continue;
            }

            if (op == null) { /* operator is not set (and comes first) */
                op = token;
                if (!is_op(op)) {
                    new Exception().printStackTrace();
                    System.exit(1);
                }
                toks = new Node<Tokens>(op, null, null); /* init toks for the first time */
            } else if (lhs == null) {
                lhs = token;
                if (is_op(lhs)) {
                    /* if lhs is an operator, that means that we need to start parsing from here */
                    toks.setLeft(parse_expr(expr.substring(i)));
                    i = toks.getLeft().getEnd_point() + i;
                } else {
                    toks.setLeft(new Node<Tokens>(lhs, null, null));
                }
            } else if (rhs == null) {
                rhs = token;
                if (is_op(rhs)) {
                    /* if rhs is an operator, that means that we need to start parsing from here */
                    toks.setRight(parse_expr(expr.substring(i)));
                    i = toks.getRight().getEnd_point() + i;
                } else {
                    toks.setRight(new Node<Tokens>(rhs, null, null));
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

    private static double evaluate_tokens(Node<Tokens> toks) {
        double left = 0;
        double right = 0;
        if (toks.getLeft() != null) {
            left = evaluate_tokens(toks.getLeft());
        }
        if (toks.getRight() != null) {
            right = evaluate_tokens(toks.getRight());
        }

        switch (toks.getObj()) {
            /*
             * if this isn't an operator, then it is a number, in which case the expressions
             * value is simply the integer associated with the token
             */
            case NUM_ZERO:
                return 0;
            case NUM_ONE:
                return 1;
            case NUM_TWO:
                return 2;
            case NUM_THREE:
                return 3;
            case NUM_FOUR:
                return 4;
            case NUM_FIVE:
                return 5;
            case NUM_SIX:
                return 6;
            case NUM_SEVEN:
                return 7;
            case NUM_EIGHT:
                return 8;
            case NUM_NINE:
                return 9;
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