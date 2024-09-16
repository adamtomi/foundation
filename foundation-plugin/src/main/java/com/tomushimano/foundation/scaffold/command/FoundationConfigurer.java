package com.tomushimano.foundation.scaffold.command;

import grapefruit.command.dispatcher.config.DispatcherConfigurer;

import static com.tomushimano.foundation.scaffold.command.FoundationContextKeys.SENDER_KEY;

public class FoundationConfigurer extends DispatcherConfigurer {

    @Override
    public void configure() {
        // Setup authorizer
        authorize((perm, context) -> context.require(SENDER_KEY).hasPermission(perm));
    }
}
