import javax.swing.*;
import java.awt.*;


public class StartUp
{
	public StartUp()
	{
		JFrame f = new JFrame("Start Up");
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(450,300);
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
	
		JLabel label = new JLabel();
        label.setBounds(0, 30, 450, 270);

		ImageIcon bg = new ImageIcon("start3.png");
        Image bgIMG = bg.getImage();
        Image bgIMGScale = bgIMG.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon bgScaled = new ImageIcon(bgIMGScale);
        label.setIcon(bgScaled);
        f.setContentPane(label);
		
		
		
		JProgressBar pb = new JProgressBar();
		f.add(pb);
		pb.setBounds(20,225,395,5);
		pb.setForeground(new Color(1,89,88));
		pb.setBackground(new Color(250,250,250));
		pb.setFont(new Font("serif",Font.BOLD,16));
		pb.setMinimum(0);
		pb.setMaximum(100);
		pb.setStringPainted(false);

		



		



		for (int i = 0; i <= 800; i++)
			{
				final int presentValue = i;
				try
					{
						SwingUtilities.invokeLater(new Runnable()
							{
								public void run()
									{
										pb.setValue(presentValue);
									}
							});
							java.lang.Thread.sleep(10);
					}
					catch (InterruptedException e)
						{
							JOptionPane.showMessageDialog(f, e.getMessage());
						}
						if(presentValue==100)
						{
							f.setVisible(false);
							new loginLanguage();
						}
			}
	}
}