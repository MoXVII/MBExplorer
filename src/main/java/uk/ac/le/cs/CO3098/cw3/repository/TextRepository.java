package uk.ac.le.cs.CO3098.cw3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import uk.ac.le.cs.CO3098.cw3.domain.TextFile;

@Repository
public interface TextRepository extends CrudRepository<TextFile,Integer> {
	
	
	public TextFile findById(Integer id);
	public TextFile findByPath(String path);
	public TextFile deleteByPath(String path);
	@Override
	void delete(TextFile entity);

}
