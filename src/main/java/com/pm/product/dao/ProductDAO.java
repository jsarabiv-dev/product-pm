package com.pm.product.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pm.product.model.CategoryProductEntity;
import com.pm.product.model.ProductEntity;
import com.pm.product.model.PymeUserProfileEntity;

@Repository
public class ProductDAO {
	
	private List<ProductEntity> products = new ArrayList<>();
	
	private List<CategoryProductEntity> categories = new ArrayList<>();
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryProductRepository categoryProductRepository;
	@Autowired
	private PymeUserProfileRepository pymeUserProfileRepository;
	@PersistenceContext
	private EntityManager em;
	
	public List<ProductEntity> prueba() {
		
		/*
		// === Listar con EM === 
		ProductEntity product = em.find(ProductEntity.class, 75L);
		System.out.println(product.toString());
		System.out.println();
		*/
		
		/*
		// === Transacciones con EM === 
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		*/
		
		/*
		// === Borrar con EM transaction === 
		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();
		*/
		
		/*
		// === Actualizar con EM transaction === 
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
		*/
		
		
	// === Querys con JPA (JSQL) ===
		
		/*
		// Diseño primera consulta orientada a objetos con TypedQuery (consulta fuertemente tipada).
		TypedQuery<ProductEntity> consulta = em.createQuery("select p from ProductEntity p", ProductEntity.class);
		products = consulta.getResultList();
		products.forEach( p -> System.out.println(p.getProductName()));
		*/
		
		/*
		// Consulta orientada a objeto con where
		TypedQuery<ProductEntity> consulta = em.createQuery("select p from ProductEntity p where p.productOffer=:offer", ProductEntity.class);
		consulta.setParameter("offer", 16f);
		products = consulta.getResultList();
		products.forEach( p -> System.out.println(p.getProductName()));
		*/
		
		/*
		// Consulta orientada a objeto con where y and
		TypedQuery<ProductEntity> consulta = em.createQuery("select p from ProductEntity p where p.productUnitPrice>:price and p.productOffer>=:offer", ProductEntity.class);
		consulta.setParameter("price", 48000f);
		consulta.setParameter("offer", 0f);
		products = consulta.getResultList();
		products.forEach( p -> System.out.println(p.getProductName()));
		return products;
		*/
		
		/*
		// Consulta orientada a objeto con between
		TypedQuery<ProductEntity> consulta = em.createQuery("SELECT p FROM ProductEntity p WHERE p.productUnitPrice BETWEEN :price1 AND :price2", ProductEntity.class);
		consulta.setParameter("price1", 30000f);
		consulta.setParameter("price2", 50000f);
		products = consulta.getResultList();
		products.forEach( 
				p -> 
					{
						System.out.printf("[+] product.id = %d product.name = %s product.price = %f \n", 
								p.getProduct_Id(), p.getProductName(), p.getProductUnitPrice());
					});
		return products;
		*/
		
		/*
		// Consulta orientada a objeto con IN
		TypedQuery<ProductEntity> consulta = em.createQuery("SELECT p FROM ProductEntity p WHERE p.productId IN (:arg1, :arg2)", ProductEntity.class);
		consulta.setParameter("arg1", 77L);
		consulta.setParameter("arg2", 100L);
		products = consulta.getResultList();
		products.forEach( 
				p -> 
					{
						System.out.printf("[+] product.id = %d product.name = %s product.price = %f \n", 
								p.getProduct_Id(), p.getProductName(), p.getProductUnitPrice());
					});
		return products;
		*/
		
		
	// === Querys con JPA (JSQL) - Valores escalares ===
		
		/*
		TypedQuery<String> consulta = em
				.createQuery("SELECT p.productName FROM ProductEntity p", String.class);
		List<String> names = consulta.getResultList();
		names.forEach(name -> {
			System.out.print("[+] product.name = " + name.toString() +"\n");
		});
		return null;
		*/
		
		
	// === Funcionas JPA ===	
		
		/*
		// DISTINC and UPPER
		TypedQuery<String> consulta = em.createQuery("SELECT DISTINCT UPPER(p.productName) FROM ProductEntity p", String.class);
		List<String> names = consulta.getResultList();
		names.forEach(name -> {
			System.out.print("[+] product.name = " + name.toString() +"\n");
		});
		return products;
		*/
		
		/*
		// Order By
		TypedQuery<ProductEntity> consulta = em.createQuery("SELECT p FROM ProductEntity p ORDER BY p.productUnitPrice", ProductEntity.class);
		products = consulta.getResultList();
		products.forEach( 
				p -> 
					{
						System.out.printf("[+] product.id = %d product.name = %s product.price = %f \n", 
								p.getProduct_Id(), p.getProductName(), p.getProductUnitPrice());
					});
		return products;
		*/
		
		/*
		// Group By and COUNT
		TypedQuery<Object[]> consulta = em.createQuery("SELECT COUNT(p.productIsFreeShipping), productIsFreeShipping FROM ProductEntity p GROUP BY p.productIsFreeShipping", Object[].class);
		List<Object[]> lista = consulta.getResultList();
	
		lista.forEach( sl -> {
			System.out.printf("Cantidad: %d IsFreeShipping: %b \n", sl[0], sl[1]);
		});
		
		return products;
		*/
		
		/*
		// IsNull
		TypedQuery<ProductEntity> consulta = em.createQuery("select p from ProductEntity p WHERE p.productDescription IS NULL", ProductEntity.class);
		List<ProductEntity> products = consulta.getResultList();
		products.forEach( p -> {
			System.out.printf("[+] product.id = %d product.name = %s product.price = %f \n", 
				p.getProduct_Id(), p.getProductName(), p.getProductUnitPrice());
		});
		return products;
		*/
		
		/*
		// LIKE
		TypedQuery<ProductEntity> consulta = em.createQuery("select p from ProductEntity p WHERE p.productDescription LIKE :c", ProductEntity.class);
		consulta.setParameter("c", "café%");
		List<ProductEntity> products = consulta.getResultList();
		products.forEach( p -> {
			System.out.printf("[+] product.id = %d product.name = %s product.price = %f \n", 
				p.getProduct_Id(), p.getProductName(), p.getProductUnitPrice());
		});
		return products;
		*/
		
		
	// === JPA Relaciones Complejas	===
		
		
		em.getTransaction().begin();
	
		//TypedQuery<CategoryProductEntity> consulta = em.createQuery("select c from CategoryProductEntity c", CategoryProductEntity.class);
		CategoryProductEntity category = em.find(CategoryProductEntity.class, 2L);
		PymeUserProfileEntity pyme = em.find(PymeUserProfileEntity.class, 2L);
		
		ProductEntity p1 = new ProductEntity(pyme, category, "p1", "Prueba para producto1", "url", "Search_url", 1f, 1f, new Date(), new Date(), false);
		ProductEntity p2 = new ProductEntity(pyme, category, "p2", "Prueba para producto2", "url", "Search_url", 1f, 1f, new Date(), new Date(), true);
		
		em.getTransaction().commit();
		
		return null;
		
		
		
	}
	
	
	
	
	

}
	

