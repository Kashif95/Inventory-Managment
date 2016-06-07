/**
 * 
 */
package com.sellar.managment.fms.report;

import java.io.File;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.sellar.managment.fms.order.domain.GeneratedOrderDetails;

/**
 * @author rakumari
 *
 */
public interface ReportService {

	Workbook createExcelReport(List<GeneratedOrderDetails> orderDetailsList);

}
