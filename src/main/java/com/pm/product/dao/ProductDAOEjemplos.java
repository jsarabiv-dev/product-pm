package com.pm.product.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pm.product.model.CategoryProductEntity;
import com.pm.product.model.ProductEntity;
import com.pm.product.model.PymeUserProfileEntity;

@Repository
public class ProductDAOEjemplos {
/*
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
	
	@Transactional
	public List<ProductEntity> prueba() {
	*/	
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
		
		//TypedQuery<CategoryProductEntity> consulta = em.createQuery("select c from CategoryProductEntity c", CategoryProductEntity.class);
//		CategoryProductEntity category = em.find(CategoryProductEntity.class, 14L);
//		CategoryProductEntity category2 = em.find(CategoryProductEntity.class,15L);
//		PymeUserProfileEntity pyme = em.find(PymeUserProfileEntity.class, 2L);
//		CategoryProductEntity c1 = new CategoryProductEntity(null, null, "Prueba persistir categoria por JPA3", "iconxd2", "SearchUrlxd2");
//		CategoryProductEntity c2 = new CategoryProductEntity(null, null, "Prueba persistir categoria por JPA4", "iconxd2", "SearchUrlxd2");
//		ProductEntity p1 = new ProductEntity(pyme, null, "p4", "Prueba para producto3", "url", "Search_url", 1f, 1f, new Date(), new Date(), false);
//		ProductEntity p2 = new ProductEntity(pyme, null, "p5", "Prueba para producto4", "url", "Search_url", 1f, 1f, new Date(), new Date(), true);
//		c1.addProduct(p1);
//		c2.addProduct(p2);
//		em.persist(p1);
//		em.persist(p2);
		
		//em.remove(category);
		//em.remove(category2);
		//CategoryProductEntity cat = em.find(CategoryProductEntity.class, 12L);
		//return null;
		
		
	// === JPA Count ===
		
		/*
		TypedQuery<ProductEntity> consulta = em.createQuery("select p from ProductEntity p", ProductEntity.class);
		
		TypedQuery<Long> totalProd = em.createQuery("select COUNT(p) from ProductEntity p", Long.class);
		
		List<ProductEntity> prod = consulta.getResultList();
		
		System.out.printf("[+] Cantidad de productos en BD: %s \n",totalProd.getSingleResult().toString());
		
		prod.forEach( p ->{
				System.out.println("[+] "+p.getProductName());
				});
		
		return null;
		*/
		
		
	// === Native Querys ===
		
		/*
		Query consulta = em.createNativeQuery("SELECT * FROM product");
		
		List<ProductEntity> prodList = consulta.getResultList();
		prodList.forEach( p -> {
			System.out.printf("[+] Producto Name: %s", p.getProductName());
		});
		return null;
		*/
		
	// === Dynamic Querys ===

		/*
		String name = "Product Prueba";
		String imgUrl = "";
		String consulta = "SELECT p FROM ProductEntity p ";

		if (name != "" || imgUrl != "") {
			consulta+="WHERE ";
		}
		if (name != "") {
			consulta+="p.productName=:name";
		}
		if (imgUrl != "") {
			if (name != "") {
				consulta+=" AND ";
			}
			consulta+="p.productImgUrl=:imgUrl";
		}

		System.out.println(consulta);
		TypedQuery<ProductEntity> consulta1 = em.createQuery(consulta.toString(), ProductEntity.class);
		
		if (name != "") {
			consulta1.setParameter("name", name);
		}
		if (imgUrl != "") {
			consulta1.setParameter("imgUrl", imgUrl);
		}
		
		List<ProductEntity> productList= consulta1.getResultList();
		
		productList.forEach(p -> {
			System.out.printf("[+] Producto Name: %s", p.getProductName());
		});
		return null;
		 */
		
		
	// === JPA Criteria ===
		/*
		String name = "caf%";
		String imgUrl = "";
		List<ProductEntity> productList= new ArrayList<>();
		
		// Constructor de criteria
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ProductEntity> cq = cb.createQuery(ProductEntity.class);
		// select p from ProductEntity p
		Root<ProductEntity> productRaiz = cq.from(ProductEntity.class);
		
		List<Predicate> listPredicates = new ArrayList<>();
		if (name != "") {
//			listPredicates.add(cb.equal(productRaiz.get("productName"), name));
			listPredicates.add(cb.like(productRaiz.get("productName"), name));
		}
		if (imgUrl != "") {
			listPredicates.add(cb.equal(productRaiz.get("productImgUrl"), imgUrl));
		}
		
		// Seleccion, aplica where y combina los filtros equal que se han diseñado
		cq.select(productRaiz).where(listPredicates.toArray(new Predicate[listPredicates.size()]));
		
		
		productList = em.createQuery(cq).getResultList();
		
		imprimirList(productList);
		
		
		
		
		
		
		
		
		
		
		
		return null;
		
	}
	
	
	public void  imprimirList(List<ProductEntity> list){
		
		list.forEach( p -> {
			System.out.printf("[+] Product Name: %s || Product Id: %s", p.getProductName(), p.getProduct_Id().toString());
		});
		
		
	}
*/

}
	



































