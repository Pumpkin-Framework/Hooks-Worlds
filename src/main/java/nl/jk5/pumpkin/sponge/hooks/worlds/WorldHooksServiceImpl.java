package nl.jk5.pumpkin.sponge.hooks.worlds;

import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import org.spongepowered.api.world.DimensionType;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.common.interfaces.IMixinWorldInfo;

import java.util.BitSet;

public class WorldHooksServiceImpl implements WorldHooksService {

    private final BitSet dimensionIdList;

    public WorldHooksServiceImpl() {
        dimensionIdList = ReflectionHelper.getPrivateValue(DimensionManager.class, null, "dimensionMap");
    }

    @Override
    public int getDimensionId(World world) {
        WorldServer srv = (WorldServer) world;
        return srv.provider.getDimensionId();
    }

    @Override
    public void unregisterDimension(int dimid) {
        DimensionManager.unregisterDimension(dimid);
    }

    @Override
    public void registerDimension(int dimid, int providerId) {
        DimensionManager.registerDimension(dimid, providerId);
    }

    @Override
    public void releaseDimensionId(int dimid) {
        if(dimid < 0) return;
        this.dimensionIdList.clear(dimid);
    }

    @Override
    public void setDimensionType(WorldProperties properties, DimensionType type) {
        ((IMixinWorldInfo) properties).setDimensionType(type);
    }
}
