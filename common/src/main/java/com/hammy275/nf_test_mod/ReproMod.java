package com.hammy275.nf_test_mod;

import com.hammy275.nf_test_mod.common.network.Network;
import com.hammy275.nf_test_mod.common.network.S2CIntPacket;
import dev.architectury.event.events.common.TickEvent;
import dev.architectury.networking.NetworkManager;
import net.minecraft.server.level.ServerPlayer;

public class ReproMod {
    public static final String MOD_ID = "nf_test_mod";

    public static void init() {
        Network.registerPacket();
        TickEvent.PLAYER_POST.register((player) -> {
            if (player instanceof ServerPlayer sp && player.tickCount % 20 == 0 && player.tickCount > 99) {
                NetworkManager.sendToPlayer(sp, new S2CIntPacket(62));
            }
        });
    }
}
