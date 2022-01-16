package TeamStrati.LobbySystem.trails;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        ParticleData p = new ParticleData(event.getPlayer().getUniqueId());
        if(p.hasID())
            p.endTask();

    }

}
