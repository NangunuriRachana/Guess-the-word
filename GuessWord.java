//Create a frame window with 2 labels and 2 text fields. The first textfield should choose a word from an array list of words that are scrambled. The user should be prompted to enter the correct word and check the spelling by clicking the guess button. If the word is correct then a third label should print correct else it should print wrong. The user can click on another button called New word and the next word will be exhibited in the First textfield again.

/*
Guess the word : ________ (a random scrambled word from array list is selected and displayed here)
Enter the correct word : ________ (user should enter his answer here) 
|guess button| (this is pressed to check the spelling is correct or wrong)
{Result} (this label is displayed as correct, if true else displayed as wrong)
|new word button| (this is pressed to get another random scrambled word from array list and display that in Guess the word's text field)
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
class GuessWord extends Frame implements ActionListener{
 Label l1,l2,l3;
 TextField t1,t2;
 Button b1,b2;
 Random r=new Random();
 int n=10;
 ArrayList<String> a=new ArrayList<String>(n);
 ArrayList<String> q=new ArrayList<String>(n);
 static int i;
 public GuessWord(){

  a.add("elhol");
  a.add("wlomece");
  a.add("vaja");
  a.add("rpgrmoa");
  a.add("hkatn");
  a.add("mnidayc");
  a.add("rewdon");
  a.add("aftc");
  a.add("olev");
  a.add("twier");

  q.add("hello");
  q.add("welcome");
  q.add("java");
  q.add("program");
  q.add("thank");
  q.add("dynamic");
  q.add("wonder");
  q.add("fact");
  q.add("love");
  q.add("write");

  setLayout(new FlowLayout());

  l1=new Label("Guess the word : ");
  add(l1);
  t1=new TextField(20);
  add(t1);
  i=r.nextInt(n);
  t1.setText(a.get(i));
  l2=new Label("Enter the correct word : ");
  add(l2);
  t2=new TextField(30);
  add(t2);
  b1=new Button("Guess?");
  add(b1);
  b2=new Button("New Word!");
  add(b2);
  b2.addActionListener(this);
  l3=new Label("");
  add(l3);

  b1.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent e){
     String s=t2.getText();
     l3.setFont(new Font("Times New Roman",Font.BOLD|Font.ITALIC,50));
     l3.setBackground(new Color(45,255,165));
     l3.setForeground(Color.magenta);
     l3.setBounds(100,100,300,100);
     if(s.equals(q.get(i)))
      l3.setText("Correct!");
     else
      l3.setText("Wrong!");
   }
  });

  addWindowListener(new WindowAdapter(){
   public void windowClosing(WindowEvent e){
    dispose();
    System.exit(0);
   }
  });
 }

 public void actionPerformed(ActionEvent e){
  i=r.nextInt(n);
  t1.setText(a.get(i));
  t2.setText("");
  l3.setText("");
 }

 public static void main(String[] args){
  GuessWord g=new GuessWord();
  g.setTitle("Guess the word!");
  g.setVisible(true);
  g.setSize(900,250);
 }
}