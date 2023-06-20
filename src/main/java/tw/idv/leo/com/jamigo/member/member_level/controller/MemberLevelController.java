package tw.idv.leo.com.jamigo.member.member_level.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.leo.com.jamigo.member.member_level.dao.MemberLevelDetailDAO;
import tw.idv.leo.com.jamigo.member.member_level.model.MemberLevelDetail;


@RestController  // 標示該類別與前端交互，自動轉Json
public class MemberLevelController {
	
	@Autowired // 注入MemberLevelDetailDAO實例 (dao)
	private MemberLevelDetailDAO memberLevelDetailDAO;
	
	
	@GetMapping("/memberLevelDetail")
	public List<MemberLevelDetail> getMemberLevelDetail(){
		return memberLevelDetailDAO.findAll();
	}
	
	@PostMapping("/addLevel")
	public String addLevel (@RequestBody MemberLevelDetail data){
		memberLevelDetailDAO.save(data);
		System.out.println(data);
		return null;
	}
	
	@PutMapping("/update/{levelNo}")
	public ResponseEntity<String> updateLevel(@PathVariable int levelNo, @RequestBody MemberLevelDetail data) {
	    
	    Optional<MemberLevelDetail> level = memberLevelDetailDAO.findById(levelNo);

	    if (level == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level not found");
	    }

	    // 更新存在的pk
	    var level2 = level.orElse(null);
	    level2.setLevelFeedback(data.getLevelFeedback());
	    level2.setLevelName(data.getLevelName());

	    
	    memberLevelDetailDAO.save(level2);
	    
	    return ResponseEntity.ok("Level updated successfully");
	}
	


	
	
}
