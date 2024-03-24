import java.io.*;

public class main {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static TalentData td = new TalentData();

    public static void main(String[] args) throws IOException {
        while (true) {
            clear();
            System.out.println("=========================================");
            System.out.println("       Hybe Company Talent Database");
            System.out.println("=========================================");
            System.out.println("1. Add Data");
            System.out.println("2. View Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            System.out.println("5. Exit");
            System.out.println("=========================================");
            System.out.print("Choose [1-5] : ");
            int choice = cekInt();
            switch (choice) {
                case 1:
                    addData();
                    break;
                case 2:
                    viewData();
                    break;
                case 3:
                    clear();
                    updateData();
                    break;
                case 4:
                    clear();
                    deleteData();
                    break;
                case 5:
                    System.out.println("\nLoading... Exiting the program...");
                    pause(1);
                    System.out.println("\nSuccessfully exited. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n[ Invalid choice! ]");
                    System.out.print("Press ENTER to continue... ");
                    input.readLine();
                    break;
            }
        }
    }

    // tambah data
    public static void addData() throws NumberFormatException, IOException {
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
                    td.addTraineeData();
                    break;
                case 2:
                    clear();
                    td.addArtistData();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\n[ Invalid choice! ]");
                    break;
            }
            System.out.print("Press ENTER to continue...");
            input.readLine();
        }
    }

    // lihat data
    public static void viewData() throws IOException {
        while (true) {
            clear();
            System.out.println("=========================================");
            System.out.println("             View Talent Data");
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
                    td.viewTraineeData();
                    break;
                case 2:
                    clear();
                    System.out.println("=========================================");
                    System.out.println("               Artist Data");
                    System.out.println("=========================================");
                    td.viewArtistData();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\n[ Invalid choice! ]");
                    break;
            }
            System.out.print("Press ENTER to continue... ");
            input.readLine();
        }
    }

    // ubah data
    public static void updateData() throws IOException {
        System.out.println("=========================================");
        System.out.println("          Update Talent Data");
        System.out.println("=========================================");
        System.out.print("Enter the name : ");
        String name = input.readLine();
        clear();
        td.updateData(name);
        System.out.print("Press ENTER to continue... ");
        input.readLine();
    }

    // hapus data
    public static void deleteData() throws IOException {
        System.out.println("=========================================");
        System.out.println("            Delete Talent Data");
        System.out.println("=========================================");
        System.out.print("Enter the name : ");
        String name = input.readLine();
        td.deleteData(name);
        System.out.print("Press ENTER to continue... ");
        input.readLine();
    }

    // clear screen
    private static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    // pause
    private static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // cek int
    private static int cekInt() throws IOException {
        int cek = 0;
        while (true) {
            try {
                cek = Integer.parseInt(input.readLine());
                break;
            } catch (NumberFormatException e) {
                break;
            }
        }
        return cek;
    }
}
