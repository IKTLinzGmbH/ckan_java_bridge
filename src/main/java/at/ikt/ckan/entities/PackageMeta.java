package at.ikt.ckan.entities;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Entity object that holds information for a CKAN package resource.
 * 
 * Normally accessed vie REST using '.../api/rest/package/{name}'
 * 
 * A Json/Jackson Wrapper
 * 
 * @author Markus Merzinger
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackageMeta {
	private String id;
	private String name;
	private String title;

	private String maintainer;
	private String maintainerEmail;

	private String author;
	private String authorEmail;

	private String state;
	private String version;

	private String license;
	private String licenseId;

	private String notesRendered;
	private String notes;

	private String url;
	private String ckanUrl;
	private String downloadUrl;

	private Date metadataCreated;
	private Date metadataModified;

	private List<PackageMetaResource> resources;

	private List<String> tags;
	private List<String> groups;

	private Map<String, String> extras;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMaintainer() {
		return maintainer;
	}

	public void setMaintainer(String maintainer) {
		this.maintainer = maintainer;
	}

	@JsonProperty("maintainer_email")
	public String getMaintainerEmail() {
		return maintainerEmail;
	}

	@JsonProperty("maintainer_email")
	public void setMaintainerEmail(String maintainerEmail) {
		this.maintainerEmail = maintainerEmail;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@JsonProperty("license_id")
	public String getLicenseId() {
		return licenseId;
	}

	@JsonProperty("license_id")
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@JsonProperty("notes_rendered")
	public String getNotesRendered() {
		return notesRendered;
	}

	@JsonProperty("notes_rendered")
	public void setNotesRendered(String notesRendered) {
		this.notesRendered = notesRendered;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("ckan_url")
	public String getCkanUrl() {
		return ckanUrl;
	}

	@JsonProperty("ckan_url")
	public void setCkanUrl(String ckanUrl) {
		this.ckanUrl = ckanUrl;
	}

	@JsonProperty("download_url")
	public String getDownloadUrl() {
		return downloadUrl;
	}

	@JsonProperty("download_url")
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	@JsonProperty("metadata_created")
	public Date getMetadataCreated() {
		return metadataCreated;
	}

	@JsonProperty("metadata_created")
	public void setMetadataCreated(Date metadataCreated) {
		this.metadataCreated = metadataCreated;
	}

	@JsonProperty("metadata_modified")
	public Date getMetadataModified() {
		return metadataModified;
	}

	@JsonProperty("metadata_modified")
	public void setMetadataModified(Date metadataModified) {
		this.metadataModified = metadataModified;
	}

	public List<PackageMetaResource> getResources() {
		return resources;
	}

	public List<PackageMetaResource> getResourcesOrderedByPosition() {
		Collections.sort(getResources(),
				new PackageMetaResource.ByPositionComparator());

		return resources;
	}

	public void setResources(List<PackageMetaResource> resources) {
		this.resources = resources;
	}

	/**
	 * @return a List of all tags assigned to this package
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            a List of all tags assigned to this package
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * @return a List of all groups assigned to this package
	 */
	public List<String> getGroups() {
		return groups;
	}

	/**
	 * @param a
	 *            List of all groups assigned to this package
	 */
	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	/**
	 * @return a Map<key, value> holding extra attributes
	 */
	public Map<String, String> getExtras() {
		return extras;
	}

	/**
	 * @param extras
	 *            a Map<key, value> holding extra attributes
	 */
	public void setExtras(Map<String, String> extras) {
		this.extras = extras;
	}

	@Override
	public String toString() {
		return "PackageMeta [id=" + id + ", name=" + name + ", title=" + title
				+ ", maintainer=" + maintainer + ", maintainerEmail="
				+ maintainerEmail + ", author=" + author + ", authorEmail="
				+ authorEmail + ", state=" + state + ", version=" + version
				+ ", license=" + license + ", licenseId=" + licenseId
				+ ", notesRendered=" + notesRendered + ", notes=" + notes
				+ ", url=" + url + ", ckanUrl=" + ckanUrl + ", downloadUrl="
				+ downloadUrl + ", metadataCreated=" + metadataCreated
				+ ", metadataModified=" + metadataModified + ", resources="
				+ resources + ", tags=" + tags + ", groups=" + groups
				+ ", extras=" + extras + "]";
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
		PackageMeta other = (PackageMeta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
