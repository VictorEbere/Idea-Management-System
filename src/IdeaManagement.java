import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class IdeaManagement {
    private final Scanner keyboard = new Scanner(System.in);
    private final FileManager fileManager = new FileManager();
    //LocalDate date;

    public void run(){
        boolean running = true;

        do {
            int choice;
            displayMenu();
            if (!keyboard.hasNextInt()) {
                System.out.print("Please enter a number!!!");
                keyboard.nextLine();
                continue;
            }
            choice = keyboard.nextInt();
            keyboard.nextLine();

            switch(choice){
                case 1:
                    createNewIdeaFile();
                    running = returnToMenu();
                    break;
                case 2:
                    addNewIdea();
                    running = returnToMenu();
                    break;
                case 3:
                    viewIdea();
                    running = returnToMenu();
                    break;
                case 4:
                    editIdea();
                    running = returnToMenu();
                    break;
                case 5:
                    deleteIdea();
                    running = returnToMenu();
                    break;
                case 6:
                    System.out.println("Thank you for using this Idea Management System(IMS)!!!");
                    System.out.println("Have a good day :)");
                    running = false;
                    break;
                default:
                    System.out.println("Please enter a valid choice!!!");
            }
        }while(running);
    }

    public boolean returnToMenu(){
        boolean innerRunning = true;
        boolean outerRunning = true;

        do{
            int innerChoice;
            System.out.println("1. Go back to Main menu \n2. Exit Program");
            System.out.print("Please enter choice: ");

            if (!keyboard.hasNextInt()) {
                System.out.print("Please enter a number!!!");
                keyboard.nextLine();
                continue;
            }
            innerChoice = keyboard.nextInt();
            keyboard.nextLine();

            switch(innerChoice){
                case 1:
                    innerRunning = false;
                    break;
                case 2:
                    innerRunning = false;
                    outerRunning = false;
                    break;
                default:
                    System.out.println("Please enter a valid choice!!!");
            }
        }while(innerRunning);
        return outerRunning;
    }

    public Ideas createIdea(){
        System.out.print("Enter Date (MM/dd/yyyy): ");
        String dateInput = keyboard.nextLine();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateInput, format);

        System.out.print("Enter Title: ");
        String ideaTitle = keyboard.nextLine();

        String priorityLevel;
        while (true) {
            System.out.print("Enter Priority level (high, medium, low): ");
            priorityLevel = keyboard.nextLine().toLowerCase();
            if (priorityLevel.equals("high") ||
                    priorityLevel.equals("medium") ||
                    priorityLevel.equals("low")) {
                break;
            }
            System.out.println("Please enter high, medium, or low.");
        }

        System.out.print("Enter Descriptions: ");
        String description = keyboard.nextLine();

        Ideas idea = new Ideas(date, ideaTitle, priorityLevel, description);
        System.out.println("Your Idea Has Been Made!!!");

        return idea;
    }


    public void displayMenu(){
        System.out.println("********************************");
        System.out.println("    Welcome to Idea Manger!!!   ");
        System.out.println("********************************");

        System.out.println("1. Create new Idea file \n2. Add new Idea \n3. View Idea \n4. Edit Idea \n5. Delete Idea \n6. Exit Program");
        System.out.print("What would you like to do today?: ");
    }

    public void createNewIdeaFile(){
        Ideas idea = createIdea();

        System.out.print("Enter file name: ");
        String fileName = keyboard.nextLine() + ".txt";
        fileManager.createFile(idea, fileName);
        System.out.println("Idea/s saved successfully in "+ fileName +"\n");

    }

    public void addNewIdea(){
        System.out.println("What Idea file do you want to add to? ");
        System.out.print("Enter file name: ");
        String ideaFileName = keyboard.nextLine();
        Ideas idea = createIdea();
        if(ideaFileName.contains(".txt")){
            fileManager.addToFile(ideaFileName, idea);
        }else{
            String fileName = keyboard.nextLine() + ".txt";
            fileManager.addToFile(fileName, idea);
        }

    }

    public void viewIdea(){
        System.out.println("What Idea would you like to view?");
        System.out.print("Enter the file name: ");
        String title = keyboard.nextLine();

        if(title.contains(".txt")){
            fileManager.loadFile(title);
        }else{
            String fileName = title + ".txt";
            fileManager.loadFile(fileName);
        }

    }

    public void editIdea(){
        System.out.print("which Idea would you like to edit?: ");
        String ideaChoice = keyboard.nextLine();



    }

    public void deleteIdea(){

    }

}

