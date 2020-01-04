/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

/**
 *
 * @author manxboy
 */
public class ConverterFrame extends javax.swing.JFrame {

    /**
     * Creates new form ConverterFrame
     */
    public ConverterFrame() {
        initComponents();
    }

    /**
     * Converts a string into binary from decimal
     *
     * @param decimal the string to convert
     * @return the converted string, or "error" on failure
     */
    public static String toBinary(String decimal) {
        //validate input

        if (decimal.matches("\\d+")) {

            //get the value of the input as an int
            int value = Integer.parseInt(decimal);

            //check the bounds
            if (value >= 0 && value <= 255) {
                
                //set the quotient to the initial value of "value"
                int quotient = value;

                //output value
                String bin = "";

                //loop until the quotient is zero
                while (quotient != 0) {

                    //prepend the relavent bit (found by modulo) to the end
                    bin = (quotient % 2) + bin;

                    //divide the quotient by two (integer division)
                    quotient /= 2;
                }

                return bin;
                
            } else {
                //return error message
                return "enter a number between 0 and 255";
            }

        }
        
        //return error message
        return "enter a number";
    }

    /**
     * Converts a string into decimal from binary
     *
     * @param bin the string to convert
     * @return the converted string, or "error" on failure
     */
    public static String toDecimal(String bin) {
        //validate input
        if (bin.matches("[01]+")) {

            //sum of digits
            int sum = 0;

            //loop over all of the digits
            for (int i = 0; i < bin.length(); i++) {

                //get the digit at the index using String.charAt and then testing it to either return a 1 or a 0
                int digit = bin.charAt(bin.length() - (i + 1)) == '1' ? 1 : 0;

                //add the digit mulitipled by 2 raised to the index to the total sum of digits
                sum += digit * Math.pow(2, i);
            }

            //return the sum as a String
            return sum + "";
        }
        
        return "error";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        decimalToBinaryInput = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        decimalToBinaryConvert = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        decimalToBinaryOutput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        binaryToDecimalInput = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        binaryToDecimalConvert = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        binaryToDecimalOutput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel1.setText("Decimal");
        jPanel2.add(jLabel1);

        decimalToBinaryInput.setToolTipText("");
        decimalToBinaryInput.setPreferredSize(new java.awt.Dimension(100, 24));
        jPanel2.add(decimalToBinaryInput);

        jPanel5.add(jPanel2);

        decimalToBinaryConvert.setText("CONVERT!");
        decimalToBinaryConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decimalToBinaryConvertActionPerformed(evt);
            }
        });
        jPanel3.add(decimalToBinaryConvert);

        jPanel5.add(jPanel3);

        jLabel2.setText("Binary");
        jPanel4.add(jLabel2);

        decimalToBinaryOutput.setEditable(false);
        decimalToBinaryOutput.setToolTipText("");
        decimalToBinaryOutput.setPreferredSize(new java.awt.Dimension(180, 24));
        jPanel4.add(decimalToBinaryOutput);

        jPanel5.add(jPanel4);

        jPanel1.add(jPanel5, java.awt.BorderLayout.NORTH);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Binary/Decimal Conversions");
        jLabel5.setMaximumSize(new java.awt.Dimension(353, 16));
        jLabel5.setMinimumSize(new java.awt.Dimension(353, 16));
        jLabel5.setPreferredSize(new java.awt.Dimension(353, 16));
        jLabel5.setSize(new java.awt.Dimension(353, 16));
        jPanel1.add(jLabel5, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel3.setText("Binary");
        jPanel7.add(jLabel3);

        binaryToDecimalInput.setPreferredSize(new java.awt.Dimension(100, 24));
        jPanel7.add(binaryToDecimalInput);

        jPanel6.add(jPanel7);

        binaryToDecimalConvert.setText("CONVERT!");
        binaryToDecimalConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binaryToDecimalConvertActionPerformed(evt);
            }
        });
        jPanel8.add(binaryToDecimalConvert);

        jPanel6.add(jPanel8);

        jLabel4.setText("Decimal");
        jPanel9.add(jLabel4);

        binaryToDecimalOutput.setEditable(false);
        binaryToDecimalOutput.setPreferredSize(new java.awt.Dimension(180, 24));
        jPanel9.add(binaryToDecimalOutput);

        jPanel6.add(jPanel9);

        jPanel1.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void decimalToBinaryConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decimalToBinaryConvertActionPerformed
        //convert the input into Binary
        String bin = toBinary(decimalToBinaryInput.getText());

        //set the output to display the result
        decimalToBinaryOutput.setText(bin);
    }//GEN-LAST:event_decimalToBinaryConvertActionPerformed

    private void binaryToDecimalConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binaryToDecimalConvertActionPerformed
        //convert the input into decimal
        String decimal = toDecimal(binaryToDecimalInput.getText());

        //set the output to display the result
        binaryToDecimalOutput.setText(decimal);
    }//GEN-LAST:event_binaryToDecimalConvertActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConverterFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton binaryToDecimalConvert;
    private javax.swing.JTextField binaryToDecimalInput;
    private javax.swing.JTextField binaryToDecimalOutput;
    private javax.swing.JButton decimalToBinaryConvert;
    private javax.swing.JTextField decimalToBinaryInput;
    private javax.swing.JTextField decimalToBinaryOutput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
