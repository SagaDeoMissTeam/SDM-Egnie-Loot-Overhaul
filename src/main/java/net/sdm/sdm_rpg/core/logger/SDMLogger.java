package net.sdm.sdm_rpg.core.logger;

import com.mojang.logging.LogUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SDMLogger implements ISDMLogger{

    public String name = "";
    public Path location;
    public SDMLogger(String name, Path location){
        this.name = name;
        this.location = location;
        createFile();
    }
    @Override
    public void sendInfo(Object message) {
        if(isExist()){
            String timeStamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(Calendar.getInstance().getTime());
            try {
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(location.toFile(), true)));
                writer.println(("[" + timeStamp + "] "  + (!name.isEmpty() ? "[" + name + "] " : "") + "[INFO] " + message));
                LogUtils.getLogger().info((!name.isEmpty() ? "[" + name + "] " : "") + message);
                writer.flush();
                writer.close();
            } catch (IOException e) {}
        }
    }

    @Override
    public void sendDebug(Object message) {
        String timeStamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(Calendar.getInstance().getTime());
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(location.toFile(), true)));
            writer.println(("[" + timeStamp + "] "  + (!name.isEmpty() ? "[" + name + "] " : "") + "[DEBUG] " + message));
            LogUtils.getLogger().debug((!name.isEmpty() ? "[" + name + "] " : "") + message);
            writer.close();
        } catch (IOException e) {}
    }

    @Override
    public void sendError(Object message) {
        String timeStamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(Calendar.getInstance().getTime());
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(location.toFile(), true)));
            writer.println(("[" + timeStamp + "] "  + (!name.isEmpty() ? "[" + name + "] " : "") + "[ERROR] " + message));
            LogUtils.getLogger().error((!name.isEmpty() ? "[" + name + "] " : "") + message);
            writer.flush();
            writer.close();
        } catch (IOException e) {}
    }

    @Override
    public void sendMessage(Object message) {
        String timeStamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(Calendar.getInstance().getTime());
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(location.toFile(), true)));
            writer.println(("[" + timeStamp + "] "  + (!name.isEmpty() ? "[" + name + "] " : "") + message));
            writer.close();
        } catch (IOException e) {}
    }

    @Override
    public void sendWarn(Object message) {
        String timeStamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(Calendar.getInstance().getTime());
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(location.toFile(), true)));
            writer.println(("[" + timeStamp + "] "  + (!name.isEmpty() ? "[" + name + "] " : "") + "[WARN] " + message));
            LogUtils.getLogger().warn((!name.isEmpty() ? "[" + name + "] " : "") + message);
            writer.close();
        } catch (IOException e) {}
    }

    @Override
    public void send(Object message) {
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(location.toFile(), true)));
            writer.println(message);
            LogUtils.getLogger().trace(message.toString());
            writer.close();
        } catch (IOException e) {}
    }

    public boolean isExist(){
        return location.toFile().exists();
    }

    public void createFile() {
        if(!isExist()) {
            try {
                location.toFile().createNewFile();
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(location.toFile(), false)));
                writer.write("");
                writer.flush();
                writer.close();
            } catch (IOException e) {}
        } else{
            try {
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(location.toFile(), false)));
                writer.write("");
                writer.flush();
                writer.close();
            } catch (IOException e) {}
        }
    }
}
