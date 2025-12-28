package za.co.lzinc.heriplay.service;

import java.util.List;

public interface IService <T, ID> {
    T create(T t);
    List<T> readAll();
    T readById(ID id);
    T update(T t);
}
