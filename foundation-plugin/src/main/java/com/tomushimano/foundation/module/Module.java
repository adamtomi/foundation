package com.tomushimano.foundation.module;

import grapefruit.command.CommandContainer;
import grapefruit.command.dispatcher.config.DispatcherConfigurer;

import java.util.Set;

public interface Module {

    default void load() {}

    default void unload() {}

    Set<CommandContainer> commands();

    DispatcherConfigurer configurer();
}
