package com.hammy275.nf_test_mod.common.network;

import com.hammy275.nf_test_mod.ReproMod;
import dev.architectury.networking.NetworkManager;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public class S2CIntPacket implements CustomPacketPayload {

    public static final ResourceLocation ID = new ResourceLocation(ReproMod.MOD_ID, "s2c");
    public static final Type<S2CIntPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, S2CIntPacket> CODEC = CustomPacketPayload.codec(S2CIntPacket::write, S2CIntPacket::new);

    public final int myInt;

    public S2CIntPacket(int myInt) {
        this.myInt = myInt;
    }

    public S2CIntPacket(RegistryFriendlyByteBuf buffer) {
        this.myInt = buffer.readInt();
    }

    public void write(RegistryFriendlyByteBuf buffer) {
        buffer.writeInt(this.myInt);
    }

    public static void receiveClient(S2CIntPacket packet, NetworkManager.PacketContext context) {
        context.queue(() -> {
            context.getPlayer().sendSystemMessage(Component.literal("Got int: " + packet.myInt));
        });
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
