package com.woniuxy.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.woniuxy.domain.Product;
import com.woniuxy.service.IProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	private IProductService service;

	@GetMapping
	public List<Product> findAll() {
		return service.findAll();
	}
	
	@GetMapping("front")
	public List<Product> findAll1(@RequestParam int page) {
		return service.findAll1(page);
	}
	
	@GetMapping("countpage")
	public Map<String, Object> findAll1() {
		int max = (Integer) service.findCountPage();
		Map< String, Object> map = new HashMap<>();
		map.put("max", max);
		List<Integer> clist = new ArrayList<>(max);
		for (Integer i = 0; i < max; i++) {
			clist.add(i+1);
		};
		map.put("clist", clist);
		return map;
	}
 


	// 查找热门前n产品
	@GetMapping("{num}")
	public List<Product> findByLooktimesTen(@PathVariable Integer num) {
		return service.findByLooktimesTen(num);
	}
	
	@PostMapping
	public void save(@RequestBody Product product,@RequestParam(required = false) CommonsMultipartFile[] photo2, HttpServletRequest request) throws IllegalStateException, IOException {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < photo2.length; i++) {
			String oldName = photo2[i].getOriginalFilename();
			int lastDot = oldName.lastIndexOf(".");
			String ext = oldName.substring(lastDot);
			String newName = UUID.randomUUID().toString().replaceAll("-", "") + ext;
			String path = request.getServletContext().getRealPath("/images");
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			photo2[i].transferTo(new File(path, newName));
			sb.append(newName);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		product.setPhoto(sb.toString());
		service.save(product);
	}
	@DeleteMapping
	public void delete(Integer proid, HttpServletRequest request) {
	}
	@PutMapping
	public void update(Product product,@RequestParam(required = false) CommonsMultipartFile[] photo2, HttpServletRequest request) {
	}

}
