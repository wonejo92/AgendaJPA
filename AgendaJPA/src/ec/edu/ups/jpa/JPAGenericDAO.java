package ec.edu.ups.jpa;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.sound.midi.Soundbank;

import com.mysql.cj.Query;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.GenericDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Telefono;
import ec.edu.ups.entidades.Usuario;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {
    private Class<T> persistentClass;
    protected EntityManager em;

    public JPAGenericDAO(Class<T> persistentClass) {
	this.persistentClass = persistentClass;
	this.em = Persistence.createEntityManagerFactory("AgendaJPA").createEntityManager();
    }

    @Override
    public void create(T entity) {
	em.getTransaction().begin();
	try {
	    em.persist(entity);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
	    if (em.getTransaction().isActive())
		em.getTransaction().rollback();
	}
   }
    
    @Override
    public T read(ID id) {
	return em.find(persistentClass, id);
    }

    @Override
    public void update(T entity) {
	em.getTransaction().begin();
	try {
	    em.merge(entity);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
	    if (em.getTransaction().isActive())
		em.getTransaction().rollback();
	}
    }

    // entity debe estar en estado de "Managed"
    @Override
    public void delete(T entity) {
	em.getTransaction().begin();
	try {
	    em.remove(entity);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
	    if (em.getTransaction().isActive())
		em.getTransaction().rollback();
	}
  }

    @Override
    public void deleteByID(ID id) {
	T entity = this.read(id);
	if (entity != null)
	    this.delete(entity);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<T> findAll() {
	em.getTransaction().begin();
	List<T> lista = null;
	try {
	    javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	    cq.select(cq.from(persistentClass));
	    lista = em.createQuery(cq).getResultList();
	    em.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return lista;

    }
//Listar todos los Usuarios.
	@Override
	public List<Usuario> ListarU() {
		// TODO Auto-generated method stub
		String consulta="SELECT u FROM Usuario u";
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios =em.createQuery(consulta).getResultList();
		em.close();
		return usuarios;
	}
//Validar por correo y contraseña.
	
	@Override
	public Usuario validar(String correo, String contrasena) {
		// TODO Auto-generated method stub
		Usuario user = new Usuario();
		String consulta =("SELECT u FROM Usuario u WHERE u.correo='"+correo+"'and u.contrasena='"+contrasena+"'");
		try {
			user= (Usuario) em.createQuery(consulta).getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return user;
	}
	//Nos permite buscar por cedula
	@Override
	public List<Telefono> BCedula(String cedula) {
		// TODO Auto-generated method stub
		System.out.println();
		UsuarioDAO usuDAO = DAOFactory.getFactory().getUsuarioDAO();
		Usuario usu=usuDAO.read(cedula);
		String sql=("SELECT t FROM Telefono t where t.cedulaU.cedula='"+usu.getCedula()+"'");	
		List<Telefono> list=em.createQuery(sql).getResultList();				
		return list;
	}

//Listar todos los numeros de un usuario
	@Override
	public List<Telefono> BTelefonos(String cedula) {
		
		UsuarioDAO usuDao= DAOFactory.getFactory().getUsuarioDAO();
		Usuario usu = usuDao.read(cedula);
		String sql=("SELECT t FROM Telefono t where t.cedulaU.cedula='"+usu.getCedula()+"'");
		List<Telefono> listTelefonos=em.createQuery(sql).getResultList();
		// TODO Auto-generated method stub
		System.out.println("ME LLAMAN!!!!!!! ------> " + listTelefonos);
		return listTelefonos;
	}

	@Override
	//Permite buscar por correo
	public List<Telefono> BCorreo( String correo) {
		UsuarioDAO usuDao= DAOFactory.getFactory().getUsuarioDAO();
		String sql=("SELECT t FROM Telefono t, Usuario u where u.cedula=t.cedulaU.cedula AND u.correo='"+ correo+"'");
		List<Telefono> listTelefonos=em.createQuery(sql).getResultList();
		return listTelefonos;
	}
	
	
 	
}