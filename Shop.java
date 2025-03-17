import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Shop extends JPanel {
    private double constPrice;
    private double multPrice;
    private JButton increaseConst;
    private JButton increaseMult;
    
    public Shop() {
        setLayout(new GridLayout(2,1));
        
        constPrice = 100;
        multPrice = 100;
        increaseConst = new JButton("const+ (cost:100)");
        increaseConst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(MainFrame.getMeows());
                System.out.println(constPrice);
                if (MainFrame.getMeows() >= (constPrice)) {
                    MainFrame.setMeows(MainFrame.getMeows() - (constPrice));
                    MainFrame.setClickConstant(MainFrame.getClickConstant() + 1);
                    constPrice += (constPrice * 0.1);
                    increaseConst.setText("const+ (cost:" + (int) constPrice + ")");
                }
            }
        });
        increaseMult = new JButton("mult+ (cost:100)");
        increaseMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainFrame.getMeows() >= (multPrice))
                    MainFrame.setMeows(MainFrame.getMeows() - (multPrice));
                    MainFrame.setClickMultiplier(MainFrame.getClickMultiplier() + 0.1);
                    multPrice += (multPrice * 0.1);
                    increaseMult.setText("mult+ (mult:" + (int) (multPrice) + ")");
            }
        });
        add(increaseConst);
        add(increaseMult);
    }

    public double getConstantPrice() {
        return constPrice;
    }

    public double getMultiplierPrice() {
        return multPrice;
    }
}