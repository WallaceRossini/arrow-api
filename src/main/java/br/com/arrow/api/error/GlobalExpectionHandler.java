package br.com.arrow.api.error;

import br.com.arrow.api.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExpectionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException exception){
        BindingResult result = exception.getBindingResult();
        List<ErrorDTO> errors = new ArrayList<>();

        for(FieldError fieldError: result.getFieldErrors()){
            ErrorDTO dto = new ErrorDTO(fieldError.getField(),fieldError.getDefaultMessage());
            errors.add(dto);
        }

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno no servidor.");
    }
}
