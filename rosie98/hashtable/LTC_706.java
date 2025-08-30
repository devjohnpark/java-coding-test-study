class MyHashMap {
    Map<Integer, Integer> hashMap;

    public MyHashMap() {
        hashMap = new HashMap<>();
    }
    
    public void put(int key, int value) {
        hashMap.put(key, value);
    }
    
    public int get(int key) {
        if (hashMap.get(key) == null) {
            return -1;
        }

        return hashMap.get(key);
    }
    
    public void remove(int key) {
        hashMap.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */