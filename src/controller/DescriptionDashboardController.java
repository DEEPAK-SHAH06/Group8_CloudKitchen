/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.DescriptionDash;
import view.MainPage;

/**
 *
 * @author deepakshah
 */
public class DescriptionDashboardController {
    
    private DescriptionDash descriptionview;
    
    public DescriptionDashboardController(DescriptionDash descriptionview){
        this.descriptionview = descriptionview;
        descriptionview.backButtonListener(new AddBackButtonListener());
    }

    class AddBackButtonListener implements ActionListener {

        public AddBackButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MainPage mp = new MainPage();
            MainPageController controller = new MainPageController(mp);
            controller.open();
        }
    }
    
}
