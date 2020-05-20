package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.domain.Numbers;

public interface NumbersRepository extends JpaRepository<Numbers, Integer>{
	
}
