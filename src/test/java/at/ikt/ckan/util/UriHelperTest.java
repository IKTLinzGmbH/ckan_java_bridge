package at.ikt.ckan.util;

import org.junit.Test;

import static junit.framework.Assert.*;

public class UriHelperTest {

	private static final String FULL_URI = "http://data.linz.gov.at/api/rest/package/test";
	private static final String RESOURCE_URI = "api/rest/package/test";
	private static final String HOST_URI = "http://data.linz.gov.at/";
	private static final String HOST_URI_2ND = "http://ckan.net/";
	private static final String PACKAGE_RESOURCE_URI = "http://data.linz.gov.at/api/rest/package/";
	

	@Test
	public void testWithBaseUriIsNull() {
		assertEquals(FULL_URI, UriHelper.concatUris(null, FULL_URI));
		
		assertEquals(RESOURCE_URI,
				UriHelper.concatUris(null, RESOURCE_URI));
		
		assertEquals(HOST_URI, UriHelper.concatUris(null, HOST_URI));
		
		assertEquals(HOST_URI_2ND, UriHelper.concatUris(null, HOST_URI_2ND));
	}

	@Test
	public void testWithBaseUriIsHostUri() {
		assertEquals(FULL_URI, UriHelper.concatUris(HOST_URI, FULL_URI));
		
		assertEquals(HOST_URI + RESOURCE_URI,
				UriHelper.concatUris(HOST_URI, RESOURCE_URI));
		
		assertEquals(HOST_URI, UriHelper.concatUris(HOST_URI, HOST_URI));
		
		assertEquals(HOST_URI_2ND, UriHelper.concatUris(HOST_URI, HOST_URI_2ND));
	}
	
	@Test
	public void testWithPackageOnly() {
		assertEquals(FULL_URI, UriHelper.concatUris(PACKAGE_RESOURCE_URI, "test"));		
	}
	
}
