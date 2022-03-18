import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SecretTable {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readLineSplit;
        Table table;
        int tableSize;
        int operationsQuantity;
        int operation;
        int x;
        int r;


        readLineSplit = br.readLine().split(" ");
        tableSize = Integer.parseInt(readLineSplit[0]);
        operationsQuantity = Integer.parseInt(readLineSplit[1]);

        table = new Table(tableSize);

        for (int i = 0; i < operationsQuantity; i++) {

            readLineSplit = br.readLine().split(" ");

            if (readLineSplit.length == 3) {
                operation = Integer.parseInt(readLineSplit[0]);
                x = Integer.parseInt(readLineSplit[1]);
                r = Integer.parseInt(readLineSplit[2]);
                if (operation == 1) {
                    table.updateRow(x, r);
                } else if (operation == 2) {
                    table.updateColumn(x, r);
                }
            } else if (readLineSplit.length == 2) {
                operation = Integer.parseInt(readLineSplit[0]);
                x = Integer.parseInt(readLineSplit[1]);
                if (operation == 3) {
                    System.out.println(table.printFrequentValueRow(x));
                } else if (operation == 4) {
                    System.out.println(table.printFrequentValueColumn(x));
                }
            }
        }
    }

    static class Table {
        private final int tableSize;
        private final int[][] table;
        private int maxKey;
        private int maxValue;

        public Table(int tableSize) {
            this.tableSize = tableSize;
            this.table = new int[tableSize][tableSize];
            this.maxKey = 0;
            this.maxValue = 0;
        }

        public void updateRow(int x, int r) {
            for (int i = 0; i < this.tableSize; i++) {
                this.table[x - 1][i] = r;
            }
        }

        public void updateColumn(int x, int r) {
            for (int i = 0; i < this.tableSize; i++) {
                this.table[i][x - 1] = r;
            }
        }

        public int printFrequentValueRow(int x) {
            HashMap<Integer, Integer> listMap = new HashMap<>();
            this.maxKey = 0;
            this.maxValue = 0;
            int r, v;
            for (int i = 0; i < this.tableSize; i++) {
                r = this.table[x - 1][i];
                if (listMap.containsKey(r)) {
                    v = listMap.get(r) + 1;
                    listMap.put(r, v);
                    setMaxEntry(r, v);
                } else {
                    listMap.put(r, 1);
                    setMaxEntry(r, 1);
                }
            }

            return getMaxKey();
        }

        public int printFrequentValueColumn(int x) {
            HashMap<Integer, Integer> listMap = new HashMap<>();
            this.maxKey = 0;
            this.maxValue = 0;
            int r, v;
            for (int i = 0; i < this.tableSize; i++) {
                r = this.table[i][x - 1];
                if (listMap.containsKey(r)) {
                    v = listMap.get(r) + 1;
                    listMap.put(r, v);
                    setMaxEntry(r, v);
                } else {
                    listMap.put(r, 1);
                    setMaxEntry(r, 1);
                }
            }

            return getMaxKey();
        }

        private void setMaxEntry(int key, int value) {
            if (value > this.maxValue) {
                this.maxValue = value;
                this.maxKey = key;
            } else if (value == this.maxValue) {
                if (key > this.maxKey) {
                    this.maxKey = key;
                }
            }
        }

        private int getMaxKey() {
            return this.maxKey;
        }

    }
}