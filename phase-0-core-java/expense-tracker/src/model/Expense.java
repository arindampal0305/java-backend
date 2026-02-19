package model;

import java.time.LocalDate;

public class Expense {
    private int id;
    private String category;
    private double amount;
    private LocalDate date;

    public Expense(int id, String category, double amount, LocalDate date){
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public int getId(){
        return id;
    }
    public String getCategory(){
        return category;
    }
    public double getAmount(){
        return amount;
    }
    public LocalDate getDate(){
        return date;
    }

    @Override
    public String toString(){
        return "Expense{" + "id=" + id +", Category='" + category+'\''+", amount="+amount+" Date="+date+'}';
    }
}
