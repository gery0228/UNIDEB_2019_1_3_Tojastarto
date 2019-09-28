package BankATM;

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




    }

