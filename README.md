# CKAN Java Bridge

## Introduction

This code has its origin in the [Open Data - Linz](http://data.linz.gv.at/) project. 

It is a _Java interface_ using [Restlet](http://www.restlet.org/) to access the [CKAN](http://ckan.org/) rest api.  
Information about the _CKAN_ API can be found [here](http://docs.ckan.org/en/latest/api-tutorial.html).

* It enables you to retrieve _package_ information and associated _resource_ information from any _CKAN_ instance
* _JSP taglibs_  to render that information


## Usage 

### Retrieving package information

``` java
String packageName = ...;
String uri = UriHelper.concatUris(baseUri, PackageMetaRestletResource.PACKAGE_URI + packageName);

RestletResourceFactory factory = new RestletResourceFactory();   
	    PackageMetaRestletResource restletResource = factory
			.createPackageMetaResource(uri);

PackageMeta result = restletResource.get();
```


### Searching for packages

``` java
String queryString = ...;
String searchUri = SearchResultMetaRestletResource.SEARCH_URI + queryString;

SearchResultMetaRestletResource restletResource = factory
				.createSearchResultMetaResource(searchUri);

SearchResultMeta listOfFoundPackagesResult = restletResource.get();
```


## Credits

* [Open Data - Linz](http://data.linz.gv.at/)
* [IKT Linz GmbH](http://www.linz.at/politik_verwaltung/44530.asp)
* with some help of [solvistas GmbH](www.solvistas.at)
* thanks to [Open Knowledge Foundation](http://okfn.org/) for developing [CKAN](http://ckan.org/) 


## License

The code is licensed under [Mozilla Public License](http://www.mozilla.org/MPL/).  
Please contact [Open Data - Linz](http://data.linz.gv.at/) for questions. 