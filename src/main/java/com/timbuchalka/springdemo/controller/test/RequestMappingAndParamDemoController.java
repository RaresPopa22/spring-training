package com.timbuchalka.springdemo.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/requestMappingAndParamDemo")
public class RequestMappingAndParamDemoController {

	private static Logger LOGGER = 
			LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);
		
	@RequestMapping(value = "/home")
	private String home() {
		return "requestMappingAndParamHome";
	}
	
	@RequestMapping(value  ="/test1")
	public String requestMappingAndParamTest1(@RequestParam("orgName") String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test1");
		
		return "requestMappingAndParamResults";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String requestMappingAndParamTest2(@RequestParam("orgName") String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test2");
		
		return "requestMappingAndParamResults";
	}
	
	@RequestMapping(value = "*", method = RequestMethod.GET)
	public String requestMappingAndParamTest3() {		
		return "fallback";
	}
	
	@RequestMapping(value = "/test4")
	public String requestMappingAndParamTest4(
			@RequestParam(value = "orgName", defaultValue = "Anonymus Organization") String orgName, 
			Model model) {		
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test4");
		return "requestMappingAndParamResults";
	}
	
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String requestMappingAndParamTest5(@RequestParam String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test5");
		
		return "requestMappingAndParamResults";
	}
	
	@RequestMapping(value = "/test6", params = "orgName")
	public String requestMappingAndParamTest6Subtest1(@RequestParam String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test6-subtest1");
		
		return "requestMappingAndParamResults2";
	}
	
	@RequestMapping(value = "/test6", params = "empCount")
	public String requestMappingAndParamTest6Subtest2(@RequestParam String empCount, Model model) {
		model.addAttribute("orgName", empCount);
		model.addAttribute("testSerial", "test6-subtest2");
		
		return "requestMappingAndParamResults2";
	}
	
	@RequestMapping(value = "/test6/subtest3", method = RequestMethod.GET,
			params = {"orgName", "empCount"})
	public String requestMappingAndParamTest6Subtest3(@RequestParam String orgName, 
			@RequestParam String empCount, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("empCount", empCount);
		model.addAttribute("testSerial", "test6-subtest3");
		
		return "requestMappingAndParamResults2";
	}
	
	@RequestMapping(value = "/test6/subtest4", method = RequestMethod.GET,
			params = {"orgName", "empCount"})
	public String requestMappingAndParamTest6Subtest4(@RequestParam String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test6-subtest4");
		
		return "requestMappingAndParamResults2";
	}
	
	@RequestMapping(value = {"/test7", "/test8"}, method = RequestMethod.GET)
	public String requestMappingAndParamTest7and8(@RequestParam String orgName, Model model,
			HttpServletRequest request) {
		model.addAttribute("orgName", orgName);
		LOGGER.info(request.getRequestURL().toString());
		
		if(request.getRequestURL().toString().contains("test7")) {
			model.addAttribute("testSerial", "test7");
		} else {
			model.addAttribute("testSerial", "test8");			
		}
		
		return "requestMappingAndParamResults2";
	}
}

















