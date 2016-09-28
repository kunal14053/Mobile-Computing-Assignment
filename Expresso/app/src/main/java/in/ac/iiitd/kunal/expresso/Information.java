package in.ac.iiitd.kunal.expresso;

/**
 * Created by KunalSaini on 28-Sep-16.
 */
public class Information {

    int id;
    String name;
    String college_name;
    String college_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String dob;
    String phone_number;

    public Information(){}


    public Information(int id,String name,String college_name,String college_id,String dob,String phone_number )
    {
        this.id=id;
        this.name=name;
        this.college_id=college_id;
        this.college_name=college_name;
        this.dob=dob;
        this.phone_number=phone_number;
    }


    public Information(String name,String college_name,String college_id,String dob,String phone_number )
    {

        this.name=name;
        this.college_id=college_id;
        this.college_name=college_name;
        this.dob=dob;
        this.phone_number=phone_number;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege_id() {
        return college_id;
    }

    public void setCollege_id(String college_id) {
        this.college_id = college_id;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
