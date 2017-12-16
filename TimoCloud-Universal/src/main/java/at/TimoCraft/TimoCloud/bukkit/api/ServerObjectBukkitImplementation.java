package at.TimoCraft.TimoCloud.bukkit.api;

import at.TimoCraft.TimoCloud.api.objects.ServerObject;
import at.TimoCraft.TimoCloud.api.implementations.ServerObjectBasicImplementation;
import at.TimoCraft.TimoCloud.bukkit.TimoCloudBukkit;

import java.net.InetSocketAddress;

public class ServerObjectBukkitImplementation extends ServerObjectBasicImplementation implements ServerObject {

    public ServerObjectBukkitImplementation() {}

    public ServerObjectBukkitImplementation(String name, String group, String token, String state, String extra, String map, String motd, int currentPlayers, int maxPlayers, InetSocketAddress socketAddress) {
        super(name, group, token, state, extra, map, motd, currentPlayers, maxPlayers, socketAddress);
    }

    public ServerObjectBukkitImplementation(ServerObjectBasicImplementation serverObjectBasicImplementation) {
        this(
                serverObjectBasicImplementation.getName(),
                serverObjectBasicImplementation.getGroupName(),
                serverObjectBasicImplementation.getToken(),
                serverObjectBasicImplementation.getState(),
                serverObjectBasicImplementation.getExtra(),
                serverObjectBasicImplementation.getMap(),
                serverObjectBasicImplementation.getMotd(),
                serverObjectBasicImplementation.getCurrentPlayers(),
                serverObjectBasicImplementation.getMaxPlayers(),
                serverObjectBasicImplementation.getSocketAddress()
        );
    }

    @Override
    public void setState(String state) {
        this.state = state;
        TimoCloudBukkit.getInstance().getBukkitSocketMessageManager().sendMessage("SET_STATE", getName(), state);
    }

    @Override
    public void setExtra(String extra) {
        this.extra = extra;
        TimoCloudBukkit.getInstance().getBukkitSocketMessageManager().sendMessage("SET_EXTRA", getName(), extra);
    }

    @Override
    public void executeCommand(String command) {
        TimoCloudBukkit.getInstance().getBukkitSocketMessageManager().sendMessage("REDIRECT_COMMAND", getName(), command);
    }

    @Override
    public void stop() {
        TimoCloudBukkit.getInstance().getBukkitSocketMessageManager().sendMessage("STOP_SERVER", getName(), "");
    }
}
