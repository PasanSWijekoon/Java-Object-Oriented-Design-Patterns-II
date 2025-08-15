import java.util.Stack;

interface Expression {

    int interprete();
}

class Number implements Expression {

    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interprete() {
        return number;
    }

}

class Add implements Expression {

    private Expression left, right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interprete() {

        return left.interprete() + right.interprete();

    }

}

class Subtract implements Expression {

    private Expression left, right;

    public Subtract(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interprete() {

        return left.interprete() - right.interprete();

    }

}

class ExpressionParser {

    public static Expression Parse(String expression) {

        String tokens[] = expression.split(" ");
        Stack<Expression> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            String token = tokens[i];

            if (token.equals("+")) {
                Expression left = stack.pop();
                Expression right = new Number(Integer.parseInt(tokens[++i]));
                stack.push(new Add(left, right));
            } else if (token.equals("-")) {
                Expression left = stack.pop();
                Expression right = new Number(Integer.parseInt(tokens[++i]));
                stack.push(new Subtract(left, right));
            } else {
                stack.push(new Number(Integer.parseInt(token)));
            }

        }
        return stack.pop();
    }

}

public class InterpreterDesignpattern {

    public static void main(String[] args) {
        String input = "10 - 2 + 4";
        Expression expression = ExpressionParser.Parse(input);
        int result = expression.interprete();

        System.out.println("Result: " + result);
    }

}
