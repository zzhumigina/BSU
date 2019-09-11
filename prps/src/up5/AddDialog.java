package up5;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddDialog extends JFrame {



    private CatalogFrame frame;
    private JLabel compLabel, countryLabel, systemLabel, priceLabel;
    private JTextField compTextField, countryTextField, systemTextField, priceTextField;
    private JButton cancelButton, okButton;

    AddDialog(CatalogFrame temp) {
        frame = temp;
        initComponents();
        setTitle("Add sold item");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private void initComponents() {
        compLabel = new JLabel();
        countryLabel = new JLabel();
        systemLabel = new JLabel();
        priceLabel = new JLabel();
        compTextField = new JTextField();
        countryTextField = new JTextField();
        systemTextField = new JTextField();
        priceTextField = new JTextField();
        okButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        compLabel.setText("Discount:");
        countryLabel.setText("Seller:");
        systemLabel.setText("Name:");
        priceLabel.setText("Price:");

        compTextField.addCaretListener(this::brandTextFieldCaretUpdate);
        countryTextField.addCaretListener(this::modelTextFieldCaretUpdate);
        systemTextField.addCaretListener(this::systemTextFieldCaretUpdate);
        okButton.setText("OK");
        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                okButtonMouseClicked(evt);
            }
        });
        cancelButton.setText("Cancel");
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(compLabel)
                                                        .addComponent(countryLabel)
                                                        .addComponent(systemLabel)
                                                        .addComponent(priceLabel))
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                                                        .addComponent(compTextField, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(compTextField, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(countryTextField, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(systemTextField, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(okButton)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cancelButton))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(18, 18, 18))))
                                                .addGap(0, 4, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(compLabel)
                                        .addComponent(compTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(countryLabel)
                                        .addComponent(countryTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(systemLabel)
                                        .addComponent(systemTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(priceLabel)
                                        .addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(okButton)
                                        .addComponent(cancelButton))
                                .addContainerGap())
        );

        pack();
    }

    private void brandTextFieldCaretUpdate(CaretEvent evt) {
        checkOkClose();
    }

    private void modelTextFieldCaretUpdate(CaretEvent evt) {
        checkOkClose();
    }

    private void systemTextFieldCaretUpdate(CaretEvent evt) {
        checkOkClose();
    }

    private void cancelButtonMouseClicked(MouseEvent evt) {
        dispose();
    }

    private void okButtonMouseClicked(MouseEvent evt) {
        if (okButton.isEnabled()) {
            CatalogFrame.addResult = new CameraNode(compTextField.getText(),
                    countryTextField.getText(),
                    systemTextField.getText(),
                    priceTextField.getText()
                            .isEmpty()
                            ? "-1" : this.priceTextField.getText());
            frame.addNewItem();
            dispose();
        }
    }


    private void checkOkClose() {
        if (!compTextField.getText().isEmpty() &&
                !countryTextField.getText().isEmpty() &&
                !systemTextField.getText().isEmpty()) {
            okButton.setEnabled(true);
        }
    }


}
