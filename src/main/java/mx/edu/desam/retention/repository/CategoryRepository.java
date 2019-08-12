package mx.edu.desam.retention.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.edu.desam.retention.entity.Category;
 
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{ 
	@Query(value="select * from retention.category where id_parent= :idParent order by id_category, id_parent", nativeQuery=true)
	List<Category> findCategoryByIdParent(@Param("idParent") Integer idParent);
	
	@Query(value="SELECT c FROM Category c WHERE c.idParent = null order by c.idCategory")
	List<Category> findCategoryByParent();
}
