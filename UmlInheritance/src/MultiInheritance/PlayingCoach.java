package MultiInheritance;

import java.time.LocalDate;

public class PlayingCoach extends Coach implements IPlayer {

    private Player player;

    public PlayingCoach(String firstName, String lastName, LocalDate birthDate, LocalDate contractEnd, float salary, String favouriteFormation, int number, float advertisingIncome, String position, float playerSalary) {
        super(firstName, lastName, birthDate, contractEnd, salary, favouriteFormation);
        player = new Player(null, null, null, null, position, number, playerSalary, advertisingIncome);
    }

    @Override
    public float getAdvertisingIncome() {
        return player.getAdvertisingIncome();
    }

    @Override
    public void setAdvertisingIncome(float advertisingIncome) {
        player.setAdvertisingIncome(advertisingIncome);
    }

    @Override
    public void setPosition(String position) {
        player.setPosition(position);
    }

    @Override
    public String getPosition() {
        return player.getPosition();
    }

    @Override
    public void setNumber(int number) {
        player.setNumber(number);
    }

    @Override
    public int getNumber() {
        return player.getNumber();
    }

    @Override
    public float getIncome() {
        return super.getSalary()+getAdvertisingIncome() +getSalary();
    }

    @Override
    public float getSalary() {
        return player.getSalary();
    }

    @Override
    public void setSalary(float salary) {
        player.setSalary(salary);
    }

    @Override
    public String toString() {
        return "PlayingCoach{" +
                "firstName="+getFirstName()+
                ", lastName="+getLastName()+
                ", contractEnd="+getContractEnd()+
                ", favouriteFormation="+getFavouriteFormation()+
                ", number=" + getNumber() +
                ", advertisingIncome=" + getAdvertisingIncome() +
                ", position='" + getPosition() + '\'' +
                ", couch salary=" + super.getSalary() +
                ", player salary="+ getSalary()+
                ", total income=" + getIncome()+
                '}';
    }
}
