package org.example.Strings;

class ReverseString {
    public void reverseString(char[] s) {

        //Assign Pointers
        int start = 0;
        //Get the index of the Last Character
        int end = s.length - 1;

        //As long as start is less than end, want pointers to meet in middle
        while (start < end) {
            //set current to store the current value of the start index
            char currStart = s[start];

            //assign the value of the end index, to the value of the start index
            s[start] = s[end];

            //assign the value of currStart index, to the value of the end index
            s[end] = currStart;

            //To have pointers meet in middle
            //increment start index by 1
            start++;
            //decrement end index by 1
            end--;
        }
    }
}
