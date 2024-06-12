package com.Diabetes.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class test {
    @Id
    private Long id;
    @Column
    private String name;
}
