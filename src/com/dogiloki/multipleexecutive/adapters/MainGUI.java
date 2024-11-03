package com.dogiloki.multipleexecutive.adapters;

import com.dogiloki.multipleexecutive.app.ExecutiveService;
import com.dogiloki.multipleexecutive.domains.Executive;
import com.dogiloki.multitaks.database.record.RecordList;
import com.dogiloki.multitaks.directory.HashFields;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author _dogi
 */

public class MainGUI extends javax.swing.JFrame{
    
    private HashFields<Integer,Executive> executives=new HashFields<>();
    
    public MainGUI(){
        initComponents();
        this.loadExecutives();
    }
    
    public void loadExecutives(){
        try{
            RecordList<Executive> executives=new Executive().all();
            Executive executive;
            DefaultListModel model_executive=new DefaultListModel();
            int index=0;
            this.tabbed_executives.removeAll();
            while((executive=executives.next())!=null){
                model_executive.add(index,executive.name);
                this.executives.put(index,executive);
                index++;
            }
            this.list_executives.setModel(model_executive);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void loadExec(Executive executive){
        if(executive==null){
            return;
        }
        for(int index=0; index<this.tabbed_executives.getTabCount(); index++){
            if(this.tabbed_executives.getTitleAt(index).equals(executive.name)){
                return;
            }
        }
        this.tabbed_executives.addTab(executive.name,new ExecPanel(new ExecutiveService(executive)));
    }
    
    public void save(){
        try{
            if(this.box_name.getText().trim().equals("")){
                return;
            }
            Executive executive=new Executive();
            executive.name=this.box_name.getText();
            executive.command=this.box_command.getText();
            executive.context=this.box_context.getText();
            executive.save();
            this.loadExecutives();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete(Executive executive){
        if(executive==null){
            JOptionPane.showMessageDialog(null,"Error","Seleccionar un Ejecutable",JOptionPane.ERROR_MESSAGE);
        }else{
            executive.delete();
            for(int index=0; index<this.tabbed_executives.getTabCount(); index++){
                if(this.tabbed_executives.getTitleAt(index).equals(executive.name)){
                    this.tabbed_executives.remove(index);
                }
            }
            this.loadExecutives();
        }
    }
    
    public void selectedExecutives(){
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbed_executives = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        box_name = new javax.swing.JTextField();
        box_command = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_executives = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        box_context = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Comando:");

        btn_save.setText("Agregar");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        list_executives.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                list_executivesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(list_executives);

        jLabel3.setText("Contexto:");

        box_context.setText("/");

        btn_delete.setText("Eliminar");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box_name, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(btn_delete))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box_command, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_save))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(box_context, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addGap(82, 82, 82))
                            .addComponent(tabbed_executives))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(box_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(box_command, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_save))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(box_context, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbed_executives)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        this.save();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void list_executivesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_executivesMouseReleased
        Executive executive=this.executives.get(this.list_executives.getSelectedIndex());
        this.loadExec(executive);
    }//GEN-LAST:event_list_executivesMouseReleased

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        Executive executive=this.executives.get(this.list_executives.getSelectedIndex());
        this.delete(executive);
    }//GEN-LAST:event_btn_deleteActionPerformed

    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField box_command;
    private javax.swing.JTextField box_context;
    private javax.swing.JTextField box_name;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list_executives;
    private javax.swing.JTabbedPane tabbed_executives;
    // End of variables declaration//GEN-END:variables
}
