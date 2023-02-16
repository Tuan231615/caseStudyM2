package storage;

import model.ElectronicDevice;

import java.util.List;

public interface InReadWriteFile {

    void writeToFile(List<ElectronicDevice> electronicDevices);
     List<ElectronicDevice> readToFile();
}
