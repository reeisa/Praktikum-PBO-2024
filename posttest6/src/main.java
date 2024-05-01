import java.io.*;

public final class main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static TalentData td = new TalentData();

    public static void main(String[] args) throws IOException {
        while (true) {
            td.clear();
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
            int choice = TalentData.cekInt();
            switch (choice) {
                case 1:
                    td.addData();
                    break;
                case 2:
                    td.viewData();
                    break;
                case 3:
                    td.clear();
                    updateData();
                    break;
                case 4:
                    td.clear();
                    deleteData();
                    break;
                case 5:
                    System.out.print("\nPress ENTER to terminate your session...");
                    br.readLine();
                    System.out.println("\nSuccessfully exited. Thank you!\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n[ Invalid choice! ]");
                    System.out.print("Press ENTER to continue... ");
                    br.readLine();
                    break;
            }
        }
    }

    // ubah data
    public static void updateData() throws IOException {
        System.out.println("=========================================");
        System.out.println("          Update Talent Data");
        System.out.println("=========================================");
        System.out.print("Enter the name : ");
        String name = br.readLine();
        td.updateData(name);
        System.out.print("Press ENTER to continue... ");
        br.readLine();
    }

    // hapus data
    public static void deleteData() throws IOException {
        System.out.println("=========================================");
        System.out.println("            Delete Talent Data");
        System.out.println("=========================================");
        System.out.print("Enter the name : ");
        String name = br.readLine();
        td.deleteData(name);
        System.out.print("Press ENTER to continue... ");
        br.readLine();
    }
}
