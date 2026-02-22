package expenseapp;
import java.util.Scanner;
import model.Expense;
import service.ExpenseService;

public class Main {
    public static void main(String[] args){
        ExpenseService expense = new ExpenseService();
        System.out.println("==EXPENSE TRACKER==");
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Remove Expense by ID");
            System.out.println("4. Show Total Expense");
            System.out.println("5. Filter Expenses by Category");
            System.out.println("6. Filter Expenses Above Amount");
            System.out.println("7. Sort Expenses by Amount");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if(choice == 0){
                System.out.println("Exiting...");
                break;
            }
            switch(choice){
                case 1 ->{
                    System.out.println("Enter ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Category:");
                    String category = sc.nextLine();
                    System.out.println("Enter Amount:");
                    double amount = sc.nextDouble();
                    System.out.println("Enter Date (YYYY-MM-DD):");
                    String dateInput = sc.next();
                    Expense expenseItem = new Expense(id,category,amount,java.time.LocalDate.parse(dateInput));
                    boolean flag = expense.addExpense(expenseItem);
                    if(flag) System.out.println("Expense added successfully!");
                    else System.out.println("Expense with id "+id+" already Exists!");

                }
                case 2 ->{
                    expense.getAllExpense().forEach(System.out::println);
                }
                case 3->{
                    System.out.println("Enter Expense ID to remove:");
                    int id = sc.nextInt();
                    expense.removeByExpenseId(id);
                    System.out.println("Expense Removed (If existed)");
                }
                case 4->{
                    double total = expense.getTotalExpense();
                    System.out.println("Total Expenditure= "+ total + " Rupees.");
                }
                case 5->{
                    sc.nextLine();
                    System.out.println("Enter category to Filter:");
                    String category = sc.nextLine();
                    expense.getExpenseByCategory(category).forEach(System.out::println);
                }
                case 6->{
                    System.out.println("Enter minimum amount:");
                    double amount = sc.nextDouble();
                    expense.getExpenseAboveAmount(amount).forEach(System.out::println);
                }
                case 7->{
                    expense.sortByAmount().forEach(System.out::println);
                }
                default ->{
                    System.out.println("Invalid Choice! Please Try again.");
                }

            }

        }sc.close();

    }
}
