/**
 * 
 */
package com.ashu.sbt.react.wf.poc.ent;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */

@Document(collection = "Products")
public class Product {
    @Id
    private String id;
    private String name;
    private int quantity;
    private double price;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @param id
     * @param name
     * @param quantity
     * @param price
     */
    public Product(String id, String name, int quantity, double price) {
        super();
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * 
     */
    public Product() {
        super();
    }

}
