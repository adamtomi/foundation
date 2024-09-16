package com.tomushimano.foundation.util;

import com.tomushimano.foundation.Foundation;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class IOUtil {

    private IOUtil() {
        throw new DontInvokeMe();
    }

    public static void copyResource(Path parent, String resource) throws IOException {
        // Create parent if it doesn't exist
        if (!Files.exists(parent)) Files.createDirectory(parent);
        // Resolve destination file
        Path destination = parent.resolve(resource);
        // We don't want to replace existing files
        if (Files.exists(destination)) return;

        String formattedResource = "/%s".formatted(resource);
        try (InputStream in = Foundation.class.getResourceAsStream(formattedResource)) {
            // No such resource, cannot copy
            if (in == null) throw new IOException("Could not copy resource '%s', because it does not exist.".formatted(formattedResource));

            Files.copy(in, destination);
        }
    }
}
