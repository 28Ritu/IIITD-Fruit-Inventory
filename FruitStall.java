//Name: Ritu Kumari Roll No.: 2016078
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;
public class FruitStall extends JFrame
{
	static Toolkit kit = Toolkit.getDefaultToolkit();
	static Dimension screenSize = kit.getScreenSize();
	static int screenWidth = screenSize.width;
	static int screenHeight = screenSize.height;
	//JPanel p;
	public static void main(String []args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				FruitStall frame=new FruitStall();
				frame.setTitle("Welcome To IIITD Fruit Stall");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	public FruitStall()
	{
		setSize(screenWidth/2, screenHeight/2);
		setLocationByPlatform(true);
		add(new Panel());
	    pack();
	}
	public Dimension getPreferredSize() 
	{ 
		return new Dimension(screenWidth, screenHeight); 
	}
}
class Panel extends JPanel 
{
	private int ap1=8, ap2=0;
	private int man1=3, man2=0;
	private int or1=8, or2=0;
	private int pi1=1, pi2=0;
	private int ba1=2, ba2=0;
	
	private JLabel apple, apple2;
	private JLabel mango, mango2;
	private JLabel orange, orange2;
	private JLabel pine, pine2;
	private JLabel banana, banana2;
	private JLabel total1, total3;

	private JTextField apple1, apple3;
	private JTextField mango1, mango3;
	private JTextField orange1, orange3;
	private JTextField pine1, pine3;
	private JTextField banana1, banana3;
	private JTextField total2, total4;
	
