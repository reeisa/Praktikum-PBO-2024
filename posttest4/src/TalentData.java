import java.io.*;
import java.util.*;

public class TalentData {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private List<Trainee> dataTrainee;
    private List<Artist> dataArtist;

    public TalentData() {
        dataTrainee = new ArrayList<>();
        dataArtist = new ArrayList<>();
    }

    // menu tambah data
    public void addData() throws IOException {
        while (true) {
            clear();
            System.out.println("=========================================");
            System.out.println("             Add Talent Data");
            System.out.println("=========================================");
            System.out.println("1. Add Trainee");
            System.out.println("2. Add Artist");
            System.out.println("3. Back to Main Menu");
            System.out.println("=========================================");
            System.out.print("Choose [1-3] : ");
            int choice = cekInt();
            switch (choice) {
                case 1:
                    clear();
                    addTraineeData();
                    break;
                case 2:
                    clear();
                    addArtistData();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\n[ Invalid choice! ]");
                    break;
            }
            System.out.print("Press ENTER to continue...");
            br.readLine();
        }
    }

    // tambah data trainee
    public void addTraineeData() throws NumberFormatException, IOException {
        System.out.println("=========================================");
        System.out.println("          Add Trainee Data");
        System.out.println("=========================================");
        System.out.print("Name            : ");
        String name = br.readLine();

        if (cekName(name)) {
            System.out.println("\n[ Data of this talent already exists ]");
            return;
        }

        System.out.print("Age             : ");
        int age = Integer.parseInt(br.readLine());
        System.out.print("Gender          : ");
        String gender = br.readLine();
        System.out.print("Nationality     : ");
        String nationality = br.readLine();
        System.out.print("Training Period : ");
        int trainingPeriod = Integer.parseInt(br.readLine());
        System.out.print("Training Class  : ");
        String trainingClass = br.readLine();

        Trainee newTrainee = new Trainee(name, age, gender, nationality, trainingPeriod, trainingClass);
        dataTrainee.add(newTrainee);

        System.out.println("\n[ Data successfully added ]");
    }

    // tambah data artist
    public void addArtistData() throws IOException {
        System.out.println("=========================================");
        System.out.println("          Add Artist Data");
        System.out.println("=========================================");
        System.out.print("Name        : ");
        String name = br.readLine();

        if (cekName(name)) {
            System.out.println("\n[ Data of this talent already exists ]");
            return;
        }

        System.out.print("Age         : ");
        int age = Integer.parseInt(br.readLine());
        System.out.print("Gender      : ");
        String gender = br.readLine();
        System.out.print("Nationality : ");
        String nationality = br.readLine();
        System.out.print("Debut Year  : ");
        int debutYear = Integer.parseInt(br.readLine());
        System.out.print("Group Name  : ");
        String groupName = br.readLine();

        Artist newArtist = new Artist(name, age, gender, nationality, debutYear, groupName);
        dataArtist.add(newArtist);

        System.out.println("\n[ Data successfully added ]");
    }

    // menu lihat data
    public void viewData() throws IOException {
        while (true) {
            clear();
            System.out.println("=========================================");
            System.out.println("          View Talent Data");
            System.out.println("=========================================");
            System.out.println("1. View Trainee");
            System.out.println("2. View Artist");
            System.out.println("3. Back to Main Menu");
            System.out.println("=========================================");
            System.out.print("Choose [1-3]: ");
            int choice = cekInt();
            switch (choice) {
                case 1:
                    clear();
                    System.out.println("=========================================");
                    System.out.println("              Trainee Data");
                    System.out.println("=========================================");
                    viewData("Trainee");
                    break;
                case 2:
                    clear();
                    System.out.println("=========================================");
                    System.out.println("              Artist Data");
                    System.out.println("=========================================");
                    viewData("Artist");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\n[ Invalid choice! ]");
                    break;
            }
            System.out.print("Press ENTER to continue... ");
            br.readLine();
        }
    }

    // overloading
    public void viewData(String status) {
        if ("Trainee".equalsIgnoreCase(status)) {
            if (dataTrainee.isEmpty()) {
                System.out.println("No trainee data available.");
                System.out.println("-----------------------------------------");
            } else {

                for (Trainee tr : dataTrainee) {
                    tr.display();
                    System.out.println("-----------------------------------------");
                }
            }
        } else if ("Artist".equalsIgnoreCase(status)) {
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
    }

    // ubah data
    public void updateData(String name) throws IOException {
        boolean found = false;
        for (Trainee tr : dataTrainee) {
            if (tr.getName().equalsIgnoreCase(name)) {
                clear();
                System.out.println("Trainee found : " + tr.getName());
                tr.updateTraineeData();
                found = true;
                break;
            }
        }
        if (!found) {
            for (Artist ar : dataArtist) {
                if (ar.getName().equalsIgnoreCase(name)) {
                    clear();
                    System.out.println("Artist found : " + ar.getName());
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

    // hapus data
    public void deleteData(String name) {
        boolean deleted = dataTrainee.removeIf(talent -> talent.getName().equalsIgnoreCase(name))
                | dataArtist.removeIf(talent -> talent.getName().equalsIgnoreCase(name));

        if (!deleted) {
            System.out.println("\n[ Data not found ]");
        } else {
            System.out.println("\n[ Data successfully deleted ]");
        }
    }

    // cek nama
    public boolean cekName(String name) {
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

    // clear screen
    public void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    // cek int
    public int cekInt() throws IOException {
        int cek = 0;
        while (true) {
            try {
                cek = Integer.parseInt(br.readLine());
                break;
            } catch (NumberFormatException e) {
                break;
            }
        }
        return cek;
    }
}