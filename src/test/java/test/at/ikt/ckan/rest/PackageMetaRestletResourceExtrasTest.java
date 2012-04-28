package at.ikt.ckan.rest;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import at.ikt.ckan.entities.PackageMeta;

public class PackageMetaRestletResourceExtrasTest {

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

		assertEquals(0, packageMeta.getExtras().size());
	}

	@Test
	public void testWithFileOpenspendingExample() {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("openspending-example");
		PackageMeta packageMeta = packageMetaResource.get();


		assertEquals(5, packageMeta.getExtras().size());
		
		assertEquals("Value 3", packageMeta.getExtras().get("key-3"));
		assertEquals("Value 1", packageMeta.getExtras().get("Key 1"));
		assertEquals("5000", packageMeta.getExtras().get("links:freebase"));
		assertNull(packageMeta.getExtras().get("notthere"));
	}

	@Test
	public void testWithFileAiddata() {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("aiddata");
		PackageMeta packageMeta = packageMetaResource.get();


		assertEquals(0, packageMeta.getExtras().size());
		
		
	}
}
