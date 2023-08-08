import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {


        String path = "C:\\Windows\\Temp\\votos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            Map<String, Integer> map = new HashMap<>();

            while (line != null) {


                String[] fields = line.split(",");
                String nome = fields[0];
                int valor = Integer.parseInt(fields[1]);


                if (map.containsKey(nome)) {
                    int contagem = map.get(nome);
                    map.replace(nome, contagem + valor);
                } else map.put(nome, valor);

                line = br.readLine();
            }

            System.out.println(map);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}