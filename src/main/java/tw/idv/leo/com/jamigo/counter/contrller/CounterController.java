package tw.idv.leo.com.jamigo.counter.contrller;



import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.leo.com.jamigo.counter.dao.CounterRepository;
import tw.idv.leo.com.jamigo.counter.model.Counter;
import tw.idv.leo.com.jamigo.counter.service.CounterService;



@RestController
public class CounterController {
	
	@Autowired
	private CounterRepository counterRepository;
	@Autowired
	private CounterService counterService;
	
	
	// ========================== 查櫃位資料 ===========================
	
	@GetMapping("/get/count/{counterNo}")
	public Counter getCounte(@PathVariable Integer counterNo) {
	
		return counterService.getCounterByCounterNo(counterNo);
	}

	// ========================== 更新櫃位資料 ==========================
	
	@PutMapping("/update/counter/{counterNo}")
	public ResponseEntity<String> updateCounter(@PathVariable Integer counterNo, @RequestBody Counter data) {
		 	Optional<Counter> counter = counterRepository.findById(counterNo);

		    if (counter == null) {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level not found");
		    }
		
			counterService.updateCounter(data); 
		    
		    return ResponseEntity.ok("Level updated successfully");
		}
	
	// ========================== 櫃位登入 ==========================
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Counter counter, HttpServletRequest req ){
		
		System.out.println(counter);
		
		
		return ResponseEntity.ok("successfully");
	}
	
	}
	
	
	
	
	

