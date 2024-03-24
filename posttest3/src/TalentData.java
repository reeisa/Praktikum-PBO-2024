import java.io.*;
import java.util.*;

public class TalentData {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private List<Trainee> dataTrainee;
    private List<Artist> dataArtist;

    public TalentData() {
        dataTrainee = new ArrayList<>();
        dataArtist = new ArrayList<>();
    }

    public void addTraineeData() throws IOException {
        System.out.println("=========================================");
        System.out.println("          Add Trainee Data");
        System.out.println("=========================================");
        System.out.print("Name            : ");
        String name = input.readLine();

        if (cekNama(name)) {
            System.out.println("\n[ Data of this talent already exists ]");
            return;
        }

        System.out.print("Age             : ");
        int age = Integer.parseInt(input.readLine());
        System.out.print("Gender          : ");
        String gender = input.readLine();
        System.out.print("Nationality     : ");
        String nationality = input.readLine();
        System.out.print("Training Period : ");
        int trainingPeriod = Integer.parseInt(input.readLine());
        System.out.print("Training Class  : ");
        String trainingClass = input.readLine();
    
        Trainee newTrainee = new Trainee(name, age, gender, nationality, trainingPeriod, trainingClass);
        dataTrainee.add(newTrainee);

        System.out.println("\n[ Data successfully added ]");
    }
    
    public void addArtistData() throws IOException {
        System.out.println("=========================================");
        System.out.println("          Add Artist Data");
        System.out.println("=========================================");
        System.out.print("Name        : ");
        String name = input.readLine();

        if (cekNama(name)) {
            System.out.println("\n[ Data of this talent already exists ]");
            return;
        }

        System.out.print("Age         : ");
        int age = Integer.parseInt(input.readLine());
        System.out.print("Gender      : ");
        String gender = input.readLine();
        System.out.print("Nationality : ");
        String nationality = input.readLine();
        System.out.print("Debut Year  : ");
        int debutYear = Integer.parseInt(input.readLine());
        System.out.print("Group Name  : ");
        String groupName = input.readLine();
    
        Artist newArtist = new Artist(name, age, gender, nationality, debutYear, groupName);
        dataArtist.add(newArtist);
        
        System.out.println("\n[ Data successfully added ]");
    }
    
    private boolean cekNama(String name) {
        for (Trainee tr : dataTrainee) {
            if (tr.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        for (Artist ar : dataArtist) {
            if (ar.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    

    public void viewTraineeData() {
        if (dataTrainee.isEmpty()) {
            System.out.println("No trainee data available.");
            System.out.println("-----------------------------------------");
        } else {
            for (Trainee tr : dataTrainee) {
                tr.display();
                System.out.println("-----------------------------------------");
            }
        }
    }
    
    public void viewArtistData() {
        if (dataArtist.isEmpty()) {
            System.out.println("No artist data available.");
            System.out.println("-----------------------------------------");
        } else {
            for (Artist ar : dataArtist) {
                ar.display();
                System.out.println("-----------------------------------------");
            }
        }
    }
    
    public void updateData(String name) throws IOException {
        boolean found = false;
        for (Trainee tr : dataTrainee) {
            if (tr.getName().equalsIgnoreCase(name)) {
                tr.updateTraineeData();
                found = true;
                break;
            }
        }
        if (!found) {
            for (Artist ar : dataArtist) {
                if (ar.getName().equalsIgnoreCase(name)) {
                    ar.updateArtistData();
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("\n[ Data not found ]");
        }
    }
    
    public void deleteData(String name) {
        boolean deleted = dataTrainee.removeIf(talent -> talent.getName().equalsIgnoreCase(name))
                | dataArtist.removeIf(talent -> talent.getName().equalsIgnoreCase(name));
    
        if (!deleted) {
            System.out.println("\n[ Data not found ]");
        } else {
            System.out.println("\n[ Data successfully deleted ]");
        }
    }
    
}
