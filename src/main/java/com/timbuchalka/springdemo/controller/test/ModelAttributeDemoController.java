package com.timbuchalka.springdemo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.timbuchalka.springdemo.domain.Address;

@Controller
public class ModelAttributeDemoController {
	
	private static final String MA_HOME = "testfolder/modelAttributeHome";
	private static Logger LOGGER = LoggerFactory.getLogger(ModelAttributeDemoController.class);
	
	@RequestMapping(value = "/home")
	public String home() {
		LOGGER.info("INSIDE home: " + System.currentTimeMillis());
		return MA_HOME;
	}
	
	@RequestMapping(value = "/home2")
	public ModelAndView home2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(MA_HOME);
		mav.addObject("command", new Address());
		return mav;
	}
	
	@RequestMapping(value = "/home3")
	public ModelAndView home3() {
		ModelAndView mav = new ModelAndView(MA_HOME);
		mav.addObject("anAddress", new Address());
		return mav;
	}
	
	@RequestMapping(value = "/home4")
	public ModelAndView home4() {
		return new ModelAndView(MA_HOME, "anAddress", 
				new Address("Melbourne", "3000"));
	}
	
	@RequestMapping(value = "/home5")
	public String home5(Model model) {
		model.addAttribute("anAddress", new Address("Brisbane", "4000"));
		return MA_HOME;
	}
	
	@ModelAttribute
	public void modelAttributeTest1(Model model) {
		LOGGER.info("INSIDE modelAttributeTest1: " + System.currentTimeMillis());
		model.addAttribute("testdata1A", "Welcome to the @ModelAttribute Test Bed!");
		model.addAttribute("testdata1B", 
				"We will test both usages of the @ModelAttribute, on methods and on method arguments");
	}
	
	@ModelAttribute(name = "testData2")
	public String modelAttributeTest2() {
		LOGGER.info("INSIDE modelAttributeTest2");
		return "We will conduct a series of tests here";
	}
	
	@ModelAttribute(value = "testData3")
	public Address modelAttributeTest3() {
		LOGGER.info("INSIDE modelAttributeTest3");
		return new Address("Adelaide", "5000");
	}
	
	@ModelAttribute
	public Address modelAttribute4() {
		LOGGER.info("INSIDE modelAttribute4");
		return new Address("Sydney", "2000");
	}
	
	@RequestMapping(value = "/test5", method = RequestMethod.POST)
	public String modelAttribute5(@ModelAttribute(value="anAddress") Address anAddress,
			ModelMap model) {
		model.addAttribute("testdata5A", anAddress.getCity());
		model.addAttribute("testdata5B", anAddress.getZipCode());
		return "modelAttributeTest";
	}
	
	@RequestMapping(value = "/modelAttributeTest")
	@ModelAttribute("testdata6")
	public Address modelAttributeTest6() {
		return new Address("Canberra", "2600");
	}
}












