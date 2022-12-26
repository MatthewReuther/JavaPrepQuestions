package org.example.Arrays;

import java.util.HashSet;
import java.util.Set;

//Single Number
class SingleNumber {
    public int singleNumber(int[] nums) {

        Set<Integer> numsSet = new HashSet<>();

        //any element that appears more than once will be added to the Set only once
        for (int number : nums) {
            //if the number is already in the Set,
            if (numsSet.contains(number)) {
                //remove the number from the Set
                numsSet.remove(number);
            } else {
                //add the number to the Set
                numsSet.add(number);
            }
        }

        return numsSet.iterator().next();
    }
}
