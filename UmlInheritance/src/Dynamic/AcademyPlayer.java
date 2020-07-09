package Dynamic;

import java.time.LocalDate;

public class AcademyPlayer extends Person {
    private String previousPosition;
    private String position;
    private float scholarship;

    public AcademyPlayer(String firstName, String lastName, LocalDate birthDate, String previousPosition, String position, float scholarship) {
        super(firstName, lastName, birthDate);
        this.previousPosition = previousPosition;
        this.position = position;
        this.scholarship = scholarship;
    }

    public AcademyPlayer(Person prevPerson, String previousPosition, String position, float scholarship){
        super(prevPerson.firstName, prevPerson.lastName, prevPerson.birthDate);
        this.previousPosition = previousPosition;
        this.position = position;
        this.scholarship = scholarship;
    }

    public String getPreviousPosition() {
        return previousPosition;
    }

    public void setPreviousPosition(String previousPosition) {
        this.previousPosition = previousPosition;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getScholarship() {
        return scholarship;
    }

    public void setScholarship(float scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public float getIncome() {
        return getScholarship();
    }
}
