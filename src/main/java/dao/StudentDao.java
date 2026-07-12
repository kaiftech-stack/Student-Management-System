package dao;

import entities.Courses;
import entities.Students;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import utility.HibernateUtil;
import java.util.List;


public class StudentDao {

    public void saveStudent(Students student) {

        EntityManager em = HibernateUtil.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(student);

        transaction.commit();

        em.close();
    }

    public List<Students> getAllStudents() {

        EntityManager em = HibernateUtil.getEntityManager();

        String hql = "FROM Students";

        TypedQuery<Students> query = em.createQuery(hql, Students.class);

        List<Students> studentList = query.getResultList();

        em.close();

        return studentList;
    }
    public Students findStudentById(int id) {

        EntityManager em = HibernateUtil.getEntityManager();

        Students student = em.find(Students.class, id);

        em.close();

        return student;
    }

    public void updateStudentEmail(int id, String newEmail) {

        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Students student = em.find(Students.class, id);

        if (student != null) {
            student.setEmail(newEmail);
            transaction.commit();
            System.out.println("Email Updated Successfully...");
        } else {
            System.out.println("Student Not Found...");
            transaction.rollback();
        }

        em.close();
    }

    public void deleteStudent(int id) {

        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Students student = em.find(Students.class, id);

        if (student != null) {

            em.remove(student);

            transaction.commit();

            System.out.println("Student Deleted Successfully...");
        } else {

            System.out.println("Student Not Found...");
            transaction.rollback();
        }

        em.close();
    }

    public List<Students> findStudentsByCity(String city) {

        EntityManager em = HibernateUtil.getEntityManager();

        String hql = "FROM Students s WHERE s.address.city = :city";

        TypedQuery<Students> query = em.createQuery(hql, Students.class);

        query.setParameter("city", city);

        List<Students> students = query.getResultList();

        em.close();

        return students;
    }

    public List<Students> findStudentsByCourse(String courseName) {

        EntityManager em = HibernateUtil.getEntityManager();

        String hql = """
            SELECT DISTINCT s
            FROM Students s
            JOIN s.courses c
            WHERE c.courseName = :courseName
            """;

        TypedQuery<Students> query =
                em.createQuery(hql, Students.class);

        query.setParameter("courseName", courseName);

        List<Students> students = query.getResultList();

        em.close();

        return students;
    }


    public void enrollStudent(int studentId, Courses course) {

        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Students student = em.find(Students.class, studentId);

        if (student != null) {

            course.setStudent(student);

            student.getCourses().add(course);

            em.persist(course);

            transaction.commit();

            System.out.println("Student Enrolled Successfully...");

        } else {

            System.out.println("Student Not Found...");
            transaction.rollback();
        }

        em.close();
    }
}