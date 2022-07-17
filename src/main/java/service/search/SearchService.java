package service.search;

public interface SearchService<R, T, U> {
    U searchBy(R r, T t);
}
