package at.ikt.ckan.rest;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;

import at.ikt.ckan.entities.PackageMeta;

public class PackageMetaRestletResourceSimpleTest {

	private RestletResourceFactory resourceFactory;

	@Before
	public void setUp() throws Exception {
		resourceFactory = new RestletResourceFactory("clap://class/",
				".ckan.json");
	}

	@Test
	public void testWithFileEuropeanaLod() {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("europeana-lod");
		PackageMeta packageMeta = packageMetaResource.get();

		System.out.println(packageMeta);

		assertEquals("europeana-lod", packageMeta.getName());
		assertEquals("e6ed21f3-d92e-4156-99db-a76f82f48c29",
				packageMeta.getId());
		assertEquals("", packageMeta.getVersion());
		assertEquals("active", packageMeta.getState());

		assertEquals("Europeana Linked Open Data", packageMeta.getTitle());

		assertEquals("", packageMeta.getMaintainer());
		assertEquals("", packageMeta.getAuthor());

		assertNotNull(packageMeta.getNotes());
		assertNotNull(packageMeta.getNotesRendered());

		assertEquals("http://ckan.net/package/europeana-lod",
				packageMeta.getCkanUrl());
		assertNull(packageMeta.getDownloadUrl());
		assertEquals("http://data.europeana.eu/", packageMeta.getUrl());

		assertNull(packageMeta.getLicense());
		assertEquals("", packageMeta.getLicenseId());		
	}

	@Test
	public void testWithFileOpenspendingExample() {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("openspending-example");
		PackageMeta packageMeta = packageMetaResource.get();

		assertEquals("openspending-example", packageMeta.getName());
		assertEquals("32f38fab-bc2d-4e06-b32e-5173487f138d",
				packageMeta.getId());
		assertEquals("1.0", packageMeta.getVersion());

		assertEquals("Sample OpenSpending dataset", packageMeta.getTitle());

		assertEquals("", packageMeta.getMaintainer());
		assertEquals("Martin Keegan", packageMeta.getAuthor());

		assertEquals("http://ckan.net/package/openspending-example",
				packageMeta.getCkanUrl());
		assertEquals(
				"http://mk.ucant.org/info/data/sample-openspending-dataset.csv",
				packageMeta.getDownloadUrl());
		assertEquals(
				"http://mk.ucant.org/info/data/sample-openspending-dataset.csv",
				packageMeta.getUrl());

		assertEquals("OKD Compliant::UK Open Government Licence (OGL)",
				packageMeta.getLicense());
		assertEquals("uk-ogl", packageMeta.getLicenseId());
	}

	@Test
	public void testWithFileAiddata() {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("aiddata");
		PackageMeta packageMeta = packageMetaResource.get();

		assertEquals("aiddata", packageMeta.getName());
		assertEquals("e691ceae-4950-455d-8df2-4c9ca94d1a26",
				packageMeta.getId());
		assertEquals("AidData v1.1.r15", packageMeta.getVersion());

		assertEquals("AidData", packageMeta.getTitle());

		assertEquals("Development Gateway", packageMeta.getMaintainer());
		assertEquals("AidData.org", packageMeta.getAuthor());

		assertEquals("http://ckan.net/package/aiddata",
				packageMeta.getCkanUrl());
		assertEquals("http://s3.amazonaws.com/plaid19/plaid192.csv.zip",
				packageMeta.getDownloadUrl());
		assertEquals("http://www.aiddata.org/", packageMeta.getUrl());

		assertEquals("OKD Compliant::GNU Free Documentation License",
				packageMeta.getLicense());
		assertEquals("gfdl", packageMeta.getLicenseId());
	}
}
