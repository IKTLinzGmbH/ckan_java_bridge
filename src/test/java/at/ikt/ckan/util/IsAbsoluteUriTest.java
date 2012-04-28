package at.ikt.ckan.util;

import org.junit.Test;

import static junit.framework.Assert.*;

public class IsAbsoluteUriTest {


	@Test
	public void testHttp() {
		assertTrue(UriHelper.isAbsoluteUri("http://data.linz.gov.at/api/rest/package/test"));
		assertTrue(UriHelper.isAbsoluteUri("https://data.linz.gov.at/api/rest/package/test"));
	}
	
	
	@Test
	public void testNotAbsolute() {
		assertFalse(UriHelper.isAbsoluteUri("/api/rest/package/test"));
		assertFalse(UriHelper.isAbsoluteUri("api/rest/package/test"));
		assertFalse(UriHelper.isAbsoluteUri("//api/rest/package/test"));
	}
	
	
	@Test
	public void testOtherProtocols() {
		assertTrue(UriHelper.isAbsoluteUri("ftp://data.linz.gov.at/api/rest/package/test"));
		assertTrue(UriHelper.isAbsoluteUri("hg+https://data.linz.gov.at/api/rest/package/test"));
		assertTrue(UriHelper.isAbsoluteUri("git+ssh://data.linz.gov.at/api/rest/package/test"));
	}
}
