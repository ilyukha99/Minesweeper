package gui;

import exceptions.NoResourceInitException;
import score.ScoreItem;
import score.ScoreManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Collections;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Collectors;

public class HighScoresFrame extends JFrame {

    private JPanel contentPane;
    private JTable scoreTable;

    public HighScoresFrame() {
        $$$setupUI$$$();
        setSize(300, 300);
        setVisible(true);
        setContentPane(contentPane);
    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        contentPane = new JPanel();
        contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("High Scores");
        contentPane.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        contentPane.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        scrollPane1.setViewportView(scoreTable);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

    private void createUIComponents() {
        try {
            TreeSet<ScoreItem> tableData = new ScoreManager().getScoreTable();
            Vector<Vector<String>> data = tableData.stream().map(item -> {
                Vector<String> res = new Vector<>();
                Collections.addAll(res, item.getName(),
                        ScoreItem.noteDateFormatter.format(item.getNoteTime()),
                        ScoreItem.timeFormatter.format(item.getTime()));
                return res;
            }).collect(Collectors.toCollection(Vector::new));
            Vector<String> header = new Vector<>();
            Collections.addAll(header, "Name", "Note date", "Result");
            scoreTable = new JTable(data, header);
        } catch (IOException | NoResourceInitException e) {
            scoreTable = new JTable();
        }
    }

}
