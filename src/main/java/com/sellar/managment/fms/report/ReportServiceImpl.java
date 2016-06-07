/**
 * 
 */
package com.sellar.managment.fms.report;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.sellar.managment.fms.order.domain.GeneratedOrderDetails;
import com.sellar.managment.fms.order.domain.OrderedProduct;

/**
 * @author rakumari
 *
 */
@Service
public class ReportServiceImpl implements ReportService {
	
	private static final Logger LOGGER = LogManager
            .getLogger(ReportServiceImpl.class);

	@Override
	public Workbook createExcelReport(List<GeneratedOrderDetails> orderDetailsList) {
		// TODO Auto-generated method stub
		HSSFWorkbook workbook = new HSSFWorkbook(); 
        
        //Create a blank sheet
        HSSFSheet sheet = workbook.createSheet("Order Data");
        
        int rownum =0;
        Row row = sheet.createRow(rownum++);
        for(int cellnum = 0;  cellnum <14; cellnum++){
        	Cell cell = row.createCell(cellnum);
        	cell.setCellValue(ReportColumNameEnum.values()[cellnum].getName());
        }
        
        for(GeneratedOrderDetails order : orderDetailsList){
        	
        	List<OrderedProduct> productList = order.getOrderedProductList();
             	
        	for(OrderedProduct product : productList){
        		int cellnum = 0;
        		Row row1 = sheet.createRow(rownum++);
        		Cell cell1 = row1.createCell(cellnum++);
        		cell1.setCellValue(product.getOrderId());
        		Cell cell2 = row1.createCell(cellnum++);
        		cell2.setCellValue(product.getProductStock().getProductId());
        		Cell cell3 = row1.createCell(cellnum++);
        		cell3.setCellValue(product.getProductStock().getProductDetail().getProductName());
        		Cell cell4 = row1.createCell(cellnum++);
        		cell4.setCellValue(product.getProductStock().getAgencyId());
        		Cell cell5 = row1.createCell(cellnum++);
        		cell5.setCellValue(product.getProductStock().getProductDetail().getAgencyDetail().getAgencyName());
        		Cell cell6 = row1.createCell(cellnum++);
        		cell6.setCellValue(product.getQuantity());
        		Cell cell7 = row1.createCell(cellnum++);
        		cell7.setCellValue(product.getOrderDetail().getOrderTotalPrice());
        		Cell cell8 = row1.createCell(cellnum++);
        		cell8.setCellValue(product.getOrderDetail().getOrderPrice());
        		Cell cell9 = row1.createCell(cellnum++);
        		cell9.setCellValue(product.getOrderDetail().getLabourFee());
        		Cell cell10 = row1.createCell(cellnum++);
        		cell10.setCellValue(product.getOrderDetail().getShippingFee());
        		Cell cell11 = row1.createCell(cellnum++);
        		cell11.setCellValue(product.getOrderDetails().getRetailerDetail().getRetailerFirstName()+" "+product.getOrderDetails().getRetailerDetail().getRetailerLastName());
        		Cell cell12 = row1.createCell(cellnum++);
        		cell12.setCellValue(product.getOrderDetail().getRetailerDetail().getMobileNumber());
        		Cell cell13 = row1.createCell(cellnum++);
        		cell13.setCellValue(product.getOrderDetail().getCreatedOn());SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        		String creatinDate = df.format(product.getOrderDetail().getCreatedOn());
        		cell13.setCellValue(creatinDate);
        		Cell cell14 = row1.createCell(cellnum++);
        		cell14.setCellValue(product.getOrderDetail().getOrderStatus().getDescription());
        		
        		
        	}
        	 
        }
        
        return workbook;
        	
		
	}

	/*@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<GeneratedOrderDetails> orderDetailsList = (List<GeneratedOrderDetails>) model.get("orderList");
		
		
	}*/

}
