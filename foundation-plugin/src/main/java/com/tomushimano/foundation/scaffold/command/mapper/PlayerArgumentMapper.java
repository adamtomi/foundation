package com.tomushimano.foundation.scaffold.command.mapper;

import grapefruit.command.CommandException;
import grapefruit.command.argument.CommandArgumentException;
import grapefruit.command.argument.mapper.ArgumentMapper;
import grapefruit.command.dispatcher.CommandContext;
import grapefruit.command.dispatcher.input.StringReader;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class PlayerArgumentMapper implements ArgumentMapper<Player> {

    @Override
    public Player tryMap(CommandContext context, StringReader input) throws CommandException {
        String nameOrUuid = input.readSingle();
        Player player;

        // Attempt to retrieve player based on UUID
        try {
            UUID uuid = UUID.fromString(nameOrUuid);
            player = Bukkit.getPlayer(uuid);
        } catch (IllegalArgumentException ex) {
            // Oops, this is not a valid uuid
            player = Bukkit.getPlayer(nameOrUuid);
        }

        if (player == null) throw new CommandArgumentException(); // TODO error message
        return player;
    }

    @Override
    public List<String> complete(CommandContext context, String input) {
        return Bukkit.getOnlinePlayers()
                .stream()
                .map(Player::getName)
                .toList();
    }
}
