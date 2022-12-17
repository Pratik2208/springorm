package org.spring.orm.dao;

import org.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;

public class studentDao {
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void insert(Student student){
        this.hibernateTemplate.save(student);
    }

    // Getting single data object
    public Student get(int studentId){
       Student student = this.hibernateTemplate.get(Student.class,studentId);
        return student;
    }

    // Deleting student
    @Transactional
    public void delete(int studentId){
        Student student = this.hibernateTemplate.get(Student.class,studentId);
        this.hibernateTemplate.delete(student);
    }
}
