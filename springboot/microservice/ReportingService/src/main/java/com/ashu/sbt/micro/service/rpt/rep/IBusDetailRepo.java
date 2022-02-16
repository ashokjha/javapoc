/**
 * 
 */
package com.ashu.sbt.micro.service.rpt.rep;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ashu.sbt.micro.service.rpt.ent.BusDetails;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
public interface IBusDetailRepo extends JpaRepository<BusDetails, String>{

}
