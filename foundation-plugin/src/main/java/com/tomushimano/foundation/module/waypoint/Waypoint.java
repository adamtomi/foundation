package com.tomushimano.foundation.module.waypoint;

import com.tomushimano.foundation.scaffold.identity.Identity;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public class Waypoint implements Identity {
    private final UUID uuid;
    private final UUID owner;
    private final String name;
    private final @Nullable String displayName;
    private final boolean global;

    private Waypoint(
            UUID uuid,
            UUID owner,
            String name,
            @Nullable String displayName,
            boolean global
    ) {
        this.uuid = requireNonNull(uuid, "uuid cannot be null");
        this.owner = requireNonNull(owner, "owner cannot be null");
        this.name = requireNonNull(name, "name cannot be null");
        this.displayName = displayName;
        this.global = global;
    }

    @Override
    public UUID id() {
        return this.uuid;
    }

    public UUID owner() {
        return this.owner;
    }

    public String name() {
        return this.name;
    }

    public Optional<String> displayName() {
        return Optional.ofNullable(this.displayName);
    }

    public boolean isGlobal() {
        return this.global;
    }
}
