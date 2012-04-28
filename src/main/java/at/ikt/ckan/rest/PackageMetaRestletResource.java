package at.ikt.ckan.rest;

import org.restlet.resource.Get;

import at.ikt.ckan.entities.PackageMeta;

/**
 * A RESTLET  Resource to handle {@link PackageMeta}
 * should be used with URI "/api/rest/package/" 
 * 
 * @author Markus Merzinger
 *
 */
public interface PackageMetaRestletResource {
	public static String PACKAGE_URI = "/api/rest/package/";
	
	@Get
	public PackageMeta get();
}