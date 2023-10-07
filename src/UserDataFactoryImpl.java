import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDataFactoryImpl implements UserDataFactory{
    @Override
    public UserData createUserData(String input) throws InputFormatException {
        String[] tokens = input.split(" ");
        if (tokens.length != 6) {
            throw new InputFormatException("Неверное количество данных. Введите все данные.");
    }
        String lastName = tokens[0];
        String firstName = tokens[1];
        String middleName = tokens[2];
        String birthDateStr = tokens[3];
        String phoneNumberStr = tokens[4];
        String genderStr = tokens[5];

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);

        try {
            Date birthDate = dateFormat.parse(birthDateStr);
            long phoneNumber = Long.parseLong(phoneNumberStr);

            if (!genderStr.equals("f") && !genderStr.equals("m")) {
                throw new InputFormatException("Неверный формат пола. Используйте 'f' или 'm'.");
            }

            return new UserData(lastName, firstName, middleName, birthDate, phoneNumber, genderStr);
        } catch (ParseException | NumberFormatException e) {
            throw new InputFormatException("Неверный формат данных.");
        }
    }
}
