package com.Fintech.CoPro.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fintech.CoPro.domain.User;
@Repository

public interface UserRepository extends JpaRepository <User, Long> {

	Optional<User>findByUsername(String username);
	User findByVerficationCode(String verfication_code);
	User findByNationalId(String nationalId);
	User findByNumberCardBank(String numberCardBank);

   /// User findByEmail(String email);


}
