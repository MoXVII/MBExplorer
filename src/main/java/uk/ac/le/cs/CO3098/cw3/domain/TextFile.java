package uk.ac.le.cs.CO3098.cw3.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class TextFile {

	@Id
	@GeneratedValue
	@Column
	Integer id; 
	
	@Column
	String title;
	
	@Column(length = 1000)
	String text;
	
	
	@Column
	String path;
	
	@Column
	Boolean readOnly = false;
	
	@Column
	String type = "TEXTFILE";

	@ManyToOne
	@JoinColumn(name="parentFolderId")
	Folder parentFolder;

	public TextFile() {}
	
	public TextFile(String title) {
		this.title = title;
		setReadOnly(false);
		setType("TEXTFILE");
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Boolean getReadOnly() {
		return readOnly;
	}


	public void setReadOnly(Boolean readOnly) {
		this.readOnly = readOnly;
	}

	public Folder getParentFolder() {
		return parentFolder;
	}

	public void setParentFolder(Folder parentFolder) {
		this.parentFolder = parentFolder;
	}

	
}
