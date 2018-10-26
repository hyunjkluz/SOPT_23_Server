package org;

import org.sopt.model.Department;
import org.sopt.model.Professor;
import org.sopt.model.Student;
import org.sopt.model.University;
import org.sopt.service.impl.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<University> universities = new ArrayList<University>();
        ArrayList<Department> departments = new ArrayList<Department>();
        ArrayList<Professor> professors = new ArrayList<Professor>();
        ArrayList<Student> students = new ArrayList<Student>();

        //대학교
        final University uni1 = new University();
        final University uni2 = new University();
        final University uni3 = new UniversityServiceImpl().getByUniversityIdx(3);

        universities.add(uni1);
        universities.add(uni2);
        universities.add(uni3);

        for (final University u : universities) {
            System.out.print(u.toString());
        }
        System.out.println();

        //학과
        final Department dept1 = new Department();
        final Department dept2 = new Department();
        final Department dept3 = new DepartmentServiceImpl().getByDepartmentIdx(3);

        departments.add(dept1);
        departments.add(dept2);
        departments.add(dept3);

        for (final Department d : departments) {
            System.out.print(d.toString());
        }
        System.out.println();

        //교수
        final Professor prof1 = new Professor();
        final Professor prof2 = new Professor();
        final Professor prof3 = new ProfessorServiceImpl().getByProfessorIdx(3);

        professors.add(prof1);
        professors.add(prof2);
        professors.add(prof3);

        for (final Professor p : professors) {
            System.out.print(p.toString());
        }
        System.out.println();

        //학생
        final Student stu1 = new Student();
        final Student stu2 = new Student();
        final Student stu3 = new StudentServiceImpl().getByStudentIdx(20160946);

        students.add(stu1);
        students.add(stu2);
        students.add(stu3);

        for (final Student s : students) {
            System.out.print(s.toString());
        }
        System.out.println();
    }
}
