/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bngweny.View.Gui;

import javax.swing.JOptionPane;
import za.co.bngweny.Controller.Factory;
import za.co.bngweny.Controller.GameController;
import za.co.bngweny.Model.Artifact;
import za.co.bngweny.Model.Game;
import za.co.bngweny.Model.Hero;
import za.co.bngweny.Model.Villain;
import za.co.bngweny.Model.utils;

/**
 *
 * @author cnngwenya
 */
public class GUIView extends javax.swing.JFrame {

    private Hero myhero;
    private int level;
    Game game;

    /**
     * Creates new form GUIView
     */
    public GUIView() {
        initComponents();
    }

    public GUIView(Hero myhero) {
        this.myhero = myhero;
        this.level = myhero.getLevel();
        initComponents();
        populate(myhero);
        startGame();
    }

    public void startGame() {
        game = new Game(level);
        Factory.generateVillains(game.getMap(), level);
        populateField();        
        populate(myhero);
    }

    private void populateField() {
        Villain[][] temp = game.getMap();
        String field = "";
        this.txaField.setText("");
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (i == myhero.getX() && j == myhero.getY()) {
                    this.txaField.append(String.format("%-5s", "0"));
                } else if (temp[i][j] != null) {
                    this.txaField.append(String.format("%-5s", "X"));
                } else {
                    this.txaField.append(String.format("%-5s", "-"));
                }
            }
            this.txaField.append("\n");
        }
  //      this.txaField.setText(field);
    }

    private void nextLevel(Hero myHero) {
        this.level += 1;
        myHero.setup(this.level);
        startGame();
    }

    public void move(int key) {
        int out = game.move(myhero, key);
        if (out == 2) {
            JOptionPane.showMessageDialog(null, "Congratulations! On to level " + (this.level + 1));
            nextLevel(myhero);
        } else if (out == 1) {
            JOptionPane.showMessageDialog(null, "YOU have encountered the mighty Villain.\n" + game.getVillain(myhero.getX(), myhero.getY()));
            //        System.out.println();
            //       System.out.println();
            //      System.out.println("Do you want to 'fight' or do you want to 'run'?");

            String output = JOptionPane.showInputDialog("Do you want to 'fight' or do you want to 'run'?");
            int result = game.flightORfight(myhero, output);
            switch (result) {
                case 1:
                    //    System.out.println("You lost! You failed to evade the enemy");
                    //  System.out.println("Press ENTER key to continue");
                    //sc.nextLine();
                    JOptionPane.showMessageDialog(null, "You lost! You failed to evade the enemy");
                    this.level = 1;
                    Menu.main();
                    dispose();
                    break;
                case 3:
                    //     System.out.println("The Hero has fallen in Battle. GAME OVER :(");
                    //   System.out.println("Press ENTER key to continue");
//                    sc.nextLine();
                    JOptionPane.showMessageDialog(null, "The Hero has fallen in Battle. GAME OVER :(");
                    this.level = 1;
                    Menu.main();
                    dispose();
                    break;
                case 2:
//                    System.out.println("The hero has successfully evaded the Villain!");
//                    System.out.println("Press ENTER key to continue");
//                    sc.nextLine();
                    JOptionPane.showMessageDialog(null, "The hero has successfully evaded the Villain!");
                    break;
                case 0:
                 //   System.out.println("The hero WON the battle! Yay");
                    JOptionPane.showMessageDialog(null, "The hero WON the battle! Yay");
                    if ((Math.random() * 100) >= 75)
                    {
                        Artifact item = Factory.generateArtifacts();
                        JOptionPane.showMessageDialog(null, "You have won an item.\n" + item);
                     //   System.out.println();
                     //   System.out.println(item);
                     int outputint = JOptionPane.showConfirmDialog(null, "Do you want to keep it? (Y/N)");
                    //   /   = sc.nextLine();
                        if (outputint == 0)
                        {
                            game.acceptArtifact(item, myhero);
                        }               
                    }
                    break;
                case 7:
                case 4:
                    JOptionPane.showMessageDialog(null, "Congratulations!  Your courage in battle has afforded you entry into the next level "+ (this.level + 1));
                    nextLevel(myhero);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR");
                    this.level = 1;
                    break;
            }
        }
        populate(myhero);
        populateField();
    }

    private void populate(Hero myhero) {
        this.txtName.setText(myhero.getName());
        this.txtClass.setText(myhero.getHeroclass());
        this.txtLevel.setText(myhero.getLevel() + "");
        this.txtExperience.setText(myhero.getExperience() + "");
        this.txtAttack.setText(myhero.getAttack() + "");
        this.txtDefence.setText(myhero.getDefence() + "");
        this.txtHitPoints.setText(myhero.getHitpoints() + "");
        this.txtX.setText(myhero.getX() + "");
        this.txtY.setText(myhero.getY() + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblHero = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblClass = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        lblExperience = new javax.swing.JLabel();
        lblAttack = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtClass = new javax.swing.JLabel();
        txtLevel = new javax.swing.JLabel();
        txtExperience = new javax.swing.JLabel();
        txtAttack = new javax.swing.JLabel();
        lblDefence = new javax.swing.JLabel();
        lblHP = new javax.swing.JLabel();
        txtDefence = new javax.swing.JLabel();
        txtHitPoints = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        txtX = new javax.swing.JLabel();
        txtY = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaField = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        btnLeft = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblTitle.setText("SWINGY");

        lblHero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHero.setText("Hero");

        lblName.setText("Name");

        lblClass.setText("Class");

        lblLevel.setText("Level");

        lblExperience.setText("Experience");

        lblAttack.setText("Attack");

        txtName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtName.setText("jLabel3");

        txtClass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtClass.setText("jLabel8");

        txtLevel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtLevel.setText("jLabel9");

        txtExperience.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtExperience.setText("jLabel10");

        txtAttack.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtAttack.setText("jLabel11");

        lblDefence.setText("Defence");

        lblHP.setText("Hit Points");

        txtDefence.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtDefence.setText("jLabel14");

        txtHitPoints.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtHitPoints.setText("jLabel15");

        lblPosition.setText("Position");

        txtX.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtX.setText("jLabel17");

        txtY.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtY.setText("jLabel18");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAttack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDefence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblExperience, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(lblHero))
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHitPoints)
                    .addComponent(txtDefence)
                    .addComponent(txtX)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtLevel)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAttack, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtExperience, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(txtClass)
                        .addComponent(txtName)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtY)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHero)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClass)
                    .addComponent(txtClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLevel)
                    .addComponent(txtLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExperience)
                    .addComponent(txtExperience))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAttack)
                    .addComponent(txtAttack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDefence)
                    .addComponent(txtDefence))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHP)
                    .addComponent(txtHitPoints))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosition)
                    .addComponent(txtX)
                    .addComponent(txtY))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        txaField.setColumns(20);
        txaField.setRows(5);
        jScrollPane1.setViewportView(txaField);

        btnUp.setText("Up");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        btnDown.setText("Down");
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        btnLeft.setText("Left");
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });

        btnRight.setText("Right");
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDown)
                            .addComponent(btnUp)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLeft)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRight)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeft)
                    .addComponent(btnRight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDown)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnSave.setText("Save Hero");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jButton1.setText("ConsoleView");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 67, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(22, 22, 22)
                        .addComponent(btnSave)
                        .addGap(29, 29, 29)
                        .addComponent(btnExit)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExit)
                            .addComponent(btnSave)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        move(utils.up);
    }//GEN-LAST:event_btnUpActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        Menu.main();
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        move(utils.left);
    }//GEN-LAST:event_btnLeftActionPerformed

    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightActionPerformed
        move(utils.right);
    }//GEN-LAST:event_btnRightActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        move(utils.down);
    }//GEN-LAST:event_btnDownActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to save Hero?");
        if (option == 0)
        {
            GameController.saveHero(myhero);
            JOptionPane.showMessageDialog(null, "Saved Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(Hero args) {
        final Hero hero = args;
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
            java.util.logging.Logger.getLogger(GUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (hero == null) {
                    new GUIView().setVisible(true);
                } else {
                    new GUIView(hero).setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnRight;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUp;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAttack;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblDefence;
    private javax.swing.JLabel lblExperience;
    private javax.swing.JLabel lblHP;
    private javax.swing.JLabel lblHero;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txaField;
    private javax.swing.JLabel txtAttack;
    private javax.swing.JLabel txtClass;
    private javax.swing.JLabel txtDefence;
    private javax.swing.JLabel txtExperience;
    private javax.swing.JLabel txtHitPoints;
    private javax.swing.JLabel txtLevel;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtX;
    private javax.swing.JLabel txtY;
    // End of variables declaration//GEN-END:variables
}
