package com.dogiloki.multipleexecutive.adapters;

import com.dogiloki.multipleexecutive.app.ExecutiveService;
import com.dogiloki.multitaks.persistent.ExecutionObserver;
import javax.swing.JOptionPane;

/**
 *
 * @author _dogi
 */

public class ExecPanel extends javax.swing.JPanel{
    
    private ExecutiveService service;
    private ExecutionObserver observer;
    
    public ExecPanel(ExecutiveService service){
        initComponents();
        this.service=service;
        this.label_command.setText(this.service.executive.command);
        try{
            this.observer=this.service.exec();
            this.observer.start((text,line)->{
                this.text_command.setText(text+"\n"+this.text_command.getText());
            });
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_command = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_command = new javax.swing.JTextArea();

        label_command.setText("jLabel1");

        text_command.setColumns(20);
        text_command.setRows(5);
        jScrollPane1.setViewportView(text_command);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_command, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_command)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_command;
    private javax.swing.JTextArea text_command;
    // End of variables declaration//GEN-END:variables
}
