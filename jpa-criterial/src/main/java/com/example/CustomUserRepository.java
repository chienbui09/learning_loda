package com.example;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class CustomUserRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public User getUserById(Long id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Predicate condition = cb.equal(root.get("id"),id);
        query.select(root).where(condition);
        return entityManager.createQuery(query).getSingleResult();
    }
    public Collection<User> getUserByComplexConditions(String name, User.UserType userType){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        if(name != null){
            predicates.add(
                    cb.equal(root.get("name"),name)

            );
        }
        if (userType != null){
            predicates.add(
                    cb.equal(root.get("userType"),userType)
            );
        }
        Predicate condition = cb.and(predicates.toArray(new Predicate[0]));
        query.select(root).where(condition);
        return entityManager.createQuery(query).getResultList();

    }
}
