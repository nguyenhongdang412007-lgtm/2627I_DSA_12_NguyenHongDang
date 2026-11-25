public static List<Integer> missingNumbers(
        List<Integer> arr, List<Integer> brr) {

    HashMap<Integer, Integer> freq = new HashMap<>();

  
    for (int x : brr) {
        freq.put(x, freq.getOrDefault(x, 0) + 1);
    }

   
    for (int x : arr) {
        freq.put(x, freq.getOrDefault(x, 0) - 1);
    }

    List<Integer> result = new ArrayList<>();

    for (int x : freq.keySet()) {
        if (freq.get(x) > 0) {
            result.add(x);
        }
    }

    Collections.sort(result);

    return result;
}
