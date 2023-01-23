import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HtmlLP implements ActionListener {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea ta;
    private JTextField tf;
    private int WIDTH=800;
    private int HEIGHT=700;
    private JButton del,two;
    private JLabel firstLURL;
    private JLabel secondLURL;


    public HtmlLP() {
        prepareGUI();
    }

    public static void main(String[] args) {
        HtmlLP swingControlDemo = new HtmlLP();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("HTML Link Puller");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(10, 1));
        //two= new JButton("Two");

        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);

        JTextField firstURL = new JTextField();
        JTextField secondURL = new JTextField();


        //ta = new JTextArea();
        //ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
        mainFrame.add(mb);
        //mainFrame.add(ta);
        mainFrame.add(firstURL);
        mainFrame.add(secondURL);
        mainFrame.setJMenuBar(mb);

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel((new BorderLayout()));
        //controlPanel.add(firstLURL,BorderLayout.WEST);
        //controlPanel.add(secondLURL,BorderLayout.WEST);
        //controlPanel.add(firstURL,BorderLayout.CENTER);
        //controlPanel.add(secondURL,BorderLayout.CENTER);
        controlPanel.setLayout(new FlowLayout());

        // mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
       // JPanel holdme= new JPanel();
        //holdme.setLayout(new FlowLayout());
        //holdme.add(del);
        //holdme.add(two);
        //del.setActionCommand("test1");
        //two.setActionCommand("two");

        //del.addActionListener(new ButtonClickListener());
        //two.addActionListener(new ButtonClickListener());


        //mainFrame.add(holdme);
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {
        headerLabel.setText("Control in action: Button");

        JButton goButton = new JButton("Go");


        //JButton okButton = new JButton("OK");
        //JButton submitButton = new JButton("Submit");
        //JButton cancelButton = new JButton("Cancel");

       // okButton.setActionCommand("OK");
        //submitButton.setActionCommand("Submit");
       // cancelButton.setActionCommand("Cancel");
        goButton.setActionCommand("Go");

       // okButton.addActionListener(new ButtonClickListener());
       // submitButton.addActionListener(new ButtonClickListener());
       // cancelButton.addActionListener(new ButtonClickListener());
        goButton.addActionListener(new ButtonClickListener());

        //controlPanel.add(okButton);
       // controlPanel.add(submitButton);
       // controlPanel.add(cancelButton);
        controlPanel.add(goButton);

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
        if (e.getSource() == cut)
            ta.cut();
        if (e.getSource() == paste)
            ta.paste();
        if (e.getSource() == copy)
            ta.copy();
        if (e.getSource() == selectAll)
            ta.selectAll();

    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            System.out.println("*"+command);
            if (command.equals("test1")) {
                System.out.println("booom");
                ta.setText("booom");

            }
            if (command.equals("Go")){
                statusLabel.setText("Go Button clicked, finding results.");
            }

        }
    }
}


