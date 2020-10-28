package ModeloSistema;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TratamentoCampos {

    public void soLetras(java.awt.event.KeyEvent evt) {
        //OBS: ESSA FUNÇÃO SÓ FUNCIONA NO EVENTO KEYTYPED DO TEXTFIELD
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')
                && c != 'á' //Minúsculas             
                && c != 'ã'
                && c != 'â'
                && c != 'é'
                && c != 'ê'
                && c != 'í'
                && c != 'ó'
                && c != 'õ'
                && c != 'ô'
                && c != 'ú'
                && c != 'ç'
                && c != 'Á' //Mayúsculas             
                && c != 'Ã'
                && c != 'Â'
                && c != 'É'
                && c != 'Ê'
                && c != 'Í'
                && c != 'Ó'
                && c != 'Õ'
                && c != 'Ô'
                && c != 'Ú'
                && c != 'Ç'
                && (c != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }

    public void soNumeros(java.awt.event.KeyEvent evt) {
        //OBS: ESSA FUNÇÃO SÓ FUNCIONA NO EVENTO KEYTYPED DO TEXTFIELD
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }
    
//    public static boolean validarEmail(String email) {
//        
//        if ((email == null) || (email.trim().length() == 0))
//            return false;
//
//        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
//        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }
}
