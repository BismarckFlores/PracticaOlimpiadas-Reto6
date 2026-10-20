import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Bienvenido al sistema de ventas.");
        System.out.print("Ingrese la cantidad de ventas (1-100000): ");
        int n = Integer.parseInt(br.readLine().trim());

        Map<String, Long> totales = new HashMap<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Venta " + (i + 1) + " (ej: Rivas 1500): ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String sucursal = st.nextToken();
            int importe = Integer.parseInt(st.nextToken());
            totales.merge(sucursal, (long) importe, Long::sum);
        }

        String ganadora = null;
        long max = -1;
        for (Map.Entry<String, Long> e : totales.entrySet()) {
            long total = e.getValue();
            if (total > max || (total == max && e.getKey().compareTo(ganadora) < 0)) {
                max = total;
                ganadora = e.getKey();
            }
        }

        System.out.println(ganadora + " " + max);
    }
}