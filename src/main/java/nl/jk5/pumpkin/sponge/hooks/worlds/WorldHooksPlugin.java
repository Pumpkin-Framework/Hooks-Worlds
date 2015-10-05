package nl.jk5.pumpkin.sponge.hooks.worlds;

import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.service.ProviderExistsException;

import javax.inject.Inject;

@Plugin(id = "PumpkinWorldHooks", name = "Pumpkin World Hooks", version = "1.1.0")
public class WorldHooksPlugin {

    @Inject
    private Logger logger;

    @Listener
    public void preInit(GamePreInitializationEvent event){
        try {
            event.getGame().getServiceManager().setProvider(this, WorldHooksService.class, new WorldHooksServiceImpl());
        } catch (ProviderExistsException e) {
            logger.warn("Could not inject WorldHooksService implementation as it already exists");
        }
    }
}
