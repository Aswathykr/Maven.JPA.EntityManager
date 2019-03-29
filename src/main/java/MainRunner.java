

import entities.*;

import services.CDService;
import services.TeacherService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;


public class MainRunner {

    public static void main(String ...args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("publishing");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        CDService cdService = new CDService(em);
        Set<Musician> musicians = new HashSet<Musician>();
        Musician musician = new Musician();
        musician.setFirst_name("Aswathy");
        musician.setLast_name("kanakarajan");
        musician.setInstrument(InstrumentEnum.INSTRUMENT2);
        musicians.add(musician);

        musician = new Musician();
        musician.setFirst_name("second");
        musician.setLast_name("kanakarajan");
        musician.setInstrument(InstrumentEnum.INSTRUMENT1);
        musicians.add(musician);

        musician = new Musician();
        musician.setFirst_name("third");
        musician.setLast_name("kanakarajan");
        musician.setInstrument(InstrumentEnum.INSTRUMENT3);
        musicians.add(musician);

        CD cd = new CD();
        cd.setPrice(67);
        cd.setMusicians(musicians);
        cd.setYear(1999);
        cd.setDescription("description");
        cd.setTitle("CD1");

        CD returnedCd = cdService.createCD(cd);

        System.out.println("Musician Persisted : " + cd.getId());

        cd = cdService.findMusician(returnedCd.getId());

        System.out.println("Musician Found    : " + cd.getId());
        musicians = new HashSet<Musician>();
        musician = new Musician();
        musician.setFirst_name("Aswathy");
        musician.setLast_name("kanakarajan");
        musician.setInstrument(InstrumentEnum.INSTRUMENT2);
        musicians.add(musician);

        musician = new Musician();
        musician.setFirst_name("second");
        musician.setLast_name("kanakarajan");
        musician.setInstrument(InstrumentEnum.INSTRUMENT1);
        musicians.add(musician);

        musician = new Musician();
        musician.setFirst_name("third");
        musician.setLast_name("kanakarajan");
        musician.setInstrument(InstrumentEnum.INSTRUMENT3);
        musicians.add(musician);

        cd = new CD();
        cd.setPrice(100);
        cd.setMusicians(musicians);
        cd.setYear(2019);
        cd.setDescription("description");
        cd.setTitle("CD2");
        returnedCd = cdService.createCD(cd);

        System.out.println("Musician Persisted : " + cd.getId());

        cd = cdService.findMusician(returnedCd.getId());

        TeacherService teacherService = new TeacherService(em);

        Set<Student> students = new HashSet<Student>();
        Student student = new Student();
        student.setName("Aswathy");
        student.setGrade("2");
        students.add(student);

        student = new Student();
        student.setName("second");
        student.setGrade("1");
        students.add(student);

        student = new Student();
        student.setName("third");
        student.setGrade("2");
        students.add(student);

        Teacher teacher = new Teacher();
        teacher.setSubject("English");
        teacher.setName("Pat");
        teacher.setStudents(students);

        Teacher returnedTeacher = teacherService.createTeacher(teacher);

        System.out.println("Teacher Persisted : " + teacher.getId());
        teacher = teacherService.findTeacher(returnedTeacher.getId());
        System.out.println("Teacher Found    : " + teacher.getId());

        teacher = new Teacher();
        teacher.setSubject("Maths");
        teacher.setName("Henry");
        teacher.setStudents(students);

        returnedTeacher = teacherService.createTeacher(teacher);

        System.out.println("Teacher Persisted : " + teacher.getId());

        teacher = teacherService.findTeacher(returnedTeacher.getId());
        System.out.println("Teacher Found    : " + teacher.getId());
    }
}