package TeamStrati.LobbySystem.ImageMaps;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapPalette;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class LogoRenderer extends MapRenderer {

    private BufferedImage image;
    private boolean done;

    public LogoRenderer() {
        done = false;
    }

    public LogoRenderer(String url) {
        load(url);
        done = false;
    }

    public boolean load(String url) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new URL(url));
            image = MapPalette.resizeImage(image); //less ram
        } catch (IOException e) {
            return false;
        }
        this.image = image;
        return true;
    }

    @Override
    public void render(MapView view, MapCanvas canvas, Player player) {
        if (done)
            return;

        canvas.drawImage(0, 0, image);
        //canvas.drawText(15, 15, MinecraftFont.Font, player.getName()); // <--- Draws text on map
        view.setTrackingPosition(false);
        done = true; // super important
    }

}