	int Total3=0;
	int Total1=compute(ap1, man1, or1, pi1, ba1);
	public void paintComponent(Graphics g)
	{
		Font f=new Font("Abyssinica SIL", Font.BOLD, 40);
		int x=450, y=48;
		g.setFont(f);
		g.drawString("IIITD Fruit Stall", x, y);
		
		Image image = new ImageIcon("/home/ritu/logo.gif").getImage();
		g.drawImage(image, 350, 15, 70, 37, null);
		
		Font f1=new Font("Century Schoolbook L", Font.ROMAN_BASELINE, 35);
		g.setFont(f1);
		g.drawString("Inventory", 240, 100);
		g.drawString("User", 930, 100);
		
		Font f2=new Font("Century Schoolbook L", Font.ROMAN_BASELINE, 32);
		g.setFont(f2);
		g.drawString("Name", 100, 150);
		g.drawString("Quantity", 430, 150);
		g.drawString("Name", 750, 150);
		g.drawString("Quantity", 1050, 150);
	}
	public Panel()
	{
		setLayout(new GridBagLayout());
		//Font font=new Font("Century Schoolbook L", Font.BOLD, 32);
		apple = new JLabel("Apple");
		//apple.setFont(font);
        mango = new JLabel("Mango");
        //mango.setFont(font);
        orange = new JLabel("Orange");
        pine = new JLabel("Pineapple");
        banana = new JLabel("Banana");
        total1 = new JLabel("Total");
        
        apple2 = new JLabel("Apple");
        mango2 = new JLabel("Mango");
        orange2 = new JLabel("Orange");
        pine2 = new JLabel("Pineapple");
        banana2 = new JLabel("Banana");
        total3 = new JLabel("Total");
        
        apple1=new JTextField(Integer.toString(ap1), 10);
        mango1=new JTextField(Integer.toString(man1));
        orange1=new JTextField(Integer.toString(or1));
        pine1=new JTextField(Integer.toString(pi1));
        banana1=new JTextField(Integer.toString(ba1));
        total2=new JTextField(Integer.toString(Total1));
        
        apple3=new JTextField(Integer.toString(ap2), 10);
        mango3=new JTextField(Integer.toString(man2));
        orange3=new JTextField(Integer.toString(or2));
        pine3=new JTextField(Integer.toString(pi2));
        banana3=new JTextField(Integer.toString(ba2));
        total4=new JTextField(Integer.toString(Total3));
        
        JPanel labelPane = new JPanel(new GridLayout(0, 1));
        labelPane.add(apple);
        labelPane.add(mango);
        labelPane.add(orange);
        labelPane.add(pine);
        labelPane.add(banana);
        labelPane.add(total1);
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        add(labelPane, c);
        
        JPanel fieldPane = new JPanel(new GridLayout(0, 1));
        fieldPane.add(apple1);
        fieldPane.add(mango1);
        fieldPane.add(orange1);
        fieldPane.add(pine1);
        fieldPane.add(banana1);
        fieldPane.add(total2);
        
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.5;
        c.gridx = 1;
        add(fieldPane, c);
        
        JPanel labelPane1 = new JPanel(new GridLayout(0, 1));
        labelPane1.add(apple2);
        labelPane1.add(mango2);
        labelPane1.add(orange2);
        labelPane1.add(pine2);
        labelPane1.add(banana2);
        labelPane1.add(total3);
        
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.5;
        c.gridx = 2;
        add(labelPane1, c);
        
        JPanel fieldPane1 = new JPanel(new GridLayout(0, 1));
        fieldPane1.add(apple3);
        fieldPane1.add(mango3);
        fieldPane1.add(orange3);
        fieldPane1.add(pine3);
        fieldPane1.add(banana3);
        Total3=computeUser(Integer.parseInt(apple1.getText()), Integer.parseInt(mango1.getText()),
        		Integer.parseInt(orange1.getText()), Integer.parseInt(pine1.getText()), 
        		Integer.parseInt(banana1.getText()), Integer.parseInt(apple3.getText()), Integer.parseInt(mango3.getText()),
        		Integer.parseInt(orange3.getText()), Integer.parseInt(pine3.getText()), 
        		Integer.parseInt(banana3.getText()));
        total4.setText(Integer.toString(Total3));
        fieldPane1.add(total4); 
        
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.5;
        c.gridx = 3;
        add(fieldPane1, c);
        
        final JButton button = new JButton("Submit");
        button.setEnabled(true);
        button.addActionListener(new ActionListener() 
        {
           public void actionPerformed(ActionEvent e) 
           {    
        	   if (((Integer.parseInt(apple1.getText())-Integer.parseInt(apple3.getText()))<0) || 
        			   ((Integer.parseInt(mango1.getText())-Integer.parseInt(mango3.getText()))<0) ||
        		   ((Integer.parseInt(orange1.getText())-Integer.parseInt(orange3.getText()))<0) ||
        		   ((Integer.parseInt(pine1.getText())-Integer.parseInt(pine3.getText()))<0) ||
        		   ((Integer.parseInt(banana1.getText())-Integer.parseInt(banana3.getText()))<0))
        	   {
        		   Total3=computeUser(Integer.parseInt(apple1.getText()), Integer.parseInt(mango1.getText()),
        	        		Integer.parseInt(orange1.getText()), Integer.parseInt(pine1.getText()), 
        	        		Integer.parseInt(banana1.getText()), Integer.parseInt(apple3.getText()), Integer.parseInt(mango3.getText()),
        	        		Integer.parseInt(orange3.getText()), Integer.parseInt(pine3.getText()), 
        	        		Integer.parseInt(banana3.getText()));
        		   total4.setText(Integer.toString(Total3));
        		   button.setEnabled(false);
        	   }
        	   else
        	   {
        		   Total3=computeUser(Integer.parseInt(apple1.getText()), Integer.parseInt(mango1.getText()),
        		Integer.parseInt(orange1.getText()), Integer.parseInt(pine1.getText()), 
        		Integer.parseInt(banana1.getText()), Integer.parseInt(apple3.getText()), Integer.parseInt(mango3.getText()),
        		Integer.parseInt(orange3.getText()), Integer.parseInt(pine3.getText()), 
        		Integer.parseInt(banana3.getText()));
        		   button.setEnabled(true);
        		   total4.setText(Integer.toString(Total3));
        		   apple1.setText(Integer.toString(Integer.parseInt(apple1.getText())-Integer.parseInt(apple3.getText())));
        		   mango1.setText(Integer.toString(Integer.parseInt(mango1.getText())-Integer.parseInt(mango3.getText())));
        		   orange1.setText(Integer.toString(Integer.parseInt(orange1.getText())-Integer.parseInt(orange3.getText())));
        		   pine1.setText(Integer.toString(Integer.parseInt(pine1.getText())-Integer.parseInt(pine3.getText())));
        		   orange1.setText(Integer.toString(Integer.parseInt(banana1.getText())-Integer.parseInt(banana3.getText())));
        		   total2.setText(Integer.toString(Total1-Total3));
        		   apple3.setText("0");
        		   mango3.setText("0");
        		   orange3.setText("0");
        		   pine3.setText("0");
        		   banana3.setText("0");
        		   //total4.setText("0");
        	   }
           }
        });
        fieldPane1.add(button);
	}
	public int compute(int ap, int man, int or, int pi, int ba)
	{
		return ap+man+or+pi+ba;
	}
	public int computeUser(int ap, int man, int or, int pi, int ba, int ap1, int man1, int or1, int pi1, int ba1)
	{
		int tot=ap1+man1+or1+pi1+ba1;
		boolean[] b=new boolean[5];
	    b[0]=((ap-ap1)>=0);
	    b[1]=((man-man1)>=0);
	    b[2]=((or-or1)>=0);
	    b[3]=((pi-pi1)>=0);
	    b[4]=((ba-ba1)>=0);
	    String s="";
	    for (int i=0; i<5; i++)
	    {
	    	if (b[i]==false)
	    		s+=i+1;
	    }
	    for (int j=0; j<s.length(); j++)
	    {
	    	int c=(int) s.charAt(j);
	    	switch (c)
	    	{
	    	case 1:tot=tot-ap1;
	    	break;
	    	case 2: tot-=man1;
	    	break;
	    	case 3: tot-=or1;
	    	break;
	    	case 4: tot-=pi1;
	    	break;
	    	case 5: tot-=ba1;
	    	break;
	    	default: return tot;
	    	}
	    }
	    return tot;
	}
}
