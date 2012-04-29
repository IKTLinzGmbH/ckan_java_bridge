package at.ikt.ckan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import junit.framework.Assert;

public class DateAssert {
	private static final SimpleDateFormat DATETIME_DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss" );
	
	static {
		DATETIME_DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));
	}
	
	

	public static Date parseDateTime(String dateTime) throws ParseException {
		return DATETIME_DATE_FORMAT.parse(dateTime);
	}

	public static void assertAfter(Date border, Date actual) {
		Assert.assertTrue("actual time must be after border",
				actual.after(border));
	}

	public static void assertBefore(Date border, Date actual) {
		Assert.assertTrue("actual time must be before border",
				actual.before(border));
	}

	public static void assertBetween(Date lowerBorder, Date upperBorder,
			Date actual) {
		assertAfter(lowerBorder, actual);
		assertBefore(upperBorder, actual);
	}
}
