package GA;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author devinmcgloin
 * @version 12/20/15.
 */
public class Expression implements GAInterface<Expression> {

    String expression = "";
    char[] possible = "0123456789-+/*^".toCharArray();
    HashMap<String, Character> table = new HashMap<>();
    int chromoLen = 5;
    int geneCount = 5;
    int target;
    HashMap<String, Character> translationMap = new HashMap<>();
    Translator<Expression> t = new Translator<Expression>() {
        @Override
        Expression decode(final String s) {
            StringBuffer buffer = new StringBuffer();
            int i = 0;
            while (i < s.length()) {
                buffer.append(translationMap.get(s.substring(i, i + chromoLen)));
                i += chromoLen;
            }
            return null;

        }
    };


    public Expression(int chromoLen, int geneCount, int target) {
        this.chromoLen = chromoLen;
        this.geneCount = geneCount;
        ArrayList<String> seq = Translator.genBinSeq(chromoLen);
        for (int i = 0; i < seq.size(); i++) {
            Character c = possible[i % (possible.length - 1)];
            translationMap.put(seq.get(i), c);
        }
    }

    public double fitness() {
        return 0.0;
    }
}
