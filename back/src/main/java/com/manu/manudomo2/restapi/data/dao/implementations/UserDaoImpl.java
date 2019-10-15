package com.manu.manudomo2.restapi.data.dao.implementations;

import com.manu.manudomo2.restapi.data.dao.interfaces.UserDao;
import com.manu.manudomo2.restapi.data.entities.User;
import com.manu.manudomo2.restapi.security.data.SecurityUserDao;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao, SecurityUserDao<User> {

    public User findByUsername(String username) {
        String stringQuery = "SELECT x FROM User x WHERE x.username=:username";
        TypedQuery<User> query = this.getSession().createQuery(stringQuery, User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}
