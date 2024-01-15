package src.uz.pdp.util;

import java.io.Serializable;
import java.util.List;

public interface Repository  <T>  {

    void save(T t);
    void delate(T t);
    List<T> showAll();
    void update(T t);

}
