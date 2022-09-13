package arquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class EscreveJSON {
	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("113");
		usuario1.setLogin("rapha");
		usuario1.setSenha("1999");
		
		Usuario usuario2 = new Usuario();
		usuario2.setCpf("356");
		usuario2.setLogin("renatinha");
		usuario2.setSenha("2607");
		
		List<Usuario>usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		//faz em outro formato
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		String jsonUser = gson.toJson(usuarios);
		
		
		//String jsonUser = new Gson().toJson(usuarios);
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\Rapha\\git\\arquivosemjava\\arquivos\\src\\arquivos\\filjson.json");
		
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
	}
}
