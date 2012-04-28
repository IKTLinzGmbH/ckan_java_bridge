package at.ikt.ckan.rest;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import at.ikt.ckan.entities.PackageMeta;
import at.ikt.ckan.entities.PackageMetaResource;

public class PackageMetaRestletResourceResourcesTest {

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

		assertEquals(0, packageMeta.getResources().size());
		assertEquals(0, packageMeta.getResourcesOrderedByPosition().size());
	}

	@Test
	public void testWithFileOpenspendingExample() {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("openspending-example");
		PackageMeta packageMeta = packageMetaResource.get();

		assertEquals(2, packageMeta.getResources().size());
		assertEquals(2, packageMeta.getResourcesOrderedByPosition().size());

		PackageMetaResource pmr0 = packageMeta.getResourcesOrderedByPosition()
				.get(0);
		PackageMetaResource pmr1 = packageMeta.getResourcesOrderedByPosition()
				.get(1);

		assertEquals("7c22f698-b937-4b47-a9bc-788663baeb80", pmr1.getId());
		assertEquals("32f38fab-bc2d-4e06-b32e-5173487f138d",
				pmr1.getPackageId());
		assertEquals("2bf72f8e-8cca-41eb-9bc4-8e26fb3fea07",
				pmr0.getResourceGroupId());

		assertEquals("", pmr1.getHash());
		assertEquals("Mapping metadata", pmr1.getDescription());
		assertEquals("text/x-osmapping-csv", pmr1.getFormat());
		assertEquals(
				"https://spreadsheets.google.com/spreadsheet/ccc?key=0AkwRl6JWX8tkdERZTm0tQVpDcmZvcC1LYUxDVjZEcnc&hl=en_US#gid=0",
				pmr1.getUrl());
		assertEquals(Integer.valueOf(1), pmr1.getPosition());

		assertFalse(pmr0.equals(pmr1));
		assertFalse(pmr0.hashCode() == pmr1.hashCode());

	}

	@Test
	public void testWithFileAiddata() {
		PackageMetaRestletResource packageMetaResource = resourceFactory
				.createPackageMetaResource("aiddata");
		PackageMeta packageMeta = packageMetaResource.get();

		assertEquals(4, packageMeta.getResources().size());
		assertEquals(4, packageMeta.getResourcesOrderedByPosition().size());

		PackageMetaResource pmr0 = packageMeta.getResourcesOrderedByPosition()
				.get(0);
		PackageMetaResource pmr1 = packageMeta.getResourcesOrderedByPosition()
				.get(1);

		assertEquals("5f273ad4-b1cf-45c3-99ee-5c2e2c7a0e5f", pmr0.getId());
		assertEquals("e691ceae-4950-455d-8df2-4c9ca94d1a26",
				pmr0.getPackageId());
		assertEquals("5a19ba28-1af2-4f08-3ac2-5ddd41029a7e",
				pmr0.getResourceGroupId());

		assertEquals("", pmr0.getHash());
		assertEquals("Research Release (periodic static version of database)",
				pmr0.getDescription());
		assertEquals("zip:csv", pmr0.getFormat());
		assertEquals("http://s3.amazonaws.com/plaid19/plaid192.csv.zip",
				pmr0.getUrl());
		assertEquals(Integer.valueOf(0), pmr0.getPosition());

		assertFalse(pmr0.equals(pmr1));
		assertFalse(pmr0.hashCode() == pmr1.hashCode());
	}
}
