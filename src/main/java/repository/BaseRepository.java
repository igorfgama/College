package repository;

import java.util.Set;

public interface BaseRepository<T> {
    Set<T> getAll();

    void setData();

    void save(T t);
}
