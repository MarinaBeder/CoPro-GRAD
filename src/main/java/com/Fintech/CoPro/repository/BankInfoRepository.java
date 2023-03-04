package com.Fintech.CoPro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Fintech.CoPro.domain.BankInfo;
import com.Fintech.CoPro.domain.User;

public interface BankInfoRepository extends JpaRepository <BankInfo, Long> {

	Optional<User>findByUsername(String username);
	//User findByVerficationCode(String verfication_code);
	User findByVerficationCode(String verfication_code);
	BankInfo findByNationalId(long nationalId);
	BankInfo findByNumberCardBank(long numberCardBank);


}
