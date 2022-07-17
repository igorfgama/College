package service.validation;

public interface Validation<T> {
    void validateItem(T t);

    void validateNewRegister(T t);
}
