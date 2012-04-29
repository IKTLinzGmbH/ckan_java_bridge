package at.ikt.ckan.entities;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Entity object that holds information for a CKAN package resource.
 * 
 * Normally accessed vie REST using '.../api/search/package?q={query}'
 * 
 * A Json Wrapper
 * 
 * @author Markus Merzinger
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultMeta {
	private String[] results;
	private Integer count;

	public String[] getResults() {
		return results;
	}

	public void setResults(String[] results) {
		this.results = results;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "SearchResultMeta [results="
				+ Arrays.toString(results) + ", count=" + count + "]";
	}
}
