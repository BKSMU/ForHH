package com.example.DrinkMachine;


import java.util.Date;//localtimestamp型に変更しよう
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Drinkmachine1Controller {
	@Autowired
	DrinkMachine1Dao Dmd;
	
	
	
	@GetMapping("/")
	 public String home(Model model){
		model.addAttribute("bean",new Bean());
	 return "home";
	 }
	
	@PostMapping("/insert")
	 public String insert(@ModelAttribute Bean bean, Model model){
		
		
//		ItemDto itemDto = new ItemDto();
//		itemDto.setDtoName(bean.getName());
//		itemDto.setDtoUnitPrice(bean.getUnitPrice());
//		itemDto.setDtoCount(bean.getCount());
//		itemDto.setDtoIsPr(bean.getIsPr());
		bean.setRecordDate(new Date());
		
		Dmd.insertOne(bean);
		
		model.addAttribute("bean",bean);
		
	 return "insert";
	 }
	
	@RequestMapping("/read")
	 public String read(@ModelAttribute Bean bean, Model model){
		List<Bean> searchList = Dmd.search();
		
		model.addAttribute("searchList", searchList);
		
	 return "read";
	 }
	@RequestMapping("/delete")
	 public String delete(int code){
		Dmd.delete(code);
	 return "delete";
	 }
	
	@RequestMapping("/searchOne")
	 public String searchOne(int code, Model model){
		Bean searchOne = Dmd.searchOne(code);
		model.addAttribute("searchOne", searchOne);
	 return "searchOne";
	 }
	
	@RequestMapping("/update")
	 public String update(@ModelAttribute Bean bean){
		
		bean.setRecordDate(new Date());
		Dmd.update(bean);
	 return "update";
	 }
}
