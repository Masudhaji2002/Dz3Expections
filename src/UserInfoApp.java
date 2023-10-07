import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserInfoApp {
    private static final Map<String, UserData> userDataMap = new HashMap<>();
    private static final List<ErrorObserver> errorObservers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDataFactory factory = new UserDataFactoryImpl();

        System.out.println("Введите данные в произвольном порядке (Фамилия Имя Отчество датарождения номертелефона пол):");
        String input = scanner.nextLine();

        try {
            UserData userData = factory.createUserData(input);
            saveUserData(userData);
            System.out.println("Данные успешно сохранены.");
        } catch (InputFormatException e) {
            handleError(e.getMessage());
        } catch (IOException e) {
            handleError("Произошла ошибка при записи данных в файл.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void saveUserData(UserData userData) throws IOException {
        String lastName = userData.getLastName();
        File file = new File(lastName + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(userData.toString());
            writer.newLine();
        }
    }

    private static void handleError(String message) {
        for (ErrorObserver observer : errorObservers) {
            observer.onError(message);
        }
    }

    public static void addObserver(ErrorObserver observer) {
        errorObservers.add(observer);
    }
}
