package com.tomushimano.foundation.di;

import com.tomushimano.foundation.Foundation;
import dagger.BindsInstance;
import dagger.Component;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Singleton;

@Singleton
@Component(modules = {

})
public interface FoundationComponent {

    Foundation instance();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder plugin(JavaPlugin plugin);

        FoundationComponent build();
    }
}
