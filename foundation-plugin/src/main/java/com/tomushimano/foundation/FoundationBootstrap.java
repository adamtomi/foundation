package com.tomushimano.foundation;

import com.tomushimano.foundation.di.DaggerFoundationComponent;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.bootstrap.PluginProviderContext;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class FoundationBootstrap implements PluginBootstrap {
    private Foundation foundation;

    @Override
    public void bootstrap(@NotNull BootstrapContext context) {
        // TODO mojang command registration
    }

    @Override
    public @NotNull JavaPlugin createPlugin(@NotNull PluginProviderContext context) {
        // Very nice solution, yes, much wow.
        JavaPlugin plugin = new FoundationPlugin(
                () -> this.foundation.load(),
                () -> this.foundation.unload()
        );

        // Create loader
        this.foundation = DaggerFoundationComponent.builder()
                .plugin(plugin)
                .build()
                .instance();

        return plugin;
    }
}
