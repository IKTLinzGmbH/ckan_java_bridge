package at.ikt.ckan.taglibs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.restlet.Context;

import at.ikt.ckan.entities.PackageMeta;
import at.ikt.ckan.entities.SearchResultMeta;
import at.ikt.ckan.rest.PackageMetaRestletResource;
import at.ikt.ckan.rest.RestletResourceFactory;
import at.ikt.ckan.rest.SearchResultMetaRestletResource;
import at.ikt.ckan.util.UriHelper;

/**
 * Is used to run a query against a CKAN instance.
 * 
 * <ckan:search var="results" baseUri="http://thedatahub.org/api" queryString="population" />
 * ... will store the result in variable "results" as List<PackageMeta>
 * 
 * @see PackageMeta
 * @author maerzbow
 */
public class SearchMetaTag extends TagSupport {
	private static final String EVICT_CACHE_URI_PARAM_NAME = "evict_cache";

	private static final long serialVersionUID = 1L;

	
	private String var;
	private String queryString;
	private String baseUri;
	private String searchUri;

	private boolean caching = true;
	private static Map<String, List<PackageMeta>> cache = new HashMap<String, List<PackageMeta>>();

	@Override
	public int doStartTag() throws JspException {
		handleEventualEvictCache();

		RestletResourceFactory factory = new RestletResourceFactory();

		Logger logger = Context.getCurrentLogger();


		String fullSearchUri = buildSearchUriToUse();

		logger.log(Level.FINEST, "fullSearchUri: " + fullSearchUri);

		List<PackageMeta> packageMetaList = null;

		// retrieving eventual data from cache
		if (caching) {
			packageMetaList = retrieveFromCache(fullSearchUri);
		}

		if (packageMetaList == null) {
			SearchResultMetaRestletResource restletResource = factory
					.createSearchResultMetaResource(fullSearchUri);

			logger.log(Level.FINEST,
					"restletResource: " + restletResource.toString());

			SearchResultMeta listOfFoundPackagesResult = restletResource.get();

			logger.log(Level.FINEST, "listOfFoundPackagesResult: "
					+ listOfFoundPackagesResult);

			packageMetaList = new ArrayList<PackageMeta>();

			for (String packageName : listOfFoundPackagesResult.getResults()) {
				packageMetaList.add(retrievePackageMeta(packageName, factory));
			}

			logger.log(Level.FINEST, "packageMetaList: " + packageMetaList);

			if (caching) {
				storeInCache(fullSearchUri, packageMetaList);
			}
		} else {
			logger.log(Level.FINEST, "packageMetaList retrieved from cache : "
					+ packageMetaList);
		}

		pageContext.setAttribute(getVar(), packageMetaList);
		pageContext.setAttribute("searchUri", fullSearchUri);

		return SKIP_BODY;
	}

	private void handleEventualEvictCache() {
		if (pageContext.getRequest().getParameterMap()
				.containsKey(EVICT_CACHE_URI_PARAM_NAME)) {
			cache = new HashMap<String, List<PackageMeta>>();
		}
	}

	private List<PackageMeta> retrieveFromCache(String fullSearchUri) {
		return cache.get(fullSearchUri);
	}

	private void storeInCache(String fullSearchUri,
			List<PackageMeta> packageMetaList) {
		cache.put(fullSearchUri, packageMetaList);
	}

	public String buildSearchUriToUse() {
		String searchUri = getSearchUri() != null ? getSearchUri()
				: SearchResultMetaRestletResource.SEARCH_URI;

		String uri = UriHelper.concatUris(getBaseUri(), searchUri
				+ getQueryString());
		return uri;
	}

	public String buildPackageUri(String packageName) {
		String uri = UriHelper.concatUris(getBaseUri(),
				PackageMetaRestletResource.PACKAGE_URI + packageName);
		return uri;
	}

	protected PackageMeta retrievePackageMeta(String packageName,
			RestletResourceFactory factory) {
		PackageMetaRestletResource packageMetaRestletResource = factory
				.createPackageMetaResource(buildPackageUri(packageName));

		return packageMetaRestletResource.get();
	}

	public void setSearchUri(String searchUri) {
		this.searchUri = searchUri;
	}

	public String getSearchUri() {
		return searchUri;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setBaseUri(String baseUri) {
		this.baseUri = baseUri;
	}

	public String getBaseUri() {
		return baseUri;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getQueryString() {
		return queryString;
	}

	public boolean isCaching() {
		return caching;
	}

	public void setCaching(boolean caching) {
		this.caching = caching;
	}
}