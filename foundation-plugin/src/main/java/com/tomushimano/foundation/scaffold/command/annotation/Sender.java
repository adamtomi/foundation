package com.tomushimano.foundation.scaffold.command.annotation;

import com.tomushimano.foundation.scaffold.command.FoundationContextKeys;
import grapefruit.command.annotation.inject.InjectedBy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PARAMETER)
@InjectedBy(value = FoundationContextKeys.SENDER_KEY_NAME, nullable = false)
public @interface Sender {}
