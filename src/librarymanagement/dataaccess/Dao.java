package librarymanagement.dataaccess;

import java.util.List;

public interface Dao<T> {
	public void save(T object);
	public void save(List<T> object);
	public T get(int id);
	public void delete(int id);
	public List<T> findAll();
	

}
