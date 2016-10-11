import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;



public class ejemploFTP {

	public static void main(String[] args) {
		// Datos para la conexion
	      String server = <dirección del servidor>;
	      String username = <Usuario del servidor>;
	      String password = <Contraseña del usuario>;

	      // Cliente de conexion a FTP
	      FTPClient ftp = new FTPClient();

	      int respuesta, i;
	      String[] lista;

	      try{
	            System.out.println(“CONECTANDO AL SERVIDOR FTP”);
	            // Conectando e identificandose con el servidos
	            ftp.connect(server);
	            ftp.login(username, password);
	            // Entrando a modo pasivo
	            ftp.enterLocalPassiveMode();

	            // Obteniendo respuesta del servidos
	            respuesta = ftp.getReplyCode();
	            System.out.println(“RESPUESTA ” + respuesta);

	            // Si la respuesta del servidor indica podemos pasar procedemos 
	            if(FTPReply.isPositiveCompletion(respuesta) == true ) {
	                  System.out.println(“LISTANDO ARCHIVOS”);
	                  lista = ftp.listNames();

	                  for(i=0; i<lista.length; i++) {

	                        System.out.println(lista[i]); 
	                  }
	            // Si no avisamos
	            } else { 
	                        System.out.println(“ERROR DE CONEXION”); 
	            }

	            // en ambos casos terminaos sesion
	            ftp.logout();
	            // Y nos desconectamos
	            ftp.disconnect();

	            // Esta excepcion se lanza en caso de algun error durante el proceso 
	            }catch(IOException e) {
	                  System.out.println(“Error de conexion”);
	            } 
	      }
	}

	}

}
