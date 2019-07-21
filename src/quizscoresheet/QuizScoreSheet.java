/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizscoresheet;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JFrame;

/**
 *
 * @author s6089488
 */
public class QuizScoreSheet
{

    private static JFrame myFrame;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int teams = getTeams();
        
        myFrame = new JFrame("Quiz Score Sheet"); 
        myFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        QuizPanel qPanel = new QuizPanel(teams);
        myFrame.add(qPanel);
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setResizable(true);
        myFrame.setVisible(true);
    }

    private static int getTeams()
    {
        JDialog dialog = new JDialog(new JFrame(), "Teams", true);
        dialog.setLayout(new FlowLayout());
        
        JLabel lblTeam = new JLabel("How many teams are there?");
        JTextField txtTeam = new JTextField("", 10);
        
        txtTeam.setSize(100, 20);
        
        JButton okay = new JButton("Okay");
        okay.addActionListener((ActionEvent e) ->
        {
            int t;
            try
            {
                t = Integer.parseInt(txtTeam.getText());
                if (t < 1)
                {
                    throw new NumberFormatException("");
                }
            }
            catch (NumberFormatException err)
            {
                JOptionPane.showMessageDialog(new JFrame(),"Teams must be a number","Input Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            dialog.dispose();
        });
        
        
        dialog.add(lblTeam);
        dialog.add(txtTeam);
        dialog.add(okay);
        
        dialog.setSize(260, 90);
        dialog.setVisible(true);
        
        int t = 0;
        try
        {
            t = Integer.parseInt(txtTeam.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(new JFrame(),"Teams must be a number","Input Error",JOptionPane.ERROR_MESSAGE);
        }
        return t;
    }

}
