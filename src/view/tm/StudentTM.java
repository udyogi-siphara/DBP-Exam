/**
 * @author : Udyogi Siphara
 * Project Name: DBPExam
 * Date        : 7/12/2022
 * Time        : 8:55 AM
 */

package view.tm;

public class StudentTM {
    private String id;
    private String name;
    private String email;
    private String telNum;
    private String address;
    private String nic;

    public StudentTM() {
    }

    public StudentTM(String id, String name, String email, String telNum, String address, String nic) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telNum = telNum;
        this.address = address;
        this.nic = nic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telNum='" + telNum + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
