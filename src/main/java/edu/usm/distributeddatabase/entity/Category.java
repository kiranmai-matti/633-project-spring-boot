package edu.usm.distributeddatabase.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
/**
 * Java Representation class for the Database table Category
 */
public class Category implements Serializable {
    @Id
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private Set<Product> products = new LinkedHashSet<>();

}