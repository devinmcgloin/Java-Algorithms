package GA;


import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author devinmcgloin
 * @version 12/20/15.
 */
public class Expression implements GAInterface<Expression> {

    static Logger logger = Logger.getLogger(GA.class);
    static char[] possible = "0123456789-+/*^".toCharArray();
    static int chromoLen = 5;
    static int geneCount = 5;
    static double target = 68;
    static HashMap<String, Character> translationMap = new HashMap<>();
    static HashMap<Character, String> revTransMap = new HashMap<>();
    static Translator<Expression> t = new Translator<Expression>() {
        @Override
        String encode(final Expression item) {
            StringBuffer buffer = new StringBuffer();
            char[] cArr = item.expression.toCharArray();
            for(Character c : cArr){
                buffer.append(revTransMap.get(c));
            }
            return buffer.toString();
        }

        @Override
        ArrayList<String> genRandOffspring() {
            ArrayList<String> list = new ArrayList<>();
            StringBuffer buff = new StringBuffer();
            for(int i = 0; i < 100; i++) {
                for (int j = 0; j < geneCount; j++) {
                    buff.append(possible[r.nextInt(possible.length)]);
                }
                Expression e = new Expression(buff.toString());
                list.add(encode(e));
                buff = new StringBuffer();
            }
            return list;
        }

        @Override
        Expression decode(final String s) {
            StringBuffer buffer = new StringBuffer();
            int i = 0;
            while (i < s.length()) {
                buffer.append(translationMap.get(s.substring(i, i + chromoLen)));
                i += chromoLen;
            }
            return new Expression(buffer.toString());

        }
    };
    String expression = "";
    public Expression(String expression){
        this.expression = expression;
    }

    public static Translator<Expression> getT() {
        return t;
    }

    public static void setTarget(final int target) {
        Expression.target = target;
    }

    public static void initializeTables(){
        ArrayList<String> seq = Translator.genBinSeq(chromoLen);
        for (int i = 0; i < seq.size(); i++) {
            Character c = possible[i % (possible.length)];
            translationMap.put(seq.get(i), c);
            revTransMap.put(c, seq.get(i));
        }
        logger.debug(translationMap);
        logger.debug(revTransMap);

    }

    public static void main(String[] args){
        Expression e = new Expression("");
        initializeTables();
        GA<Expression> GA = new GA<Expression>(t);

        e = GA.solve();
        if (e != null) {
            System.out.printf("Solution Found: %s\n" +
                    "Fitness: %f\n" +
                    "Evaluates: %f\n" +
                    "Target: %f\n", e, e.fitness(), e.evaluate(), target);
        }

    }

    private double evaluate(){
        char[] chars = expression.toCharArray();
        double result = compute(Character.toString(chars[0]), Character.toString(chars[1]), Character.toString(chars[2]));
        result = compute(Double.toString(result), Character.toString(chars[3]), Character.toString(chars[4]));
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Expression{");
        sb.append("expression='").append(expression).append('\'');
        sb.append('}');
        return sb.toString();
    }

    private double compute(String x, String op, String y){
        if(!op.matches("^[\\*\\/\\-\\+\\^]$")){
            throw new NumberFormatException();
        }
        try {
            switch (op) {
                case "*":
                    return Double.parseDouble(x) * Double.parseDouble(y);
                case "/":
                    return Double.parseDouble(x) / Double.parseDouble(y);
                case "-":
                    return Double.parseDouble(x) - Double.parseDouble(y);
                case "+":
                    return Double.parseDouble(x) + Double.parseDouble(y);
                case "^":
                    return Math.pow(Double.parseDouble(x), Double.parseDouble(y));
                default: throw new NumberFormatException();
            }
        }catch(Exception e){
            throw new NumberFormatException();
        }
    }

    public double fitness() {
        Double result;
        try {
            result = evaluate();
        }catch(NumberFormatException e){
            return 1990000;
        }
        if(result == target){
            return 0;
        }else{
            return Math.abs((result - target)/ 1);
        }
    }
}
