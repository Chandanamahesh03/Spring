package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.User;

public class UserDao
{
EntityManagerFactory emf= Persistence.createEntityManagerFactory("dev");
EntityManager em=emf.createEntityManager();
EntityTransaction et=em.getTransaction();

public void save (User user) 
{
et.begin();
em.persist(user);
et.commit();
}
public User find(String email)
{
	List<User> users=em.createQuery("select x from User x where email=?1").setParameter(1, email).getResultList();
//   if to is empty o avoid nullpointer exception use if condition 
	if(users.isEmpty())
    {
    	return null;
    }else
    	return users.get(0);
//	in list only one email v can store soo take get (0)
//	return em.find(User.class, email);
	
}
public List<User> fetchAll()
{
return em.createQuery("select x from User x").getResultList();	 
}

public void delete(User user)
{
et.begin();
em.remove(user);
et.commit();
}

public void updateUser(User user)
{
	et.begin();
	em.merge(user);
	et.commit();
}

}

