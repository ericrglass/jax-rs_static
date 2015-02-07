package com.github.jaxrs_static.jaxrs;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.github.jaxrs_static.bean.Product;
import com.github.jaxrs_static.bean.ProductsList;
import com.github.jaxrs_static.bean.ProductsSession;

@Path(ProductResource.PATH)
public class ProductResource {

	public static final String PATH = "/product";

	@Context
	protected HttpServletRequest request;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ProductsList list() {
		return getProductsList();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product get(@PathParam("id") long id) {
		Product product = null;
		ProductsList productsList = getProductsList();

		for (Product p : productsList) {
			if (p == null) {
				continue;
			}

			if (p.getId() == id) {
				product = p;
				break;
			}
		}

		if (product == null) {
			product = new Product();
			product.setId(id);
		}

		return product;
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product delete(@PathParam("id") long id) {
		Product product = null;
		ProductsList productsList = getProductsList();

		for (Product p : productsList) {
			if (p == null) {
				continue;
			}

			if (p.getId() == id) {
				product = p;
				break;
			}
		}

		if (product == null) {
			product = new Product();
			product.setId(id);
		} else {
			productsList.remove(product);
			setProductsList(productsList);
		}

		return product;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Product post(Product product) {
		if (product == null) {
			return new Product();
		}

		ProductsList productsList = getProductsList();
		Product postedProduct = null;
		long maxId = 0;
		int index = 0;

		for (; index < productsList.size(); index++) {
			Product p = productsList.get(index);

			if (p == null) {
				continue;
			}

			if (p.getId() > maxId) {
				maxId = p.getId();
			}

			if (p.getId() == product.getId()) {
				postedProduct = p;
				break;
			}
		}

		if (postedProduct == null) {
			postedProduct = product;
			postedProduct.setId(maxId + 1);
			productsList.add(postedProduct);
		} else {
			postedProduct = product;
			productsList.set(index, postedProduct);
		}

		setProductsList(productsList);
		return postedProduct;
	}

	private void setProductsList(ProductsList productsList) {
		if (productsList == null) {
			return;
		}

		ProductsSession productsSession = null;
		HttpSession session = request.getSession();

		if ((session != null)
				&& (session.getAttribute(ProductsSession.NAME) instanceof ProductsSession)) {
			productsSession = (ProductsSession) session
					.getAttribute(ProductsSession.NAME);
		}

		if (productsSession == null) {
			productsSession = new ProductsSession();
		}

		productsSession.setProducts(productsList);
		session.setAttribute(ProductsSession.NAME, productsSession);
	}

	private ProductsList getProductsList() {
		ProductsSession productsSession = null;
		HttpSession session = request.getSession();

		if ((session != null)
				&& (session.getAttribute(ProductsSession.NAME) instanceof ProductsSession)) {
			productsSession = (ProductsSession) session
					.getAttribute(ProductsSession.NAME);
		}

		ProductsList productsList = null;

		if (productsSession != null) {
			productsList = productsSession.getProducts();
		}

		if (productsList == null) {
			productsList = new ProductsList();
		}

		if (productsList.size() == 0) {

			Product prod1 = new Product();
			prod1.setId(1);
			prod1.setCode("ZK12-B");
			prod1.setDescription("Digital Kitchen Food Scale");
			prod1.setColor("Black");
			prod1.setCost(new BigDecimal(24.99));
			prod1.setQuantity(new BigDecimal(11));
			productsList.add(prod1);

			Product prod2 = new Product();
			prod2.setId(2);
			prod2.setCode("23WALK");
			prod2.setDescription("Women's Action Walker Shoes");
			prod2.setColor("White");
			prod2.setCost(new BigDecimal(99.95));
			prod2.setQuantity(new BigDecimal(6));
			productsList.add(prod2);

			Product prod3 = new Product();
			prod3.setId(3);
			prod3.setCode("40FS4610R");
			prod3.setDescription("TCL (Roku TV) 40-Inch 1080p Smart LED TV");
			prod3.setColor("Black");
			prod3.setCost(new BigDecimal(268.88));
			prod3.setQuantity(new BigDecimal(2));
			productsList.add(prod3);

			setProductsList(productsList);
		}

		return productsList;
	}

}
