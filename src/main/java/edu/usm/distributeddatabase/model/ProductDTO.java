package edu.usm.distributeddatabase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDTO {
    private Integer categoryId;
    private Integer prdId;
    private String prdName;
    private String prdDesc;
    private Double prdPrice;
    private Integer prdCode;
    private String prdImgUrl;

}