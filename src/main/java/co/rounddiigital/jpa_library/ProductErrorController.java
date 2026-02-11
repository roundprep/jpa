package co.rounddiigital.jpa_library;

import co.rounddiigital.jpa_library.exception.InvalidProductNameException;
import co.rounddiigital.jpa_library.exception.InvalidProductPriceException;
import co.rounddiigital.jpa_library.model.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/***
 * Centralized Error Handling
 * Can we have more than one controller Advise - Yes
 * @Configuration
 */

import java.time.Instant;
@ControllerAdvice
public class ProductErrorController {

    @ExceptionHandler(InvalidProductNameException.class)
    public ResponseEntity<ErrorResponse> handleProductNameException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder().errorCode("API-410")
                        .errorMessage(ex.getMessage())
                        .errorTimestamp(Instant.now())
                        .build());
    }

    @ExceptionHandler(InvalidProductPriceException.class)
    public ResponseEntity<ErrorResponse> handlePrice(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder().errorCode("API-411")
                        .errorMessage(ex.getMessage())
                        .errorTimestamp(Instant.now())
                        .build());
    }
}
