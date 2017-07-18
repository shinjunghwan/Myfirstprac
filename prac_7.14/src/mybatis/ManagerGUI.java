package mybatis;

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.domain.MemberDTO;


public class ManagerGUI {
	Frame frame;
	Panel[] panel;
	Label lbTitle, lbName, lbHeight, lbWeight, lbSex, lbAge, lbLogin, lbDialog;
	TextField tfName, tfHeight, tfAge, tfWeight, tfLogin;
	Button btnSave, btnDelete, btnUpdate, btnReset, btnSearch, btnLogin, btnDialog;
	List list;
	Checkbox cbMale, cbFemale;
	CheckboxGroup cbGroup;
	
	public ManagerGUI() {
		frame = new Frame("회원 관리");
		panel = new Panel[12];
		for( int i = 0; i < panel.length ; i++)
		{
			panel[i] = new Panel();
		}
		lbTitle = new Label("회원 관리", Label.CENTER);
		Font font = new Font("dialog" , Font.BOLD, 20);
		lbTitle.setFont(font);
		lbTitle.setForeground(new Color(123,54,32));
		lbName = new Label("이 름");
		lbHeight = new Label("키 ");
		lbSex = new Label("성 별");
		lbAge = new Label("연 령");
		lbWeight = new Label("체 중");
		lbLogin = new Label("데이터 베이스 서버 주소 ");
		lbDialog = new Label(" ");
		tfName = new TextField("");
		tfHeight = new TextField("");
		tfAge = new TextField("");
		tfWeight = new TextField("");
		tfLogin = new TextField("");
		btnSave = new Button("저장");
		btnSearch = new Button("검색");
		btnDelete  = new Button("삭제");
		btnReset = new Button("지우기");
		btnUpdate = new Button("수정");
		btnLogin = new Button("OK");
		btnDialog = new Button("OK");

		list = new List(7,false);
		cbGroup = new CheckboxGroup();
		cbMale = new Checkbox("Male",cbGroup,false);
		cbFemale = new Checkbox("FeMale",cbGroup,false);
	
		
		frame.addWindowListener( new WindowAdapter () {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}

	    });	
	
	
	

