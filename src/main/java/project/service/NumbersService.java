package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.domain.Numbers;
import project.repository.NumbersRepository;

@Service
public class NumbersService {

	@Autowired
	private NumbersRepository numbersRepository;

	public Numbers save(Numbers numbers) {
		return numbersRepository.save(numbers);
	}

	public List<Numbers> getAll() {
		return numbersRepository.findAll();
	}

}
