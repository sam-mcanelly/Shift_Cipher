
import java.io.*;

/**
 *
 * @author Sam McAnelly
 */
public class Caesar {
    

    public static void main(String[] args){
        if (args.length < 2 || args.length > 3){
            System.out.println("Usage: java Caeser <key> <inFile> [OUTFILE]");
        } else if (args.length == 2) {
            encrypt(Integer.parseInt(args[0]), args[1]);
        } else {
            encrypt(Integer.parseInt(args[0]), args[1], args[2]);
        }
    }
    
    public static void encrypt(int key, String inFile){
        File read = new File(inFile);
        String line; 
        char output;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(read));
            while ((line = reader.readLine()) != null) {
                for (char c: line.toCharArray()){
                    if (c < 32 || c > 126){
                        System.out.print(c);
                    } else {
                        if (c + key > 126){
                            System.out.print((char)(c + key - 95));
                        } else if (c + key < 32){
                            System.out.print((char)(c + key + 95));
                        } else {
                            System.out.print((char)(c + key));
                        }
                    }
                }
                System.out.println();
            }
            
        } catch (NullPointerException e){
            
        } catch (java.io.IOException e){
            System.out.println("Something went wrong and I cannot read the file!");
            e.printStackTrace();
            
        }finally {
            
        }
    }
    
    public static void encrypt(int key, String inFile, String outFile){
        File read = new File(inFile);
        PrintWriter writer;
        BufferedReader reader;
        String line;
        char output;
        try {
            reader = new BufferedReader(new FileReader(read));
            writer = new PrintWriter(new FileWriter(outFile), true);
            while ((line = reader.readLine().toLowerCase()) != null) {
                for (char c: line.toCharArray()){
                    if (c < 32 || c > 126){
                        writer.print(c);
                    } else {
                        if (c + key > 126){
                            writer.print((char)(c + key - 95));
                        } else if (c + key < 32){
                            writer.print((char)(c + key + 95));
                        } else {
                            writer.print((char)(c + key));
                        }
                    }
                }
                writer.println();
            }
            writer.flush();
            writer.close();
        } catch (NullPointerException e){
            
        } catch (java.io.IOException e){
            System.out.println("Something went wrong with one of the files, please try again!");
            e.printStackTrace();
        }finally {
        }
    }
}
