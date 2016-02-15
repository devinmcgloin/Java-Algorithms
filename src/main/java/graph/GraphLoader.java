package graph;

import dataStructures.Graph;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author devinmcgloin
 * @version 2/15/16.
 */
public class GraphLoader {
    static Logger logger = Logger.getLogger(Dijkstra.class);


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
