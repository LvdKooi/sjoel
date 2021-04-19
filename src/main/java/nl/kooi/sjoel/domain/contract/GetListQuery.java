package nl.kooi.sjoel.domain.contract;

import java.util.List;

public interface GetListQuery<T, V> {

    List<T> get(V dao);
}
