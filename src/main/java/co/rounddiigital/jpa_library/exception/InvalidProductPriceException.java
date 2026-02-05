package co.rounddiigital.jpa_library.exception;

public class InvalidProductPriceException extends RuntimeException {
    public InvalidProductPriceException(String productPriceIsInvalid) {
        super(productPriceIsInvalid);
    }
}
