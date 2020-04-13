package com.makotomiyamoto.ssdi.parser;

import com.google.gson.Gson;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

public interface GsonParsable {

    default void saveToJsonAbsolutePath(String absolutePath, Gson gson) throws FileNotFoundException {

        // todo save
        File file = new File(absolutePath.replaceAll("/", File.separator));
        if (!file.exists()) {
            throw new FileNotFoundException(file.getPath() + " does not exist.");
        }

        save(file, gson);

    }

    default void saveToJsonRelativePath(JavaPlugin plugin, String relativePath, Gson gson) throws FileNotFoundException {

        // todo save
        File file = new File(plugin.getDataFolder().getPath() + relativePath.replaceAll("/", File.separator));
        if (!file.exists()) {
            throw new FileNotFoundException(file.getPath() + " does not exist.");
        }

        save(file, gson);

    }

     default void save(File file, Gson gson) {
        byte[] bytes = gson.toJson(this).getBytes();
        try {
            OutputStream oStream = new FileOutputStream(file);
            oStream.write(bytes);
            oStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
