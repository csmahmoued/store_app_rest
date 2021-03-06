package com.store.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.store.errors.NotFoundException;
import com.store.model.Product;
import com.store.model.ProductGalary;
import com.store.model.ResponseMessage;
import com.store.service.ProductGalaryService;
import com.store.service.ProductService;


@RestController
@CrossOrigin
public class ProductGalaryController {

	@Autowired
	private ProductGalaryService storageService;
	
	@Autowired
	private ProductService ps;
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file ,@RequestParam int productId) {
		String message = "";
		try {
			storageService.save(file);

			String filename =  file.getOriginalFilename();
			String url = MvcUriComponentsBuilder
					.fromMethodName(ProductGalaryController.class, "getFile", file.getOriginalFilename().toString()).build()
					.toString();
	
			Product product=ps.getProductById(productId);

			if(product==null) {
				throw new NotFoundException("product with this id not found");
			}
			ProductGalary galary=new ProductGalary();
			galary.setImgName(filename);
			galary.setProduct(product);
			galary.setUrl(url);
			
			storageService.saveProductImg(galary);
			
			
			
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	

	/*

	@GetMapping("/files")
	public ResponseEntity<List<ProductGalary>> getListFiles() {
		List<ProductGalary> fileInfos = storageService.loadAll().map(path -> {			
			String filename = path.getFileName().toString();
			String url = MvcUriComponentsBuilder
					.fromMethodName(ProductGalaryController.class, "getFile", path.getFileName().toString()).build()
					.toString();
			return new ProductGalary(filename, url);
		}).collect(Collectors.toList());;

		return ResponseEntity.status(HttpStatus.OK).body(fileInfos);

	}
	
	*/
	@GetMapping("/files/{filename:.+}")
	  @ResponseBody
	  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
	    Resource file = storageService.load(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	  }

	
	
	
	
}

	