	btnSave.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String name = tfName.getText();
			String age = tfAge.getText();
			String weight = tfWeight.getText();
			String height = tfHeight.getText();
			String sex = "여";
			if(cbMale.getState()) {
				sex = "남";
			}
			MemberDAO dao = new MemberDAO();
			dao.insert(name,age,height,weight,sex);
			displayAll();
		}

	});
	
	btnReset.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tfName.setText("");
			tfAge.setText("");
			tfHeight.setText("");
			tfWeight.setText("");
		}
	});
	
	list.addItemListener(new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			String str = list.getSelectedItem();
			StringTokenizer st = new StringTokenizer(str);
			tfName.setText(st.nextToken());
			tfAge.setText(st.nextToken());
			tfWeight.setText(st.nextToken());
			tfHeight.setText(st.nextToken());
			String sex = st.nextToken();
			if(sex.equals("여")) {
				cbFemale.setState(true);
			} else {
				cbMale.setState(true);
			}
		}
	});
	
	btnDelete.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String name = tfName.getText();
			MemberDAO dao = new MemberDAO();
			dao.delete(name);
			displayAll();
		}
		
	});
	
	btnUpdate.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = tfName.getText();
			String age = tfAge.getText();
			String height = tfHeight.getText();
			String weight = tfWeight.getText();
			String sex = "남";
			if(cbFemale.getState()) {
				sex = "여";
			}
			MemberDAO dao = new MemberDAO();
			dao.update(name, age, height, weight, sex);
			displayAll();
		}
	});
	
	btnSearch.addActionListener(new ActionListener() {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = tfName.getText();
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = null;
			try {
				dto = dao.search(name);
			} catch (RecordNotFoundException ee) {
				final Dialog dialog = new Dialog(frame, "경고");
					dialog.setLayout(new FlowLayout());
				dialog.setSize(200,80);
				dialog.setTitle(ee.getMessage());
				Button btnok = new Button("확 인");
				btnok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						dialog.dispose();
					}
					
				});
				dialog.add(btnok);
				dialog.show();
				return;
			}
			tfName.setText(dto.getName());
			dto.setHighlight(dto.getName());
			tfAge.setText(Integer.toString(dto.getAge()));
			tfHeight.setText(Integer.toString(dto.getHeight()));
			tfWeight.setText(Integer.toString(dto.getWeight()));
			String sex = Character.toString(dto.getSex());
			if(sex.equals("여")) {
				cbFemale.setState(true);
			} else {
				cbMale.setState(true);
			}
			//
			displayAll();
		}
	});
	}
	public static void main(String args[]) {
		ManagerGUI mem = new ManagerGUI();
		mem.launchFrame();
	}

	private void launchFrame() {
		// TODO Auto-generated method stub
		panel[1].setLayout( new GridLayout(2,1));
		panel[1].add(lbName);
		panel[1].add(lbHeight);
		panel[2].setLayout( new GridLayout(2,1));
		panel[2].add(tfName);
		panel[2].add(tfHeight);
		panel[3].setLayout( new BorderLayout());
		panel[3].add(panel[1], "West");
		panel[3].add(panel[2], "Center");
		panel[3].add( new Label(" "), "East");
		panel[4].setLayout( new GridLayout(2,1));
		panel[4].add(lbAge);
		panel[4].add(lbWeight);
		panel[5].setLayout( new GridLayout(2,1));
		panel[5].add(tfAge);
		panel[5].add(tfWeight);
		panel[6].setLayout( new BorderLayout());
		panel[6].add(panel[4],"West");
		panel[6].add(panel[5],"Center");
		panel[7].setLayout( new GridLayout(1,2));
		panel[7].add(panel[3]);
		panel[7].add(panel[6]);
		panel[8].add(lbSex);
		panel[8].add(cbMale);
		panel[8].add(cbFemale);
		panel[9].setLayout( new BorderLayout());
		panel[9].add(lbTitle, "North");
		panel[9].add(panel[7], "Center");
		panel[9].add(panel[8], "South");
		panel[10].setLayout( new GridLayout(1,5));
		panel[10].setBackground(Color.black);
		panel[10].setForeground(Color.white);
		panel[10].add( new Label("이 름     "));
		panel[10].add( new Label("나 이     "));
		panel[10].add( new Label("체 중     "));
		panel[10].add( new Label(" 키       "));
		panel[10].add( new Label("성 별     "));
		panel[11].setLayout( new BorderLayout());
		panel[11].add(panel[10], "North");
		panel[11].add(list , "Center");
		panel[0].add(btnSave);
		panel[0].add( new Label(" "));
		panel[0].add(btnSearch);
		panel[0].add( new Label(" "));
		panel[0].add(btnDelete);
		panel[0].add( new Label(" "));
		panel[0].add(btnUpdate);
		panel[0].add( new Label(" "));
		panel[0].add(btnReset);

		frame.add(panel[9], "North");
		frame.add(panel[11], "Center");
		frame.add(panel[0], "South");
	//	frame.setSize(400,300);
	    frame.pack();

		frame.setResizable(false);// 크기 조절 불가
		frame.setLocation( ((frame.getToolkit().getScreenSize()).width  -  frame.getWidth()) /2 ,
							 ((frame.getToolkit().getScreenSize()).height -  frame.getHeight())/ 2); 
		frame.setVisible(true);

	  //리스트보기 호출
		displayAll();
	}

	private void displayAll() {
		// TODO Auto-generated method stub
		list.removeAll();
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> allData = (ArrayList<MemberDTO>) dao.select();
		for(MemberDTO dto : allData) {
			String name = dto.getName();
			int age = dto.getAge();
			int height = dto.getHeight();
			int weight = dto.getWeight();
			char sex = dto.getSex();
			//System.out.println(dto.isHighlight());
			if(name.equals(dto.getHighlight())) {
				list.add(name + "<-     " +age+"                  "+weight+"                  "+height+"              "+sex);
				
			} else {
				list.add(name + "         " +age+"                  "+weight+"                  "+height+"              "+sex);
			}
		}
	}
}

