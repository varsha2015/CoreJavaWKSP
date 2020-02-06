package com.psl;

import java.util.Comparator;

public class CompareByCity implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		int i = c1.getCity().compareTo(c2.getCity());
		if (i == 0) {
			if (c1.getId() < c2.getId())
				return -1;
			else if (c1.getId() > c2.getId())
				return 1;
			else
				return 0;

		}
		return i;

	}
}
