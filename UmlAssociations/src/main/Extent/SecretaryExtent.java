package main.Extent;

import main.Model.Secretary;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SecretaryExtent {

    private List<Secretary> secretaryList = new ArrayList<>();

    public void addSecretary(Secretary secretary){
        secretaryList.add(secretary);
    }

    public void showSecretaries(){
        for(Secretary secretary : secretaryList){
            System.out.println(secretary);
        }
    }

    public void removeSecretary(Secretary secretary){
        secretaryList.remove(secretary);
    }

    //Metoda klasowa
    public List<Secretary> findSecretaryWithTheBiggestSalary(){
        return Collections.singletonList(secretaryList.stream().max(Comparator.comparing(Secretary::getSalary)).get());
    }

    public void writeToFile(String pathToFile) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(pathToFile));
        stream.writeObject(secretaryList);

        stream.close();
    }

    public void readFromFile(String pathToFile) throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(pathToFile));
        secretaryList = (ArrayList<Secretary>) stream.readObject();

        stream.close();
    }
}
