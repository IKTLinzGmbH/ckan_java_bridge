package at.ikt.ckan.rest;

import org.restlet.resource.ClientResource;

/**
 * A Factory that helps you to create RESTLET resource handlers
 * 
 * @author Markus Merzinger
 */
public class RestletResourceFactory {
	private String baseUri = "";
	private String uriPrefix = "";

	/**
	 * create a {@link RestletResourceFactory}
	 */
	public RestletResourceFactory() {
	}

	/**
	 * create a {@link RestletResourceFactory}
	 * 
	 * @param baseUri eg. "http://thedatahub.org/api"
	 */
	public RestletResourceFactory(String baseUri) {
		super();
		this.baseUri = baseUri;
	}
   
	/**
	 * create a {@link RestletResourceFactory}
	 * 
	 * @param baseUri eg. "http://thedatahub.org/api"
	 * @param uriPrefix eg ".json"
	 */
	public RestletResourceFactory(String baseUri, String uriPrefix) {
		super();
		this.baseUri = baseUri;
		this.uriPrefix = uriPrefix;
	}
   
	/**
	 * @param resourceLocator
	 * @return a {@link PackageMetaRestletResource} addressed by the resourceLocator
	 */
	public PackageMetaRestletResource createPackageMetaResource(
			String resourceLocator) {
		ClientResource cr = new ClientResource(
				createResourceUri(resourceLocator));

		return cr.wrap(PackageMetaRestletResource.class);
	}

	/**
	 * @param resourceLocator
	 * @return {@link SearchResultMetaRestletResource} addressed by the resourceLocator
	 */
	public SearchResultMetaRestletResource createSearchResultMetaResource(
			String resourceLocator) {
		ClientResource cr = new ClientResource(
				createResourceUri(resourceLocator));

		return cr.wrap(SearchResultMetaRestletResource.class);
	}

	/**
	 * @param resourceLocator 
	 * @return baseUri + resourceLocator + uriPrefix
	 */
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
