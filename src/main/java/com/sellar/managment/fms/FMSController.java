/**
 * 
 */
package com.sellar.managment.fms;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sellar.managment.fms.agency.AgencyService;
import com.sellar.managment.fms.agency.domain.AgencyDetail;
import com.sellar.managment.fms.agency.domain.AgencyDetailWrapper;
import com.sellar.managment.fms.product.ProductService;
import com.sellar.managment.fms.product.domain.ProductDetail;
import com.sellar.managment.fms.product.domain.ProductDetailWrapper;
import com.sellar.managment.fms.product.domain.ProductType;
import com.sellar.managment.fms.retailer.RetailerService;
import com.sellar.managment.fms.retailer.domain.RetailerDetail;
import com.sellar.managment.fms.retailer.domain.RetailerDetailWrapper;
import com.sellar.managment.fms.security.AccountUserDetails;
import com.sellar.managment.fms.user.UserService;
import com.sellar.managment.fms.user.domain.UserDetails;
import com.sellar.managment.fms.user.domain.UserType;
import com.sellar.managment.fms.util.FMSConstant;

/**
 * @author rakumari
 *
 */

@Controller
public class FMSController {
	
	
	@Autowired
	@Qualifier("fmsAgency")
	private AgencyService agencyService;
	
	@Autowired
	private RetailerService retailerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	UserService userService;
	private static final Logger LOGGER = LogManager
            .getLogger(FMSController.class);
	
	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping("/home")
	public @ResponseBody String displayHomePage(HttpServletRequest request){
		
		//UserDetails user  = userService.getUserByUserId(name);
		AccountUserDetails user = (AccountUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		Map<String, Object> userDetailMap = new HashedMap();
		userDetailMap.put(FMSConstant.USER_NAME, user.getUserFirstName());
		userDetailMap.put(FMSConstant.USER_ROLE, user.getAuthorities().toArray()[0]);
		userDetailMap.put(FMSConstant.USER_COMPANY, user.getCompanyType());
		request.getSession().setAttribute(FMSConstant.USER_DETAIL, userDetailMap);
		
		ObjectMapper map = new ObjectMapper();
		String userDetailMapString=null;
		try {
			userDetailMapString =  map.writeValueAsString(userDetailMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDetailMapString;
	}
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping(value="/agency/saveAgency",method=RequestMethod.PUT)
	public  String saveAgencyDetail(@RequestBody AgencyDetailWrapper agencyDetail,HttpServletRequest request){
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		String userName = (String) userMap.get(FMSConstant.USER_NAME);
		try{
			agencyService.saveAgencyDetail(agencyDetail,userName);
		}catch(Exception e){
			LOGGER.error(e);
			throw new FMSCustomException("database issue while saving");
		}
		return  "redirect:/agency/getAgencyList";
		
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping(value="/agency/deleteAgency",method=RequestMethod.PUT)
	public  String deletAgencyDetail(@RequestBody AgencyDetail agencyDetail,HttpServletRequest request){
		try{
			agencyService.deletAgencyDetail(agencyDetail);
		}catch(Exception e){
			LOGGER.error(e);
			throw new FMSCustomException("database issue while saving");
		}
		return  "redirect:/agency/getAgencyList";
		
	}
	
	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping("/agency/getAgencyList")
	public @ResponseBody List<AgencyDetail> getAllAgencyDetails(){
		
		return agencyService.getAllAgencyList();
	}
	
	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping("/agency/getAgencyById")
	public @ResponseBody AgencyDetailWrapper getAgencyDetailById(@RequestBody Integer agencyId){
		
		return agencyService.getAgencyDetailByAgencyId(agencyId);
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping(value="/retailer/saveRetailer",method=RequestMethod.PUT)
	public String saveRetailerDetails(@RequestBody RetailerDetailWrapper retailerDetail,HttpServletRequest request){
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		String userName = (String) userMap.get(FMSConstant.USER_NAME);
	 try{	
		 retailerService.saveRetailerDetail(retailerDetail,userName);
	 }catch(HibernateException e){
			LOGGER.error(e);
			throw new FMSCustomException("database issue while saving retailer data");
		} 
		return "redirect:/retailer/getRetailerList";
		
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping(value="/retailer/deleteRetailer",method=RequestMethod.PUT)
	public String deleteRetailerDetails(@RequestBody RetailerDetail retailerDetail,HttpServletRequest request){
		
	 try{	
		 retailerService.deleteRetailerDetail(retailerDetail);
	 }catch(HibernateException e){
			LOGGER.error(e);
			throw new FMSCustomException("database issue while saving retailer data");
		} 
		return "redirect:/retailer/getRetailerList";
		
	}
	
	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping("/retailer/getRetailerList")
	public @ResponseBody  List<RetailerDetail> getAllRetailerDetails(){
		
		return retailerService.getAllRetailerList();
	}
	
	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping("/retailer/getRetailerById")
	public @ResponseBody RetailerDetail getRetailerDetailById(@RequestBody String retailerId){
		
		return retailerService.getRetailerDetailByRetailerId(Integer.getInteger(retailerId));
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping(value="/product/saveProduct",method=RequestMethod.PUT)
	public String saveProductDetails(@RequestBody ProductDetailWrapper productDetail,HttpServletRequest request){
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
	 try{	
		 productService.saveProduct(productDetail,userMap);
	 }catch(HibernateException e){
			LOGGER.error("database issue while saving product data"+e);
			throw new FMSCustomException("database issue while saving product data");
		} 
		return "redirect:/product/getProductList";
		
	}
	
	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping("/product/getProductList")
	public @ResponseBody  List<ProductDetail> getAllProductList(HttpServletRequest request){
		return productService.getAllProductList(userService.getLoggedInUserCompType(request));
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping(value="/product/deleteProduct",method=RequestMethod.PUT)
	public String deleteProductDetails(@RequestBody ProductDetail productDetail,HttpServletRequest request){
		
	 try{	
		 productService.deleteProduct(productDetail);
	 }catch(HibernateException e){
			LOGGER.error("database issue while deleting product data"+e);
			throw new FMSCustomException("database issue while deleting product data");
		} 
		return "redirect:/product/getProductList";
		
	}
	
	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping(value="/product/getProductListByAgencyId",method=RequestMethod.PUT)
	public @ResponseBody  List<ProductDetail> getProductListByAgencyId(@RequestBody String agencyId,HttpServletRequest request){
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		Short compType = (Short) userMap.get(FMSConstant.USER_COMPANY);
		
		return productService.getProductListByAgencyId(Integer.valueOf(agencyId),compType);
	}
	
	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping("user/getUserRoleList")
	public @ResponseBody  List<UserType> getAllUserRoleList(){
		
		return userService.getAllUserRoleList();
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping(value="/user/saveUser",method=RequestMethod.PUT)
	public String saveUserDetails(@RequestBody String user,HttpServletRequest request){
		
		ObjectMapper mapper = new ObjectMapper();
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		
	 try{	
		 UserDetails userDetail = mapper.readValue(user, UserDetails.class);
		 userService.saveUserDetail(userDetail,userMap);
	 }catch(HibernateException e){
			LOGGER.error("database issue while saving user data"+e);
			throw new FMSCustomException("database issue while saving user data");
		} catch (JsonParseException e) {
		// TODO Auto-generated catch block
			LOGGER.error(e);
			throw new FMSCustomException("Parsing exception while saving user data");
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return "redirect:/user/getUserList";
		
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/user/getUserList")
	public @ResponseBody  List<UserDetails> getUserList(HttpServletRequest request){
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		Short companyType = (Short) userMap.get(FMSConstant.USER_COMPANY);
		return userService.getUserList(companyType);
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping(value="/user/deleteUser",method=RequestMethod.PUT)
	public String deleteUserDetails(@RequestBody UserDetails userDetail,HttpServletRequest request){
		
	 try{	
		 userService.deleteUser(userDetail);
	 }catch(HibernateException e){
			LOGGER.error("database issue while deleting user data" +e);
			throw new FMSCustomException("database issue while deleting user data");
		} 
		return "redirect:/user/getUserList";
		
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping(value="/user/getUserByphoneNum/{phnNum}",method=RequestMethod.GET)
	public @ ResponseBody String getUserByPhoneNumber(@PathVariable String phnNum,HttpServletRequest request){
		
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		Short companyType = (Short) userMap.get(FMSConstant.USER_COMPANY);
	 try{	
		 UserDetails user = userService.getUserByUserIdAndCompId(phnNum,companyType);
		 if(user==null){
			 return "TRUE";
		 }
	 }catch(HibernateException e){
			LOGGER.error(e);
			throw new FMSCustomException("database issue while deleting user data");
		} 
	 return "FALSE";
		
	}
	
	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping("/product/getProductTypeList")
	public @ResponseBody  List<ProductType> getProductTypeList(HttpServletRequest request){
		Map userMap  = (Map) request.getSession().getAttribute(FMSConstant.USER_DETAIL);
		Short compType = (Short) userMap.get(FMSConstant.USER_COMPANY);
		return productService.getProductTypeList(compType);
	}
	
	@PreAuthorize("isFullyAuthenticated() and  hasAnyRole('Admin')")
	@RequestMapping("/retailer/getSerchedRetailerList")
	public @ResponseBody  List<RetailerDetail> getSearchedRetailer(@RequestParam("searchKey") String searchKey){
		
		return retailerService.getSearchedRetailer(searchKey);
	}

	
	
	
	
	

}
