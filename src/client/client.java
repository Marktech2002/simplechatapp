package client;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.*;
import java.lang.ClassNotFoundException;

public class client {
    public static void main(String[] args) throws Exception {
        try {
            Socket s = new Socket("localhost", 5050);
            System.out.println("connected");
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("over")) {
                str = br.readLine();
                out.writeUTF(str2);
                out.flush();
                str2 = in.readUTF();
                System.out.println("Server Says " + str2);
            }
            out.close();
            s.close();
        } catch (IOException e) {
            System.out.print(e);
        }
       
    }
   
}