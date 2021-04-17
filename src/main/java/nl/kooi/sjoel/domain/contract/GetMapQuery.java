package nl.kooi.sjoel.domain.contract;

import java.util.Map;

public interface GetMapQuery<K, V, T> {

    Map<K, V> get(T dao);
}
