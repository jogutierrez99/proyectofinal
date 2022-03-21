package com.ProyectoFinal.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ProyectoFinal.Entities.User;

public interface UsersCRUDRepository extends JpaRepository<User, Integer> {

	@Query("from User as u where u.user=:user and u.password=:password")
	//Solo puede dar un ÚNICO objeto con la misma clave y la misma contraseña
	public User getLogin(String user, String password);
	
	@Query(" from User as usu")
	public Iterable<User> getUsuarios();
	
	@Modifying
	@Query("delete from User as usu where usu.id=:id")
	public void deleteUser(@Param("id") int id);
}
