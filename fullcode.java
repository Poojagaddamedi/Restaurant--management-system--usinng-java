import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Pers extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JLabel bg;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	
	Pers()
	{
		setSize(500,500);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon img=new ImageIcon("C:\\Users\\gadda\\OneDrive\\Desktop\\crop\\p11.jpg");
		
		l1=new JLabel("Enter name");
		
		l2=new JLabel("enter password");

		t1=new JTextField();
		
		t2=new JPasswordField();
		bg=new JLabel("",img,JLabel.CENTER);
		bg.setBounds(0,0,500,500);
		
		
		b1=new JButton("Login");
		b2=new JButton("Sign up");
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		l1.setBounds(30,100,100,100);
		l2.setBounds(30,150,100,100);
		t1.setBounds(150,130,120,50);
		t2.setBounds(150,180,120,50);
		b2.setBounds(180,240,120,50);
		b1.setBounds(50,240,120,50);
		
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		add(l1);
		add(l2);
		add(bg);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		System.out.println("helloo butiion");
		//new SignUpFrame();
		//new Login();
		try{
		Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser","root","Root");
		Statement st=conn.createStatement();
		String name=t1.getText();
		Integer rollno=Integer.parseInt(t2.getText());
		ResultSet rs=st.executeQuery("select * from student where name='"+name+"' AND rollno='"+rollno+"'" );
		if(rs.next()){
			System.out.println("success");
			setVisible(false);
			new Login();
			//new Menu();
		}
		else{
			System.out.println("fail");
			JDialog re=new JDialog();
			re.setSize(new Dimension(100,100));
			//re.setLocationRelativeTo(JFrame);
			re.add(new JLabel("incoreect details"));
			re.setModal(true);
			re.setVisible(true);
			
		}
		
		//st.executeUpdate("insert into student values('pooj',200)");
		conn.close();
		}
			
		catch(SQLException e){
			System.out.println(e);
		}
		
		
	
		}
	

public static void main(String[] args)
{
	new Pers ();
}
}

class SignUpFrame extends JFrame implements ActionListener{
	JLabel l11,l22,l3,l4;
	JTextField t1,t2,t3;
     	JButton b1;
	
	SignUpFrame(){
		setSize(500,500);
		setLayout(null);
		l11=new JLabel("CREATE YOUR ACCOUNT ");
		l22=new JLabel("enter your email");
		l3=new JLabel("YOUR PASSWORD");
		l4=new JLabel("Create password");
		t1=new JTextField(25);
		t2=new JTextField(15);
		t3=new JTextField(15);
		b1=new JButton("submit");
		b1.addActionListener(this);
		l11.setBounds(70,50,250,120);
		l22.setBounds(30,100,100,100);
		l3.setBounds(30,150,120,120);
		l4.setBounds(30,180,150,150);
		t1.setBounds(150,130,120,50);
		t2.setBounds(150,190,120,50);
		t3.setBounds(150,260,120,50);
		b1.setBounds(50,330,120,50);
		add(l11);
		add(l22);
		add(l3);
		add(l4);
		add(t1);
		add(t2);
		add(t3);
		add(b1);
		
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		try{
			Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser","root","Root");
		Statement st=conn.createStatement();
		String name=t1.getText();
		Integer rollno=Integer.parseInt(t2.getText());
		st.executeUpdate("insert into student values('"+name+"',"+rollno+")");
		//st.executeUpdate("insert into student values('pooj',200)");
		conn.close();
			
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
	}
	
	
}
class Login extends JFrame implements ActionListener
{
	JLabel lb,lb2;
	JButton bt;
	Login ()
	{
		setSize(500,500);
		setLayout(null);
		lb=new JLabel("WELCOME");
				lb2=new JLabel("ENJOY THE FOOD");
				bt=new JButton("MENU");
				bt.setBounds(300,100,100,50);
				add(bt);
				bt.addActionListener(this);
         lb.setBounds(130,150,200,200);
		 lb2.setBounds(150,200,200,200);
		 add(lb);
		 add(lb2);
		
		setVisible(true);
	}
public void actionPerformed(ActionEvent ae)
	{
		new Menu();
		

	}
	class Menu extends JFrame
	{
		JLabel lbb;
		JRadioButton rb1,rb2;
		Menu()
		{
	   setSize(500,500);
		setLayout(null);
		lbb=new JLabel("WELCOME");
		rb1=new JRadioButton("order");
		rb2=new JRadioButton("payment");
		rb1.setBounds(30,50,100,50);
		rb2.setBounds(50,60,100,100);
		add(rb1);
		add(rb2);
		
		add(lbb);
		setVisible(true);
		
		}
	
	}
}
	

	
