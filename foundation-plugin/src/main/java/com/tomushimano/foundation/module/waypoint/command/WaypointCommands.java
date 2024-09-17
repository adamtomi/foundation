package com.tomushimano.foundation.module.waypoint.command;

import com.tomushimano.foundation.module.waypoint.Waypoint;
import com.tomushimano.foundation.scaffold.command.CommandHolder;
import com.tomushimano.foundation.scaffold.command.annotation.Sender;
import com.tomushimano.foundation.scaffold.command.condition.IsPlayer;
import grapefruit.command.CommandContainer;
import grapefruit.command.annotation.CommandDefinition;
import grapefruit.command.annotation.argument.Arg;
import grapefruit.command.annotation.argument.Flag;
import grapefruit.command.dispatcher.CommandDispatcher;
import org.bukkit.entity.Player;

import static com.tomushimano.foundation.module.waypoint.WaypointPermissions.WAYPOINT_MANAGEMENT;

public class WaypointCommands implements CommandHolder {
    private final CommandContainer container = new WaypointCommands_Container(this);

    @Override
    public void registerCommands(CommandDispatcher dispatcher) {
        dispatcher.register(this.container);
    }

    @CommandDefinition(route = "waypoint|wp set", permission = WAYPOINT_MANAGEMENT, conditions = { IsPlayer.class })
    public void set(
            @Sender Player sender,
            @Arg String name,
            @Flag String displayName,
            @Flag boolean global,
            @Flag boolean unsafe
    ) {

    }

    @CommandDefinition(route = "waypoint|wp remove|rm", permission = WAYPOINT_MANAGEMENT, conditions = { IsPlayer.class })
    public void remove(@Sender Player sender, @Arg Waypoint waypoint) {

    }

    @CommandDefinition(route = "waypoint|wp list|ls", permission = WAYPOINT_MANAGEMENT, conditions = { IsPlayer.class })
    public void list(
            @Sender Player sender,
            @Flag int page,
            @Flag boolean hideGlobals
    ) {

    }

    @CommandDefinition(route = "waypoint|wp toggle", permission = WAYPOINT_MANAGEMENT, conditions = { IsPlayer.class })
    public void toggle(@Sender Player sender, @Flag Waypoint target) {

    }
}
