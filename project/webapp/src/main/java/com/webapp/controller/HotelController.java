package com.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.webapp.exception.DAOException;
import com.webapp.service.impl.HotelServiceImpl;
import com.webapp.web.vo.EmployeeVo;
import com.webapp.web.vo.HotelVo;

@Controller
public class HotelController {
	
	@Autowired
	HotelServiceImpl hotelservice;
	
	@RequestMapping(value="/hotelController",method = RequestMethod.GET)
	String hotel(ModelMap model){
		HotelVo hotel=new HotelVo();
		model.addAttribute("hotel",hotel);
		return "addHotel";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST,headers="name=pankaj")
	String addHotel(@ModelAttribute("hotel") HotelVo HotelVo,
            BindingResult result, SessionStatus status){
		System.out.println(HotelVo.getHotelname());
		System.out.println(HotelVo.getCity());
		System.out.println(HotelVo.getState());
		try {
			hotelservice.addHotel(HotelVo);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "addHotel";
	}

}
