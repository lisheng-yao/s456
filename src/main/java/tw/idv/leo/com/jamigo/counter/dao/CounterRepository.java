package tw.idv.leo.com.jamigo.counter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tw.idv.leo.com.jamigo.counter.model.Counter;

public interface CounterRepository extends JpaRepository<Counter, Integer>{

}
