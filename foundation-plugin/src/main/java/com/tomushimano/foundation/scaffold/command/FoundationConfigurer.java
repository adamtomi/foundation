package com.tomushimano.foundation.scaffold.command;

import com.tomushimano.foundation.scaffold.command.mapper.PlayerArgumentMapper;
import grapefruit.command.dispatcher.config.DispatcherConfigurer;
import org.bukkit.entity.Player;

import static com.tomushimano.foundation.scaffold.command.FoundationContextKeys.SENDER_KEY;

public class FoundationConfigurer extends DispatcherConfigurer {

    @Override
    public void configure() {
        // Setup authorizer
        authorize((perm, context) -> context.require(SENDER_KEY).hasPermission(perm));

        // Register mappers
        map(Player.class).using(new PlayerArgumentMapper());
    }
}
