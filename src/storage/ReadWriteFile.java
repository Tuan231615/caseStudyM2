package storage;

import model.ElectronicDevice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    private ReadWriteFile() {
    }

    private static ReadWriteFile instance;

    private static ReadWriteFile getInstance() {
        if (instance == null) {
            return instance = new ReadWriteFile();
        }
        return instance;
    }
    
    public boolean writeToFile(List<ElectronicDevice> electronicDevices) {
        File file = new File("ElectronicDevice.dat");
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(electronicDevices);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public List<ElectronicDevice> readToFile() {
        File file = new File("ElectronicDevice.dat");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (objectInputStream != null) {
                List<ElectronicDevice> electronicDevices = null;
                try {
                    electronicDevices = (List<ElectronicDevice>) objectInputStream.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                return electronicDevices;
            } else return new ArrayList<>();
        }
    }
}
