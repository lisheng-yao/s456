package tw.idv.leo.com.jamigo.counter.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import tw.idv.leo.com.jamigo.counter.model.Counter;

public interface CounterService {
	
	void updateCounter(Counter counter);
	
	Counter getCounterByCounterNo(Integer counterNo);
	
	Counter findByAcc(String counterAccount , String counterPassword);
	
	String forget(Counter counter);
	
	void updateCounterPic(Integer counterNo, MultipartFile counterPic) throws IOException;

}
