package dataStructures.graph;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * todo would like to add other formats for unweighted graphs, or where you can define multiple edges on one line.
 * @author devinmcgloin
 * @version 2/15/16.
 */
public class GraphLoader {
    static Logger logger = Logger.getLogger(GraphLoader.class);


    /**
     * loads a graph in which each line is a value of the graph type, a double then another value.
     * This indicates a link from a to c with a weight of b.
     * a b c
     *
     * @param g
     * @param path
     */
    public static void loadGraph(Graph<String> g, String path) {
        File f = new File(path);
        Scanner scanner;
        try {
            scanner = new Scanner(f);
        } catch (FileNotFoundException e) {
            logger.error(String.format("Please ensure that file exists. \n%s", f.toString()));
            return;
        }
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.isEmpty())
                continue;
            String[] items = line.split(" ");
            g.addEdge(items[0], Double.valueOf(items[1]), items[2]);
        }
    }
}
