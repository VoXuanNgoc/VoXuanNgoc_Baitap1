package xn_View;


import java.awt.*;
import javax.swing.*;
import xn_Controller.TextController;
import java.io.File;

public class TextView extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private JButton openButton;
    private JButton saveButton;
    private JButton removeEmptyLinesButton;
    private TextController controller;

    public TextView(TextController controller) {
        this.controller = controller;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Text Editor");
        setSize(600, 400);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        openButton = new JButton("Load");
        saveButton = new JButton("Save");
        removeEmptyLinesButton = new JButton("Remove Empty Lines");
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(removeEmptyLinesButton);
        add(buttonPanel, BorderLayout.NORTH);

        openButton.addActionListener(e -> controller.openButtonClicked());
        saveButton.addActionListener(e -> controller.saveButtonClicked());
        removeEmptyLinesButton.addActionListener(e -> controller.removeEmptyLines());
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public File showOpenDialog() {
        if (fileChooser == null) {
            fileChooser = new JFileChooser();
        }
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public File showSaveDialog() {
        if (fileChooser == null) {
            fileChooser = new JFileChooser();
        }
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public void setController(TextController controller) {
        this.controller = controller;
    }
}
