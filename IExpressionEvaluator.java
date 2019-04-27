package eg.edu.alexu.csd.datastructure.stack.cs22;
import java.awt.*;
import java.util.*;
import java.lang.*;

public interface IExpressionEvaluator {
    public String infixToPostfix(String expression);
    public int evaluate(String expression);
}
class solver implements IExpressionEvaluator {
    static int Prec(char ch)
    {
        switch (ch)
        {
            /**
             * Checks the order of operations
             * @param ch
             * @return a numerical value to respect the order of operations
             */
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
    public String infixToPostfix(String expression){
        /**
         * Transforms the infix form to its equivalent in postfix form
         * @param expression
         * @return the expression in postfix form
         */
        String result = new String("");
        Stack sol=new Stack();
        for (int i = 0; i<expression.length(); ++i)
        {
            char c = expression.charAt(i);
            if(c==' ')
                continue;
            if (Character.isLetterOrDigit(c))
                result += c;
            else if (c == '(')
                sol.push(c);
            else if (c == ')')
            {
                while (!sol.isEmpty() && (char)sol.peek() != '(')
                    result += sol.pop();

                if (!sol.isEmpty() && (char)sol.peek() != '(')
                    return "Invalid Expression";
                else
                    sol.pop();
            }
            else
            {
                while (!sol.isEmpty() && Prec(c) <= Prec((char)sol.peek()))
                    result += sol.pop();
                sol.push(c);
            }
        }
        while (!sol.isEmpty())
            result += sol.pop();

        return result;
    }
    public int evaluate(String expression) {
        /**
         * Calculates the value of a postfix expression
         * @param expression
         * @return the numerical value of the postfix expression
         */
        Stack sol = new Stack();
        int start = 0;
        int end = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ' ') {
                end = i;
                if (expression.charAt(start) != '+' && expression.charAt(start) != '-' &&
                        expression.charAt(start) != '*' && expression.charAt(start) != '/') {
                    String ans=new String();
                    for(int j=start;j<end;j++){
                        ans+=expression.charAt(j);
                    }
                    sol.push(Float.parseFloat(ans));
                }
                start = end + 1;
            }
            if (expression.charAt(i) == '+')
                sol.push((float) sol.pop() + (float) sol.pop());
            else if (expression.charAt(i) == '-')
                sol.push(-(float) sol.pop() + (float) sol.pop());
            else if (expression.charAt(i) == '*')
                sol.push((float) sol.pop() * (float) sol.pop());
            else if (expression.charAt(i) == '/')
            {if((float)sol.peek()==0.0)
                throw new ArithmeticException("You can't divide by zero");
        sol.push(1 / (float) sol.pop() * (float) sol.pop());
    }
       }
       return (int)(float)sol.peek();
    }
}
