package GA;

import org.apache.log4j.Logger;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


/**
 * @author devinmcgloin
 * @version 12/14/15.
 */
public class GA<E extends GAInterface<E>> {
    static Logger logger = Logger.getLogger(GA.class);
    static Random r = new Random();
    double mutation_rate = 0.001;
    int population = 1000;
    double crossover_rate = 0.7;
    int iterations = 1000;
    int select_amount = 8;
    E answer;
    ArrayList<String> init;
    Translator<E> t;

    public GA(Translator<E> t) {
        this.t = t;
    }

    public E getAnswer() {
        solve(init);
        return answer;
    }

    private ArrayList<String> reproduce(String a, String b, int subPop) {
        ArrayList<String> decendants = new ArrayList<>(subPop);

        char[] first, second;

        while (decendants.size() < subPop) {
            if (r.nextDouble() < crossover_rate) {
                String[] cross = cross(a, b);
                first = cross[0].toCharArray();
                second = cross[1].toCharArray();
            } else {
                first = a.toCharArray();
                second = b.toCharArray();
            }
            for (int i = 0; i < first.length; i++) {
                if (r.nextDouble() < mutation_rate) {
                    if (first[i] == '0') {
                        first[i] = '1';
                    } else {
                        first[i] = '0';
                    }
                }
                if (r.nextDouble() < mutation_rate) {
                    if (second[i] == '0') {
                        second[i] = '1';
                    } else {
                        second[i] = '0';
                    }
                }
            }
            decendants.add(Arrays.toString(first));
            decendants.add(Arrays.toString(second));
        }

        return decendants;
    }

    private ArrayList<String> generatePopulation(ArrayList<String> selected) {
        Collections.shuffle(selected);
        ArrayList<String> nextGen = new ArrayList<>();
        for (int i = 1; i < selected.size(); i++) {
            ArrayList<String> crossDecendants = reproduce(selected.get(i - 1), selected.get(i), population / selected.size());
            crossDecendants.forEach(nextGen::add);
        }
        return nextGen;
    }

    private ArrayList<String> select(ArrayList<String> totalPopulation) {
        ArrayList<Pair<Double, String>> populationFitness = new ArrayList<>(totalPopulation.size());
        for (String item : totalPopulation) {
            populationFitness.add(new Pair(t.decode(item).fitness(), item));
        }
        populationFitness.sort((a, b) -> a.getValue0().compareTo(b.getValue0()));
        ArrayList<String> selected = new ArrayList<>();
        for (Pair<Double, String> item : populationFitness.subList(0, select_amount)) {
            selected.add(item.getValue1());
            logger.debug(item);
        }
        return selected;
    }


    private String[] cross(String a, String b) {
        int crossIndex1 = r.nextInt(a.length());
        int crossIndex2 = r.nextInt(a.length());
        String a1, b1;
        if (crossIndex1 < crossIndex2) {
            a1 = a.substring(0, crossIndex1) + b.substring(crossIndex1, crossIndex2)
                    + a.substring(crossIndex2, a.length());
            b1 = b.substring(0, crossIndex1) + a.substring(crossIndex1, crossIndex2)
                    + b.substring(crossIndex2, a.length());
        } else {
            a1 = a.substring(0, crossIndex2) + b.substring(crossIndex2, crossIndex1)
                    + a.substring(crossIndex1, a.length());
            b1 = b.substring(0, crossIndex2) + a.substring(crossIndex2, crossIndex1)
                    + b.substring(crossIndex1, a.length());
        }
        return new String[]{a1, b1};
    }

    private void solve(ArrayList<String> l) {
        if (init.size() < 2) {
            throw new IllegalArgumentException("Initialization ArrayList must have more than 1 element");
        }

        l = generatePopulation(l);
        l = select(l);

        for (int i = 1; i <= iterations; i++) {
            l = select(generatePopulation(l));
            if (t.decode(l.get(0)).fitness() == 0) {
                System.out.printf("Solution found: \n%s\n", t.decode(l.get(0)));
                answer = t.decode(l.get(0));
            }
            if (i == iterations) {
                System.out.println("No solution found, please consider increasing iterations count.");
            }
        }
    }

}