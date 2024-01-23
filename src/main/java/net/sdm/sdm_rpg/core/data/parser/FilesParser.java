package net.sdm.sdm_rpg.core.data.parser;

import com.google.common.io.Files;
import com.mojang.logging.LogUtils;
import net.sdm.sdm_rpg.core.Constants;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FilesParser {
    public static final List<Path> files = new ArrayList<>();
    public static void readFiles(){
        File dir = Constants.PROPERTY_FOLDER.toFile();
        if(dir.exists() && dir.isDirectory()){

            File arr[] = dir.listFiles();

            Recursive(arr, 0, 0);
        }
    }

    public static void Recursive(File[] arr, int index, int level){
        if(index == arr.length)
            return;

        for(int i = 0; i < level; i++){
        }

        if (arr[index].isFile())
            if(Files.getFileExtension(arr[index].toPath().getFileName().toString()).contains("snbt")) {
                files.add(arr[index].toPath());
            } else {}
        else if (arr[index].isDirectory()) {
//            LogUtils.getLogger().info("[" + arr[index].getName()
//                    + "]");

            // recursion for sub-directories
            Recursive(arr[index].listFiles(), 0,
                    level + 1);
        }

        Recursive(arr, ++index, level);
    }
}
