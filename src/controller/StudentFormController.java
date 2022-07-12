/**
 * @author : Udyogi Siphara
 * Project Name: DBPExam
 * Date        : 7/12/2022
 * Time        : 8:53 AM
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;
import util.CrudUtil;
import view.tm.StudentTM;

import java.sql.ResultSet;
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
    public TableView<Student>tblStudent;

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
        ResultSet result = CrudUtil.execute("SELECT * FROM Student");
            ObservableList<Student> obList = FXCollections.observableArrayList();

            while (result.next()){
                obList.add(
                        new Student(
                                result.getString("student_id"),
                                result.getString("student_name"),
                                result.getString("email"),
                                result.getString("contact"),
                                result.getString("address"),
                                result.getString("nic")

                        )
                );
            }
            tblStudent.setItems(obList);



    }

    public void btnAddStudentOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (btnAddStudent.getText().equals("Add Student")) {
            Student stu = new Student(
                    txtStudentId.getText(), txtStudentName.getText(), txtStudentEmail.getText(), txtStudentContact.getText(), txtStudentAddress.getText(), txtStudentNic.getText()
            );

            try {
                if (CrudUtil.execute("INSERT INTO Student VALUES (?,?,?,?,?,?)", stu.getId(), stu.getName(), stu.getEmail(), stu.getTelNum(), stu.getAddress(), stu.getNic())) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
                    loadAllStudents();
                    clearText();
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }else{
            Student student = new Student(txtStudentId.getText(),txtStudentName.getText(),txtStudentEmail.getText(),txtStudentContact.getText(),txtStudentAddress.getText(),txtStudentNic.getText());

            boolean isUpdated = CrudUtil.execute("UPDATE Student SET student_name = ?, email = ?, contact = ? , address = ? , nic = ?  WHERE student_id = ? ",student.getName(),student.getEmail(),student.getTelNum(),student.getAddress(),student.getNic(),student.getId());

            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"Updated !...").show();
                btnAddStudent.setText("Add Student");
                txtStudentId.setEditable(true);
                loadAllStudents();
                clearText();
            }else {
                new Alert(Alert.AlertType.ERROR,"Something Wrong").show();
            }
        }

    }

    private void clearText(){
        txtStudentId.clear();
        txtStudentName.clear();
        txtStudentEmail.clear();
        txtStudentContact.clear();
        txtStudentAddress.clear();
        txtStudentNic.clear();
    }

    public void menuUpdateOnAction(ActionEvent actionEvent) {
        Student selectedItem = tblStudent.getSelectionModel().getSelectedItem();

        txtStudentId.setText(selectedItem.getId());
        txtStudentName.setText(selectedItem.getName());
        txtStudentEmail.setText(selectedItem.getEmail());
        txtStudentContact.setText(selectedItem.getTelNum());
        txtStudentAddress.setText(selectedItem.getAddress());
        txtStudentNic.setText(selectedItem.getNic());

        btnAddStudent.setText("Update");
    }

    public void menuDeleteOnAction(ActionEvent actionEvent) {
    }
}
