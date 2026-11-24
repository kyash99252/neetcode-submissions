class MyHashMap {
    List<int[]> map;

    public MyHashMap() {
        this.map = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        if (get(key) == -1) {
            map.add(new int[]{key, value});
        } else {
            for (int i = 0; i < map.size(); i++) {
                if (map.get(i)[0] == key) {
                    map.get(i)[1] = value;
                }
            }
        }
    }
    
    public int get(int key) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i)[0] == key) {
                return map.get(i)[1];
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i)[0] == key) {
                map.remove(i);
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */