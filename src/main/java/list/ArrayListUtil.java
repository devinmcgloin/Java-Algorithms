package list;

import java.util.ArrayList;

/**
 * Created by devinmcgloin on 9/14/15.
 */
public class ArrayListUtil {

    /**
     * TODO currently not dealing with duplicates of 3 in a row or more.
     *
     * @param list
     * @param <T>
     *
     * @return
     */
    public static <T> boolean duplicate(ArrayList<T> list) {
        boolean modified = false;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (j == i) {
                    continue;
                }
                if (list.get(i).equals(list.get(j))) {
                    modified = true;
                    list.remove(j);
                    j = j--;
                } else {
                    break;
                }
            }
        }
        return modified;
    }

    public static void main(String[] args) {
        ArrayList<String> listOfStates = new ArrayList<String>();

        String[] list = {"Argentina", "Chile", "Chile", "Chile", "Czech Republic", "France", "Georgia", "India", "India", "Poland", "Romania", "Romania", "Romania"};

        for (String item : list) {
            listOfStates.add(item);
        }
        System.out.println(listOfStates);
        System.out.println(duplicate(listOfStates));
        System.out.println(listOfStates);

    }
}
