package sort_tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortIO {
    public static Integer[] getData(String filename) throws Exception {
        Scanner inFile = new Scanner(new File(filename)).useDelimiter(",\\s*");
        List<Integer> temps = new ArrayList<Integer>();
        String first = inFile.next();
        first = first.substring(1);
        temps.add(Integer.parseInt(first));
        while (inFile.hasNext()) {
            try {
                Integer token1 = inFile.nextInt();
                temps.add(token1);
            }
            catch(Exception ex) {
                String last = inFile.next();
                last = last.substring(0, last.length() - 2);
                temps.add(Integer.parseInt(last));
            }
        }
        inFile.close();

        return temps.toArray(new Integer[0]);
    }

    public static void writeData(Integer[] list, String output) throws Exception {
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(output));
        outputWriter.write(Arrays.toString(list));
        outputWriter.close();
    }

    public static void writeMeas(long start, long stop, String file) throws Exception {
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(file));
        outputWriter.write(Long.toString(stop - start));
        outputWriter.close();
    }
}