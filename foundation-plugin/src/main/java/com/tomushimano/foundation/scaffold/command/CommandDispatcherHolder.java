package com.tomushimano.foundation.scaffold.command;

import grapefruit.command.dispatcher.CommandDispatcher;
import grapefruit.command.dispatcher.config.DefaultConfigurer;

import javax.inject.Inject;

public class CommandDispatcherHolder {
    private final CommandDispatcher dispatcher;

    @Inject
    public CommandDispatcherHolder(FoundationConfigurer configurer) {
        this.dispatcher = CommandDispatcher.using(DefaultConfigurer.getInstance(), configurer);
    }
}
