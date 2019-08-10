package mx.edu.desam.retain.repository;

import org.springframework.data.repository.CrudRepository;

import mx.edu.desam.retain.entity.UserPlay;
 

public interface UserPlayRepository extends CrudRepository<UserPlay, Integer>{
//	List<Aplicacion> findByLastName(String lastName);
}
