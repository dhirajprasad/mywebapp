package com.webapp.dao.generic;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	
	public T add(T t) {
		System.out.println("generic add  " + t.getClass().getCanonicalName());
		return null;
	}

	
}
