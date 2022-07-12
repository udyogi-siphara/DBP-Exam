/**
 * @author : Udyogi Siphara
 * Project Name: DBPExam
 * Date        : 7/12/2022
 * Time        : 10:53 AM
 */

package controller;

import model.Student;
import util.CrudUtil;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentCrudController {
    public static ArrayList<Student> getAllStudent() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT *  FROM Student");

        ArrayList<Student> stList = new ArrayList<>();
        while (resultSet.next()) {
            stList.add(new Student(
                    resultSet.getString("1"),
                    resultSet.getString("2"),
                    resultSet.getString("3"),
                    resultSet.getString("4"),
                    resultSet.getString("5"),
                    resultSet.getString("6")
            ));
        }
        return stList;
    }

    public static boolean addStudent(Student student) throws SQLException, ClassNotFoundException {
        if (CrudUtil.execute("INSERT INTO Student VALUES (?,?,?,?,?,?)",student.getId(),student.getName(),student.getEmail(),student.getTelNum(),student.getAddress(),student.getNic())){
            return true;
        }
        return false;
    }

    public static boolean updateStudent(Student student) throws SQLException, ClassNotFoundException{

        if(CrudUtil.execute("UPDATE Student SET student_name = ?, email = ?, contact = ?, address = ?, nic = ?,  = ? WHERE student_id = ? ",student.getName(),student.getEmail(),student.getTelNum(),student.getAddress(),student.getNic(),student.getId())){

            return true;
        }
        return false;
    }


    public static boolean deleteStudent(String id)throws SQLException, ClassNotFoundException{
        return CrudUtil.execute("DELETE FROM Student WHERE student_id = ?",id);

    }

    public static ArrayList<Student> getSearchStudent(String enteredText) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM student where studentId LIKE ? OR studentName LIKE ? OR email LIKE ? OR contact LIKE ? OR address LIKE ? OR nic LIKE ?", enteredText, enteredText, enteredText, enteredText,enteredText,enteredText);
        ArrayList<Student> list = new ArrayList<>();

        while (result.next()) {
            list.add(new Student(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)

            ));
        }
        return list;


    }

}
