/**
 * 
 */
package com.sellar.managment.medicine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sellar.managment.fms.product.ProductService;
import com.sellar.managment.medicine.agency.AgencyService;
import com.sellar.managment.medicine.agency.domain.MedicalAgencyDetail;






/**
 * @author rakumari
 *
 */@Controller
public class MedicineController {
	 
	 @Autowired
	 @Qualifier("medicalAgency")
	 AgencyService agencyService;
	 
	 @Autowired
	 ProductService productService;
	
	private static final Logger LOGGER = LogManager
            .getLogger(MedicineController.class);
	
	@RequestMapping(value="/medicine/agency/saveAgency",method=RequestMethod.PUT)
	public  String saveAgencyDetail(@RequestBody String agency,HttpServletRequest request){
		try{
			ObjectMapper mapper = new ObjectMapper();
			MedicalAgencyDetail agencyDetail = mapper.readValue(agency, MedicalAgencyDetail.class);
			agencyService.saveAgencyDetail(agencyDetail);
		}catch(Exception e){
			LOGGER.error(e);
			throw new MedicineCustomException("database issue while saving");
		}
		return  "redirect:/medicine/agency/getAgencyList";
		
	}
	
	@RequestMapping("/medicine/agency/getAgencyList")
	public @ResponseBody List<MedicalAgencyDetail> getAllAgencyDetails(){
		
		return agencyService.getAllAgencyList();
	}
	
	@RequestMapping("/medicine/agency/getAgencyById")
	public @ResponseBody MedicalAgencyDetail getAgencyDetailById(@RequestBody Integer agencyId){
		
		return agencyService.getAgencyDetailByAgencyId(agencyId);
	}
	
	@RequestMapping(value="/medicine/agency/deleteAgency",method=RequestMethod.PUT)
	public  String deletAgencyDetail(@RequestBody MedicalAgencyDetail agencyDetail,HttpServletRequest request){
		try{
			agencyService.deleteAgencyDetail(agencyDetail);
		}catch(Exception e){
			LOGGER.error(e);
			throw new MedicineCustomException("database issue while saving");
		}
		return  "redirect:/agency/getAgencyList";
		
	}
	
	

}
