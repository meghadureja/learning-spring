package edu.practice.spring.repository;

import edu.practice.spring.entity.PhoneNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumberEntity, Long> {
}
