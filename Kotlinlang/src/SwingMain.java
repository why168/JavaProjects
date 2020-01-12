import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Edwin.Wu edwin.wu05@gmail.com
 * @version 2019-02-09 14:08
 * @since JDK1.8
 */
class SwingMain {

    public static void main(String[] args) {
        JPanel.getDefaultLocale();

        JScrollPane.getDefaultLocale();

        JLabel.getDefaultLocale();

        Button aButton = new Button();
        aButton.addActionListener(new MyActionListener());

        JFrame jFrame = new JFrame("jFrame标题");
        jFrame.setBounds(500, 500, 500, 500);
        jFrame.setSize(500, 500);
        Point location = jFrame.getLocation();
        int x = location.x;
        int y = location.y;
        System.out.println("x = " + x + ", y = " + y);

        JButton jButton = new JButton("按钮");
        jButton.setSize(100, 100);
        jButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited");
            }
        });

//        jFrame.getContentPane().add(jButton, BorderLayout.CENTER);
        jFrame.add(jButton, BorderLayout.CENTER);


        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jButton,BorderLayout.CENTER);



        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            System.out.println("Hello There");
        }
    }
}
