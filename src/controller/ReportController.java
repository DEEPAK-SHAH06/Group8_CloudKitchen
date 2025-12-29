/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author deepakshah
 */

import dao.ReportDao;
import tablemodel.ReportTableModel;

public class ReportController {

    private final ReportDao dao = new ReportDao();
    private final ReportTableModel model;

    public ReportController(ReportTableModel model) {
        this.model = model;
    }

    public void loadReports() {
        model.setReports(dao.getReports());
    }
}
