/*package uk.ac.le.cs.CO3098.cw3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.le.cs.CO3098.cw3.domain.Folder;
import uk.ac.le.cs.CO3098.cw3.repository.FolderRepository;

@Service
public class FolderService {

	@Autowired
	private FolderRepository fr;
	
	

	
	public Object findAllFolders() {
		return fr.findAll();
	}
	
	public Folder findById(Integer id){
		return fr.findOne(id);
	
	}
	
	public void deleteById(Integer id) {
		 fr.delete(id);
	}
	
	public void save(Folder f) {
		fr.save(f);
	}

}
*/