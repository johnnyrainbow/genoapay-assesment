package genoapay;

import java.util.ArrayList;
import java.util.Collections;

public class ProfitCalculator {

	/*
	 * Suppose we could access yesterday's stock prices as a list, where: The
	 * indices are the time in minutes past trade opening time, which was 10:00am
	 * local time. The values are the price in dollars of the stock at that time. So
	 * if the stock cost $5 at 11:00am, stock_prices_yesterday[60] = 5. Write an
	 * efficient function that takes an array of stock prices and returns the best
	 * profit could have been made from 1 purchase and 1 sale of 1 stock.
	 * 
	 * You must buy before you sell. You may not buy and sell in the same time step
	 * (at least 1 minute must pass).
	 */

	public int getMaxProfit(int[] list) {
		int current_lowest_val = 0;
		int greatest_diff = 0;
		int lowest_diff = 0;

		if (list == null || list.length < 2) {
			return -1; // List requires not null and at least 2 values
		}

		current_lowest_val = list[0]; // Set to first value in list
		for (int i = 1; i < list.length; i++) {

			if (list[i] < current_lowest_val) { // If current value smaller than current lowest value
				current_lowest_val = list[i];
				int diff = list[i] - list[i - 1];

				if (greatest_diff == 0 && diff != 0) { // Account for decrement list scenario
					if (diff < lowest_diff) {
						lowest_diff = diff;
					}
				}
				continue;
			}

			// Check current value against current lowest value
			int diff = list[i] - current_lowest_val;
			if (diff > greatest_diff) {
				greatest_diff = diff; // Set new greatest diff
			}
		}

		if (greatest_diff == 0) { // Was a list of decrementing values, take the minimum loss
			greatest_diff = lowest_diff;
		}
		return greatest_diff;
	}

}
