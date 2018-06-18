package uk.ac.le.cs.CO3098.cw3.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Link {

	@Id
	@GeneratedValue
	@Column
	Integer id; 
	
	@Column
	String uri;
	
	@Column
	String title;
	
	@Column
	String path;
	
	@Column
	Boolean readOnly;
		
	@Column
	String type = "LINK";

	@ManyToOne
	@JoinColumn(name="parentFolderId")
	Folder parentFolder;
	
	public Link() {}
	
	public Link(String title) {
		this.title = title;
		setType("LINK");
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(Boolean readOnly) {
		this.readOnly = readOnly;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Folder getParentFolder() {
		return parentFolder;
	}

	public void setParentFolder(Folder parentFolder) {
		this.parentFolder = parentFolder;
	}


}
