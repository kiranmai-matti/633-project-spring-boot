package edu.usm.distributeddatabase.mapper;

import edu.usm.distributeddatabase.entity.Category;
import edu.usm.distributeddatabase.entity.CustAddress;
import edu.usm.distributeddatabase.entity.Customer;
import edu.usm.distributeddatabase.entity.Product;
import edu.usm.distributeddatabase.model.CategoryDTO;
import edu.usm.distributeddatabase.model.CustomerDTO;
import edu.usm.distributeddatabase.model.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    /**
     * This Method is used to convert Entity Class to Transformed Data Object
     * @param category Category Entity
     * @return CategoryDTO
     */
    public CategoryDTO buildCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();
    }

    /**
     * This Method is used to convert Entity Class to Transformed Data Object
     * @param product Product Entity
     * @return ProductDTO
     */
    public ProductDTO buildProductDTO(Product product) {
        return ProductDTO.builder()
                .categoryId(product.getCategory().getCategoryId())
                .prdId(product.getPrdId())
                .prdCode(product.getPrdCode())
                .prdName(product.getPrdName())
                .prdDesc(product.getPrdDesc())
                .prdImgUrl(product.getPrdImgUrl())
                .prdPrice(product.getPrdPrice())
                .build();
    }

    /**
     * This Method is used to convert Entity Class to Transformed Data Object
     * @param custAddress CustAddress Entity
     * @return CustAddress
     */
    public CustAddress getAddress(CustAddress custAddress) {
        return CustAddress.builder()
                .addr1(custAddress.getAddr1())
                .addr2(custAddress.getAddr2())
                .city(custAddress.getCity())
                .state(custAddress.getState())
                .zipcode(custAddress.getZipcode())
                .country(custAddress.getCountry())
                .build();
    }

    /**
     * This Method is used to convert Entity Class to Transformed Data Object
     * @param customer Customer Entity
     * @return CustomerDTO
     */
    public CustomerDTO buildCustomerDTO(Customer customer) {
        return CustomerDTO.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .mobileNo(customer.getMobileNo())
                .email(customer.getEmail())
                .billingAddr(customer.getBillingAddr()==null?null:getAddress(customer.getBillingAddr()))
                .shippingAddr(customer.getShippingAddr()==null?null:getAddress(customer.getShippingAddr()))
                .build();
    }
}
