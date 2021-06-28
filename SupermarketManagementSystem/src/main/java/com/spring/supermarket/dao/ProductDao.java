package com.spring.supermarket.dao;

import java.util.Set;

import com.spring.supermarket.model.OrderProduct;
import com.spring.supermarket.model.Product;
import com.spring.supermarket.model.VerifiedOrder;

public interface ProductDao {

	public Product findById(Long id);

	public Product findByName(String name);

	public Product findByCategory(String category);

	public Set<Product> findAll();

	public Product createProduct(Product product);

	public void deleteProduct(Long id);

	public Product updateProduct(Long id);

	public Set<Product> findByCustomer(Long id);

	public Set<Product> findVerifyOrderByProductId(Long id);

	public Set<VerifiedOrder> findVerifiedOrderByProductId(Long id);

	public Set<OrderProduct> findByCashier(Long id);

}
