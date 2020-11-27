package bank.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    T save(T obj);
    boolean delete(T obj);
    void deleteAll(List<T> entities);
    void saveAll(List<T> entities);
    List<T> findAll();
    boolean deleteById(long id);
    Optional<T> getOne(long id);
}
