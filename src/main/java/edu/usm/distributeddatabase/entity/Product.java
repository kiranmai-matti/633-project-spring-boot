package edu.usm.distributeddatabase.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product implements Serializable {
    @Id
    @Column(name = "prd_id", nullable = false)
    private Integer prdId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;
    private String prdName;
    private String prdDesc;
    private Double prdPrice;
    private Integer prdCode;
    private String prdImgUrl;


}