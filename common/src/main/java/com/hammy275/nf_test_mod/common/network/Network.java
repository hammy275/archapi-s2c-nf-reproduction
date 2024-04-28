package com.hammy275.nf_test_mod.common.network;

import dev.architectury.networking.NetworkManager;
import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;

public class Network {

    public static void registerPacket() {
        if (Platform.getEnvironment() == Env.CLIENT) {
            NetworkManager.registerReceiver(NetworkManager.s2c(), S2CIntPacket.TYPE, S2CIntPacket.CODEC, S2CIntPacket::receiveClient);
        } else {
            NetworkManager.registerS2CPayloadType(S2CIntPacket.TYPE, S2CIntPacket.CODEC);
        }
    }
}
