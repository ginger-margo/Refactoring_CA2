import javax.swing.JTextField;
import javax.swing.text.Document;

public class JTextFieldLimitAdapter implements TextFieldAdapter {
    private JTextField textField;

    public JTextFieldLimitAdapter(JTextField textField, Document limitDocument) {
        this.textField = textField;
        this.textField.setDocument(limitDocument);
    }

    @Override
    public void setText(String text) {
        textField.setText(text);
    }

    @Override
    public String getText() {
        return textField.getText();
    }

    @Override
    public void setDocument(Document doc) {
        textField.setDocument(doc);
    }

    @Override
    public JTextField getTextField() {
        return textField; 
    }

    @Override
    public void setFont(java.awt.Font font) {
        textField.setFont(font);
    }
}
