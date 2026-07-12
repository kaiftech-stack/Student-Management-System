# 🎓 Student Course Management System (Hibernate)

A Java console-based Student Course Management System built using **Hibernate ORM** and **PostgreSQL**. This project demonstrates CRUD operations, entity relationships, and Hibernate mapping by managing students, courses, and addresses.

## 🚀 Features

- Add Student
- Add Course
- Add Address for a Student
- Enroll Student in Multiple Courses
- Display All Students
- Display Students by Course
- Update Student Email
- Delete Student
- Find Courses by Student Name
- Find Students by City
- Unenroll Student from a Course

---

## 🛠️ Technologies Used

- Java
- Hibernate ORM
- PostgreSQL
- Maven
- IntelliJ IDEA

---

## 📂 Project Structure

```
src
 ├── entity
 ├── dao
 ├── utility
 └── test
```

---

## 📊 Entity Relationship

### Student
- id
- name
- email
- age

### Course
- id
- courseName
- fees
- duration

### Address
- id
- plotNo
- area
- pincode
- city
- state
- country

### Relationships

- One Student ↔ One Address (Bi-directional One-to-One)
- One Student ↔ Many Courses (Bi-directional One-to-Many)

---

## 📋 Functionalities

1. Add Student
2. Add Course
3. Add Address for a Student
4. Enroll Student into Course
5. Display All Students
6. Display Students by Course
7. Update Student Email
8. Delete Student
9. Find Courses by Student Name
10. Find Students by City
11. Unenroll Student from Course

---

## ⚙️ Prerequisites

- Java 17 or later
- Maven
- PostgreSQL
- IntelliJ IDEA

---

## ▶️ How to Run

1. Clone the repository

```bash
git clone https://github.com/your-username/Student-Course-Management-System.git
```

2. Open the project in IntelliJ IDEA.

3. Configure your PostgreSQL database credentials in the Hibernate configuration file.

4. Build the project using Maven.

5. Run the `StudentTest` class.

---

## 📸 Sample Menu

```
========== Student Course Management System ==========

1. Add Student
2. Add Course
3. Add Address
4. Enroll Student
5. Display All Students
6. Display Students by Course
7. Update Student Email
8. Delete Student
9. Find Courses by Student Name
10. Find Students by City
11. Unenroll Student
0. Exit
```

---

## 📚 Concepts Covered

- Hibernate Configuration
- SessionFactory & Session
- CRUD Operations
- One-to-One Mapping
- One-to-Many Mapping
- Bi-directional Relationships
- HQL Queries
- Transaction Management
- Maven Project Structure

---

## 👨‍💻 Author

**Kaif Pathan**

If you found this project helpful, consider giving it a ⭐ on GitHub.