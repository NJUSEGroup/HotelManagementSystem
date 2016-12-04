package hrs.client.UI.UserUI.HotelSearchUI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.HotelUI.Components.RoomTableModel;
import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.SearchListener;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.SearchTableListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.VO.UserVO;
import hrs.common.util.FilterCondition.FilterCondition;
import hrs.common.util.FilterCondition.NameFilterCondition;
import hrs.common.util.FilterCondition.RoomTypeFilterCondition;
import hrs.common.util.type.FilterType;

public class HotelSearchPanel extends CommonPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 666845916774725335L;
	private UserVO user;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private SearchPanel searchPanel;
	private IUserHotelController controller;
	private SearchResultTable table;
	private JButton orderJB;
	private JButton detailJB;

	public HotelSearchPanel(UserVO user) {
		this.user = user;
		controller = ControllerFactory.getUserHotelController();
		init();
	}

	@Override
	public void init() {
		setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBounds(0, 30, this.getWidth(), this.getHeight() - 30);
		contentPane.setBackground(UIConstants.jframe);
		contentPane.setLayout(null);

		add(contentPane);

		setdownButton();//立即下单和详细信息按钮
		setSearchPanel();
		setSearchButton();//搜索按钮
		setTable();
		
		// scrollPane = new JScrollPane(contentPane);
		// scrollPane.setBounds(0, 30, this.getWidth(),this.getHeight()-30);
		// scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		// add(scrollPane);

	}

	private void setdownButton() {

		detailJB = new JButton("详细信息");
		detailJB.setFont(UIConstants.jlabelChinese);
		detailJB.setBounds(this.getWidth() - 330, 620, 120, 40);
		contentPane.add(detailJB);
		
		orderJB = new JButton("立即下单");
		orderJB.setBounds(this.getWidth() - 180, 620, 120, 40);
		orderJB.setFont(UIConstants.jlabelChinese);
		contentPane.add(orderJB);
		
		
		
	}

	
	

	private void setTable() {
		// 默认空表
		table = new SearchResultTable();

		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setBounds(30, 350, 1020, 280);
//		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214),2));
		scrollPane.getViewport().setBackground(new Color(211, 237, 249));
		scrollPane.setOpaque(true);

		Map<HotelVO, List<RoomVO>> map = new HashMap<>();
		table.setModel(new SearchResultTableModel(map));
		table.addMouseListener(new SearchTableListener(this));

		contentPane.add(scrollPane);

	}

	private void setSearchPanel() {
		searchPanel = new SearchPanel(user);
		searchPanel.setBounds(30, 0, 1020, 283);
		contentPane.add(searchPanel);
	}

	private void setSearchButton() {
		JButton searchJB = new JButton("搜索");
		searchJB.setBounds(this.getWidth() - 160, 295, 100, 40);
		searchJB.setFont(UIConstants.jlabelChinese);
		contentPane.add(searchJB);
		searchJB.addActionListener(new SearchListener(this));
	}

	public void doSearch() {
		Map<HotelVO, List<RoomVO>> map = getSearchResult();
		Map<HotelVO, List<RoomVO>> newmap = null;
		System.out.println(map.size());
		List<FilterCondition> conditions = searchPanel.getFilters();//从搜索条件面板中得到所有筛选条件
		NameFilterCondition nameFilter = new NameFilterCondition(FilterType.Name);
		nameFilter.setHotelName("酒店");
		conditions.add(nameFilter);
		if(conditions!=null){
			newmap = controller.filterHotels(map,conditions);
		}
		System.out.println(newmap.size());
		table.setModel(new SearchResultTableModel(newmap));
	}

	

	private Map<HotelVO, List<RoomVO>> getSearchResult() {
		Map<HotelVO, List<RoomVO>> map = searchPanel.findHotels();
		return map;
	}

	public void setButtonStatus() {
		detailJB.setEnabled(true);
		orderJB.setEnabled(true);
		
	}

}
