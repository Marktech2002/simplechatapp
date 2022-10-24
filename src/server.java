import java.util.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class server {
    public static void main(String[] args) throws Exception {
       try {
        ServerSocket ss = new ServerSocket(5050);
        System.out.println("server started");
        Socket s = ss.accept();
        System.out.println("connected");
         DataInputStream in = new DataInputStream(s.getInputStream());
         DataOutputStream out = new DataOutputStream(s.getOutputStream());
         BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));

         String f_str ="" , s_str = "";
         while(!f_str.equals("over")) {
            f_str = in.readUTF();
            System.out.println("clients say " + f_str);
            s_str = bufread.readLine();
            out.writeUTF(s_str);
            out.flush();
         }

         in.close();
         s.close();
         ss.close();
    }
    catch(IOException i) {
      System.out.println(i);
    }
}

}
