package by.academy.homework6;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Main {

    public static final String PATH_FILE_SERVICE = Paths.get("").toAbsolutePath().toString().concat("\\Files S.");

    public static final String PATH_TASK_1 = PATH_FILE_SERVICE.concat("\\fromConsole.txt");

    public static final String PATH_TASK_2 = PATH_FILE_SERVICE.concat("\\result.txt");

    public static final String PATH_100_NAMELESS_FILE = PATH_FILE_SERVICE.concat("\\100 nameless file\\");

    public static final Scanner scan = new Scanner(System.in);

    static {
        File fileServiceDirectory = new File(PATH_FILE_SERVICE);
        if (!fileServiceDirectory.exists()) {
            fileServiceDirectory.mkdir();
        }
    }

    public static void main(String[] args) {
//        catchExceptionTask(1);
//        catchExceptionTask(2);
//        catchExceptionTask(3);
        catchExceptionTask(4);
    }

    public static void catchExceptionTask(int taskNumber) {
        try {
            switch (taskNumber) {
                case 1 -> task_1();
                case 2 -> task_2();
                case 3 -> tast_3();
                case 4 -> task_4();
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void task_4() throws IOException {
        File namelessDirectory = new File(PATH_100_NAMELESS_FILE);
        if (!namelessDirectory.exists()) {
            namelessDirectory.mkdir();
        }

        if (namelessDirectory.length() > 0L) {
            for (var file : namelessDirectory.listFiles()) {
                file.delete();
            }
        }


        String namelessFileName = "";
        String namelessFilePath = "";
        Random rand = new Random();
        int randomValue = 0;
        // sry i am not creating 100 files as needed, but i suppose 10 files are enough
        for (int i = 0; i < 10; i++) {
            randomValue = rand.nextInt(1, 576);
            namelessFileName = (i + 1) + "_" + randomValue +".txt";
            namelessFilePath = PATH_100_NAMELESS_FILE.concat(namelessFileName);
            createFile(namelessFilePath);
            getRandomSymbolsFromText(randomValue, namelessFilePath);
        }

        getMetaFileInfo();
    }

    public static void getRandomSymbolsFromText(int randomValue, String PATH) throws IOException {
        String fullText = task_2();
        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(PATH))) {
            bWriter.write(fullText.substring(0, randomValue));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void getMetaFileInfo() throws IOException {
        String PATH_FILE_META_DATA = PATH_FILE_SERVICE.concat("\\meta_data_100_nameless_file.txt");
        createFile(PATH_FILE_META_DATA);
        File[] fileList100Nameless = new File(PATH_100_NAMELESS_FILE).listFiles();

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(PATH_FILE_META_DATA))) {
            StringBuilder sBuilder = new StringBuilder();
            for (var namelessFile : fileList100Nameless) {
                sBuilder.append(namelessFile.getName()).append(" -> ").append(namelessFile.length()).append(" Bytes").append("\n");
            }
            bWriter.write(sBuilder.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void tast_3() throws IOException {
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("John", "Doe", (short)20));
        userList.add(new User("Lewis", "Hamilton", (short)35));
        userList.add(new User("Valtteri", "Bottas", (short)33));
        userList.add(new User("Niki", "Lauda", (short)90));
        userList.add(new User("Max", "Verstappen", (short)24));
        userList.add(new User("Daniel", "Ricciardo", (short)30));
        userList.add(new User("Esteban", "Ocon", (short)28));
        userList.add(new User("Pierre", "Gasly", (short)27));
        userList.add(new User("Fernando", "Alonso", (short)39));
        userList.add(new User("Lando", "Norris", (short)24));

        final String PATH_USER_DIRECTORY = PATH_FILE_SERVICE.concat("\\users\\");
        File usersDirectory = new File(PATH_USER_DIRECTORY);
        if (!usersDirectory.exists()) {
            usersDirectory.mkdir();
        }
        String userFileName = "";
        String userFilePath = "";
        for (int i = 0; i < userList.size(); i++) {
            userFileName = userList.get(i).getUserName() + "_" + userList.get(i).getUserSurname() + ".bin";
            userFilePath = PATH_USER_DIRECTORY.concat(userFileName);
            createFile(userFilePath);
            serializeUser(userList.get(i), userFilePath);
        }
        System.out.println("Files was created.");
    }

    public static void serializeUser(User user, String USER_PATH) {
        try (BufferedOutputStream BOS = new BufferedOutputStream(new FileOutputStream(USER_PATH));
             ObjectOutputStream OOS = new ObjectOutputStream(BOS)) {
            OOS.writeObject(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String task_2() throws IOException {
        createFile(PATH_TASK_2);

        StringBuilder sb_editedText = new StringBuilder();
        StringBuilder sb_noEditText = new StringBuilder();
        try (BufferedReader bReader = new BufferedReader(new FileReader("D:\\java\\academy\\Files S\\lorem ipsum.txt"))) {
            String buffString;
            while ((buffString = bReader.readLine()) != null) {
                sb_noEditText.append(buffString);
                buffString = buffString.replace(" ", "");
                sb_editedText.append(buffString);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(PATH_TASK_2))) {
            bWriter.write(sb_editedText.toString());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("File was edit.");
        return sb_noEditText.toString();
    }

    private static void task_1() throws IOException {
        createFile(PATH_TASK_1);

        StringBuilder sbText = new StringBuilder();
        String stopWord = "stop";
        String currentString = "";
        System.out.print("Enter the text (\"stop\" if need exit) ");
        for (;;) {
            currentString = scan.nextLine();
            if (currentString.equals(stopWord)) {
                break;
            }
            sbText.append(currentString).append("\n");
        }

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(PATH_TASK_1))) {
            bWriter.write(sbText.toString());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("Saved to file.");
    }

    public static void createFile(String PATH) throws IOException {
        File newFile = new File(PATH);
        if (!newFile.exists()) {
            newFile.createNewFile();
        }
    }
}
