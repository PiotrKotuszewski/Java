package Dynamic;

import java.time.LocalDate;

public class Player extends Person {
    private int number;
    private String position;
    private float sponsorIncome;
    private float contractIncome;

    public Player(String firstName, String lastName, LocalDate birthDate, String position, float sponsorIncome, float contractIncome) {
        super(firstName, lastName, birthDate);
        this.position = position;
        this.sponsorIncome = sponsorIncome;
        this.contractIncome = contractIncome;
    }

    public Player(Person prevPerson, String position, float sponsorIncome, float contractIncome){
        super(prevPerson.firstName, prevPerson.lastName, prevPerson.birthDate);
        this.position = position;
        this.sponsorIncome = sponsorIncome;
        this.contractIncome = contractIncome;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSponsorIncome() {
        return sponsorIncome;
    }

    public void setSponsorIncome(float sponsorIncome) {
        this.sponsorIncome = sponsorIncome;
    }

    public float getContractIncome() {
        return contractIncome;
    }

    public void setContractIncome(float contractIncome) {
        this.contractIncome = contractIncome;
    }

    @Override
    public float getIncome() {
        return getSponsorIncome()+getContractIncome();
    }
}
