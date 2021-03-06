package com.chinasofti.etc.hiq.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.chinasofti.etc.hiq.po.User;

public class MyInformation extends JFrame {
	private static final long serialVersionUID = -266077703729622905L;
	private int x = 0;
	private int y = 0;
	private int width = 461;
	private int height = 671;
	private Container cp;
	private ImageIcon bgImage,headImage,imag,centerImage;
	private JLabel bg,headPortrait,name,userId,separtot,sex,age,address,cL;
	private JButton change,edit;
	private JLabel nickName,person,note,homeLand,add,phoneNumber,email,username,school,person2,note2,homeLand2,phoneNumber2,email2,username2,school2;
	private JTextField inNickName,inPerson,inName,inHomeland,inPhone,inEmail,inSchool,inNote;
	private JLabel userSex,userAge,userBirthday;
	private JTextField inAge,inBirthday;
	private User userMy;
	private JToggleButton jbtClose;
	/**
	 * 构造函数，获取并显示个人资料
	 * @param arg0
	 * @param userMy
	 * @throws HeadlessException
	 */
	public MyInformation(String arg0, User userMy) throws HeadlessException {
		super(arg0);
		this.userMy = userMy;
		init();
	}

	public void init(){
		// 设置窗口关闭方式
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//居中显示
		this.setLocationRelativeTo(this);
		
		//取消最大化最小化的设置
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		//背景
		this.bgImage = new ImageIcon("images/main.jpg");
		this.bg = new JLabel(this.bgImage);
		getLayeredPane().add(this.bg,new Integer(Integer.MIN_VALUE));
		this.bg.setBounds(0, 0, this.bgImage.getIconWidth(), 265);
		((JPanel)getContentPane()).setOpaque(false);
		this.cp = getContentPane();
		this.cp.setLayout(null);
		// 关闭按钮
		jbtClose = new JToggleButton();
		jbtClose.setRolloverIcon(new ImageIcon("images/close_over.png"));// 设置获取焦点图片
		jbtClose.setRolloverSelectedIcon(new ImageIcon("images/close_over.png"));// 设置鼠标点击图片
		jbtClose.setIcon(new ImageIcon("images/close.png"));// 设置按钮正常显示的图片
		jbtClose.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				do_jbtClose_itemStateChanged(e);
			}
		});
		jbtClose.setContentAreaFilled(false);
		jbtClose.setBorderPainted(false);
		jbtClose.setFocusPainted(false);
		cp.add(jbtClose);
		jbtClose.setBounds(width - 35, 0, 35, 20);
		//头像
		this.headImage = new ImageIcon("images/" + userMy.getUserImage());
		this.headPortrait = new JLabel(this.headImage);	
		this.cp.add(this.headPortrait);
		this.headPortrait.setBounds(10, 93, 77, 77);
		//更换头像按钮
		change = new JButton("更换头像");
		Font font1 = new Font("宋体",0,12);
		change.setFont(font1);
		this.change.setBounds(10, 175, 80, 25);
		this.cp.add(change);
		//获取并显示数据库的信息
		name =new JLabel(userMy.getUserNikName());
		Font font = new Font("宋体",0,24);
		name.setForeground(Color.white);
		this.name.setFont(font);
		this.cp.add(this.name);
		this.name.setBounds(100, 93, 200, 30);
		
		userId = new JLabel(userMy.getUserQQ() + "");
		this.userId.setBounds(180, 105, 100, 20);
		cp.add(userId);
		userId.setForeground(Color.white);
		
		sex = new JLabel(userMy.getUserSex() > 0 ? "男" : "女");
		this.sex.setBounds(110, 150, 16, 15);
		cp.add(sex);
		sex.setForeground(Color.white);
		
		age = new JLabel(userMy.getUserAge() +  "岁");
		this.age.setBounds(130, 150, 40, 15);
		this.cp.add(age);
		age.setForeground(Color.white);
		
		address = new JLabel(userMy.getUserAddress());
		this.address.setBounds(110, 175, 200, 15);
		this.cp.add(address);
		address.setForeground(Color.white);
		//分割线
		imag = new ImageIcon("images/spry.png");
		separtot = new JLabel(imag);
		this.cp.add(separtot);
		this.separtot.setBounds(0, 200, 461, 4);
		//两个选项卡，详细资料和资料编辑	
		final JTabbedPane tablePane = new JTabbedPane(JTabbedPane.TOP);
		tablePane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				int selectedIndex = tablePane.getSelectedIndex();
				tablePane.getTitleAt(selectedIndex);	
			}
		});
		tablePane.setBounds(0, 205, width, 390);
		this.cp.add(tablePane);
		final JPanel tabPane1 = new JPanel();
		tabPane1.setLayout(null);
		tablePane.addTab("   详细资料   ", tabPane1);
		tabPane1.setLayout(null);
		tabPane1.setSize(461, 400);
		
		//底部的背景图片
		centerImage = new ImageIcon("images/main.jpg");
		this.cL = new JLabel(centerImage);
		getLayeredPane().add(this.cL, new Integer(Integer.MIN_VALUE));
		this.cL.setBounds(0,600, this.centerImage.getIconWidth(), this.centerImage.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false);
		this.cp = getContentPane();
		
		//详细资料
		person = new JLabel("个人说明：	" + userMy.getUserSpeak());
		this.person.setBounds(15, 10, 400, 20);

		tabPane1.add(person);
		note = new JLabel("个        人：  男  25岁  冬月十四（农历生日）  属龙  摩羯座   O型血");
		this.note.setBounds(15, 50, 400, 20);
	
		tabPane1.add(note);
		
		homeLand = new JLabel("故        乡：	" + userMy.getUserAddress());
		this.homeLand.setBounds(15, 90, 400, 20);
		
		tabPane1.add(homeLand);		
		
		add = new JLabel("所  在  地： 中国   天津   滨海新区");
		this.add.setBounds(15, 130, 400, 20);
		
		tabPane1.add(add);
		phoneNumber = new JLabel("手        机： 18766968888");
		this.phoneNumber.setBounds(15, 170, 400, 20);
		tabPane1.add(phoneNumber);
		
		email = new JLabel("邮        箱： " + userMy.getUserEmail());
		this.email.setBounds(15, 210, 400, 20);
		tabPane1.add(email);
		
		username = new JLabel("姓        名：	" + userMy.getUserNikName());
		this.username.setBounds(15, 250, 400, 20);
		tabPane1.add(username);
		
		school = new JLabel("学        校： 山东理工大学");
		this.school.setBounds(15, 290, 400, 20);
		tabPane1.add(school);
		//编辑资料界面
		final JPanel twoPane = new JPanel();
		twoPane.setLayout(null);
		tablePane.addTab("   编辑资料   ", twoPane);
		// 输入个性签名
		person2 = new JLabel("个性签名：");
		this.person2.setBounds(15, 10, 100, 20);
		twoPane.add(person2);
		inPerson =new JTextField();
		inPerson.setBounds(15, 30, 300, 50);
		twoPane.add(inPerson);
		// 输入个人说明
		note2 = new JLabel("个人说明：");
		this.note2.setBounds(15, 80, 100, 20);	
		twoPane.add(note2);
		inNote = new JTextField();
		inNote.setBounds(15, 100, 300,50);
		twoPane.add(inNote);
		// 输入昵称
		nickName = new JLabel("昵        称：");
		this.nickName.setBounds(15, 160, 100, 20);
		twoPane.add(nickName);
		inNickName = new JTextField();
		this.inNickName.setBounds(80, 160, 100, 25);
		twoPane.add(inNickName);	
		// 输入姓名
		username2 = new JLabel("姓        名：");
		this.username2.setBounds(200,160, 100, 20);
		twoPane.add(username2);
		inName = new JTextField();
		inName.setBounds(265, 160, 100, 25);
		twoPane.add(inName);
		// 选择性别
		userSex = new JLabel("性        别：");
		userSex.setBounds(15, 190, 100, 20);
		twoPane.add(userSex);
		JPanel jpstatus = new JPanel();
		jpstatus.add(new JLabel());
		JComboBox statusComboBox = new JComboBox();
		statusComboBox.addItem("男                  ");
		statusComboBox.addItem("女                  ");
		jpstatus.add(statusComboBox);
		jpstatus.setBounds(72, 180, 105, 28);
		twoPane.add(jpstatus);
		// 输入年龄
		userAge = new JLabel("年        龄：");
		userAge.setBounds(200, 190, 100, 20);
		twoPane.add(userAge);
		inAge = new JTextField();
		inAge.setBounds(265,190, 100, 25);
		twoPane.add(inAge);
		// 输入生日
		userBirthday = new JLabel("生       日：");
		userBirthday.setBounds(15, 220, 100, 20);
		twoPane.add(userBirthday);
		inBirthday = new JTextField();
		inBirthday.setBounds(80, 220, 100, 25);
		twoPane.add(inBirthday);
		// 输入学校
		school2 = new JLabel("学        校：");
		this.school2.setBounds(200, 220, 100, 20);
		twoPane.add(school2);
		inSchool = new JTextField();
		inSchool.setBounds(265, 220, 100, 25);
		twoPane.add(inSchool);
		// 输入故乡
		homeLand2 = new JLabel("故        乡：");
		this.homeLand2.setBounds(15, 250, 100, 20);
		twoPane.add(homeLand2);	
		inHomeland = new JTextField();
		inHomeland.setBounds(80, 250, 200, 25);
		twoPane.add(inHomeland);
		// 输入手机
		phoneNumber2 = new JLabel("手        机：");
		this.phoneNumber2.setBounds(15, 280, 100, 20);
		twoPane.add(phoneNumber2);
		inPhone = new JTextField();
		inPhone.setBounds(80, 280, 200, 25);
		twoPane.add(inPhone);
		// 输入邮箱
		email2 = new JLabel("邮        箱：");
		this.email2.setBounds(15, 310, 100, 20);
		twoPane.add(email2);
		inEmail = new JTextField();
		inEmail.setBounds(80, 310, 200, 25);
		twoPane.add(inEmail);
		// 保存按钮
		edit = new JButton("保存修改");
		edit.setBounds(280,320, 100, 30);
		twoPane.add(edit);
		edit.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "修改成功", "消息", JOptionPane.OK_OPTION);
			}
		});
		// 注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。
		//((JPanel) this.cp).setOpaque(false);
		// 获取当前屏幕的大小
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		x = (d.width - width) / 2;
		y = (d.height - height) / 2;
		// 设置登陆窗口的位置和大小
		setBounds(x, y, width, height);
		
		// 显示窗口
		setVisible(true);
	}

	protected void do_jbtClose_itemStateChanged(MouseEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}
}
