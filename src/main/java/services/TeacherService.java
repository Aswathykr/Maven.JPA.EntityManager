package services;

import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Set;

public class TeacherService {
    EntityManager em = null;
    EntityTransaction tx = null;

    public TeacherService(EntityManager em) {
        this.em = em;
        this.tx = em.getTransaction();
    }
    public Teacher createTeacher(String name, String subject, Set<Student> students){

        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setSubject(subject);
        teacher.setStudents(students);

        tx.begin();
        em.persist(teacher);
        tx.commit();

        return teacher;
    }

    public Teacher createTeacher(Teacher teacher){
        tx.begin();
        em.persist(teacher);
        tx.commit();

        return teacher;
    }

    public Teacher findTeacher(int id) {
        return em.find(Teacher.class, id);
    }

    public void removeCD(int id){
        Teacher teacher = em.find(Teacher.class, id);
        if(teacher != null){
            tx.begin();
            em.remove(teacher);
            tx.commit();
        }
    }

    public void removeCD(Teacher teacher){
        Teacher teacherToBeDeleted = em.merge(teacher);
        tx.begin();
        em.remove(teacherToBeDeleted);
        tx.commit();
    }

}
