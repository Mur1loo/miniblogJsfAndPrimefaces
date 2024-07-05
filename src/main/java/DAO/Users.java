package DAO;

import entities.User;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Users implements Serializable {

    private EntityManager manager;

    public Users() {}

    public Users(EntityManager manager) {
        this.manager = manager;
    }

    public User porId(Long id){
        return manager.find(User.class, id);
    }

    public List<User> pesquisar(String nome){
        TypedQuery<User> query = manager.createQuery(   "from User where login like :login", User.class);
        query.setParameter("login", nome + "%d");
        return query.getResultList();
    }

    public User guardar(User user){
        return manager.merge(user);
    }

    public void remover(User user){
        user = porId(user.getId());
        manager.remove(user);
    }
}
