package model.view;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

import model.Reuniones;

public class TableRenderBilerak extends JTextArea implements TableCellRenderer {
    private ArrayList<Reuniones> bilerakList;

    public TableRenderBilerak(ArrayList<Reuniones> bilerakList) {
        this.bilerakList = bilerakList;
        setLineWrap(true);
        setWrapStyleWord(true);
        setBorder(null); // Optionally remove border around JTextArea
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
    	
        // Ensure JTextArea text is updated
        String text = value != null ? value.toString() : "";
        setText(text);

        // Apply selection and focus styles
        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        } else {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }

        // Ensure the text is updated for multi-line support
        setCaretPosition(0); // Reset caret position
        return this;
    }
}
