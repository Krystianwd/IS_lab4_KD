package com.lg;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users", indexes = @Index(columnList = "login"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false,unique = true)
    String login;
    @Column(nullable = false)
    String password ;
    String FirstName;
    String LastName;
    @Enumerated(EnumType.STRING)
    Sex sex;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private final List<Roles> roles = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL)
    private final List<UserGroup> UserGroups = new ArrayList<>();
    public User(Long id, String login, String password, String firstName, String lastName, Sex sex,List<Roles> role,List<UserGroup> UserGroups) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.sex = sex;
    }
    public void addRole(Roles rola)
    {
        this.roles.add(rola);
    }
    public void addedToGroup(UserGroup UserGroup)
    {
        this.UserGroups.add(UserGroup);
    }
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

}
