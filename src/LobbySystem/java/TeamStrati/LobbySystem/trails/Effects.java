package TeamStrati.LobbySystem.trails;

import TeamStrati.LobbySystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class Effects {

    private int taskID;
    private final Player player;

    public Effects(Player player) {
        this.player = player;
    }

    public void startTotem() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {

            double var = 0;
            Location loc, first, second;
            ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run() {
                if (!particle.hasID()) {
                    particle.setID(taskID);
                }

                var += Math.PI / 16;

                loc = player.getLocation();
                first = loc.clone().add(Math.cos(var), Math.sin(var) + 1, Math.sin(var));
                second = loc.clone().add(Math.cos(var + Math.PI), Math.sin(var) + 1, Math.sin(var + Math.PI));

                player.getWorld().spawnParticle(Particle.TOTEM, first, 0);
                player.getWorld().spawnParticle(Particle.TOTEM, second, 0);
            }

        }, 0, 1);
    }
    public void heartTrail(){
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {

            double var = 0;
            Location loc, first, second;
            ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run(){
                if (!particle.hasID()) {
                    particle.setID(taskID);
                }

                player.getWorld().spawnParticle(Particle.HEART, player.getLocation(), 1);
            }

        }, 0, 1);
    }
    public void AngryHead(){
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {

            double var = 0;
            Location loc, first, second;
            ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run(){
                if (!particle.hasID()) {
                    particle.setID(taskID);
                }

                player.getWorld().spawnParticle(Particle.VILLAGER_ANGRY, player.getLocation().add(0,1.60,0), 1);
            }

        },0,1);
    }
    public void EmeraldHalo(){
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {

            double var = 0;
            Location loc, first, second;
            ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run(){
                if (!particle.hasID()) {
                    particle.setID(taskID);
                }

                var += Math.PI / 20;

                loc = player.getLocation();
                first = loc.clone().add(Math.cos(var), 2, Math.sin(var));


                player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, first, 0);

            }

        },0,1);
    }
    public void FeueruntermHintern(){
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {

            double var = 0;
            Location loc, first, second;
            ParticleData particle = new ParticleData(player.getUniqueId());

            @Override
            public void run(){
                if (!particle.hasID()) {
                    particle.setID(taskID);
                }

                player.getWorld().spawnParticle(Particle.LAVA, player.getLocation().add(0,0.70,0), 1);
            }

        },0,1);
    }

}
