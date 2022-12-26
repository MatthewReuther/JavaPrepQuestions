package org.example.Strings;

import java.util.HashMap;
import java.util.Map;

//getOrDefault() method of Map returns value of specific key or a default value if the key is not present in the map
//Time Complexity is O(n)... n is the length of the string.
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {

        //Create a map with key (Characters of string) and value (amount of times character appears in string)
        Map<Character, Integer> charCounterMap = new HashMap<Character, Integer>();

        //for every character (element) in the string
        for (char character : s.toCharArray()) {
            //add character to charCounterMap, if character (key) not already present, default value to 0 and then increment character count by 1
            //if character already present increment character count by 1
            charCounterMap.put(character, charCounterMap.getOrDefault(character, 0) + 1);
        }

        //for every character in provided string
        for (int i = 0; i < s.length(); i++) {
            //get the character (value of index) of the current index in string you are at.
            char character = s.charAt(i);
            //using the current character as the key, get count (value) of times it appears in string from charCounterMap
            //if it equals 1 return the current index in string
            if (charCounterMap.get(character) == 1) {
                //return that
                return i;
            }
        }
        //if no repeating numbers return -1;
        return -1;
    }
}
