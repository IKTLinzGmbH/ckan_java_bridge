package at.ikt.ckan.rest;

import org.restlet.resource.Get;

import at.ikt.ckan.entities.SearchResultMeta;

/**
 * A RESTLET  Resource to handle {@link SearchResultMeta}
 * 
 * @author Markus Merzinger
 *
 */
public interface SearchResultMetaRestletResource {
	public static String SEARCH_URI = "/api/search/package?q=";
	
	@Get
	public SearchResultMeta get();
}
