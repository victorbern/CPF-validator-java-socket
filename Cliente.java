import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
	private static Socket socket;
	private static DataInputStream entrada;
	private static DataOutputStream saida;
	
	public static void main (String[] args) {
		
		try {
			socket = new Socket("127.0.0.1", 5000);
			entrada = new DataInputStream(socket.getInputStream());
			saida = new DataOutputStream(socket.getOutputStream());
			
//			Recebe alguns dados do usuário
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String cpf = br.readLine();
			
//			Envia estes dados ao server
			saida.writeUTF(cpf);
			
//			Recebe a resposta do server
			boolean resultado = entrada.readBoolean();
			
			socket.close();
			
//			Imprime a resposta do server
			if (resultado) {
				System.out.println("O CPF digitado é válido");
			} else {
				System.out.println("O CPF digitado é inválido");
			}
			
		} catch (Exception e) {
			
		}
	}
}
