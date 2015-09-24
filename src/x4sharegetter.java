
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class x4sharegetter extends JFrame {
	private JButton btn;
	private JTextArea txtarea;
	private JTextField txt;
	private String link;
	BufferedReader br;
	private JLabel linkcheckcode;
	private FlowLayout layout;
	public static String STANDARDLIZE(String s){
		int i = 0;
		while(s.charAt(0)==' '){
			s=s.substring(1);
		}
		return s;
	}
	x4sharegetter() throws IOException{
		super(" TOOL POST LINK 4SHAREVN");
		
		//layout = new FlowLayout(FlowLayout.TRAILING);
		//setLayout(layout);
		Box box = Box.createVerticalBox();
		link ="";
		txtarea = new JTextArea(10,15);
		txt = new JTextField();
		txt.setAlignmentX(CENTER_ALIGNMENT);
		
		box.add(txt);
		//add(txt);
		btn = new JButton("GENERATE");
	    box.add(btn);
		//add(btn);
	    btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				link = txt.getText();
				if(!link.contains("4share.vn")){
					JOptionPane.showMessageDialog(null,"Phải nhập link FOLDER 4share.vn");
					return;
				}
				URL url;
				try {
					url = new URL(link);
					URLConnection conn = url.openConnection();
					 br  = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"URL Không hợp lệ hoặc có vấn đề khi kết nối với LINK, vui lòng thử lại");
				}			
				String inputLine;
				String x ="";
				try {
					while((inputLine=br.readLine())!=null){
						if(inputLine.contains("style="+"'"+"margin-top: 10px;margin-left: 20px; " +
								"border: 1px solid #ccc; padding: 8px; display: none"+"'"+">")){		
							 x = inputLine.replace("style="+"'"+"margin-top: 10px;margin-left:" +
							 		"20px; border: 1px solid #ccc; padding: 8px; display: none"+"'"+">","");
							 break;
						}	
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String parts[] = x.replace("</div>        </div>","").split("  <br/>");
				String[] result =new String[parts.length];
				String aaa="";
				parts[0] = STANDARDLIZE(parts[0].replace("               style='margin-top: 10px;margin-left: 20px; border: 1px solid #ccc; padding: 8px; display: none'> ", ""));
				for(int i=1;i<=parts.length-1;i++){
					aaa +="<p style=\"text-align: center;\"><a href=\""+parts[i-1]+"\"target=\"_blank\">" +
							"<strong><span style=\"font-size: 20px;\">PART"+i+"</span></strong></a></p>"+"\n";					
				}
				txtarea.setText(aaa);				//br.close();		
			} 	
	    });
	   box.add(new JScrollPane(txtarea));
	   //add(new JScrollPane(txtarea));
	   linkcheckcode = new JLabel("http://www.onlinehtmleditor.net/");
	   box.add(linkcheckcode);
	   add(box);
	   
	}
	public static void main(String[] args) throws IOException{
		x4sharegetter demo = new x4sharegetter();
		demo.setDefaultCloseOperation(EXIT_ON_CLOSE);
		demo.setVisible(true);
		demo.setSize(200, 425);
		 
	
	}
}
