package doa;

import java.util.List;

import beans.Users;

public interface IDao<T> {
		boolean create(T o);

		boolean delete(T o);

		boolean update(T o);

		T findById(int id);

		List<T> findAll();

	  

	 
	}

