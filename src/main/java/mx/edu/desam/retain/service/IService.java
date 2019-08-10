package mx.edu.desam.retain.service;

import java.util.List;

public interface IService<T> {
	/***
	 * Trae toda la informacion relevante que hay por persona
	 * 
	 * @return
	 */
	List<T> getAll();

	/****
	 * Consulta un elemento usando su ID como base
	 * 
	 * @param i
	 * @return
	 */
	T getById(Integer i);

	/***
	 * Agrega un nuevo elemento
	 * 
	 * @param t
	 * @return
	 */
	boolean add(T t);

	/***
	 * Actualiza el elemento seleccionado
	 * 
	 * @param t
	 */
	void update(T t);

	/***
	 * Elimina un elemento del mismo tipo
	 */
	void delete(Integer tId);
}
