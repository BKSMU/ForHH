package com.example.DrinkMachine;


import java.util.Date;

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
		
		
		ItemDto itemDto = new ItemDto();
		itemDto.setDtoName(bean.getName());
		itemDto.setDtoUnitPrice(bean.getUnitPrice());
		itemDto.setDtoCount(bean.getCount());
		itemDto.setDtoIsPr(bean.getIsPr());
		itemDto.setDtoRecordDate(new Date());
		
		Dmd.insertOne(itemDto);
		
		model.addAttribute("bean",itemDto);
		
	 return "insert";
	 }
	
	@RequestMapping("/read")
	 public String read(){
		
		
	 return "read";
	 }
	@RequestMapping("/delete")
	 public String delete(){
	 return "delete";
	 }
}
