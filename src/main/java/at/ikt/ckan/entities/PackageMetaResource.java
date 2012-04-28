package at.ikt.ckan.entities;

import java.util.Comparator;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;


/**
 * Holds information about one resource of {@link PackageMeta}
 * 
 *  A Json/Jackson Wrapper.
 * 
 * @author Markus Merzinger
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackageMetaResource {
	private String id;
	private String resourceGroupId;
	private String packageId;
	private String hash;
	private String description;
	private String format;
	private String url;
	private Integer position;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("resource_group_id")
	public String getResourceGroupId() {
		return resourceGroupId;
	}

	@JsonProperty("resource_group_id")
	public void setResourceGroupId(String resourceGroupId) {
		this.resourceGroupId = resourceGroupId;
	}

	@JsonProperty("package_id")
	public String getPackageId() {
		return packageId;
	}

	@JsonProperty("package_id")
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PackageMetaResource other = (PackageMetaResource) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PackageMetaResource [id=");
		builder.append(id);
		builder.append(", resourceGroupId=");
		builder.append(resourceGroupId);
		builder.append(", packageId=");
		builder.append(packageId);
		builder.append(", hash=");
		builder.append(hash);
		builder.append(", description=");
		builder.append(description);
		builder.append(", format=");
		builder.append(format);
		builder.append(", url=");
		builder.append(url);
		builder.append(", position=");
		builder.append(position);
		builder.append("]");
		return builder.toString();
	}


	public static class ByPositionComparator implements
			Comparator<PackageMetaResource> {

		@Override
		public int compare(PackageMetaResource pmr1, PackageMetaResource pmr2) {
			return pmr1.getPosition() != null ? pmr1.getPosition().compareTo(
					pmr2.getPosition()) : -1;
		}
	}
}
