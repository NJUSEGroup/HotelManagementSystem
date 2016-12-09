package hrs.client.UI.LoginUI.LoginPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BGPanel extends JPanel {
//	Image IMG_BG=new ImageIcon("src/main/source/imgs/LoginUI/bg.png").getImage();
	Image IMG_BG=new ImageIcon("src/main/resources/imgs/LoginUI/bg3.png").getImage();;
	
	@Override
	public void paintComponent(Graphics g){
		
		g.drawImage(IMG_BG,0,0,1100,506,null);
	}
}
