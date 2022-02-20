/**
 * 
 */
package com.ashu.poc.java8.ent;

import java.util.List;

/**
 * @author  Ashok Kumar Jha (ashu.kr.jha@gmail.com) SAmple Entity Class
 *
 */
public class Books {
	private int id;
	private String name;
	private String auther;
	private List<String> phones;
	
	/**
	 * 
	 */
	public Books() {
		super();
		// TODO 
	}
	/**
	 * @param id
	 * @param name
	 * @param auther
	 * @param phoneumber
	 */
	public Books(int id, String name, String auther, List<String> phones) {
		super();
		this.id = id;
		this.name = name;
		this.auther = auther;
		this.phones = phones;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the auther
	 */
	public String getAuther() {
		return auther;
	}
	/**
	 * @param auther the auther to set
	 */
	public void setAuther(String auther) {
		this.auther = auther;
	}
	/**
	 * @return the phones
	 */
	public List<String> getPhones() {
		return phones;
	}
	/**
	 * @param phoneumber the phones to set
	 */
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", auther=" + auther + ", phones=" + phones + "]";
	}
	

}
