package org.example.Arrays;

import java.util.HashMap;
import java.util.Map;

//Contains Duplicate
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> countDups = new HashMap<>();

        //count the number of times each value appears in the array
        for (int i : nums) {
            if (countDups.containsKey(i)) {
                countDups.put(i, countDups.get(i) + 1);
            } else {
                countDups.put(i, 1);
            }
        }

        // iterates through the values in the Map
        // return true if any value has a count of at least 2.
        for (int count : countDups.values()) {
            if (count >= 2) {
                return true;
            }
        }
        return false;
    }
}
