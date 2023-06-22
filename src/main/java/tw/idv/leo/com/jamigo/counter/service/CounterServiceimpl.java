package tw.idv.leo.com.jamigo.counter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.leo.com.jamigo.counter.dao.CounterRepository;
import tw.idv.leo.com.jamigo.counter.model.Counter;

@Service
public class CounterServiceimpl implements CounterService {

	@Autowired
	private CounterRepository counterRepository;

	@Override
	public void updateCounter(Counter data) {
		int counterNo = data.getCounterNo();
		Optional<Counter> counter = counterRepository.findById(counterNo);

		// 更新存在的pk
		var counter2 = counter.orElse(null);
		counter2.setCounterName(data.getCounterName());
		    counter2.setCutPercent(data.getCutPercent());
		    counter2.setCounterPassword(data.getCounterPassword());
		    counter2.setCounterStat(data.getCounterStat());
		    counter2.setCounterGui(data.getCounterGui());
		    counter2.setCounterFloor(data.getCounterFloor());
		    counter2.setCounterTel(data.getCounterTel());
		    counter2.setCounterPoc(data.getCounterPoc());
		    counter2.setCounterPocPhone(data.getCounterPocPhone());
		    counter2.setCounterPocAddress(data.getCounterPocAddress());
		    counter2.setCounterEmail(data.getCounterEmail());
		    counter2.setCounterBankAccount(data.getCounterBankAccount());
		    counter2.setCounterAbout(data.getCounterAbout());
		    counter2.setCounterPassword(data.getCounterPassword());
		    counter2.setCounterPic(data.getCounterPic());

		counterRepository.save(counter2);

	}

	@Override
	public Counter getCounterByCounterNo(Integer counterNo) {
		Optional<Counter> counter = counterRepository.findById(counterNo);

		return counter.orElse(null);
	}

	@Override
	public Counter findByAcc(String counterAccount, String counterPassword) {
		
		return counterRepository.findByCounterAccountAndCounterPassword(counterAccount, counterPassword);
		
		
	}

}
