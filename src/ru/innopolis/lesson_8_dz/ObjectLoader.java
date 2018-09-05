package ru.innopolis.lesson_8_dz;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ObjectLoader extends ClassLoader {

    private String pathClass = "TestClass";
    private String dest = "/home/sergej/IdeaProjects/STC12/Sergej.class";

    public ObjectLoader() {
    }

    public void setPathClass(String pathClass) {
        this.pathClass = pathClass;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        System.out.println("Object Load");
        if (name.equals(pathClass)){
            byte[]classData = readClassFromDest(dest);
            return defineClass(name,classData,0,classData.length);
        }
        return super.loadClass(name);
    }

    private byte[] readClassFromDest(String dest){
        byte[]classData = null;
        try {
            URL url = new URL(dest);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int data = inputStream.read();
            while (data != -1){
                byteArrayOutputStream.write(data);
                data = inputStream.read();
            }
            inputStream.close();
            classData = byteArrayOutputStream.toByteArray();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classData;
    }
}
