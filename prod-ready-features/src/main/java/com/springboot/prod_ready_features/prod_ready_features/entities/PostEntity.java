package com.springboot.prod_ready_features.prod_ready_features.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
@Getter
@Setter
@Audited
public class PostEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @PrePersist
    void beforeSave() {

    }

    @PreUpdate
    void beforeUpdate() {

    }

    @PostRemove
    void beforeDelete() {

    }

}







