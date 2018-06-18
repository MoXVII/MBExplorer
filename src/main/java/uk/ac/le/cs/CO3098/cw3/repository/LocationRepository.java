package uk.ac.le.cs.CO3098.cw3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import uk.ac.le.cs.CO3098.cw3.domain.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location,Integer> {
	
	
	public Location findById(Integer id);
	public Location findByPath(String path);
	public Location deleteByPath(String path);
	@Override
	void delete(Location entity);

}
