package at.ikt.ckan.rest;

import org.restlet.resource.Get;

import at.ikt.ckan.entities.PackageMeta;

/**
 * A RESTLET  Resource to handle {@link PackageMeta}
 * should be used with URI "/api/rest/package/" 
 * 
 * It is used to access the data of a CKAN package as {@link PackageMeta}
 * 
 * Usage:
 * ------
 * 
 * String packageName = ...;
 * String uri = UriHelper.concatUris(baseUri, PackageMetaRestletResource.PACKAGE_URI + packageName);
 * 
 * RestletResourceFactory factory = new RestletResourceFactory();   
 * 	    PackageMetaRestletResource restletResource = factory
 * 			.createPackageMetaResource(uri);
 * 
 * PackageMeta result = restletResource.get();
 * 
 * @see RestletResourceFactory
 * @author Markus Merzinger
 *
 */
public interface PackageMetaRestletResource {
	public static String PACKAGE_URI = "/api/rest/package/";
	
	@Get
	public PackageMeta get();
}