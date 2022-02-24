/**
 * 
 */
package com.ashu.sbt.react.wf.poc.dto;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */

public class Customer {

    private int id;
    private String name;

    /**
     * 
     */
    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @param id
     * @param name
     */
    public Customer(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
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

}
