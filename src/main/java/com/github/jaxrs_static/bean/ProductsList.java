package com.github.jaxrs_static.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProductsList implements List<Product>, Serializable {

	private static final long serialVersionUID = -5114621348340529655L;

	public ProductsList() {
		super();
		setTheList(null);
	}

	public ProductsList(List<Product> theList) {
		super();
		setTheList(theList);
	}

	private List<Product> theList;

	public List<Product> getTheList() {
		if (theList == null) {
			setTheList(null);
		}

		return theList;
	}

	public void setTheList(List<Product> theList) {
		if (theList == null) {
			this.theList = new ArrayList<Product>();
		} else {
			this.theList = theList;
		}
	}

	@Override
	public int size() {
		return getTheList().size();
	}

	@Override
	public boolean isEmpty() {
		return getTheList().isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return getTheList().contains(o);
	}

	@Override
	public Iterator<Product> iterator() {
		return getTheList().iterator();
	}

	@Override
	public Object[] toArray() {
		return getTheList().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return getTheList().toArray(a);
	}

	@Override
	public boolean add(Product e) {
		return getTheList().add(e);
	}

	@Override
	public boolean remove(Object o) {
		return getTheList().remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return getTheList().containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Product> c) {
		return getTheList().addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Product> c) {
		return getTheList().addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return getTheList().removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return getTheList().retainAll(c);
	}

	@Override
	public void clear() {
		getTheList().clear();
	}

	@Override
	public Product get(int index) {
		return getTheList().get(index);
	}

	@Override
	public Product set(int index, Product element) {
		return getTheList().set(index, element);
	}

	@Override
	public void add(int index, Product element) {
		getTheList().add(index, element);
	}

	@Override
	public Product remove(int index) {
		return getTheList().remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return getTheList().indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return getTheList().lastIndexOf(o);
	}

	@Override
	public ListIterator<Product> listIterator() {
		return getTheList().listIterator();
	}

	@Override
	public ListIterator<Product> listIterator(int index) {
		return getTheList().listIterator(index);
	}

	@Override
	public List<Product> subList(int fromIndex, int toIndex) {
		return getTheList().subList(fromIndex, toIndex);
	}

}
