package com.klef.soa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="users-salary")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;

    @Column(nullable = false)
	private String name;
    
    @Column(nullable=false)
	private String password;
    
    @Column(nullable=false, unique=true)
	private String email;
	
}
