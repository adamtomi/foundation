package com.tomushimano.foundation;

import org.bukkit.plugin.java.JavaPlugin;

public class FoundationPlugin extends JavaPlugin {
    private final Runnable enableHook;
    private final Runnable disableHook;

    public FoundationPlugin(Runnable enableHook, Runnable disableHook) {
        this.enableHook = enableHook;
        this.disableHook = disableHook;
    }

    @Override
    public void onEnable() {
        this.enableHook.run();
    }

    @Override
    public void onDisable() {
        this.disableHook.run();
    }
}
