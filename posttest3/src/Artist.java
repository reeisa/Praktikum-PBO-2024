import java.io.*;

public class Artist extends Talent {
    private String status = "Artist";
    private int debutYear; // tahun debut
    private String groupName; // nama grup
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public Artist(String name, int age, String gender, String nationality, int debutYear, String groupName) {
        super(name, age, gender, nationality);
        this.debutYear = debutYear;
        this.groupName = groupName;
    }

    public String getStatus() {
        return status;
    }

    public int getDebutYear() {
        return debutYear;
    }

    public void setDebutYear(int debutYear) {
        this.debutYear = debutYear;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void display() {
        super.display();
        System.out.println("Status          : " + this.status);
        System.out.println("Debut Year      : " + this.debutYear);
        System.out.println("Group Name      : " + this.groupName);
    }

    public void updateArtistData() throws IOException {
        System.out.println("=========================================");
        System.out.println("          Update Artist Data");
        System.out.println("=========================================");
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. Gender");
        System.out.println("4. Nationality");
        System.out.println("5. Debut Year");
        System.out.println("6. Group Name");
        System.out.println("=========================================");
        System.out.print("Choose [1-6]: ");
        int choice = Integer.parseInt(input.readLine());

        switch (choice) {
            case 1:
                System.out.print("Change name : ");
                setName(input.readLine());
                System.out.println("\n[ Name successfully updated ]");
                break;
            case 2:
                System.out.print("Change age : ");
                setAge(Integer.parseInt(input.readLine()));
                System.out.println("\n[ Age successfully updated ]");
                break;
            case 3:
                System.out.print("Change gender : ");
                setGender(input.readLine());
                System.out.println("\n[ Gender successfully updated ]");
                break;
            case 4:
                System.out.print("Change nationality : ");
                setNationality(input.readLine());
                System.out.println("\n[ Nationality successfully updated ]");
                break;
            case 5:
                System.out.print("Change debut year : ");
                setDebutYear(Integer.parseInt(input.readLine()));
                System.out.println("\n[ Debut year successfully updated ]");
                break;
            case 6:
                System.out.print("Change group name: ");
                setGroupName(input.readLine());
                System.out.println("\n[ Group name successfully updated ]");
                break;
            default:
                System.out.println("\n[ Invalid choice! ]");
                break;
        }
    }
}
