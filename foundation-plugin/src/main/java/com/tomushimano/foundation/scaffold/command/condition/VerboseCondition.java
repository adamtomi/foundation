package com.tomushimano.foundation.scaffold.command.condition;

import grapefruit.command.dispatcher.condition.CommandCondition;
import net.kyori.adventure.text.Component;

public interface VerboseCondition extends CommandCondition {

    Component describeFailure();
}
