package com.rahul.ecartbackend.repositoryImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.ecartbackend.dto.Category;
import com.rahul.ecartbackend.repository.CategoryRepository;

@Repository("categoryRepository")
@Transactional
public class CategoryRepoImpl implements CategoryRepository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Category> listCategory() {
		try {
			String query="from Category where active=:active";
			
			Query qr =sessionFactory.getCurrentSession().createQuery(query);
			qr.setParameter("active",true);
			return qr.getResultList();
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public Category findById(int id) {
		// return cat.stream().filter(t -> t.getId() == id).findFirst().get();
		Category c = null;
		try {
			c = sessionFactory.getCurrentSession().get(Category.class, id);
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			return c;
		}
	}

	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
