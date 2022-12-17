package org.spring.orm;

import org.spring.orm.dao.studentDao;
import org.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/config.xml");
        studentDao studentDao = context.getBean("studentDao", studentDao.class);
        studentDao.insert(new Student(3,"Stephen","USA"));
        Student student = (Student) studentDao.get(3);
        studentDao.delete(1);
        System.out.println("Done");
        System.out.println(student);
    }
}
