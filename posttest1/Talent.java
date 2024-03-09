class Talent {
    String name;
    int age;
    String gender;
    String nationality;
    String status;

    Talent(String name, int age, String gender, String nationality, String status) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.status = status;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getGender() {
        return gender;
    }

    String getNationality() {
        return nationality;
    }

    String getStatus() {
        return status;
    }

    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        this.age = age;
    }

    void setGender(String gender) {
        this.gender = gender;
    }

    void setNationality(String nationality) {
        this.nationality = nationality;
    }

    void setStatus(String status) {
        this.status = status;
    }
}
