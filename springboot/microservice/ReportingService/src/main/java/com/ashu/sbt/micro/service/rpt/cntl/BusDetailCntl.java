/**
 * 
 */
package com.ashu.sbt.micro.service.rpt.cntl;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.sbt.micro.service.rpt.srv.BusDetailsSrv;

import net.sf.jasperreports.engine.JRException;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */

@RestController
@RequestMapping("/ashu/rpt")
@RefreshScope
public class BusDetailCntl {

	@Autowired
	private BusDetailsSrv busDetailSrv;

	/**
	 * @param busDetailSrv
	 */
	public BusDetailCntl(BusDetailsSrv busDetailSrv) {
		super();
		this.busDetailSrv = busDetailSrv;
	}

	@GetMapping("{type}")
	public String createReport(@PathVariable("type") String type) throws JRException, FileNotFoundException {
		return busDetailSrv.exportReport(type);
	}

}
