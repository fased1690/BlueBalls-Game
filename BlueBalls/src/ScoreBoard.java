/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

/**
 *
 * @author Fabio
 */
public class ScoreBoard extends javax.swing.JFrame {

    /**
     * Creates new form ScoreBoard
     */
    int scores[] = new int[6];  //stores all the scores
    Main main; //for main menu button
    

    public ScoreBoard() {
        initComponents();
        
    }

    public ScoreBoard(int score) {
        initComponents();

        scores[5] = score; //stores the score you got ingame in the last element
        score(); //gets all the scores from the file
    }

    public void score() {

        try {
            FileReader fr = new FileReader("src\\scores.txt"); //gets the file
            BufferedReader br = new BufferedReader(fr); 
            for (int i = 0; i < 5; i++) { //reads in the 5 scores saved in there
                scores[i] = Integer.parseInt(br.readLine());
            }
            br.close();//closes the file
        } catch (IOException e) {
            System.out.println(e);
        }
        sortScores(); //sorts the score
    }

    public void scoreOutPut() { //outputs the scores
        String chart = "";  //creats a chart for the scores
        for(int i = 0; i < 5; i++){ //stores the scores in the chart
            chart += i+1 +":\t" + scores[i] + "\n"; //
        }
        txtScores.setText(chart); //outputs the scores
        
    }
    public void scoreWrite(){ //score writer to data file
        String write = ""; //this stores all the scores
        
        try{
            FileWriter fw = new FileWriter("src\\scores.txt"); //opens the file
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < 5; i++){ //loops though and adds each score to the chart
                write += Integer.toString(scores[i]) + "\n";
                
            } 
            bw.write(write); //writes to the data file
            bw.close(); //closes file
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public void sortScores(){ //sorts the scores
        for (int i = 0; i < scores.length - 1; i++){ //loops through all the scores
        
            int index = i; //gets the index of the schools
            for (int j = i + 1; j < scores.length; j++) //loops though scores
                if (scores[j] > scores[index]) //if a score is higher then the other swtiches positions
                    index = j;
      
            int smallerNumber = scores[index]; 
            scores[index] = scores[i];
            scores[i] = smallerNumber; //sets number to position
        }
        scoreWrite();  //writes to the data file
        scoreOutPut(); //outputs the scores
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        LBLHighscore = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtScores = new javax.swing.JTextArea();
        btnCreds = new javax.swing.JButton();
        btnMain1 = new javax.swing.JButton();
        btnScore = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        Panel.setBackground(new java.awt.Color(0, 0, 0));

        LBLHighscore.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LBLHighscore.setForeground(new java.awt.Color(0, 0, 255));
        LBLHighscore.setText("HighScores:");

        txtScores.setEditable(false);
        txtScores.setColumns(20);
        txtScores.setRows(5);
        jScrollPane1.setViewportView(txtScores);

        btnCreds.setBackground(new java.awt.Color(0, 0, 0));
        btnCreds.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCreds.setForeground(new java.awt.Color(0, 0, 255));
        btnCreds.setText("Credits");
        btnCreds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCredsActionPerformed(evt);
            }
        });

        btnMain1.setBackground(new java.awt.Color(0, 0, 0));
        btnMain1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMain1.setForeground(new java.awt.Color(0, 0, 255));
        btnMain1.setText("Main");
        btnMain1.setMaximumSize(new java.awt.Dimension(69, 23));
        btnMain1.setMinimumSize(new java.awt.Dimension(69, 23));
        btnMain1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMain1ActionPerformed(evt);
            }
        });

        btnScore.setBackground(new java.awt.Color(0, 0, 0));
        btnScore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnScore.setForeground(new java.awt.Color(0, 0, 255));
        btnScore.setText("ScoreBoard");
        btnScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(LBLHighscore)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(btnCreds, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(btnScore, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(btnMain1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBLHighscore)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMain1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(btnScore, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addGap(16, 16, 16))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(btnCreds, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCredsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCredsActionPerformed
        LBLHighscore.setText("Credits:"); //if the credits button is clicked displays credits
        String chart = "Lead Programmer: Fabio Sedki\n\nTechnical Writer: Jackie Lam\n\nNot Very Assistant Programmer: Dane";
        txtScores.setText(chart); //outputs the credits
    }//GEN-LAST:event_btnCredsActionPerformed

    private void btnMain1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMain1ActionPerformed
        main = new Main(); //if the main menu button is clicked opens the main menu
        main.setVisible(true);
        this.setVisible(false); //closes this window
    }//GEN-LAST:event_btnMain1ActionPerformed

    private void btnScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoreActionPerformed
        LBLHighscore.setText("HighScores: "); //if the score board is clikced changes title and outputs scoreboard
        scoreOutPut();
    }//GEN-LAST:event_btnScoreActionPerformed

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
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLHighscore;
    private javax.swing.JPanel Panel;
    private javax.swing.JButton btnCreds;
    private javax.swing.JButton btnMain1;
    private javax.swing.JButton btnScore;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtScores;
    // End of variables declaration//GEN-END:variables
}
