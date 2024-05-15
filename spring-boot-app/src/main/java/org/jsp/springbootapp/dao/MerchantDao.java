package org.jsp.springbootapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootapp.dto.Merchant;
import org.jsp.springbootapp.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {

	@Autowired
	private MerchantRepository merchantRepository;

	public Merchant saveMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}

	public Optional<Merchant> findById(int id) {
		return merchantRepository.findById(id);
	}
	public List<Merchant> findByName(String name){
		return merchantRepository.findByName(name);
	}

    public void deleteMerchant(int id ){
    	merchantRepository.deleteById(id);
    }

	public List<Merchant> findAll() {
		return merchantRepository.findAll();
	}

	public List<Merchant> findAllByName(String name) {
		return merchantRepository.findByName(name);
	}

	public Optional<Merchant> findByPhone(long phone) {
		return merchantRepository.findByPhone(phone);
	}

	public Optional<Merchant> verifyByPhoneAndPassword(long phone, String password) {
		return merchantRepository.findByPhoneAndPassword(phone, password);
	}

	public Optional<Merchant> verifyByEmailAndPassword(String email, String password) {
		return merchantRepository.verifyByEmailAndPassword(email, password);
	}

	public Optional<Merchant> verifyByIdAndPassword(int id, String password) {
		return merchantRepository.verifyByIdAndPassword(id, password);
	}

	public Optional<Merchant> verifyByGstAndPassword(String gst_number, String password) {
		return merchantRepository.verifyByGstAndPassword(gst_number, password);
	}

	public Optional<Merchant> findByGst_Number(String gst_number) {
		return merchantRepository.findByGst_Number(gst_number);
	}

	public List<String> findAllName() {
		return merchantRepository.findAllName();
	}

	public List<Integer> findAllId() {
		return merchantRepository.findAllId();
	}

	public List<Long> findAllPhoneNumber() {
		return merchantRepository.findAllPhoneNumber();
	}

	public List<String> findAllEmail() {
		return merchantRepository.findAllEmail();
	}

	public List<Integer> findIdByName(String name) {
		return merchantRepository.findIdByName(name);
	}
}
