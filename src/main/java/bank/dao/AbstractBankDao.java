package bank.dao;

import bank.model.AbstractModel;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public abstract class AbstractBankDao<T extends AbstractModel> implements Dao<T>{

    protected List<T> list;
    protected Long idCounter = 1L;

    public AbstractBankDao(List<T> entities, Long idCounter) {
        this.list = entities;
        this.idCounter = idCounter;
    }

    @Override
    public T save(T obj) {
        if (obj.getId() == null) {
            obj.setId(idCounter++);
            list.add(obj);
        } else {
            int index = list.indexOf(obj);
            if(index >= 0)list.set(index, obj);
            else throw new NoSuchElementException();
        }
        return obj;
    }

    @Override
    public boolean delete(T obj) {
        return list.remove(obj);
    }

    @Override
    public void deleteAll(List<T> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void saveAll(List<T> entities) {
        entities.forEach(this::save);
    }

    @Override
    public List<T> findAll() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public boolean deleteById(long id) {
        return list.removeIf(el -> el.getId() == id);
    }

    @Override
    public Optional<T> getOne(long id) {
        return list.stream()
                .filter(el -> el.getId() == id)
                .findFirst();
    }
}
