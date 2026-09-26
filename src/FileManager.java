import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public void createFile(Ideas idea, String title){
        try(BufferedWriter out = new BufferedWriter(new FileWriter(title))){
            out.write("Date: " + idea.getDate());
            out.newLine();

            //out.write("Time: " + idea.);

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


    public void editFileTitle(String filename, String oldTitle, String newTitle){
        /*
        try(BufferedReader read = new BufferedReader(new FileReader(oldTitle))){

        }catch(FileNotFoundException e){
            System.err.println("File Not Found!!!");
        }catch(IOException e){
            System.err.println("There was an error: "+ e.getMessage());
        }
        */
    }

    public void editFileDate(String filename, String oldDate, String newDate){

    }

    public void editFilePriorityLvl(String filename, String oldPLvl, String newPLvl){

    }

    public void editFileDescription(String filename, String oldDes, String newDes){

    }

    public void deleteFile(String fileName){
        try{
            Path path;
            if(fileName.contains(".txt")){
                path = Path.of(fileName);
            }else{
                path = Path.of(fileName+".txt");
            }

            Files.deleteIfExists(path);
            System.out.println("File deleted successfully");

        }catch(FileNotFoundException e){
            System.err.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}

