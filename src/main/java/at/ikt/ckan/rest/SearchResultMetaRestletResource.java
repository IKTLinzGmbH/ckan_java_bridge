package at.ikt.ckan.rest;

import org.restlet.resource.Get;

import at.ikt.ckan.entities.SearchResultMeta;

/**
 * A RESTLET  Resource to handle {@link SearchResultMeta}
 * 
 * It is used to access the results of a CKAN query as {@link SearchResultMeta}. 
 * 
 * Usage:
 * ------
 * 
 * String queryString = ...;
 * String searchUri = SearchResultMetaRestletResource.SEARCH_URI + queryString;
 * 
 * SearchResultMetaRestletResource restletResource = factory
 * 				.createSearchResultMetaResource(searchUri);
 * 
 * SearchResultMeta listOfFoundPackagesResult = restletResource.get();
 * 
 * @see RestletResourceFactory
 * @author Markus Merzinger
 *
 */
public interface SearchResultMetaRestletResource {
	public static String SEARCH_URI = "/api/search/package?q=";
	
	@Get
	public SearchResultMeta get();
}
