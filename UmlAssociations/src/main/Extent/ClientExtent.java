package main.Extent;

import main.Model.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientExtent {

    //Atrybut powtarzalny
    private List<Client> clientList = new ArrayList<>();

    public void addClient(Client client){
        clientList.add(client);
    }

    public void removeClient(Client client){
        clientList.remove(client);
    }

    public void showClients(){
        for(Client client : clientList){
            System.out.println(client);
        }
    }

    public void writeToFile(String pathToFile) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(pathToFile));
        stream.writeObject(clientList);

        stream.close();
    }

    public void readFromFile(String pathToFile) throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(pathToFile));
        clientList = (ArrayList<Client>) stream.readObject();

        stream.close();
    }

}
