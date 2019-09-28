package BankATM;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Model {


	private int balance;
    private String username;
    private String password;



public Model(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


  /**
     * Egy Json fájlt hoz létre és ír bele.
     * @param filename a Json fájl neve.
     * @throws Exception
     */
    public void writeJsonSimpleDemo(String filename) throws Exception {
        JSONObject sampleObject = new JSONObject(); 
        sampleObject.put("balance", getBalance());
        sampleObject.put("username", getUsername());
        sampleObject.put("password", getPassword());
        Files.write(Paths.get(filename), sampleObject.toString().getBytes());
    }


    /**
     * Json fájl beolvasásához szükséges try, catch blokkok.
     */


public void readJson() {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("balance.json"));
            JSONObject jsonObject = (JSONObject) obj;
            long b1 = (long) jsonObject.get("balance");
            setBalance((int) b1);
            String b2 = (String) jsonObject.get("username");
            setUsername(b2);
            String b3 = (String) jsonObject.get("password");
            setPassword(b3);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        catch (ParseException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}
    }



         }

