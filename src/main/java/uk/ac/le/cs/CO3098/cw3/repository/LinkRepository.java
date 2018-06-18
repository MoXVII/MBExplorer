package uk.ac.le.cs.CO3098.cw3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.ac.le.cs.CO3098.cw3.domain.Link;



@Repository
public interface LinkRepository extends CrudRepository<Link,Integer> {
	
	
	public Link findById(Integer id);
	public Link findByPath(String path);
	public Link deleteByPath(String path);
	@Override
	void delete(Link entity);

}
