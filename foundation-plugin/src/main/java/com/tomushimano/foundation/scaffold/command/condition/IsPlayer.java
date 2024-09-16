package com.tomushimano.foundation.scaffold.command.condition;

import com.tomushimano.foundation.scaffold.command.FoundationContextKeys;
import grapefruit.command.dispatcher.CommandContext;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.RED;

public class IsPlayer implements VerboseCondition {

    @Override
    public Component describeFailure() {
        return text("You need to be a player to execute this command.", RED);
    }

    @Override
    public boolean evaluate(CommandContext context) {
        return context.require(FoundationContextKeys.SENDER_KEY) instanceof Player;
    }
}
