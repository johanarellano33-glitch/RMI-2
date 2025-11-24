package Cliente;

import computadora.computadora;
import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class computadoraPi {
    public static void main(String args[]) {
        if (args.length < 1) {
            System.err.println("Usage: java client.ComputadoraPi <hostname> [digits]");
            return;
        }
        
        try {
            String name = "Computadora";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            computadora comp = (computadora) registry.lookup(name);
            
            int digits = (args.length > 1) ? Integer.parseInt(args[1]) : 10;
            pi tarea = new pi(digits);
            BigDecimal pi = comp.executeTask(tarea);
            
            System.out.println("Pi calculado ed " + digits + " digitos:");
            System.out.println(pi);
        } catch (Exception e) {
            System.err.println("Computadora pi excepcion:");
            e.printStackTrace();
        }
    }
}