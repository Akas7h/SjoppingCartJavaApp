import java.util.HashMap;
import java.util.Map;

public class Order {

    // minimum coupon cost
    private static final float minimumDiscountOrderPrice = 400;

    // cost per product
    private static final float deliveryCostPerProduct = 10;

    public String address;
    public String username;
    public float finalAmount;
    public boolean is_discounted;

    public boolean isIs_discounted() {
        return is_discounted;
    }

    public Map<Product, Integer> cart;


    // const
    public Order(String address, String username, Map<Product, Integer> cart, float finalAmount, boolean is_discounted) {
        this.address = address;
        this.username = username;
        this.cart = cart;
        this.finalAmount = finalAmount;
        this.is_discounted = is_discounted;
    }


    // create new Builder
    public static Builder newBuilder(){
        return new Builder();
    }


    static class Builder {
        private Map<Product, Integer> cart;
        private String username;
        private String address;
        float amount = 0;
        float discountAmount = 0;
        float deliveryCost = 0;
        float finalAmount = 0;
        int total_quantity = 0;
        boolean is_discounted = false;

        // set Cart as hashmap because we need product type and quantity
        public Builder() {
            cart = new HashMap<>();
        }

        public Builder addToCart(Product key, Integer value) {
            // if the product exist add quantity to that record, if not add product and quantity
            if (cart.get(key) != null){
                cart.put(key, cart.get(key) + value);
            }else {
                cart.put(key, value);
            }
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        // calculate cart price
        public Order checkout(){
            // Calculate normal price and total discount price
            cart.forEach( (_product, _quantity) -> {
                amount += _product.getPrice() * _quantity;
                discountAmount += _product.calculateDiscount() * _quantity;
                total_quantity += _quantity;
                // count how many product in the cart
            });

            deliveryCost = total_quantity * deliveryCostPerProduct;
            // if total price more than minimum coupon price set discount
            if (amount <  minimumDiscountOrderPrice) {
                finalAmount = amount + deliveryCost;
            }
            else {
                is_discounted = true;
                finalAmount = amount + deliveryCost - discountAmount ;
            }
            return new Order(address, username, cart, finalAmount, is_discounted);
        }
    }

}
