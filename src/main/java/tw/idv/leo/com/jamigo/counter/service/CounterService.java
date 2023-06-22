package tw.idv.leo.com.jamigo.counter.service;

import tw.idv.leo.com.jamigo.counter.model.Counter;

public interface CounterService {
	
	void updateCounter(Counter counter);
	
	Counter getCounterByCounterNo(Integer counterNo);
	
	Counter findByAcc(String counterAccount , String counterPassword);

}
