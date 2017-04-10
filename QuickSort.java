import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import java.lang.*;
class QuickSort {
    private int length;


    public static void main(String[] args) {
        List<Integer> toSort = load();
        QuickSort Sorter = new QuickSort();
        long tStart = System.currentTimeMillis();
        Sorter.sort(toSort);
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        System.out.print(elapsedSeconds);
    }
    private static List<Integer> load() {
        List<Integer> list = new ArrayList<Integer>();
        File file = new File("three_millions.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                list.add(Integer.parseInt(text));
            }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        //print out the list
        return list;
    }
    private void sort(List<Integer> toSort) {
        length = toSort.size();
        quickSort(0, length - 1, toSort);
    }
    private void quickSort(int x, int y, List<Integer> toSort) {
        int i = x;
        int j = y;
        int pivot = toSort.get(x+(y-x)/2);
        while (i <= j) {
            while (toSort.get(i) < pivot) {
                i++;
            }
            while (toSort.get(j) > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j, toSort);

                i++;
                j--;
            }
        }

        if (x < j)
            quickSort(x, j, toSort);
        if (i < y)
            quickSort(i, y, toSort);

    }
    private void exchangeNumbers(int i, int j, List<Integer> toSort) {
        int temp = toSort.get(i);
        toSort.set(i, j);
        toSort.set(j, temp);
    }
}
