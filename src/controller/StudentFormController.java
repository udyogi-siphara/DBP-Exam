/**
 * @author : Udyogi Siphara
 * Project Name: DBPExam
 * Date        : 7/12/2022
 * Time        : 8:53 AM
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;
import view.tm.StudentTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentFormController {

    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentContact;
    public JFXTextField txtStudentEmail;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentNic;
    public JFXButton btnAddStudent;
    public TableView<StudentTM>tblStudent;

    public void initialize() throws SQLException, ClassNotFoundException {
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("telNum"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("nic"));

        loadAllStudents();

    }

    public void loadAllStudents() throws SQLException, ClassNotFoundException {
        tblStudent.getItems().clear();
        ArrayList<Student> allStudent = StudentCrudController.getAllStudent();

        for (Student student : allStudent) {
            tblStudent.getItems().add(new StudentTM(
                    student.getId(),
                    student.getName(),
                    student.getEmail(),
                    student.getTelNum(),
                    student.getAddress(),
                    student.getNic()
            ));
        }

    }

    public void btnAddStudentOnAction(ActionEvent actionEvent) {
    }

    public void menuUpdateOnAction(ActionEvent actionEvent) {
    }

    public void menuDeleteOnAction(ActionEvent actionEvent) {
    }
}
