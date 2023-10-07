import java.text.SimpleDateFormat;
import java.util.Date;

public class UserData {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final Date birthDate;
    private final long phoneNumber;
    private final String gender;

    public UserData(String lastName, String firstName, String middleName, Date birthDate, long phoneNumber, String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return lastName + firstName + middleName + dateFormat.format(birthDate) + phoneNumber + gender;
    }
}
