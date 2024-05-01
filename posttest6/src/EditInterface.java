import java.io.IOException;

interface EditInterface {
    void addData() throws IOException;
    void updateData(String name) throws IOException;
    void deleteData(String name);
}
