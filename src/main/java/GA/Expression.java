package GA;


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
    int gene_count = 5;
    int target;


    public double fitness() {
        return 0.0;
    }

}
