package DAO;

import entities.Post;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class Posts implements Serializable {

    public Posts(){
    }

    public Posts(EntityManager manager) {
        this.manager = manager;
    }

    private EntityManager manager;

    public List<Post> pesquisar(String tit){
        TypedQuery<Post> query = manager.createQuery("from Post where tittle like :tittle", Post.class);
        query.setParameter( "tittle", tit + "%d");
        return query.getResultList();
    }
}
