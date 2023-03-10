package gui.view;

import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class JoinForm extends JFrame{
	//아래의 객체들은 컨테이너로부터 주입받을 대상
	private JComponent t_id;
	private JComponent t_name;
	private JComponent t_email;
	private JComponent bt_regist;
	
	private LayoutManager layoutManager;
	
	public void setT_id(JComponent t_id) {
		this.t_id = t_id;
	}

	public void setT_name(JComponent t_name) {
		this.t_name = t_name;
	}

	public void setT_email(JComponent t_email) {
		this.t_email = t_email;
	}

	public void setBt_regist(JComponent bt_regist) {
		this.bt_regist = bt_regist;
	}

	public void setLayoutManager(LayoutManager layoutManager) {
		this.layoutManager = layoutManager;
	}

	public void create() {
		setLayout(layoutManager);
		
		add(t_id);
		add(t_name);
		add(t_email);
		add(bt_regist);
		
		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
