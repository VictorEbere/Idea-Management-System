import java.io.*;

public class FileManager {

    public void createFile(Ideas idea, String title){
        try(BufferedWriter out = new BufferedWriter(new FileWriter(title))){
            out.write("Date: " + idea.getDate());
            out.newLine();

            out.write("Title: " + (idea.getTitle()).toUpperCase());
            out.newLine();

            out.write("Priority level: " + idea.getPriorityLevel());
            out.newLine();

            out.write("Description: " + idea.getDescription());
            out.newLine();
            out.newLine();

        }catch(IOException e){
            System.err.println("There was an error: "+ e.getMessage());
            e.getStackTrace();
        }
    }

    public void addToFile(String fileName, Ideas idea){
        try(BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true))){

            out.write("Date: " + idea.getDate());
            out.newLine();

            out.write("Title: " + (idea.getTitle()).toUpperCase());
            out.newLine();

            out.write("Priority level: " + idea.getPriorityLevel());
            out.newLine();

            out.write("Description: " + idea.getDescription());
            out.newLine();
            out.newLine();

        }catch(FileNotFoundException e){
            System.err.println("File Not Found!!!");
        }catch(IOException e){
            System.err.println("There was an error: "+ e.getMessage());
            e.getStackTrace();
        }
    }

    public void loadFile(String file){
        try(BufferedReader in = new BufferedReader(new FileReader(file))){
            String line;
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
        }catch(FileNotFoundException e){
            System.err.println("File Not Found!!!");
        }catch(IOException e){
            System.err.println("There was an error: "+ e.getMessage());
            e.getStackTrace();
        }
    }

/*
    public void editFile(){

    }

    public void deleteFile(){

    }

 */
}

