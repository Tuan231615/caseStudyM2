package storage;

import controller.ElectronicManager;
import model.ElectronicDevice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    private ReadWriteFile() {
    }

    private static ReadWriteFile instance;

    public static ReadWriteFile getInstance() {
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
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
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
        List<ElectronicDevice> electronicDevices;
        FileInputStream fileInputStream;
        try {
             fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            try {
                electronicDevices = ((List<ElectronicDevice>) objectInputStream.readObject());

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
                throw new RuntimeException(e);
            }
        return electronicDevices;
    }
}
