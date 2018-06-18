package uk.ac.le.cs.CO3098.cw3.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Item {


	@Id
	@GeneratedValue
	@Column
	Integer id; 
	
	@Column
	String name;
	
	@Column
	String path;
	
	@Column
	Boolean readOnly;
	
	@ManyToOne
	@JoinColumn(name="parentFolderId")
	Integer parentFolder;
	
	
}
