package com.Ecom_Express.utilities;

import org.testng.annotations.DataProvider;

public class DBDataProvider {

	@DataProvider(name = "agentIds")
	public Object[][] getAgentIds() {

		return new Object[][] {
				{1},
				{2},
				{3},
				{4}
		};
	}
}