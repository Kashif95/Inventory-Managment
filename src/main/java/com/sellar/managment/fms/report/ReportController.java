/**
 * 
 */
package com.sellar.managment.fms.report;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sellar.managment.fms.FMSCustomException;
import com.sellar.managment.fms.order.OrderService;
import com.sellar.managment.fms.order.domain.GeneratedOrderDetails;

/**
 * @author rakumari
 *
 */
@Controller
public class ReportController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ReportService reportService;
	
	private static final Logger LOGGER = LogManager
            .getLogger(ReportController.class);
	
	
	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping(value="/report/fms/orderReport", method = RequestMethod.POST)
	public void  populateOrderReport(HttpServletRequest request,HttpServletResponse response) throws ServletRequestBindingException{
		
		List<GeneratedOrderDetails> orderDetailsList = new ArrayList<GeneratedOrderDetails>();
			
		orderDetailsList = orderService.getOrderDetailsList();
		//return new ModelAndView("excelView","orderList",orderDetailsList);

		try{
			 Workbook workbook  = reportService.createExcelReport(orderDetailsList);
			 downloadExcelReport(workbook,response);
		}catch(FMSCustomException | ServletException | IOException e){
			LOGGER.error("Error occured while populating report data"+e);
		}
				
		
	}


	private void downloadExcelReport(Workbook workbook,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream stream = null;
	    BufferedInputStream buf = null;
		      stream = response.getOutputStream();
		      	response.setHeader("Cache-Control","must-revalidate");
		        response.setHeader("Pragma", "public");
		        response.setHeader("Content-Transfer-Encoding","binary");
		      response.setHeader("Content-Disposition", "attachment; filename=orderReport.xls");
		      //response.setContentLength((int) file.length());
		     workbook.write(stream);
		     stream.flush();
		     stream.close();
		     
		  
	}	  


}
