package genoapay;

import org.junit.Assert;

class Tests {
	@org.junit.jupiter.api.Test
	void emptyListTest() {
		int[] stockPrices = {};

		ProfitCalculator pc = new ProfitCalculator();
		Assert.assertEquals(-1, pc.getMaxProfit(stockPrices));
	}

	@org.junit.jupiter.api.Test
	void nullListTest() {
		int[] stockPrices = null;

		ProfitCalculator pc = new ProfitCalculator();
		Assert.assertEquals(-1, pc.getMaxProfit(stockPrices));
	}

	@org.junit.jupiter.api.Test
	void singleValueTest() {
		int[] stockPrices = { 4 };

		ProfitCalculator pc = new ProfitCalculator();
		Assert.assertEquals(-1, pc.getMaxProfit(stockPrices));
	}

	@org.junit.jupiter.api.Test
	void testDefaultList() {
		int[] stockPrices = { 10, 7, 5, 8, 11, 9 };

		ProfitCalculator pc = new ProfitCalculator();
		Assert.assertEquals(6, pc.getMaxProfit(stockPrices));
	}

	@org.junit.jupiter.api.Test
	void testlargeList() {
		int[] stockPrices = { 52, 3, 0, 1, 12, 10, 7, 5, 8, 11, 9, 22, 3, 4, 3 };

		ProfitCalculator pc = new ProfitCalculator();
		Assert.assertEquals(22, pc.getMaxProfit(stockPrices));
	}

	@org.junit.jupiter.api.Test
	void testNegativeList() { // Although not really necessary since stock values should never be negative
		int[] stockPrices = { -10, 7, 5, 8, 11, 9 };

		ProfitCalculator pc = new ProfitCalculator();
		Assert.assertEquals(21, pc.getMaxProfit(stockPrices));
	}

	@org.junit.jupiter.api.Test
	void testSpecificList() {
		int[] stockPrices = { 100, 103, 105, 111, 139, 89, 62, 33, 35, 39 };

		ProfitCalculator pc = new ProfitCalculator();
		Assert.assertEquals(39, pc.getMaxProfit(stockPrices));
	}

	@org.junit.jupiter.api.Test
	void incrementTest() {
		int[] stockPrices = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

		ProfitCalculator pc = new ProfitCalculator();
		Assert.assertEquals(11, pc.getMaxProfit(stockPrices));
	}

	@org.junit.jupiter.api.Test
	void decrementTest() {
		int[] stockPrices = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

		ProfitCalculator pc = new ProfitCalculator();
		Assert.assertEquals(-1, pc.getMaxProfit(stockPrices));
	}

	@org.junit.jupiter.api.Test
	void identicalTest() {
		int[] stockPrices = { 1, 1, 1, 1 };

		ProfitCalculator pc = new ProfitCalculator();
		Assert.assertEquals(0, pc.getMaxProfit(stockPrices));
	}

	@org.junit.jupiter.api.Test
	void duplicatesTest() {
		int[] stockPrices = { 5, 5, 5, 5, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4 };

		ProfitCalculator pc = new ProfitCalculator();
		Assert.assertEquals(2, pc.getMaxProfit(stockPrices));
	}

	@org.junit.jupiter.api.Test
	void lossTest() {
		int[] stockPrices = { 62, 2 };

		ProfitCalculator pc = new ProfitCalculator();
		Assert.assertEquals(-60, pc.getMaxProfit(stockPrices));
	}

	@org.junit.jupiter.api.Test
	void gainTest() {
		int[] stockPrices = { 2, 992 };

		ProfitCalculator pc = new ProfitCalculator();
		Assert.assertEquals(990, pc.getMaxProfit(stockPrices));
	}
}
