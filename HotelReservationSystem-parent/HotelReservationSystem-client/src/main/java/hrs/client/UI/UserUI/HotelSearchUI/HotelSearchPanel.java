package hrs.client.UI.UserUI.HotelSearchUI;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.HotelUI.Components.RoomTableModel;
import hrs.client.UI.UserUI.CommonComponents.CommonPanel;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.SearchListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.VO.UserVO;

public class HotelSearchPanel extends CommonPanel {
	private UserVO user;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private SearchPanel searchPanel;
	private IUserHotelController controller;
	private SearchResultTable table;

	public HotelSearchPanel(UserVO user) {
		this.user = user;
		controller = ControllerFactory.getUserHotelController();
		Init();
	}

	@Override
	public void Init() {
		contentPane = new JPanel();
		contentPane.setBounds(0, 30, this.getWidth(), this.getHeight() - 30);
		contentPane.setBackground(UIConstants.jframe);
		contentPane.setLayout(null);

		add(contentPane);

		setSearchPanel();
		setButton();
		setTable();

		// scrollPane = new JScrollPane(contentPane);
		// scrollPane.setBounds(0, 30, this.getWidth(),this.getHeight()-30);
		// scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		// add(scrollPane);

	}

	private void setTable() {
		// 默认空表
		table = new SearchResultTable();

		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setBounds(30, 350, 1020, 380);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(new Color(211, 237, 249));
		scrollPane.setOpaque(true);

		Map<HotelVO, List<RoomVO>> map = new HashMap<>();
		table.setModel(new SearchResultTableModel(map));

		contentPane.add(scrollPane);

	}

	private void setSearchPanel() {
		searchPanel = new SearchPanel(user);
		searchPanel.setBounds(30, 0, 1020, 283);
		contentPane.add(searchPanel);
	}

	private void setButton() {
		JButton searchJB = new JButton("搜索");
		searchJB.setBounds(this.getWidth() - 160, 295, 100, 40);
		searchJB.setFont(UIConstants.jlabelChinese);
		contentPane.add(searchJB);
		searchJB.addActionListener(new SearchListener(this));
	}

	public void doSearch() {
		Map<HotelVO, List<RoomVO>> map = getSearchResult();

	}

	private Map<HotelVO, List<RoomVO>> getSearchResult() {
		Map<HotelVO, List<RoomVO>> map = searchPanel.findHotels();
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			HotelVO key = (HotelVO) entry.getKey();
			System.out.println(key.name);
		}
		return map;
	}

	private void setModel(SearchResultTableModel model) {
		table.setModel(model);
	}
}
