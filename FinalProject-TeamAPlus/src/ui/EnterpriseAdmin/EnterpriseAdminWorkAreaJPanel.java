package ui.EnterpriseAdmin;

import Airport.AirportEcoSystem;
import Airport.Enterprise.Enterprise;
import Airport.Organization.Organization;
import Airport.Role.EnterpriseAdminRole;
import Airport.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class EnterpriseAdminWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel container;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private AirportEcoSystem airport;

    public EnterpriseAdminWorkAreaJPanel(JPanel container, UserAccount account, Organization organization, AirportEcoSystem airport) {
        initComponents();
        this.container = container;
        this.account = account;
        this.organization = organization;
        this.airport = airport;
        this.enterprise = ((EnterpriseAdminRole) account.getRole()).getEnterprise();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        btnManageOrganizations = new javax.swing.JButton();
        btnManageUsers = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 36));
        lblTitle.setText("Enterprise Admin Work Area");

        btnManageOrganizations.setText("Manage Organizations");
        btnManageOrganizations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrganizationsActionPerformed(evt);
            }
        });

        btnManageUsers.setText("Manage Users");
        btnManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(lblTitle)
                .addContainerGap(380, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnManageUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageOrganizations, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(426, 426, 426))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblTitle)
                .addGap(61, 61, 61)
                .addComponent(btnManageOrganizations, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnManageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(592, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void btnManageOrganizationsActionPerformed(java.awt.event.ActionEvent evt) {
        ManageOrganizationsJPanel manageOrganizationsJPanel = new ManageOrganizationsJPanel(container, enterprise, airport);
        container.add("manageOrganizationsJPanel", manageOrganizationsJPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.show(container, "manageOrganizationsJPanel");
    }

    private void btnManageUsersActionPerformed(java.awt.event.ActionEvent evt) {
        ManageUsersJPanel manageUsersJPanel = new ManageUsersJPanel(container, enterprise, airport);
        container.add("manageUsersJPanel", manageUsersJPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.show(container, "manageUsersJPanel");
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnManageOrganizations;
    private javax.swing.JButton btnManageUsers;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration
}
