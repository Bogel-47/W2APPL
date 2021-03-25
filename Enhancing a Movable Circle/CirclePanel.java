/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studikasus4;

// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CirclePanel extends JPanel
{
private final int CIRCLE_SIZE = 50;
private int x,y;
private Color c;
JButton left;
JButton right;
JButton up;
JButton down;
//---------------------------------------------------------------
// Set up circle and buttons to move it.
//---------------------------------------------------------------
public CirclePanel(int width, int height)
{
// Set coordinates so circle starts in middle
x = (width/2)-(CIRCLE_SIZE/2);
y = (height/2)-(CIRCLE_SIZE/2);
c = Color.green;
// Need a border layout to get the buttons on the bottom
this.setLayout(new BorderLayout());
// Create buttons to move the circle
left = new JButton("Left");
right = new JButton("Right");
up = new JButton("Up");
down = new JButton("Down");
left.setToolTipText("To Left 20 coordinat");
right.setToolTipText("To Right 20 coordinat");
up.setToolTipText("To Up 20 coordinat");
down.setToolTipText("To Down 20 coordinat");
//left.setEnable(x < 0);
// Add listeners to the buttons
left.addActionListener(new MoveListener(-20,0));
right.addActionListener(new MoveListener(20,0));
up.addActionListener(new MoveListener(0,-20));
down.addActionListener(new MoveListener(0,20));
left.setMnemonic('l');
right.setMnemonic('r');
up.setMnemonic('u');
down.setMnemonic('d');

// Need a panel to put the buttons on or they'll be on
// top of each other.
JPanel buttonPanel = new JPanel();
buttonPanel.add(left);
buttonPanel.add(right);
buttonPanel.add(up);
buttonPanel.add(down);
// Add the button panel to the bottom of the main panel
this.add(buttonPanel, "South");
}
//---------------------------------------------------------------
// Draw circle on CirclePanel
//---------------------------------------------------------------
public void paintComponent(Graphics page)
{
    super.paintComponent(page);
page.setColor(c);
page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
}
//---------------------------------------------------------------
// Class to listen for button clicks that move circle.
//---------------------------------------------------------------
private class MoveListener implements ActionListener
{
private int dx;
private int dy;

//---------------------------------------------------------------
// Parameters tell how to move circle at click.
//---------------------------------------------------------------
public MoveListener(int dx, int dy)
{
    
this.dx = dx;

this.dy = dy;

}
//---------------------------------------------------------------
// Change x and y coordinates and repaint.
//---------------------------------------------------------------
public void actionPerformed(ActionEvent e)
{
x += dx;

y += dy;
left.setEnabled(x>0);
right.setEnabled(x<330);
up.setEnabled(y>0);
down.setEnabled(y<130);

repaint();
}
}
}   