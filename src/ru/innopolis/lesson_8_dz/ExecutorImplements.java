package ru.innopolis.lesson_8_dz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecutorImplements implements Executor {
    @Override
    public void execute(String code) throws IOException {
        String nameClass = findNameClass(code);
        String pathFileJava = writeCodeFile(nameClass,code);
        System.out.println(pathFileJava);
        Process processExec = Runtime.getRuntime().exec("javac " + pathFileJava);
    }

    private String findNameClass(String code){
        Pattern p = Pattern.compile("class(\\w*).(\\w*)");
        Matcher m = p.matcher(code);
        if (m.find()) {
            String[] strings = m.group().split("\\s");
            System.out.println(strings[1]);
            return strings[1];
        }
        return null;
    }

    private String writeCodeFile(String nameClass, String code) throws IOException {
        File fileCode = new File( nameClass + ".java");
        try (FileOutputStream fos = new FileOutputStream(fileCode)){
            fos.write(code.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileCode.getCanonicalPath();
    }
}
