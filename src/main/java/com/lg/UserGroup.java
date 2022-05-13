package com.lg;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UserGroup")
public class UserGroup {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private final List<User> Users = new ArrayList<>();

    public UserGroup(Long id,List<User> Users) {
        this.id = id;
    }
    public void addUser(User user)
    {
        user.addedToGroup(this);
        this.Users.add(user);
    }
}
