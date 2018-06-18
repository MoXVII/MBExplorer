package uk.ac.le.cs.CO3098.cw3.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.google.gson.annotations.Expose;

@Entity
public class Folder {
	
	
	
	
	@Id
	@GeneratedValue
	@Column
	Integer id; 
	
	@Expose
	@Column
	String folder;

	
	@Column
	boolean readOnly = false;
	
	
	@ManyToOne
	@JoinColumn(name="parentFolderId")
	Folder parentFolder;
	
	
	@Expose
    @OneToMany(mappedBy = "parentFolder", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	List<Folder> subfolders = new ArrayList<Folder>();
	
	
	boolean IsRootNode;
	
	
	@Column
	String path;
	
	
	@Column
	String type = "FOLDER";
	

	
	
	@OneToMany(targetEntity=Location.class, mappedBy="parentFolder", fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	List <Location> locationFiles = new ArrayList<Location>();
	
	@OneToMany(targetEntity=TextFile.class, mappedBy="parentFolder", fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	List <TextFile> textFiles = new ArrayList<TextFile>();
	
	@OneToMany(targetEntity=Link.class, mappedBy="parentFolder", fetch=FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	List <Link> linkFiles = new ArrayList<Link>();
	
	public Folder() {}
	
	public Folder (String folder) {
		this.folder = folder;
		setType("FOLDER");
	}
	
	public void addAsSubfolder(Folder f) {
		subfolders.add(f);
	}
	
	public int childrenInFolder(ArrayList<Folder> folder) {
		int counter = 0;
		for(int i=0; i<folder.size();i++) {
			counter++;
		}
		return counter;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
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



	public List<Folder> getSubfolders() {
		return subfolders;
	}

	public void setSubfolders(ArrayList<Folder> subfolders) {
		this.subfolders = subfolders;
	}

	public boolean getIsRootNode() {
		return IsRootNode;
	}

	public void setIsRootNode(boolean IsRootNode) {
		this.IsRootNode = IsRootNode;
	}

	public Folder getParentFolder() {
		return parentFolder;
	}

	public void setParentFolder(Folder parentFolder) {
		this.parentFolder = parentFolder;
	}

	public List<Location> getLocationFiles() {
		return locationFiles;
	}

	public void setLocationFiles(List<Location> locationFiles) {
		this.locationFiles = locationFiles;
	}

	public List<TextFile> getTextFiles() {
		return textFiles;
	}

	public void setTextFiles(List<TextFile> textFiles) {
		this.textFiles = textFiles;
	}

	public List<Link> getLinkFiles() {
		return linkFiles;
	}

	public void setLinkFiles(List<Link> linkFiles) {
		this.linkFiles = linkFiles;
	}
	
	

}
