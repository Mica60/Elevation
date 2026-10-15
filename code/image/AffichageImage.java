package image;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

 public class AffichageImage {
    private String lienImage;

    public AffichageImage(String lienImage) {
        this.lienImage = lienImage;
    }

    public void FaireAfficherImage() throws Exception {
        BufferedImage original = ImageIO.read(new File(this.lienImage));
        int w = 50;
        int h = original.getHeight() * w / original.getWidth();
        h -= h % 2;
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        img.getGraphics().drawImage(original.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
        for (int y = 0; y < img.getHeight() - 1; y += 2) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < img.getWidth(); x++) {
                int haut = img.getRGB(x, y);
                int bas = img.getRGB(x, y + 1);
                sb.append(String.format("\u001B[38;2;%d;%d;%dm\u001B[48;2;%d;%d;%dm▀",
                    (haut >> 16) & 255, (haut >> 8) & 255, haut & 255,
                    (bas >> 16) & 255, (bas >> 8) & 255, bas & 255));
            }
            System.out.println(sb + "\u001B[0m");
        }
    }
} 