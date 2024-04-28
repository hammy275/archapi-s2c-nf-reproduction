package com.hammy275.neoforge;

import com.hammy275.nf_test_mod.ReproMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ReproMod.MOD_ID)
public class ReproModNeoForge {
    public ReproModNeoForge(IEventBus eventBus) {
        ReproMod.init();
    }
}
