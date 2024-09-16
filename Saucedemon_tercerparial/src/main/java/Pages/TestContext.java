package Pages;

import java.util.ArrayList;
import java.util.List;

public class TestContext {
    private List<String> productNames = new ArrayList<>();

    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }

    public void addProductName(String productName) {
        this.productNames.add(productName);
    }
}
