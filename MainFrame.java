import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private static double meows;
    private static int clickConstant;
    private static double multiplier;

    //public JDialog popuDialog;

    private JMenuBar menuBar;
        private JMenu file;
            private JMenuItem save;
            private JMenuItem load;

    private JPanel leftPanel;
        private JButton kitty;
    private JPanel midPanel;
        private static JLabel meowCount;
            private Shop rightPanel;
    
    public MainFrame() {
        setName("Kitty Clicker");
        setTitle("Kitty Clicker");
        setSize(new Dimension(600,200));
        setLayout(new GridLayout(1,3));
        
        meows = 0;
        clickConstant = 1;
        multiplier = 1;

        //popuDialog = new JDialog(this);

        menuBar = new JMenuBar();
            file = new JMenu("File");
                save = new JMenuItem("Save");
                save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SaveLoad.save();
                    }
                });

                load = new JMenuItem("Load");
                load.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SaveLoad.load();
                    }
                });
            file.add(save);
            file.add(load);
        menuBar.add(file);
        setJMenuBar(menuBar);

        leftPanel = new JPanel();
            leftPanel.setLayout(new GridLayout());
            
            kitty = new JButton("Kitty!");
            kitty.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    click();
                }
            });
            leftPanel.add(kitty);
        midPanel = new JPanel();
            midPanel.setLayout(new BorderLayout());
            meowCount = new JLabel("Meows: " + meows);
            midPanel.add(meowCount, BorderLayout.PAGE_START);
        rightPanel = new Shop();
            
        
        add(leftPanel);
        add(midPanel);
        add(rightPanel);
        
        setVisible(true);
    }
    
    public void click() {
        meows = meows + (clickConstant * multiplier);
        meowCount.setText("Meows: " + meows);
    }

    public static double getMeows() {
        return meows;
    }

    public static void setMeows(double d) {
        meows = d;
        meowCount.setText("Meows: " + (int) meows);
    }

    public void refresh() {
        repaint();
    }

    public static int getClickConstant() {
        return clickConstant;
    }

    public static void setClickConstant(int i) {
       clickConstant = i;
    }

    public static double getClickMultiplier() {
        return multiplier;
    }

    public static void setClickMultiplier(double i) {
        multiplier = i;
    }

    public double getConstPrice() {
        return rightPanel.getConstantPrice();
    }

    public double getMultPrice() {
        return rightPanel.getMultiplierPrice();
    }
}