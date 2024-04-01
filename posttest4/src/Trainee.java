import java.io.*;

public class Trainee extends Talent {
    private String status = "Trainee";
    private int trainingPeriod; // durasi masa latihan (bulan)
    private String trainingClass; // kelas di company, misal kelas : A, B, C

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Trainee(String name, int age, String gender, String nationality, int trainingPeriod, String trainingClass) {
        super(name, age, gender, nationality);
        this.trainingPeriod = trainingPeriod;
        this.trainingClass = trainingClass;
    }

    public String getStatus() {
        return status;
    }

    public int getTrainingPeriod() {
        return trainingPeriod;
    }

    public void setTrainingPeriod(int trainingPeriod) {
        this.trainingPeriod = trainingPeriod;
    }

    public String getTrainingClass() {
        return trainingClass;
    }

    public void setTrainingClass(String trainingClass) {
        this.trainingClass = trainingClass;
    }

    public void updateTraineeData() throws IOException {
        System.out.println("=========================================");
        System.out.println("          Update Trainee Data");
        System.out.println("=========================================");
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. Gender");
        System.out.println("4. Nationality");
        System.out.println("5. Training Period");
        System.out.println("6. Training Class");
        System.out.println("=========================================");
        System.out.print("Choose [1-6]: ");
        int choice = Integer.parseInt(br.readLine());

        switch (choice) {
            case 1:
                System.out.print("Change name : ");
                setName(br.readLine());
                System.out.println("\n[ Name successfully updated ]");
                break;
            case 2:
                System.out.print("Change age : ");
                setAge(Integer.parseInt(br.readLine()));
                System.out.println("\n[ Age successfully updated ]");
                break;
            case 3:
                System.out.print("Change gender : ");
                setGender(br.readLine());
                System.out.println("\n[ Gender successfully updated ]");
                break;
            case 4:
                System.out.print("Change nationality : ");
                setNationality(br.readLine());
                System.out.println("\n[ Nationality successfully updated ]");
                break;
            case 5:
                System.out.print("Change training period : ");
                setTrainingPeriod(Integer.parseInt(br.readLine()));
                System.out.println("\n[ Training period successfully updated ]");
                break;
            case 6:
                System.out.print("Change training class: ");
                setTrainingClass(br.readLine());
                System.out.println("\n[ Training class successfully updated ]");
                break;
            default:
                System.out.println("\n[ Invalid choice! ]");
                break;
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Status          : " + this.status);
        System.out.println("Training Period : " + this.trainingPeriod + " months");
        System.out.println("Training Class  : " + this.trainingClass);
    }
}
