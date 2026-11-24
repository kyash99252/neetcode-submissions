class MyHashSet {
    List<Integer> set;

    public MyHashSet() {
        this.set = new ArrayList<>();
    }
    
    public void add(int key) {
        if (!contains(key)) {
            set.add(key);
        }
    }
    
    public void remove(int key) {
        if (!contains(key)) return;

        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) == key) {
                set.remove(i);
            }
        }
    }
    
    public boolean contains(int key) {
        if (set.size() == 0) { return false; }

        for (int i = 0; i < set.size(); i++) {
            if (key == set.get(i)) { return true; }
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */