package edu.usm.distributeddatabase.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
/**
 * API ERROR class to for the Error Details
 */
public class APIError {
    private String errorMessage;
    private String errorCode;
    private String request;
    private String requestType;
    private String customMessage;
}
