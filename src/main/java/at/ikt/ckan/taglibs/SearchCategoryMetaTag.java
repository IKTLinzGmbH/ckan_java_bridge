package at.ikt.ckan.taglibs;

import at.ikt.ckan.util.UriHelper;

public class SearchCategoryMetaTag extends SearchMetaTag {
	private static final long serialVersionUID = 1L;

	private static String SEARCH_URI = "/api/search/package?Kategorie=";

	private String cmsCategory;

	@Override
	public String buildSearchUriToUse() {
		String uri = UriHelper.concatUris(getBaseUri(), SEARCH_URI
				+ getCmsCategory());
		return uri;
	}

	public String getCmsCategory() {
		return cmsCategory;
	}

	public void setCmsCategory(String cmsCategory) {
		this.cmsCategory = cmsCategory;
	}
}
