package at.ikt.ckan.rest;

import static junit.framework.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import at.ikt.ckan.entities.PackageMeta;
import at.ikt.ckan.util.DateAssert;

public class PackageMetaRestletResourceDateTimeTest {

	private RestletResourceFactory resourceFactory;

	@Before
	public void setUp() throws Exception {
		resourceFactory = new RestletResourceFactory("clap://class/",
				".ckan.json");
	}

	@Test
	public void testWithFileEuropeanaLod() throws ParseException {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("europeana-lod");
		PackageMeta packageMeta = packageMetaResource.get();

		System.out.println(packageMeta);

		assertNotNull(packageMeta.getMetadataCreated());
		assertNotNull(packageMeta.getMetadataModified());

		DateAssert.assertBetween(
				DateAssert.parseDateTime("2007-04-10T21:19:00"),
				DateAssert.parseDateTime("2007-04-10T21:20:00"),
				packageMeta.getMetadataCreated());
	}
	
	@Test
	@Ignore("since the date format is in nano seconds and Java does not understand by default")
	public void testWithFileEuropeanaLodMetaDateModified() throws ParseException {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("europeana-lod");
		PackageMeta packageMeta = packageMetaResource.get();

		System.out.println(packageMeta);
		assertNotNull(packageMeta.getMetadataModified());

		DateAssert.assertBetween(
				DateAssert.parseDateTime("2011-06-20T19:48:10"),
				DateAssert.parseDateTime("2011-06-20T19:48:20"),
				packageMeta.getMetadataModified());
	}
	
	

	@Test
	public void testWithFileOpenspendingExample() throws ParseException {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("openspending-example");
		PackageMeta packageMeta = packageMetaResource.get();
		
		assertNotNull(packageMeta.getMetadataCreated());
		assertNotNull(packageMeta.getMetadataModified());
		
		DateAssert.assertBetween(
				DateAssert.parseDateTime("2007-04-10T21:19:00"),
				DateAssert.parseDateTime("2007-04-10T21:20:00"),
				packageMeta.getMetadataCreated());
	}

	@Test
	public void testWithFileAiddata() throws ParseException {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("aiddata");
		PackageMeta packageMeta = packageMetaResource.get();
		
		assertNotNull(packageMeta.getMetadataCreated());
		assertNotNull(packageMeta.getMetadataModified());
		
		DateAssert.assertBetween(
				DateAssert.parseDateTime("2007-04-10T21:19:00"),
				DateAssert.parseDateTime("2007-04-10T21:20:00"),
				packageMeta.getMetadataCreated());
	}
}
