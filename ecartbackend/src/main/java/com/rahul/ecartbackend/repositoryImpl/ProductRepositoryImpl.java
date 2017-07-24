package com.rahul.ecartbackend.repositoryImpl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.ecartbackend.dto.Product;
import com.rahul.ecartbackend.repository.ProductRepository;

@Repository("productRepository")
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {
		try {
			String query="from Product";
			return sessionFactory.getCurrentSession().createQuery(query,Product.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String query="from Product where active=:active";
		return sessionFactory
				.getCurrentSession()
				.createQuery(query,Product.class)
					.setParameter("active",true)
						.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String query="from Product where active=:active and categoryId=:categoryId";
		return sessionFactory.
				getCurrentSession()
				.createQuery(query,Product.class)
					.setParameter("active", true)
					.setParameter("categoryId", categoryId)
						.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {		
		return sessionFactory
				.getCurrentSession()
					.createQuery("from Product where active=:active order by id",Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();				
	}

}
