package com.github.jaxrs_static.bean;

import java.io.Serializable;

public class ProductsSession implements Serializable {

	private static final long serialVersionUID = -7180545022410190915L;

	public static final String NAME = "productsSession";

	private ProductsList products;

	public ProductsList getProducts() {
		if (products == null) {
			products = new ProductsList();
		}

		return products;
	}

	public void setProducts(ProductsList products) {
		this.products = products;
	}

}
