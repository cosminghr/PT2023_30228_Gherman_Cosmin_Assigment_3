package BusinessLogic.Validators;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * interfata care are rolul de a ilustra validatorii ce trebuie implementati
 * @param <T> -> poate fi de tipul Clients, Product, Order
 */
public interface Validator<T> {
    public void validateForInsert(T t) throws SQLIntegrityConstraintViolationException;
    public void validateForUpdate(T t);
}
