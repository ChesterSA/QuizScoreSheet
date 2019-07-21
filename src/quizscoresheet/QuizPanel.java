/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizscoresheet;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author s6089488
 */
public final class QuizPanel extends JPanel implements MouseListener
{
    private int teams;
    private JTextArea[][] textFields;

    public QuizPanel(int teams) {
        this.teams = (teams < 5) ? 5 : teams;

        setLayout(new GridLayout(this.teams + 1, 11));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(new MyLabel("Team Name"));
        for (int i = 1; i <= 8; i++) {
            add(new MyLabel("Round " + i));
        }

        add(new MyLabel("Picture Round"));

        MyLabel total = new MyLabel("Total");
        total.putClientProperty("index", "total");
        total.addMouseListener(this);

        add(total);

        addTextboxes();
    }

    private void addTextboxes()
    {
        textFields = new JTextArea[teams][11];
        for (int i = 0; i < teams; i++)
        {
            for (int j = 0; j < 11; j++)
            {
                JTextArea t = new JTextArea();
                
                t.setLineWrap(true);
                t.setWrapStyleWord(true);
                t.setFont(new Font("Helvetica",Font.PLAIN, 18));
                
                Border outline = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
                Border blank = BorderFactory.createEmptyBorder(20,20,20,20);
                t.setBorder(BorderFactory.createCompoundBorder(outline,blank));
                
                textFields[i][j] = t;
                add(textFields[i][j]);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        JLabel lbl = (JLabel) e.getSource();
        String index = (String) (lbl.getClientProperty("index"));
        if (SwingUtilities.isLeftMouseButton(e) && index.equals("total"))
        {
            countTotals();
        }
    }

    private void countTotals()
    {
        for (int i = 0; i < teams; i++)
        {
            int count = 0;
            for (int j = 1; j < 9; j++)
            {
                if (textFields[i][j].getText() != null)
                {
                    try
                    {
                        count += Integer.parseInt(textFields[i][j].getText().trim());
                    }
                    catch (NumberFormatException ignored)
                    {
                        
                    }
                }

            }
            textFields[i][10].setText(count + " ");
        }
    }
    @Override
    public void mousePressed(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

final class MyLabel extends JLabel
{

    MyLabel(String msg)
    {
        super(msg);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setFont(new Font("Helvetica",Font.PLAIN, 18));
        setOpaque(true);
        setHorizontalAlignment(JTextField.CENTER);
    }
}
