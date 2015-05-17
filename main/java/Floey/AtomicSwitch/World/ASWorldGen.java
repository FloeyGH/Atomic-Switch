package Floey.AtomicSwitch.World;

import Floey.AtomicSwitch.GameObjects.GameObjects;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class ASWorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        if (world.getWorldInfo().getTerrainType().getWorldTypeName().equals("flat"))
            return;

        int xMin = chunkX << 4;
        int zMin = chunkZ << 4;

        int startX = xMin + random.nextInt(16);
        int startZ = zMin + random.nextInt(16);

        int tries = random.nextInt(2);

        for (int i=0; i < tries; i++) {
            int x = startX + random.nextInt(8) - random.nextInt(8);
            int z = startZ + random.nextInt(8) - random.nextInt(8);
            int y = world.getHeightValue(x, z);

            if ((world.isAirBlock(x, y, z) || (world.getBlock(x,y,z) == Blocks.snow)) && GameObjects.blockAtomiccus.canBlockStay(world, x, y, z)) {
                if (random.nextInt(50) > 8)
                    continue;

                world.setBlock(x, y, z, GameObjects.blockAtomiccus, 0, 0);
            }
        }
    }
}