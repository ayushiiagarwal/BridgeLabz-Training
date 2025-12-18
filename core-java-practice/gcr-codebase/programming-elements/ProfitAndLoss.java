// calculate profit and loss in a number and percentage based on the cost price of INR 129 and 
// the selling price of INR 191. (Use a single line statement to dislay multiline text and variables.)
public class ProfitAndLoss {
    public static void main(String[] args) {
        double costPrice = 129.0;
        double sellingPrice = 191.0;

        if (sellingPrice > costPrice) {
            double profit = sellingPrice - costPrice;
            double profitPercent = (profit / costPrice) * 100;
            
            System.out.println("The Cost Price is INR " + costPrice + " and The Selling Price is INR " + sellingPrice +
                               "\nThe Profit is INR " + profit + " and the Profit Percentage is " + profitPercent + "%");
        } else if (costPrice > sellingPrice) {
            double loss = costPrice - sellingPrice;
            double lossPercent = (loss / costPrice) * 100;
            System.out.println("The Cost Price is INR " + costPrice + " and The Selling Price is INR " + sellingPrice +
                               "\nThe Loss is INR " + loss + " and the Loss Percentage is " + lossPercent + "%");
        } else {
            System.out.println("No Profit No Loss");
        }
    }
}
