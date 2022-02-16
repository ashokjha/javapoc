/**
 * 
 */
package com.ashu.sbt.micro.service.rpt.srv;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ashu.sbt.micro.service.rpt.ent.BusDetails;
import com.ashu.sbt.micro.service.rpt.rep.IBusDetailRepo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Service
public class BusDetailsSrv {

	@Autowired
	private IBusDetailRepo busrepo;

	@Value("${report.path}")
	private String rptpath;

	@Value("${report.template.path}")
	private String rpttemppath;

	/**
	 * @param busrepo
	 */
	public BusDetailsSrv(IBusDetailRepo busrepo) {
		super();
		this.busrepo = busrepo;
	}

	public String exportReport(String format) throws JRException, FileNotFoundException {
		List<BusDetails> buses = busrepo.findAll();
		String reportName = rptpath+"bus_detail_report";
		JasperReport jasperReport = JasperCompileManager
				.compileReport(ResourceUtils.getFile(
						rpttemppath + "samplereport.jrxml").getAbsolutePath());
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("Objective", "SADA Future");
		parameters.put("Origin", "Ashok Kumar Jha");
		parameters.put("Email", "ashu.kr.jha@gmail.com");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
				new JRBeanCollectionDataSource(buses));
		if (StringUtils.equalsIgnoreCase(format, "HTML")) {
			reportName = reportName+".html";
			JasperExportManager.exportReportToHtmlFile(jasperPrint, reportName);	
		} else if (StringUtils.equalsIgnoreCase(format, "pdf")) {
			reportName = reportName+".pdf";
			JasperExportManager.exportReportToPdfFile(jasperPrint, reportName);
		}
		return reportName;
	}
}
