package at.ikt.ckan.util;

import java.util.regex.Pattern;

/**
 * includes helper methods to handle URIs
 * 
 * @author Markus Merzinger
 */
public class UriHelper {
	private static final Pattern ABSOLUTE_URI_PATTERN = Pattern
			.compile(".*://.*");

	/**
	 * if the given uri is absolute then this will be returned. if not, it will
	 * concatenated with the given baseUri
	 * 
	 * @param baseUri
	 *            might be a given prefix uri. used if uri is relative
	 * @param uri
	 *            an uri that might be absolute or relative
	 * 
	 * @return a concatenated absolute URI
	 */
	public static String concatUris(String baseUri, String uri) {
		if (baseUri != null) {
			return isAbsoluteUri(uri) ? uri : baseUri + uri;
		} else {
			return uri;
		}
	}

	/**
	 * @param uri
	 * @return true if the given uri follows the regex pattern ".*://.*"
	 */
	public static boolean isAbsoluteUri(String uri) {
		return ABSOLUTE_URI_PATTERN.matcher(uri).matches();
	}
}
