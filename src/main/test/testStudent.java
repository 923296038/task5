import com.pojo.Student;
import com.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testStudent {
    private static final Logger log= LogManager.getLogger(testStudent.class);
    ApplicationContext context=new
            ClassPathXmlApplicationContext("applicationContext.xml");
    StudentService studentService=
            (StudentService) context.getBean("studentService");

    @Test
    public void test(){
        List<Student> studentList = studentService.findStudent();
        log.error(studentList);
        log.error(studentService.countStudent(0));
        log.error(studentService.countStudent(1));
    }
}
