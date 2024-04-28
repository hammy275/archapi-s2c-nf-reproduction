package com.hammy275.fabric;

import com.hammy275.nf_test_mod.ReproMod;
import net.fabricmc.api.ModInitializer;

public class ReproModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ReproMod.init();
    }
}
