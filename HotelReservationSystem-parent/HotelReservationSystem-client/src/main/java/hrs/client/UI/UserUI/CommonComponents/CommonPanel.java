package hrs.client.UI.UserUI.CommonComponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import hrs.client.util.UIConstants;

public abstract class CommonPanel extends JPanel {
	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = -8514676097183408632L;
	public abstract void Init();
	Font font = UIConstants.jlabelChinese;
	public CommonPanel(){
		setLayout(null);
		setBackground(new Color(211, 237, 249));
		setSize(1103, 768);
		setFont(font);
	}
}
