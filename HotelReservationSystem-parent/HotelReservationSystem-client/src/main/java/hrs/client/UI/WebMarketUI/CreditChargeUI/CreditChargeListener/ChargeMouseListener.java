package hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargeListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargePanel;
import hrs.client.util.UIConstants;

public class ChargeMouseListener implements MouseListener{
	private JButton jbButton;
	private CreditChargePanel creditChargePanel;
	private JTextField jtChargeValue;
	public ChargeMouseListener(CreditChargePanel creditChargePanel,JTextField jtChargeValue) {
		// TODO Auto-generated constructor stub
		this.jtChargeValue=jtChargeValue;
		this.creditChargePanel=creditChargePanel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(jtChargeValue.getText()==null||Integer.parseInt(jtChargeValue.getText())<=0){
			JOptionPane.showMessageDialog(creditChargePanel, "充值大于0的整数", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		creditChargePanel.charge(Integer.parseInt(jtChargeValue.getText()));
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		jbButton = (JButton)e.getSource();
		//鼠标在标签上时更换背景及字体色
		jbButton.setBackground(Color.WHITE);
		jbButton.setForeground(Color.BLACK);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		jbButton = (JButton)e.getSource(); 
		//鼠标离开标签时更换背景及字体色
		jbButton.setBackground(UIConstants.JLABEL);
		 jbButton.setForeground(Color.white);
	}

}
