package school.project.UI.Dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by forhack on 2016-06-05.
 */
public class FindDialog extends JDialog {
    public static final String OPTION_ALL = "모두";
    public static final String OPTION_DIRECTORY = "폴더";
    public static final String OPTION_FILE = "파일";
    public static final String OPTION_EXT = "확장자";
    public static final String OPTION_SIZE = "용량";
    JPanel centerPanel;
    JPanel leftPanel;
    JPanel rightPanel;
    JPanel inputTextPanel;
    JPanel optionPanel;
    JLabel inputTextLabel;
    JLabel optionLabel;
    JComboBox optionCombo;
    JTextField inputTextField;
    JButton searchButton;
    JButton cancelButton;

    String []options = {OPTION_ALL, OPTION_DIRECTORY,OPTION_FILE,OPTION_EXT,OPTION_SIZE};

    public FindDialog() {
        initComponent();
        settingComponent();
        listenerComponent();

        inputTextPanel.add(inputTextLabel);
        inputTextPanel.add(inputTextField);

        optionPanel.add(optionLabel);
        optionPanel.add(optionCombo);

        leftPanel.add(inputTextPanel, BorderLayout.NORTH);
        leftPanel.add(optionPanel, BorderLayout.SOUTH);

        rightPanel.add(searchButton, BorderLayout.NORTH);
        rightPanel.add(cancelButton, BorderLayout.SOUTH);

        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);

        add(centerPanel);
    }

    private void initComponent() {
        centerPanel = new JPanel();
        inputTextPanel = new JPanel();
        optionPanel = new JPanel();
        leftPanel = new JPanel(new BorderLayout());
        rightPanel = new JPanel(new BorderLayout());

        inputTextLabel = new JLabel("검색어");
        optionLabel= new JLabel("설정");
        optionCombo = new JComboBox(options);
        inputTextField = new JTextField(10);
        searchButton = new JButton("검색");
        cancelButton = new JButton("취소");
    }

    private void settingComponent() {
        setSize(300,125);
        setLocationRelativeTo(null);
        setTitle("검색");
    }

    public void addConfirmListener(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }

    public String getSearchWord() {
        return inputTextField.getText();
    }

    public String getOptionWord() {
        return optionCombo.getSelectedItem().toString();
    }

    private void listenerComponent() {
        cancelButton.addActionListener(disposeListener);
    }

    private ActionListener disposeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    };

}
