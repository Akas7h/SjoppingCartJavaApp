import com.sun.org.apache.xpath.internal.operations.Or;

public class Main {
    public static void main(String[] args) {
        // create 2 different campaign with their percentage
        Campaign campaignPercentFive = new Campaign().setDiscount(5);
        Campaign campaignPercentTen = new Campaign().setDiscount(10);

        // Category food does not have any parent so set null
        Category food = new Category().setTitle("food").setParentCategory(null);

        // Create 2 different category which belong to another
        Category fruit = new Category().setTitle("fruit").setParentCategory(food).setCampaign(campaignPercentFive);
        Category vegetable = new Category().setTitle("vegetable").setParentCategory(food).setCampaign(campaignPercentTen);

        // Create 2 fruit
        Product apple = new Product().setTitle("apple").setPrice(100).setCategory(fruit);
        System.out.println("Apple price: ");
        System.out.println(apple.getPrice());
        System.out.println("-----------------");

        Product banana = new Product().setTitle("banana").setPrice(100).setCategory(fruit);
        System.out.println("Banana price: ");
        System.out.println(banana.getPrice());
        System.out.println("-----------------");

        // Create 2 vegetable
        Product carrot = new Product().setTitle("carrot").setPrice(50).setCategory(vegetable);
        System.out.println("-----------------");
        System.out.println("Carrot price: ");
        System.out.println(carrot.getPrice());
        System.out.println("-----------------");
        // Create order builder and set 2 carrots
        Order.Builder orderBuilder = Order.newBuilder().addToCart(carrot, 2);

        // Checkout so calculate final amount
        Order order1 = orderBuilder.address("Istanbul/Sisli").username("kaanozbudak").checkout();
        System.out.println("There are 2 Carrots and delivery cost: ");
        System.out.println(order1.finalAmount);
        System.out.println("-----------------");
        // Add 2 more bananas, 3 more apples
        orderBuilder.addToCart(banana, 2).addToCart(apple, 3);

        // Checkout one more and calculate final amount
        Order order2 = orderBuilder.checkout();
        System.out.println("There are 2 Carrots, 2 bananas, 3 apples and delivery cost: ");
        System.out.println(order2.finalAmount);
        System.out.println("-----------------");

        // Order details

        System.out.println("Order Owner: " + order2.username);
        System.out.println("Order Address: " + order2.address);
        System.out.println("Order Cost + Delivery Cost: " + order2.finalAmount);
    }
}
