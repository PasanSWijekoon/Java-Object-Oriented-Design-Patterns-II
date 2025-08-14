import java.util.HashMap;
import java.util.Map;

interface Expression {
    int interpret(Context context);
}

class Context{
    private Map<String, Integer> variables = new HashMap<>();

    public void assign(String variable, int value) {
        variables.put(variable, value);
    }

    public int lookup(String variable) {
        if(!variables.containsKey(variable)) {
            throw new IllegalArgumentException("Variable not found: " + variable);
        }
        return variables.get(variable);
    }
}


//terminal
class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Context context) {
        return number;
    }
}

class VariableExpression implements Expression {
    private String variable;

    public VariableExpression(String variable) {
        this.variable = variable;
    }

    @Override
    public int interpret(Context context) {
        return context.lookup(variable);
    }
}

//non-terminal
class AddExpression implements Expression {
    private Expression left;
    private Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}

class SubtractExpression implements Expression {
    private Expression left;
    private Expression right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }
}

class MultiplyExpression implements Expression {
    private Expression left;
    private Expression right;

    public MultiplyExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) * right.interpret(context);
    }
}

class DivisonExpression implements Expression {
    private Expression left;
    private Expression right;

    public DivisonExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        int rightValue = right.interpret(context);
        if (rightValue == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return left.interpret(context) / rightValue;
    }
}



public class CalPro {
    public static void main(String[] args) {
       
        Context context = new Context();
        context.assign("x", 10);
        context.assign("y", 5);

        Expression ex1 = new AddExpression(new NumberExpression(5),new NumberExpression(10));
        System.out.println("ADD(5, 10) = " + ex1.interpret(context));

        Expression ex2 = new MultiplyExpression(new AddExpression(new NumberExpression(2), new NumberExpression(3)), new NumberExpression(4));
        System.out.println("MUL(ADD(2, 3), 4) = " + ex2.interpret(context));

        Expression ex3 = new DivisonExpression(new SubtractExpression(new NumberExpression(20), new NumberExpression(4)), new NumberExpression(2));
        System.out.println("DIV(20, 4),2)= " + ex3.interpret(context));

    }
}
