package cl.duoc.biblioteca.view;
import cl.duoc.biblioteca.dao.UsuarioDAO;
import cl.duoc.biblioteca.model.Usuario;
import javax.swing.*;
import java.awt.*;
public class LoginFrame extends JFrame {
 private final JTextField correo=new JTextField("antonia@correo.cl",22);
 private final JPasswordField clave=new JPasswordField("clave123",22);
 public LoginFrame() {
  super("Biblioteca Escolar | Iniciar sesión");setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(430,250);setLocationRelativeTo(null);setResizable(false);JPanel p=new JPanel(new GridBagLayout());p.setBorder(BorderFactory.createEmptyBorder(20,25,20,25));GridBagConstraints g=new GridBagConstraints();g.insets=new Insets(7,7,7,7);g.fill=GridBagConstraints.HORIZONTAL;g.gridx=0;g.gridy=0;p.add(new JLabel("Correo:"),g);g.gridx=1;p.add(correo,g);g.gridx=0;g.gridy=1;p.add(new JLabel("Contraseña:"),g);g.gridx=1;p.add(clave,g);JButton entrar=new JButton("Ingresar");g.gridx=0;g.gridy=2;g.gridwidth=2;p.add(entrar,g);entrar.addActionListener(e->login());getRootPane().setDefaultButton(entrar);add(p);}
 private void login() {
  try{Usuario u=new UsuarioDAO().autenticar(correo.getText().trim(),new String(clave.getPassword()));if(u==null){JOptionPane.showMessageDialog(this,"Correo o contraseña incorrectos.");return;}new BibliotecaFrame(u).setVisible(true);dispose();}catch(Exception ex){JOptionPane.showMessageDialog(this,"No se pudo conectar a MySQL. Revisa config/db.properties y que MySQL esté iniciado.\n"+ex.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);}}
}
