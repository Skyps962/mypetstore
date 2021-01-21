package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Product;

import java.util.List;

public interface ProductDAO {
    public List<Product> getProductListByCategory(String categoryId);

    public Product getProduct(String productId);

    public List<Product> searchProductList(String keywords);
}
