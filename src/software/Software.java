package software;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;



public class Software {

    public static void main(String[] args) {

JFrame frame=new JFrame("Sorting Files");
 frame.setSize(500,500);
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setLayout(null);
frame.setResizable(false);

JLabel user=new JLabel("PATH:");
Font fonti = new Font("Comic Sans MS", Font.BOLD, 22);
user.setFont(fonti);
user.setSize(80,30);
user.setLocation(5,100);
frame.add(user);
JTextField txt=new JTextField(null,30);
Font font = new Font("Lucida Calligraphy", Font.BOLD, 22);
txt.setFont(font);
txt.setSize(150,30);
txt.setLocation(80,100);
frame.add(txt);

JButton sort= new JButton("SORT");
sort.setSize(80,50);
sort.setLocation(90,150);
frame.add(sort);
JButton clear= new JButton("Clear");
clear.setSize(80,50);
clear.setLocation(200,150);
frame.add(clear);
JButton exit= new JButton("Exit");
exit.setSize(80,50);
exit.setLocation(290,150);
frame.add(exit);


JButton browse= new JButton("BROSER");
browse.setSize(120,30);
browse.setLocation(250,100);
frame.add(browse);
exit.addActionListener((ActionEvent e) -> {
    System.exit(0);
});
clear.addActionListener((ActionEvent e) -> {
    txt.setText("");
});
browse.addActionListener((ActionEvent e) -> {
    JFileChooser open = new JFileChooser();
    
    open.showOpenDialog(open);
    //File file=open.getSelectedFile();
});
sort.addActionListener((ActionEvent e) -> {
    File f=new File(txt.getText());
    String s[]=f.list();
    for(String x:s)
    {
        File nf=new File(f+"/"+x);
        if(nf.isFile())
        {
            long l=nf.lastModified();
            Date d=new Date(l);
            String g=(d.getDate()+"-"+(d.getMonth()+1)+"-"+(d.getYear()+1900));
            File lf=new File("H:"+"/"+g);
            if(!lf.exists())
                lf.mkdir();
            {
                try{
                    File file = null;
                    boolean bool = false;
                    file = new File("H:"+"/"+g+"/"+x);
                    bool = file.createNewFile();
                    FileInputStream fi=new FileInputStream(nf);
                    FileOutputStream fo=new FileOutputStream(file,true);
                    int i=0;
                    while((i=fi.read())!=-1)
                    {fo.write(i);
                    }
                }
                catch(IOException a)
                {
                    System.out.println(" Exception caught"+a);
                }
            }
        }
    }
});
frame.setVisible(true);
}
}        
