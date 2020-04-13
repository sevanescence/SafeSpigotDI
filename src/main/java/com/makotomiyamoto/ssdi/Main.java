package com.makotomiyamoto.ssdi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

// TODO figure out how to host this repository online
// TODO ...everything

public final class Main extends JavaPlugin {

    public String PATH;

    @Override
    public void onEnable() {

        PATH = this.getDataFolder().getPath();
        String s = File.separator;

        if (this.getDataFolder().mkdirs())
            print("Data folder created (don't worry, this is just for debugging ^-^).");



    }

    public void print(String message) {

        Bukkit.getConsoleSender().sendMessage("[SSDI] " + message);

    }

}
