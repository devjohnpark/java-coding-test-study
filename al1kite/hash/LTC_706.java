class MyHashMap {
    private static final int MAX_KEY = 1_000_000;
    private static final int EMPTY = -1;

    private final int[] table;

    public MyHashMap() {
        table = new int[MAX_KEY + 1];
        java.util.Arrays.fill(table, EMPTY);
    }

    public void put(int key, int value) {
        table[key] = value;
    }

    public int get(int key) {
        return table[key];
    }

    public void remove(int key) {
        table[key] = EMPTY;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */