package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.Telefono;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer> {
	abstract List<Telefono> findAllByID(String ID);
	abstract List<Telefono> findALLByEmail(String ID);
}
