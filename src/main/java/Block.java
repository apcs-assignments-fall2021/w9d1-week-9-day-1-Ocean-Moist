import java.util.Date;

public class Block {
    private final int difficulty = 5; // set difficulty of block, bitcoins blocks are like 20_000_000_000_000, amount of zeroes you have to solve for
    private String hash;
    private final String prevHash;
    private final String message; // like an nft, message on block.
    private final long timeStamp; // unix  time stamp.
    private int nonce;
    private String difficultyString;

    //Constructor, makes a new block
    public Block(String message, String prevHash) {
        this.message = message;
        this.prevHash = prevHash;
        this.timeStamp = new Date().getTime();
        this.hash = makeHash(); // use message to create new hash
        difficultyToString(difficulty); // make a difficulty string
    }

    // getters
    public String getHash() {
        return this.hash;
    }

    public String getDifficultyString() {
        return this.difficultyString;
    }

    public String getPrevHash() {
        return this.prevHash;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    // makes a new hash with sha256
    public String makeHash() {
        return SHA256.encrypt(prevHash + timeStamp + nonce + message);
    }

    public String mine() {
        while (!hash.startsWith(difficultyString)) { // checks if the hash's first 5 digits are 0 if not increases the nonce and make hash again. guesses what the hash will be
            nonce++; // could theoretically make this a random number
            hash = makeHash();
        }
        return hash;
    }

    public void difficultyToString(int difficulty) { // creates a string with difficulty amount of zeroes e.g. 5 ---> "00000"
        String stringDiff = "";
        for (int i = 0; i < difficulty; i++) {
            stringDiff += "0";
        }
        this.difficultyString = stringDiff;
    }

    @Override public String toString() {
        return "hash: " + hash + "\ntime stamp: " + timeStamp + "\nmessage: " + message + "\n";
    }
}
