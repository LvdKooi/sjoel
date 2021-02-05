package nl.kooi.sjoel.domain.contract;

public interface GetQuery<T, V> {

    T get(V dao);
}
