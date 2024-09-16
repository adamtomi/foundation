package com.tomushimano.foundation.scaffold.command;

import com.tomushimano.foundation.util.DontInvokeMe;
import grapefruit.command.util.key.Key;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class FoundationContextKeys {
    public static final String SENDER_KEY_NAME = "__SENDER__";
    public static final Key<CommandSender> SENDER_KEY = Key.named(CommandSender.class, SENDER_KEY_NAME);
    public static final Key<Player> PLAYER_KEY = Key.named(Player.class, SENDER_KEY_NAME);

    private FoundationContextKeys() {
        throw new DontInvokeMe();
    }
}
