public class RecursiveDescentParsing {

    /**
     * An object of type ParseError represents a syntax error found in
     * the user's input.
     */
    private static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    } // end nested class ParseError


    /**
     * If the next character in input is one of the legal operators,
     * read it and return it.  Otherwise, throw a ParseError.
     */
    static char getOperator() throws ParseError {
        TextIO.skipBlanks();
        char op = TextIO.peek(); // look ahead at the next char, without reading it
        if (op == '+' || op == '-' || op == '*' || op == '/') {
            TextIO.getAnyChar();  // read the operator, to remove it from the input
            return op;
        } else if (op == '\n')
            throw new ParseError("Missing operator at end of line.");
        else
            throw new ParseError("Missing operator.  Found \"" +
                    op + "\" instead of +, -, *, or /.");
    } // end getOperator()

    /**
     * Read an expression from the current line of input and return its value.
     *
     * @throws ParseError if the input contains a syntax error
     */
    private static double expressionValue() throws ParseError {
        TextIO.skipBlanks();
        if (Character.isDigit(TextIO.peek())) {
            // The next item in input is a number, so the expression
            // must consist of just that number.  Read and return
            // the number.
            return TextIO.getDouble();
        } else if (TextIO.peek() == '(') {
            // The expression must be of the form
            //         "(" <expression> <operator> <expression> ")"
            // Read all these items, perform the operation, and
            // return the result.
            TextIO.getAnyChar();  // Read the "("
            double leftVal = expressionValue();  // Read and evaluate first operand.
            char op = getOperator();             // Read the operator.
            double rightVal = expressionValue(); // Read and evaluate second operand.
            TextIO.skipBlanks();
            if (TextIO.peek() != ')') {
                // According to the rule, there must be a ")" here.
                // Since it's missing, throw a ParseError.
                throw new ParseError("Missing right parenthesis.");
            }
            TextIO.getAnyChar();  // Read the ")"
            switch (op) {   //  Apply the operator and return the result.
                case '+':
                    return leftVal + rightVal;
                case '-':
                    return leftVal - rightVal;
                case '*':
                    return leftVal * rightVal;
                case '/':
                    return leftVal / rightVal;
                default:
                    return 0;  // Can't occur since op is one of the above.
                // (But Java syntax requires a return value.)
            }
        } else {  // No other character can legally start an expression.
            throw new ParseError("Encountered unexpected character, \"" +
                    TextIO.peek() + "\" in input.");
        }
    } // end expressionValue()


}
