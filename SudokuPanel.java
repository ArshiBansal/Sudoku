import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuPanel extends JPanel {
    private final JTextField[][] cells = new JTextField[9][9];
    private final SudokuBoard board = new SudokuBoard();

    public SudokuPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel gridPanel = new JPanel(new GridLayout(9, 9));
        Font font = new Font("SansSerif", Font.BOLD, 18);

        // Build grid
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setFont(font);
                cell.setDocument(new JTextFieldLimit(1)); // Only 1 digit
                styleCellBorder(cell, row, col);

                int value = board.get(row, col);
                if (value != 0) {
                    cell.setText(String.valueOf(value));
                    cell.setEditable(false);
                    cell.setBackground(Color.LIGHT_GRAY);
                } else {
                    cell.setBackground(Color.WHITE);
                }

                cells[row][col] = cell;
                gridPanel.add(cell);
            }
        }

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton checkBtn = new JButton("Check");
        JButton resetBtn = new JButton("Reset");

        checkBtn.addActionListener(e -> checkBoard());
        resetBtn.addActionListener(e -> resetBoard());

        buttonPanel.add(checkBtn);
        buttonPanel.add(resetBtn);

        add(gridPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void styleCellBorder(JTextField cell, int row, int col) {
        int top = (row % 3 == 0) ? 3 : 1;
        int left = (col % 3 == 0) ? 3 : 1;
        int bottom = (row == 8) ? 3 : 1;
        int right = (col == 8) ? 3 : 1;
        cell.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));
    }

    private void checkBoard() {
        int[][] temp = new int[9][9];
        boolean hasError = false;

        try {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    String text = cells[row][col].getText().trim();
                    int val = text.isEmpty() ? 0 : Integer.parseInt(text);
                    temp[row][col] = val;
                }
            }

            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    int val = temp[row][col];
                    if (val != 0 && !SudokuValidator.isValid(temp, row, col, val)) {
                        cells[row][col].setBackground(new Color(255, 102, 102)); // red
                        hasError = true;
                    } else if (board.get(row, col) == 0) {
                        cells[row][col].setBackground(new Color(144, 238, 144)); // green
                    }
                }
            }

            if (!hasError) {
                JOptionPane.showMessageDialog(this, "Board is valid!");
            } else {
                JOptionPane.showMessageDialog(this, "Some entries are invalid!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Only numbers 1–9 allowed.");
        }
    }

    private void resetBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.get(row, col) == 0) {
                    cells[row][col].setText("");
                    cells[row][col].setBackground(Color.WHITE);
                } else {
                    cells[row][col].setBackground(Color.LIGHT_GRAY);
                }
            }
        }
    }

    // Restricts input to 1 digit
    static class JTextFieldLimit extends javax.swing.text.PlainDocument {
        private final int limit;

        JTextFieldLimit(int limit) {
            this.limit = limit;
        }

        public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
            if (str == null || getLength() >= limit || !str.matches("[1-9]")) {
                return;
            }
            super.insertString(offset, str, attr);
        }
    }
}
