import java.io.*;
import java.util.*;

public class main {

    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private static ArrayList<Talent> dataTalent = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        dataTalent.add(new Talent("Kuma", 19, "Male", "Indonesian", "Trainee"));
        dataTalent.add(new Talent("Jennie", 20, "Female", "Korean", "Debut"));

        while (true) {
            clear();
            System.out.println("=========================================");
            System.out.println("       Hybe Company Talent Database");
            System.out.println("=========================================");
            System.out.println("1. Add Data");
            System.out.println("2. View Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Delete Data");
            System.out.println("5. Exit");
            System.out.println("=========================================");
            System.out.print("Select menu [1-5] : ");
            int pilih = Integer.parseInt(input.readLine());
            switch (pilih) {
                case 1: 
                    clear();
                    addData();
                    break;
                case 2:
                    clear();
                    viewData();
                    break;
                case 3:
                    clear();
                    editData();
                    break;
                case 4:
                    clear();
                    deleteData();
                    break;
                case 5:
                    System.out.println("\nLoading... Exiting the program...");
                    pause(1);
                    System.out.println("\nSuccessfully exited. Thank you!\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n>>> Invalid choice! <<<\n");
                    pause(2);
                    break;
            }
        }
    }

    // tambah data
    static void addData() throws NumberFormatException, IOException {
        System.out.println("=========================================");
        System.out.println("             Add Talent Data");
        System.out.println("=========================================");
        System.out.print("Name        : ");
        String name = input.readLine();
        System.out.print("Age         : ");
        int age = Integer.parseInt(input.readLine());
        System.out.print("Gender      : ");
        String gender = input.readLine();
        System.out.print("Nationality : ");
        String nationality = input.readLine();
        System.out.print("Status      : ");
        String status = input.readLine();

        Talent tl = new Talent(name, age, gender, nationality, status);
        dataTalent.add(tl);
        System.out.println("\n>>> Data successfully added! <<<");
        System.out.println("\nLoading... Redirecting back to the main menu.");
        pause(1);
    }

    // lihat data
    static void viewData() throws IOException {
        clear();
        System.out.println("===================================================");
        System.out.println("                   Talent Data");
        System.out.println("===================================================");
        int nomor = 1;
        if (dataTalent.isEmpty()) {
            System.out.println("Data is empty.");
            System.out.println("---------------------------------------------------");
        } else {
            for (Talent tl : dataTalent) {
                System.out.println("[" + nomor++ +"]");
                System.out.println("Name        : " + tl.name);
                System.out.println("Age         : " + tl.age);
                System.out.println("Gender      : " + tl.gender);
                System.out.println("Nationality : " + tl.nationality);
                System.out.println("Status      : " + tl.status);
                System.out.println("---------------------------------------------------");
            }
        }
        System.out.println("\nPress 'Enter' to return to the main menu.");
        input.readLine();
    }
    
    
    // ubah data
    static void editData() throws NumberFormatException, IOException {
        System.out.println("=========================================");
        System.out.println("            Edit Talent Data");
        System.out.println("=========================================");
        System.out.print("Enter the name : ");
        String name = input.readLine();
        Talent tl = search(name);

        if (tl != null) {
            clear();
            System.out.println("Data found : " + name);
            System.out.println("=========================================");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Gender");
            System.out.println("4. Nationality");
            System.out.println("5. Status");
            System.out.println("=========================================");
            System.out.print("Choose what to edit [1-5] : ");
            int pilih = Integer.parseInt(input.readLine());
            switch (pilih) {
                case 1:
                    System.out.print("\nChange name : ");
                    tl.setName(input.readLine());
                    System.out.println("\n>>> Name successfully changed to : " + tl.getName() + " <<<");
                    break;
                case 2:
                    System.out.print("\nChange age : ");
                    tl.setAge(Integer.parseInt(input.readLine()));
                    System.out.println("\n>>> Age successfully changed to : " + tl.getAge() + " <<<");
                    break;
                case 3:
                    System.out.print("\nChange gender : ");
                    tl.setGender(input.readLine());
                    System.out.println("\n>>> Gender successfully changed to : " + tl.getGender() + " <<<");
                    break;
                case 4:
                    System.out.print("\nChange nationality : ");
                    tl.setNationality(input.readLine());
                    System.out.println("\n>>> Nationality successfully changed to : " + tl.getNationality() + " <<<");
                    break;
                case 5:
                    System.out.print("\nChange status : ");
                    tl.setStatus(input.readLine());
                    System.out.println("\n>>> Status successfully changed to : " + tl.getStatus() + " <<<");
                    break;
                default:
                    System.out.println("\n>>> Invalid choice! <<<");
                    break;
            }
        } else {
            System.out.println("\n>>> Data not found. <<<");
        }
        System.out.println("\nLoading... Redirecting back to the main menu.");
        pause(2);
    }

    // hapus data
    static void deleteData() throws NumberFormatException, IOException {
        System.out.println("=========================================");
        System.out.println("            Delete Talent Data");
        System.out.println("=========================================");
        System.out.print("Enter the name : ");
        String nama = input.readLine();
        Talent tl = search(nama);
        if (tl != null) {
            clear();
            System.out.println("Data found : " + nama);
            System.out.print("Are you sure you want to delete? [Y/N] : ");
            String confirm = input.readLine();
            if (confirm.equalsIgnoreCase("Y")) {
                dataTalent.remove(tl);
                System.out.println("\n>>> Data successfully deleted! <<<");
            } else {
                System.out.println("\n>>> Data deletion canceled. <<<");
            }
        } else {
            System.out.println("\n>>> Data not found. <<<");
        }
        System.out.println("\nLoading... Redirecting back to the main menu.");
        pause(2);
    }

    // clear screen
    public static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        ;
    }

    // pause
    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // cari
    static Talent search(String name) {
        for (Talent tl : dataTalent) {
            if (tl.name.equalsIgnoreCase(name)) {
                return tl;
            }
        }
        return null;
    }
}