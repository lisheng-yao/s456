package tw.idv.leo.com.jamigo.counter.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.idv.leo.com.jamigo.counter.model.Counter;

public interface CounterRepository extends JpaRepository<Counter, Integer>{

		Counter findByCounterAccountAndCounterPassword(String counterAccount , String counterPassword);
		Optional<Counter> findByCounterEmail(String counterEmail);
}
