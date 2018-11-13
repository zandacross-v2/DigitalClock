/**
 *
 * @author 6ix
 */
public class stopwatch extends javax.swing.JFrame implements Runnable
{
    Thread t;
    int flag=1;
    int count=1;
    int hour=0,min=0,sec=0,miliSec=0;
    String timeDisp="88:88:88",miliSecDisp="888";
    /**
     * Creates new form stopwatch
     */
    public stopwatch() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setVisible(true);
        t=new Thread(this);
        reset();
    }
    
    public void reset()
    {
        hour=0;min=0;sec=0;miliSec=0;
        timeDisp="88:88:88";miliSecDisp="888";
        display();
    }
    
    public void display()
    {
        timeShow.setText(timeDisp);
        miliSecondShow.setText(miliSecDisp);
    }

    public void setTimeCounter()
    {
        timeDisp="";
        if(hour<10)
            timeDisp=timeDisp+"0"+Integer.toString(hour);
        else
            timeDisp=timeDisp+Integer.toString(hour);
        if(min<10)
            timeDisp=timeDisp+":0"+Integer.toString(min);
        else
            timeDisp=timeDisp+":"+Integer.toString(min);
        if(sec<10)
            timeDisp=timeDisp+":0"+Integer.toString(sec);
        else
            timeDisp=timeDisp+":"+Integer.toString(sec);
    }
    
    public void setMiliSecCounter()
    {
        miliSecDisp="";
        if(miliSec<10)
            miliSecDisp="00"+Integer.toString(miliSec);
        else if(miliSec<100)
            miliSecDisp="0"+Integer.toString(miliSec);
        else
            miliSecDisp=Integer.toString(miliSec);
    }
    
    public void run()
    {
        try{
            while(true)
            {
                miliSec++;
                if(miliSec>999)
                {
                    sec++;
                    miliSec=0;
                }
                if(sec>59)
                {
                    min++;
                    sec=0;
                }
                if(min>59)
                {
                    hour++;
                    min=0;
                }
                if(hour>99)
                    reset();
                setTimeCounter();
                setMiliSecCounter();
                display();
                t.sleep(1);
            }
        }
        catch(Exception ex)
        {
        }
    }
    
    public void printTimeList()
    {
        String temp=Integer.toString(count)+". "+timeShow.getText();
        timeList.append(temp+"\n");
        count++;
        //System.out.println(temp);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeShow = new javax.swing.JLabel();
        miliSecondShow = new javax.swing.JLabel();
        startStop = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        timeList = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        timeShow.setFont(new java.awt.Font("DigifaceWide", 3, 30)); // NOI18N
        timeShow.setText("88:88:88");

        miliSecondShow.setFont(new java.awt.Font("DigifaceWide", 3, 24)); // NOI18N
        miliSecondShow.setForeground(new java.awt.Color(0, 102, 102));
        miliSecondShow.setText("888");

        startStop.setText("START");
        startStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startStopActionPerformed(evt);
            }
        });

        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        timeList.setEditable(false);
        timeList.setColumns(20);
        timeList.setRows(5);
        jScrollPane1.setViewportView(timeList);

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 24)); // NOI18N
        jLabel1.setText(" STOPWATCH");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(timeShow, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(miliSecondShow, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startStop, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(64, 64, 64))))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeShow, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miliSecondShow, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startStop)
                    .addComponent(reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startStopActionPerformed
        // TODO add your handling code here:
        if(startStop.getText().equals("START"))
        {
            startStop.setText("STOP");
            if(flag==1){
                t.start();
                flag=0;
            }
            else
                t.resume();
        }
        else
        {
            startStop.setText("START");
            t.suspend();
            printTimeList();
        }
    }//GEN-LAST:event_startStopActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        reset();
        t.suspend();
        startStop.setText("START");
        timeList.setText("");
    }//GEN-LAST:event_resetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(stopwatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stopwatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stopwatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stopwatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stopwatch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel miliSecondShow;
    private javax.swing.JButton reset;
    private javax.swing.JButton startStop;
    private javax.swing.JTextArea timeList;
    private javax.swing.JLabel timeShow;
    // End of variables declaration//GEN-END:variables
}
