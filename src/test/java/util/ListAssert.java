package util;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

public class ListAssert {
	public static void assertEquals(List<?> expected, List<?> actual) {
		Assert.assertEquals(expected.size(), actual.size());

		for (int i = 0; i < expected.size(); i++) {
			Assert.assertEquals(expected.get(i), actual.get(i));
		}
	}

	public static <T> void assertEquals(T[] expected, List<T> actual) {
		List<T> expectedList = new ArrayList<T>();
		for (T t : expected) {
			expectedList.add(t);
		}

		assertEquals(expectedList, actual);
	}

	public static <T> void assertEquals(T[] expected, T[] actual) {
		Assert.assertEquals(expected.length, actual.length);

		for (int i = 0; i < expected.length; i++) {
			Assert.assertEquals(expected[i], actual[i]);
		}
	}
}
