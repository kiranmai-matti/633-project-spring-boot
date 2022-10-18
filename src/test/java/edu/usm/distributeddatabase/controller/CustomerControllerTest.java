package edu.usm.distributeddatabase.controller;

import edu.usm.distributeddatabase.entity.Customer;
import edu.usm.distributeddatabase.mapper.ModelMapper;
import edu.usm.distributeddatabase.model.LoginRequest;
import edu.usm.distributeddatabase.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {
    @InjectMocks
    CustomerController customerController;
    @Mock
    CustomerService customerService;
    @Mock
    Customer customer;
    @Mock
    ModelMapper modelMapper;

    @Test
    void testLoginCustomer() {
        LoginRequest loginRequest = LoginRequest.builder().email("test@gmail.com").password("password").build();
        when(customerService.getCustomerPresentByEmail(anyString())).thenReturn(customer);
        when(customerService.validateCustomer(anyString(), anyString())).thenReturn(true);
        Assertions.assertDoesNotThrow(() -> customerController.loginCustomer(loginRequest));
        when(customerService.validateCustomer(anyString(), anyString())).thenReturn(false);
        Assertions.assertDoesNotThrow(() -> customerController.loginCustomer(loginRequest));
    }

    @Test
    void testRegisterCustomer() {
        when(customerService.saveCustomer(any())).thenReturn(1);
        Assertions.assertDoesNotThrow(() -> customerController.registerCustomer(customer));
        Assertions.assertDoesNotThrow(() -> customerController.registerCustomer(customer));
    }

}
