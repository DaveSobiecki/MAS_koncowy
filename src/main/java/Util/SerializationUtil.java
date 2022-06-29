package Util;

import java.io.*;
import java.util.ArrayList;

public class SerializationUtil {

    public static void serializeObject(Object object, String fileName){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> ArrayList<T> deserializeObject(Class<T> type, String fileName){

        ArrayList<T> deserializedList = null;

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))){
            deserializedList = (ArrayList<T>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deserializedList;
    }
}
