/**
 * 
 */
package com.ashu.sbt.micro.service.rpt.ent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Entity
@Table(name = "busdetails")
public class BusDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String busid;

	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "fromloc", nullable = false)
	private String fromloc;
	@Column(name = "toloc", nullable = false)
	private String toloc;
	@Column(name = "starttime", nullable = false)
	private String starttime;
	@Column(name = "stoptime", nullable = false)
	private String stoptime;
	@Column(name = "totalseat", nullable = false)
	private String totalseat;
	@Column(name = "fare", nullable = false)
	private String fare;

	/**
	 * 
	 */
	public BusDetails() {
		super();

	}

	/**
	 * @param busid
	 * @param name
	 * @param fromloc
	 * @param toloc
	 * @param starttime
	 * @param stoptime
	 * @param totalseat
	 * @param fare
	 */
	public BusDetails(String busid, String name, String fromloc, String toloc, String starttime, String stoptime,
			String totalseat, String fare) {
		super();
		this.busid = busid;
		this.name = name;
		this.fromloc = fromloc;
		this.toloc = toloc;
		this.starttime = starttime;
		this.stoptime = stoptime;
		this.totalseat = totalseat;
		this.fare = fare;
	}

	/**
	 * @return the busid
	 */
	public String getBusid() {
		return busid;
	}

	/**
	 * @param busid the busid to set
	 */
	public void setBusid(String busid) {
		this.busid = busid;
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
	 * @return the fromloc
	 */
	public String getFromloc() {
		return fromloc;
	}

	/**
	 * @param fromloc the fromloc to set
	 */
	public void setFromloc(String fromloc) {
		this.fromloc = fromloc;
	}

	/**
	 * @return the toloc
	 */
	public String getToloc() {
		return toloc;
	}

	/**
	 * @param toloc the toloc to set
	 */
	public void setToloc(String toloc) {
		this.toloc = toloc;
	}

	/**
	 * @return the starttime
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * @return the stoptime
	 */
	public String getStoptime() {
		return stoptime;
	}

	/**
	 * @param stoptime the stoptime to set
	 */
	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}

	/**
	 * @return the totalseat
	 */
	public String getTotalseat() {
		return totalseat;
	}

	/**
	 * @param totalseat the totalseat to set
	 */
	public void setTotalseat(String totalseat) {
		this.totalseat = totalseat;
	}

	/**
	 * @return the fare
	 */
	public String getFare() {
		return fare;
	}

	/**
	 * @param fare the fare to set
	 */
	public void setFare(String fare) {
		this.fare = fare;
	}

}
