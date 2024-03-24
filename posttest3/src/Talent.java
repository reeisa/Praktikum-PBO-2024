public class Talent {
    protected String name, gender, nationality;
    protected int age;

    public Talent(String name, int age, String gender, String nationality) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void display() {
        System.out.println("Name            : " + this.name);
        System.out.println("Age             : " + this.age);
        System.out.println("Gender          : " + this.gender);
        System.out.println("Nationality     : " + this.nationality);
    }
}
