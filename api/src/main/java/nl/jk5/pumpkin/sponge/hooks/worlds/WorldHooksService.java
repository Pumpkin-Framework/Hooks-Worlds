package nl.jk5.pumpkin.sponge.hooks.worlds;

import org.spongepowered.api.world.DimensionType;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.storage.WorldProperties;

public interface WorldHooksService {

    int getDimensionId(World world);

    void unregisterDimension(int dimid);

    void registerDimension(int dimid, int providerId);

    void releaseDimensionId(int dimid);

    void setDimensionType(WorldProperties properties, DimensionType type);
}
