package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.Telefono;
import ec.edu.ups.entidades.Usuario;

public interface GenericDAO<T, ID> {

    public void create(T entity);

    public T read(ID id);

    public void update(T entity);

    public void delete(T entity);

    public void deleteByID(ID id);
    
    public List<T> findAll();
    
    public List<Usuario> ListarU();
    
    public Usuario validar(String correo,String contrasena);
    
    public List<Telefono> BCedula(String cedula);
		
	
}


