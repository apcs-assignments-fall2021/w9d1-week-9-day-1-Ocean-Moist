import java.util.ArrayList;
import java.util.Scanner;

public class BlockchainClient {
    public static ArrayList<Block> blockchain = new ArrayList<>(); // makes resizable array of blocks (this is our "chain" of blocks)
    // a blockchain is just a really slow linked list that takes computational power to add another node and can be verified quickly

    public static void main(String[] args) {
        //add our blocks to the blockchain ArrayList:
        Scanner inp = new Scanner(System.in);
        System.out.println("what message do you want to be on teh genesis block??");
        insertBlock(new Block(inp.nextLine(), "0")); // genesis block with hash of 0
        label:
        while (true) {
            System.out.println("aight u finna add another block (1), validate the blockchain (2), quit (3), or print the chain (4)");
            String answer = inp.nextLine();
            switch (answer) {
                case "1":
                    System.out.println("what mesage you want to live on the block 4ever");
                    insertBlock(new Block(inp.nextLine(), blockchain.get(blockchain.size() - 1).getHash()));
                    break;
                case "2":
                    if (validateChain()) {
                        System.out.println("mf is valid af");
                    } else {
                        System.out.println("what the fricjk did you do to the chain");
                    }
                    break;
                case "3":
                    break label;
                case "4":
                    printChain();
                default:
                    break;
            }

        }
    }
    public static void printChain() {
        for (Block block : blockchain) {
            System.out.println(block);
        }
    }
    public static boolean validateChain() {
        Block currentBlock;
        Block previousBlock;


        // loop through blockchain to check hashes:
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            // compare registered hash and calculated hash:
            if (!currentBlock.getHash().equals(currentBlock.makeHash())) {
                return false;
            }
            // compare previous hash and registered previous hash
            if (!previousBlock.getHash().equals(currentBlock.getPrevHash())) {
                return false;
            }
            // check if hash is solved
            if (!currentBlock.getHash().startsWith(currentBlock.getDifficultyString())) {
                return false;
            }

        }
        return true;
    }

    public static void insertBlock(Block newBlock) {
        newBlock.mine();
        blockchain.add(newBlock);
    }

}
