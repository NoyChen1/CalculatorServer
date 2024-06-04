import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String operation = in.readLine();
                double num1 = Double.parseDouble(in.readLine());
                double num2 = Double.parseDouble(in.readLine());

                CalculatorStrategy calculatorStrategy = null;

                double result = 0;

                switch (operation) {
                    case "+":
                         calculatorStrategy = new AdditionStrategy();
                        break;
                    case "-":
                        calculatorStrategy = new SubtractionStrategy();
                        break;
                    case "*":
                        calculatorStrategy = new MultiplicationStrategy();
                        break;
                    case "/":
                        calculatorStrategy = new DivisionStrategy();
                        break;
                }

                result = calculatorStrategy.calculate(num1, num2);
                out.println(result);

                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}