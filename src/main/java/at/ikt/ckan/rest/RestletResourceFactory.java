package at.ikt.ckan.rest;

import org.restlet.resource.ClientResource;

/**
 * A Factory that helps you to create RESTLET resource handlers
 * 
 * @author Markus Merzinger
 * 
 */
public class RestletResourceFactory {
	private String baseUri = "";
	private String uriPrefix = "";

	public RestletResourceFactory() {
	}

	public RestletResourceFactory(String baseUri) {
		super();
		this.baseUri = baseUri;
	}

	public RestletResourceFactory(String baseUri, String uriPrefix) {
		super();
		this.baseUri = baseUri;
		this.uriPrefix = uriPrefix;
	}

	public PackageMetaRestletResource createPackageMetaResource(
			String resourceLocator) {
		ClientResource cr = new ClientResource(
				createResourceUri(resourceLocator));

		return cr.wrap(PackageMetaRestletResource.class);
	}

	public SearchResultMetaRestletResource createSearchResultMetaResource(
			String resourceLocator) {
		ClientResource cr = new ClientResource(
				createResourceUri(resourceLocator));

		return cr.wrap(SearchResultMetaRestletResource.class);
	}

	protected String createResourceUri(String resourceLocator) {
		return baseUri + resourceLocator + uriPrefix;
	}

	public String getBaseUri() {
		return baseUri;
	}

	public String getUriPrefix() {
		return uriPrefix;
	}
}
