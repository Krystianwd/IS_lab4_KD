package com.lg;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        List<Roles> roles = new ArrayList<>();
        List<UserGroup> UserGroups = new ArrayList<>();
        List<User> Users = new ArrayList<>();
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        System.out.println("JPA project");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        User u1 = new User(null, "test_1","test_1","Andrzej", "Kowalski", Sex.MALE,roles,UserGroups);
        User u2 = new User(null, "test_2","test_2","Andrzej", "Kowalski", Sex.MALE,roles,UserGroups);
        User u3 = new User(null, "test_3","test_3","Andrzej", "Kowalski", Sex.MALE,roles,UserGroups);
        User u4 = new User(null, "test_4","test_4","Andrzej", "Kowalski", Sex.MALE,roles,UserGroups);
        User u5 = new User(null, "test_5","test_5","Andrzeja", "Kowalski", Sex.FEMALE,roles,UserGroups);
        Roles r1 = new Roles(null,"test_1");
        Roles r2 = new Roles(null,"test_2");
        Roles r3 = new Roles(null,"test_3");
        Roles r4 = new Roles(null,"test_4");
        Roles r5 = new Roles(null,"test_5");
        em.persist(u1);
        em.persist(u2);
        em.persist(u3);
        em.persist(u4);
        em.persist(u5);
        em.persist(r1);
        em.persist(r2);
        em.persist(r3);
        em.persist(r4);
        em.persist(r5);
        User UserFind = em.find(User.class,Long.valueOf(1));
        UserFind.password = "Updated";
        em.merge(UserFind);
        Roles RolesFindRemove = em.find(Roles.class,Long.valueOf(5));
        em.remove(RolesFindRemove);


        Query query1 = em.createQuery("SELECT u FROM User u WHERE u.LastName = 'Kowalski'");
        java.util.List<User> kowalscy = query1.getResultList();
        System.out.println(kowalscy);

        Query query2 = em.createQuery("SELECT u FROM User u WHERE u.sex = 'FEMALE'");
        java.util.List<User> Kobiety = query2.getResultList();
        System.out.println(Kobiety);

        User u6 = new User(null, "user","z","Tablica", "Roles", Sex.MALE,roles,UserGroups);
        u6.addRole(r1);
        u6.addRole(r2);
        em.persist(u6);

        UserGroup ug1 = new UserGroup(null,Users);
        ug1.addUser(u1);
        ug1.addUser(u4);
        em.persist(ug1);


        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}
