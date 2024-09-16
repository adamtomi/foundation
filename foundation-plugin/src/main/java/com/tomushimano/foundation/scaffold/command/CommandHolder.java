package com.tomushimano.foundation.scaffold.command;

import grapefruit.command.dispatcher.CommandDispatcher;

public interface CommandHolder {

    void registerCommands(CommandDispatcher dispatcher);
}
