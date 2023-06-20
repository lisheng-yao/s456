package tw.idv.leo.com.jamigo.member.member_level.main;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tw.idv.leo.com.jamigo.member.member_level.dao.MemberLevelDetailDAO;



// 實做 CommandLineRunner 介面並複寫 run 方法的類別，可以在應用程式啟動後執行特定任務，用於執行初始化、配置載入等工作。
@Component
public class Main {
	
	 @Autowired
	 private MemberLevelDetailDAO memberLevelDetailDAO;

//	@Override
//	public void run (String... args) {
//		Optional<MemberLevelDetailDAO> student = memberLevelDetailDAO.findById(2);
//        // student.get() 就是用來獲取 Optional<Student> 內部的學生物件
//        // student.orElse(null) 表示如果student不存在，則返回null，可以避免例外發生
//        var student2 = student.orElse(null);
//        student2.setLastName("哈哈哈");
//        studentRepository.save(student2);
//    }
		
	}

	 

