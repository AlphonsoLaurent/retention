package mx.edu.desam.retain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.edu.desam.retain.entity.Category;
 
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{ 
	@Query(value="select * from playit.category  where id_User= :idUserp order by id_Category, id_parent", nativeQuery=true)
	List<Category> findCategoryByUser(@Param("idUserp") Integer idUserp);
}
