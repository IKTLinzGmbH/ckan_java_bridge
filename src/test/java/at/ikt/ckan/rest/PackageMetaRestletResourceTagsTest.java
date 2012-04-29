package at.ikt.ckan.rest;

import org.junit.Before;
import org.junit.Test;

import at.ikt.ckan.entities.PackageMeta;
import at.ikt.ckan.util.ListAssert;

public class PackageMetaRestletResourceTagsTest {

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

		ListAssert.assertEquals(
				new String[] { "culturalheritage", "culture", "eu", "europe",
						"europeana", "lod", "metadata", "rdf", "sparql" },
				packageMeta.getTags());
	}

	@Test
	public void testWithFileOpenspendingExample() {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("openspending-example");
		PackageMeta packageMeta = packageMetaResource.get();

		ListAssert.assertEquals(new String[] { "lbhf", "sample" },
				packageMeta.getTags());
	}

	@Test
	public void testWithFileAiddata() {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("aiddata");
		PackageMeta packageMeta = packageMetaResource.get();

		ListAssert.assertEquals(new String[] { "aid-2010", "aid-size-large",
				"development", "development-foreign",
				"donor-recipient-oda-international", "environmental",
				"international-development" }, packageMeta.getTags());
	}
}
