package com.rahul.ecartbackend.repositoryImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.ecartbackend.dto.Address;
import com.rahul.ecartbackend.dto.Cart;
import com.rahul.ecartbackend.dto.User;
import com.rahul.ecartbackend.repository.UserRepository;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
		String query = "FROM User WHERE email=:email";
		try {
			return sessionFactory.getCurrentSession().createQuery(query, User.class).setParameter("email", email)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Address getBillingAddress(int userId) {
		String query = "FROM Address WHERE userId=:userId AND billing=:billing";
		try {
			return sessionFactory.getCurrentSession().createQuery(query, Address.class).setParameter("userId", userId)
					.setParameter("billing", true).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Address> listShippingAddress(int userId) {
		String query = "FROM Address WHERE userId=:userId AND shipping=:shipping";
		try {
			return sessionFactory.getCurrentSession().createQuery(query, Address.class).setParameter("userId", userId)
					.setParameter("shipping", true).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
