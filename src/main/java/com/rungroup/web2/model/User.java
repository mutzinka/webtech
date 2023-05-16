package com.rungroup.web2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private String email;
 private String password;
 @Column(name = "role", nullable = false, columnDefinition ="ENUM('USER', 'ADMIN') DEFAULT 'USER'")
 private String role;
}
