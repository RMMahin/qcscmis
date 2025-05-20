package com.example.qcscmis.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quantaa")
public class Quantaa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantaId;
    private Integer cls;
    private String bloodType;

    @Transient
    private String action;
}
