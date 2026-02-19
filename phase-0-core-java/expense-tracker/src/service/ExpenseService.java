package service;
import model.Expense;
import java.util.List;
import java.util.ArrayList;


public class ExpenseService {
    List<Expense> expense = new ArrayList<>();

    public void addExpense(Expense e){
        expense.add(e);
    }
    public void removeByExpenseId(int id){
        expense.removeIf(expense -> expense.getId()==id);
    }
    public List<Expense> getAllExpense(){
        return expense;
    }
    public double getTotalExpense(){
        return expense.stream().map(Expense::getAmount).reduce(0.0, Double::sum);
        /*
        map -> extracts amount from each expense
        reduce -> adds all amounts
        0.0 -> starting value from 0.0
        */
    }
    public List<Expense> getExpenseByCategory(String category){
        return expense.stream().filter(expense -> expense.getCategory().equalsIgnoreCase(category)).toList();
        // equalsIgnoreCase -> so that 'food' and 'Food' both work.
    }
    public List<Expense> getExpenseAboveAmount(double amount){
        return expense.stream().filter(expense-> expense.getAmount() > amount).toList();
    }
    public List<Expense> sortByAmount(){
        return expense.stream().sorted((e1,e2)-> Double.compare(e1.getAmount(), e2.getAmount())).toList();
    }

}
