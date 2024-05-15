package org.jsp.springbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootapp.dao.MerchantDao;
import org.jsp.springbootapp.dto.Merchant;
import org.jsp.springbootapp.dto.ResponseStructure;
import org.jsp.springbootapp.exception.MerchantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MerchantService {

	@Autowired
	private MerchantDao merchantDao;

	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setMessage("User save with sucessfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(merchantDao.saveMerchant(merchant));
		return ResponseEntity.status(HttpStatus.CREATED.value()).body(structure);
	}

	public ResponseEntity<ResponseStructure<Merchant>> findById(int id) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recmerchant = merchantDao.findById(id);
		if (recmerchant.isPresent()) {
			structure.setMessage("Merchant Found");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recmerchant.get());
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		} else {
			throw new MerchantNotFoundException("Id is Invalid try Again!");
		}
	}

	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recmerchant = merchantDao.findById(merchant.getId());
		if (recmerchant.isPresent()) {
			structure.setMessage("Merchant Updated Sucessfully");
			structure.setStatusCode(HttpStatus.OK.value());
			Merchant dbmerchant = recmerchant.get();
			dbmerchant.setName(merchant.getName());
			dbmerchant.setEmail(merchant.getEmail());
			dbmerchant.setPhone(merchant.getPhone());
			dbmerchant.setGst_number(merchant.getGst_number());
			dbmerchant.setPassword(merchant.getPassword());
			structure.setData(merchantDao.saveMerchant(dbmerchant));
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		} else {
			
			throw new MerchantNotFoundException("Id is Invalid can not be update try Again!");
			
		}
	}

	public ResponseEntity<ResponseStructure<List<Merchant>>> findAll() {
		ResponseStructure<List<Merchant>> structure = new ResponseStructure<>();
		List<Merchant> recmerchant = merchantDao.findAll();
		if (recmerchant.isEmpty()) {
			throw new MerchantNotFoundException("Merchant   list Not found try Again!");
		} else {
			structure.setMessage("Record  Displayed ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recmerchant);
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		}
	}

	public ResponseEntity<ResponseStructure<Merchant>> deleteMerchant(int id) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recmerchant = merchantDao.findById(id);
		if (recmerchant.isPresent()) {
			structure.setMessage("Merchant found ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recmerchant.get());
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		} else {
			throw new MerchantNotFoundException("Wrong id Merchant Not found try Again! to Delete!");
		}
	}

	public ResponseEntity<ResponseStructure<List<Merchant>>> findByName(String name) {
		ResponseStructure<List<Merchant>> structure = new ResponseStructure<>();
		List<Merchant> recmerchant = merchantDao.findByName(name);
		if (recmerchant.isEmpty()) {
			throw new MerchantNotFoundException("Merchant Not found with name !"+name);
		} else {
			structure.setMessage("Record  Displayed ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recmerchant);
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		}
	}

	public ResponseEntity<ResponseStructure<Merchant>> findByPhone(long phone) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recmerchant = merchantDao.findByPhone(phone);
		if (recmerchant.isPresent()) {
			structure.setMessage("Merchant found ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recmerchant.get());
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		} else {
			throw new MerchantNotFoundException("Merchant Not found with phone number "+phone);
		}
	}

	public ResponseEntity<ResponseStructure<Merchant>> findByPhoneAndPassword(@RequestParam(name = "phone") long phone,
			@RequestParam(name = "password") String password) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recmerchant = merchantDao.verifyByPhoneAndPassword(phone, password);
		if (recmerchant.isPresent()) {
			structure.setMessage("Merchant found ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recmerchant.get());
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		} else {
			structure.setMessage("Merchant not found phone and password is wrong ");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(structure);
		}
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyByEmailAndPassword(String email,
			@RequestParam(name = "password") String password) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recmerchant = merchantDao.verifyByEmailAndPassword(email, password);
		if (recmerchant.isPresent()) {
			structure.setMessage("Merchant found ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recmerchant.get());
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		} else {
			structure.setMessage("Merchant not found email and password is wrong ");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(structure);
		}
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyByIdAndPassword(int id, String password) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recmerchant = merchantDao.verifyByIdAndPassword(id, password);
		if (recmerchant.isPresent()) {
			structure.setMessage("Merchant found ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recmerchant.get());
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		} else {
			throw new MerchantNotFoundException("Id and pasword id Invalid try Again!");
		}
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyByGstAndPassword(String gst_number, String password) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recmerchant = merchantDao.verifyByGstAndPassword(gst_number, password);
		if (recmerchant.isPresent()) {
			structure.setMessage("Merchant found ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recmerchant.get());
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		} else {
			throw new MerchantNotFoundException("Merchant not found Wrong gst_number and password");
		}
	}

	public ResponseEntity<ResponseStructure<Merchant>> findByGst_Number(String gst_number) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recmerchant = merchantDao.findByGst_Number(gst_number);
		if (recmerchant.isPresent()) {
			structure.setMessage("Merchant found ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recmerchant.get());
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		} else {
			
		}
			throw new MerchantNotFoundException("Merchant not found with gst_number " + gst_number);
	}

	public ResponseEntity<ResponseStructure<List<String>>> findAllName() {
		ResponseStructure<List<String>> structure = new ResponseStructure<>();
		List<String> allname = merchantDao.findAllName();
		if (allname.isEmpty()) {
			throw new MerchantNotFoundException("Merchant Name  list Not found try Again!");
		} else {
			structure.setMessage("Record  Displayed ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(allname);
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		}

	}

	public ResponseEntity<ResponseStructure<List<Integer>>> findAllId() {
		ResponseStructure<List<Integer>> structure = new ResponseStructure<>();
		List<Integer> allid = merchantDao.findAllId();
		if (allid.isEmpty()) {
			throw new MerchantNotFoundException("Merchant Id list Not found try Again!");
		} else {
			structure.setMessage("Record  Displayed ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(allid);
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		}
	}

	public ResponseEntity<ResponseStructure<List<Long>>> findAllPhoneNumber() {
		ResponseStructure<List<Long>> structure = new ResponseStructure<>();
		List<Long> allphone = merchantDao.findAllPhoneNumber();
		if (allphone.isEmpty()) {
			throw new MerchantNotFoundException("Merchant Phone list Not found try Again!");
		} else {
			structure.setMessage("Record  Displayed ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(allphone);
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		}
	}

	public ResponseEntity<ResponseStructure<List<String>>> findAllEmail() {
		ResponseStructure<List<String>> structure = new ResponseStructure<>();
		List<String> recmerchant = merchantDao.findAllEmail();
		if (recmerchant.isEmpty()) {
			throw new MerchantNotFoundException("Merchant Email  list Not found try Again!");
		} else {
			structure.setMessage("Record  Displayed ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recmerchant);
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		}
	}

	public ResponseEntity<ResponseStructure<List<Integer>>> findIdByName(String name) {
		ResponseStructure<List<Integer>> structure = new ResponseStructure<>();
		List<Integer> recmerchant = merchantDao.findIdByName(name);
		if (recmerchant.isEmpty()) {
			throw new MerchantNotFoundException("Merchant id not found with name " +name);
		} else {
			structure.setMessage("Record  Displayed ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recmerchant);
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		}
	}

}
