package org.jsp.springbootapp.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootapp.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

	List<Merchant> findByName(String name);

	Optional<Merchant> findByPhone(long phone);

	Optional<Merchant> findByPhoneAndPassword(long phone, String password);

	@Query("select m from Merchant m where m.email=?1 and m.password=?2")
	Optional<Merchant> verifyByEmailAndPassword(String email, String password);

	@Query("select m from Merchant m where m.id=?1 and m.password=?2")
	Optional<Merchant> verifyByIdAndPassword(int id, String password);

	@Query("select m from Merchant m where m.gst_number=?1 and m.password=?2")
	Optional<Merchant> verifyByGstAndPassword(String gst_number, String password);

	@Query("select m from Merchant m where m.gst_number=?1")
	Optional<Merchant> findByGst_Number(String gst_number);

	@Query("select name from Merchant")
	List<String> findAllName();

	@Query("select id from Merchant")
	List<Integer> findAllId();

	@Query("select phone from Merchant")
	List<Long> findAllPhoneNumber();

	@Query("select email from Merchant")
	List<String> findAllEmail();

	@Query("select id from Merchant m where m.name=?1")
	List<Integer> findIdByName(String name);

}
