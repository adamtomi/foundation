package com.tomushimano.foundation.module.waypoint.command;

import com.tomushimano.foundation.module.waypoint.Waypoint;
import grapefruit.command.CommandException;
import grapefruit.command.argument.mapper.ArgumentMapper;
import grapefruit.command.dispatcher.CommandContext;
import grapefruit.command.dispatcher.input.StringReader;

import java.util.List;

public class WaypointArgumentMapper implements ArgumentMapper<Waypoint> {

    @Override
    public Waypoint tryMap(CommandContext commandContext, StringReader stringReader) throws CommandException {
        return null;
    }

    @Override
    public List<String> complete(CommandContext commandContext, String s) {
        return List.of();
    }
}
