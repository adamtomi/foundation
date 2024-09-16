package com.tomushimano.foundation;

import com.tomushimano.foundation.util.NamespacedLoggerFactory;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Path;

import static com.tomushimano.foundation.util.ExceptionUtil.dumpStackTrace;
import static com.tomushimano.foundation.util.IOUtil.copyResource;

public final class Foundation {
    private static final String[] STARTUP_MESSAGE = {
            "",
            "┌─┐┌─┐┬ ┬┌┐┌┌┬┐┌─┐┌┬┐┬┌─┐┌┐┌",
            "├┤ │ ││ ││││ ││├─┤ │ ││ ││││",
            "└  └─┘└─┘┘└┘─┴┘┴ ┴ ┴ ┴└─┘┘└┘",
            "\t\tv%s",
            ""
    };
    private static final Logger LOGGER = NamespacedLoggerFactory.create("main");
    private final JavaPlugin plugin;

    @Inject
    public Foundation(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void load() {
        printStartupMessage();
        // Copying resource files
        try {
            LOGGER.info("Attempting to copy configuration files");
            copyResources();
        } catch (IOException ex) {
            dumpStackTrace(LOGGER, "Failed to copy configuration files!", ex);
        }
    }

    public void unload() {
    }

    private void printStartupMessage() {
        String version = this.plugin.getPluginMeta().getVersion();
        for (String message : STARTUP_MESSAGE) LOGGER.info(message.formatted(version));
    }

    private void copyResources() throws IOException {
        Path datafolder = this.plugin.getDataPath();
        copyResource(datafolder, "config.yml");
        copyResource(datafolder, "lang.yml");
    }
}
