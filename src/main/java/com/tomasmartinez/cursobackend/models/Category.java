package com.tomasmartinez.cursobackend.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString(of = {"id", "name"})
@Getter
@Setter
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> products;
}
