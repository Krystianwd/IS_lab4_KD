package com.lg;

import javax.persistence.*;

@Entity
@Table(name = "roles", indexes = @Index(columnList = "name"))
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false,unique = true)
    String name;

    public Roles(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Roles() {}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
