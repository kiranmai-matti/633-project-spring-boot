package edu.usm.distributeddatabase.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import  edu.usm.distributeddatabase.model.APIError;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * This method is used to send not found error details
     * @param ex NotFoundException
     * @param request HttpServletRequest
     * @return APIError
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<APIError> notFoundException(NotFoundException ex,HttpServletRequest request) {
        log.error("notFoundException : "+ ex.getLocalizedMessage()+ " for "+ request.getRequestURI() );
        return new ResponseEntity<>(
                APIError.builder()
                        .errorMessage(ex.getLocalizedMessage())
                        .errorCode(HttpStatus.NOT_FOUND.toString())
                        .request(request.getRequestURI())
                        .requestType(request.getMethod())
                        .customMessage("Details Not Found for the given request")
                        .build(), HttpStatus.NOT_FOUND);
    }
    /**
     * This method is used to send not found error details
     * @param ex IllegalArgumentException
     * @param request HttpServletRequest
     * @return APIError
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<APIError> illegalArgumentException(IllegalArgumentException ex,HttpServletRequest request) {
        log.error("illegalArgumentException : "+ ex.getLocalizedMessage()+ " for "+ request.getRequestURI() );
        return new ResponseEntity<>(
                APIError.builder()
                        .errorMessage(ex.getLocalizedMessage())
                        .errorCode(HttpStatus.BAD_REQUEST.toString())
                        .request(request.getRequestURI())
                        .requestType(request.getMethod())
                        .customMessage("Illegal Arguments to the request")
                        .build(), HttpStatus.BAD_REQUEST);
    }

    /**
     * This Method is used to return generic API Error Details
     * @param ex Exception
     * @param request HttpServletRequest
     * @return
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<APIError> genericException(Exception ex, HttpServletRequest request){
        log.error("genericException : "+ ex.getLocalizedMessage()+ " for "+ request.getRequestURI() );
        return new ResponseEntity<>(
            APIError.builder()
                    .errorMessage(ex.getLocalizedMessage())
                    .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                    .request(request.getRequestURI())
                    .requestType(request.getMethod())
                    .customMessage("Could not process request")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
