import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class SaveLoad {
    private static ArrayList<String> encodedValues;
    private static JOptionPane popuDialog;
        public static void save() {
            /*in following order:
    
    
            */
    
            encodedValues = new ArrayList<String>();
            
            JTextArea area = new JTextArea(
            encode(MainFrame.getMeows()) + "\n" +
            encode(MainFrame.getClickConstant()) + "\n" +
            encode(MainFrame.getClickMultiplier()) + "\n" +
            encode(Main.getConstPrice()) + "\n" +
            encode(Main.getMultPrice()));

            popuDialog.showMessageDialog(Main.f, area, "Copy this into a text file!", 1);
    }

    public static void load() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

    public static String encode(double d) {
        String eString = "$";
        String doubleString = "" + d;
        
        for (int i = 0; i < doubleString.length(); i++) {
            switch (doubleString.charAt(i)) {
                case '1':
                    eString += "a";
                    break;
                case '2':
                    eString += "b";
                    break;
                case '3':
                    eString += "c";
                    break;
                case '4':
                    eString += "d";
                    break;
                case '5':
                    eString += "e";
                    break;
                case '6':
                    eString += "f";
                    break;
                case '7':
                    eString += "g";
                    break;
                case '8':
                    eString += "h";
                    break;
                case '9':
                    eString += "i";
                    break;
                case '0':
                    eString += "j";
                    break;
                case '.':
                    eString += "#";
                    break;
            }
        }
        System.out.println(eString);
        return eString;
    }
    
}
