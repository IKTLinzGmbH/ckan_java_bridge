package at.ikt.ckan.rest;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;

import at.ikt.ckan.entities.PackageMeta;

public class ProxyTest {

	@Before
	public void setUp() throws Exception {
		System.setProperty("proxyUsername", "ikt09000027");
		System.setProperty("proxyPassword", "solvistas@IKT");
	}
	
	@Test
	@Ignore
	public void testJustRestlet() {	
		Client client = new Client(new Context(),Protocol.HTTP);
		client.getContext().getParameters().add("useForwardedForHeader","false");
		client.getContext().getParameters().add("proxyHost","clisa.linz.at");
		client.getContext().getParameters().add("proxyPort","8080");
		
		
		ClientResource cr = new ClientResource("http://ckan.net/api/rest/package/europeana-lod");
		cr.setNext(client);
		
		
		// Get the Contact object
		PackageMetaRestletResource pmr = cr.wrap(PackageMetaRestletResource.class);
		PackageMeta packageMeta =  pmr.get();
		
		System.out.println(packageMeta);
	}
	
	@Test
	public void testWithFile() {
		ClientResource cr = new ClientResource("clap://class/europeana-lod.ckan.json");
		PackageMetaRestletResource pmr = cr.wrap(PackageMetaRestletResource.class);
		PackageMeta packageMeta =  pmr.get();
		
		System.out.println(packageMeta);
	}
}
