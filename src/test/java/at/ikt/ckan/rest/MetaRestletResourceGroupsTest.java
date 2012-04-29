package at.ikt.ckan.rest;

import org.junit.Before;
import org.junit.Test;

import at.ikt.ckan.entities.PackageMeta;
import at.ikt.ckan.util.ListAssert;

public class MetaRestletResourceGroupsTest {

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
		ListAssert.assertEquals(new String[] {}, packageMeta.getGroups());
	}

	@Test
	public void testWithFileOpenspendingExample() {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("openspending-example");
		PackageMeta packageMeta = packageMetaResource.get();

		ListAssert.assertEquals(new String[] { "openspending" },
				packageMeta.getGroups());
	}

	@Test
	public void testWithFileAiddata() {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("aiddata");
		PackageMeta packageMeta = packageMetaResource.get();

		ListAssert.assertEquals(new String[] { "international-development" },
				packageMeta.getGroups());
	}
}
