public class Talent {
    private String name, gender, nationality, status;
    private int age;

    public Talent(String name, int age, String gender, String nationality, String status) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String newGender) {
        this.gender = newGender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String newNationality) {
        this.nationality = newNationality;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }
}