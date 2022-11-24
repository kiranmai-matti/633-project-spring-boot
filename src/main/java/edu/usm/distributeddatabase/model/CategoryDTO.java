package edu.usm.distributeddatabase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryDTO {
    private Integer categoryId;
    private String categoryName;

}