package kr.ac.kopo.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.model.Orders;
import kr.ac.kopo.bookshop.service.BookService;
import kr.ac.kopo.bookshop.service.CustomerService;
import kr.ac.kopo.bookshop.service.OrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	private final String path="orders/";
	@Autowired
	OrdersService service;
	
	@Autowired
	BookService bookService;
	
	@Autowired 
	CustomerService customerService;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Orders> list=service.list();
		model.addAttribute("list",list);
		
		return path+"list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		
		List<Book> books=bookService.list();
		List<Customer> customers=customerService.list();
		
		model.addAttribute("customers",customers);
		model.addAttribute("books",books);
		
		return path+"add";
	}
	@PostMapping("/add")
	public String add(Orders item) {
		service.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{orderid}")
	public String update(@PathVariable int orderid,Model model) {
		Orders item=service.item(orderid);
		List<Book> books=bookService.list();
		List<Customer> customers=customerService.list();
		
		model.addAttribute("customers",customers);
		model.addAttribute("books",books);
		model.addAttribute("item",item);
		return path+"update";
	}
	@PostMapping("update/{orderid}")
	public String update(@PathVariable int orderid, Orders item) {
		service.update(item);
		return "redirect:../list";
	}
	
	@GetMapping("delete/{orderid}")
	public String delete(@PathVariable int orderid) {
		service.delete(orderid);
		return "redirect:../list";
	}
}
