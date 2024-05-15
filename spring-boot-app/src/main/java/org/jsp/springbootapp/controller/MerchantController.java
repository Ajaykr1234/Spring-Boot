package org.jsp.springbootapp.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootapp.dto.Merchant;
import org.jsp.springbootapp.dto.Product;
import org.jsp.springbootapp.dto.ResponseStructure;
import org.jsp.springbootapp.repository.MerchantRepository;
import org.jsp.springbootapp.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

	@Autowired
	private MerchantService merchantService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant) {
		return merchantService.saveMerchant(merchant);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> findById(@PathVariable(name = "id") int id) {

		return merchantService.findById(id);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
		return merchantService.updateMerchant(merchant);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Merchant>>> findAll() {
		return merchantService.findAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> deleteMerchant(@PathVariable(name = "id") int id) {
		return merchantService.deleteMerchant(id);
	}

	@GetMapping("/findbyname/{name}")
	public ResponseEntity<ResponseStructure<List<Merchant>>> findByName(@PathVariable(name = "name") String name) {
		return merchantService.findByName(name);
	}

	@GetMapping("/findbyphone/{phone}")
	public ResponseEntity<ResponseStructure<Merchant>> findByPhone(@PathVariable(name = "phone") long phone) {
		return merchantService.findByPhone(phone);
	}

	@PostMapping("/findbyphoneandpassword")
	public ResponseEntity<ResponseStructure<Merchant>> findByPhoneAndPassword(@RequestParam(name = "phone") long phone,
			@RequestParam(name = "password") String password) {
		return merchantService.findByPhoneAndPassword(phone, password);
	}

	@PostMapping("/verifybyemailandpassword")
	public ResponseEntity<ResponseStructure<Merchant>> verifyByEmailAndPassword(
			@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
		return merchantService.verifyByEmailAndPassword(email, password);
	}

	@PostMapping("/verifybyidandpassword")
	public ResponseEntity<ResponseStructure<Merchant>> verifyByIdAndPassword(@RequestParam(name = "id") int id,
			@RequestParam(name = "password") String password) {
		return merchantService.verifyByIdAndPassword(id, password);
	}

	@PostMapping("/verifybygstandpassword")
	public ResponseEntity<ResponseStructure<Merchant>> verifyByGstAndPassword(
			@RequestParam(name = "gst_number") String gst_number, @RequestParam(name = "password") String password) {
		return merchantService.verifyByGstAndPassword(gst_number, password);
	}

	@GetMapping(value = "/findbygst/{gst_number}")
	public ResponseEntity<ResponseStructure<Merchant>> findByGst_Number(
			@PathVariable(name = "gst_number") String gst_number) {
		return merchantService.findByGst_Number(gst_number);
	}

	@GetMapping("/findallname")
	public ResponseEntity<ResponseStructure<List<String>>> findAllName() {
		return merchantService.findAllName();

	}

	@GetMapping("/findAllId")
	public ResponseEntity<ResponseStructure<List<Integer>>> findAllId() {
		return merchantService.findAllId();
	}

	@GetMapping("/findAllphonenumber")
	public ResponseEntity<ResponseStructure<List<Long>>> findAllPhoneNumber() {
		return merchantService.findAllPhoneNumber();
	}

	@GetMapping("/findallemail")
	public ResponseEntity<ResponseStructure<List<String>>> findAllEmail() {
		return merchantService.findAllEmail();
	}

	@GetMapping("/findidbyname/{name}")
	public ResponseEntity<ResponseStructure<List<Integer>>> findIdByName(@PathVariable(name = "name") String name) {
		return merchantService.findIdByName(name);

	}
}
