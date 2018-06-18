package uk.ac.le.cs.CO3098.cw3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.ac.le.cs.CO3098.cw3.domain.Folder;

@Repository
public interface FolderRepository extends CrudRepository<Folder,Integer> {
	
	
	public Folder findById(Integer id);
	public Folder findByPath(String path);
	public Folder deleteByPath(String path);
	@Override
	void delete(Folder entity);

}
