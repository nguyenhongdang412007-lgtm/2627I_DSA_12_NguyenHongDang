public static int pairs(int k, List<Integer> arr) {
    HashSet<Long> set = new HashSet<>();

    for (int x : arr) {
        set.add((long) x);
    }

    int count = 0;

    for (int x : arr) {
        if (set.contains((long) x + k)) {
            count++;
        }
    }

    return count;
}
