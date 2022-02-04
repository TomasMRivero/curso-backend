package com.tomasmartinez.cursobackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Entity
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Table(name = "product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Category category;
    @Column(nullable = false)
    private int stock;
    @CreatedDate
    @JsonProperty("created_date")
    private Date createdDate;
}
