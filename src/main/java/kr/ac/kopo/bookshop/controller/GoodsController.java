package kr.ac.kopo.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.bookshop.model.Goods;
import kr.ac.kopo.bookshop.pager.Pager;
import kr.ac.kopo.bookshop.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	final String path = "goods/";

	@Autowired
	GoodsService service;
	
	@GetMapping("/dummy")
	public String dummy() {
		service.dummy();
		
		return "redirect:list";
	}
	
	@GetMapping("/init")
	public String init() {
		service.init();
		
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String list(Model model, Pager pager) {
		List<Goods> list = service.list(pager);

		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(Goods item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{goodsId}")
	public String update(@PathVariable int goodsId, Model model) {
		Goods item = service.item(goodsId);
		
		model.addAttribute("item", item);
		
		return path + "update";
		
	}
	
	@PostMapping("/update/{goodsId}")
	public String update(@PathVariable int goodsId, Goods item) {
		item.setGoodsId(goodsId);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{goodsId}")
	public String delete(@PathVariable int goodsId) {
		service.delete(goodsId);
		
		return "redirect:../list";
	}
}
