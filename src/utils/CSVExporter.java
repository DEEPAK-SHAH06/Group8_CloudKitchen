/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author deepakshah
 */


import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVExporter {

    public static void exportTable(JTable table) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Report as CSV");
        fileChooser.setSelectedFile(new File("report.csv"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try (FileWriter csvWriter = new FileWriter(fileToSave)) {

                TableModel model = table.getModel();

                // ✅ Write column headers
                for (int col = 0; col < model.getColumnCount(); col++) {
                    csvWriter.write(model.getColumnName(col));
                    if (col < model.getColumnCount() - 1) {
                        csvWriter.write(",");
                    }
                }
                csvWriter.write("\n");

                // ✅ Write rows
                for (int row = 0; row < model.getRowCount(); row++) {
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        Object value = model.getValueAt(row, col);
                        csvWriter.write(value == null ? "" : value.toString());

                        if (col < model.getColumnCount() - 1) {
                            csvWriter.write(",");
                        }
                    }
                    csvWriter.write("\n");
                }

                JOptionPane.showMessageDialog(null,
                        "Report exported successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        "Error exporting CSV: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

