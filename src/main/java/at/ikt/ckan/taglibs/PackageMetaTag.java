package at.ikt.ckan.taglibs;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import at.ikt.ckan.entities.PackageMeta;
import at.ikt.ckan.rest.PackageMetaRestletResource;
import at.ikt.ckan.rest.RestletResourceFactory;
import at.ikt.ckan.util.UriHelper;

/**
 * Is used to retrieve the information of one CKAN package.
 * 
 * <ckan:search var="result" baseUri="http://thedatahub.org/api" packageName="1996populationecumenecensusdatacanada" />
 * ... will store the result in variable "results" as {@link PackageMeta}
 * 
 * @see PackageMeta
 * @author maerzbow
 */
public class PackageMetaTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private String var;
	private String packageName;
	private String baseUri;

	@Override
	public int doStartTag() throws JspException {
		RestletResourceFactory factory = new RestletResourceFactory();
		PackageMetaRestletResource restletResource = factory
				.createPackageMetaResource(buildPackageUri(getPackageName()));

		PackageMeta result = restletResource.get();

		pageContext.setAttribute(getVar(), result);

		return SKIP_BODY;
	}

	public String buildPackageUri(String packageName) {
		return UriHelper.concatUris(baseUri, PackageMetaRestletResource.PACKAGE_URI + packageName);
	}
	
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setBaseUri(String baseUri) {
		this.baseUri = baseUri;
	}

	public String getBaseUri() {
		return baseUri;
	}
}