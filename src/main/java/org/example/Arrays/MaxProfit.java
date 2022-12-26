package org.example.Arrays;

// Best Time to Buy and Sell Stock II

//input to the function is an array of integers representing the stock prices on successive days
//returns an integer representing the maximum profit by buying and selling the stock on some of the successive days.

//Peak Valley Approach
//Complexity Analysis
//Time complexity : O(n). Single pass.
//Space complexity: O(1). Constant space needed.
class MaxProfit {
    public int maxProfit(int[] prices) {
        //iterating through the array of stock prices and
        //keeping track of the minimum price seen so far (the "valley") and
        int minPrice = prices[0];
        //the maximum price seen so far (the "peak").
        int maxPrice = prices[0];

        int maxProfit = 0;
        //Whenever a new peak is found that is higher than the current peak,
        //the difference between the new peak and the current valley is added to the maximum profit.

        //the loop will continue until i has reached the second-to-last element in the array.
        //example,prices array has 5 elements, valid indices for the elements are 0, 1, 2, 3, and 4.
        //if loop were allowed to continue until i reached the value of prices.length, it would try to access the element at index 5, which does not exist.
        //By stopping the loop at i < prices.length - 1, we ensure that the loop does not go out of bounds and try to access an invalid element.
        for (int i = 0; i < prices.length - 1; ) {

            //as long as i is less than the length of the prices array minus 1 and
            //the current price is greater than or equal to the next price.
            //purpose of this loop is to find the next "valley" in the sequence of prices.
            while(i < prices.length -1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            // will be pointing to the next valley in the sequence of prices
            //assigns the value of prices[i] (the current valley) to the valley variable.
            minPrice = prices[i];

            //as long as i is less than the length of the prices array minus 1 and the current price is less than or equal to the next price.
            while(i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            //will be pointing to the next peak in the sequence of prices.
            maxPrice = prices[i];

            //add difference between the current maximum price and minimum price to the maxProfit variable.
            maxProfit += maxPrice - minPrice;

        }

        //repeated until the end of the array is reached, at which point the maximum profit is returned.
        return maxProfit;
    }



    //Complexity Analysis
    //Time complexity : O(n). Single pass.
    //Space complexity: O(1). Constant space needed.

    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
