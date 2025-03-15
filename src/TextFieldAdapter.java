import javax.swing.JTextField;
import javax.swing.text.Document;

public interface TextFieldAdapter {
    void setText(String text);
    String getText();
    void setDocument(Document doc);
    JTextField getTextField(); 
    void setFont(java.awt.Font font); 
}
