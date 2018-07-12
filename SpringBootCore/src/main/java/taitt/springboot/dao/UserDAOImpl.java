package taitt.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import taitt.springboot.entity.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<User> getAllUser() {
		String hql = "FROM User";
		return (List<User>)entityManager.createQuery(hql).getResultList();
	}

	@Override
	public User getUserById(long id) {
//		String hql = "FROM User WHERE id = " + id;
//		return (User)entityManager.createQuery(hql).getResultList().get(0);
		return (User)entityManager.find(User.class, id);
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
		
	}

	@Override
	public void updateUser(User user) {
//		entityManager.getTransaction().begin();
		User u = this.getUserById(user.getId());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		System.out.println(entityManager.contains(u));
		System.out.println(entityManager.contains(user));
		entityManager.flush();
//		entityManager.merge(u);
	}

	@Override
	public void removeUser(int id) {
		entityManager.remove(this.getUserById(id));
	}

}
