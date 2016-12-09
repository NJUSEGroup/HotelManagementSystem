package hrs.client.UI.LoginUI.LoginPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BGPanel extends JPanel {
	Image IMG_BG=new ImageIcon("src/main/source/imgs/LoginUI/bg.png").getImage();
	public void paintComponent(Graphics g){
		g.drawImage(IMG_BG,1100,536,null);
	}
}
