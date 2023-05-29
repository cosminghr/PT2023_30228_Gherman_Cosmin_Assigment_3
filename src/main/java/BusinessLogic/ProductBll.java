package BusinessLogic;

import DataAccess.ProductDAO;
import DataModel.Product;

import java.util.List;

/**
 * in aceasta clasa se vor apela metodele insert, delete, update, findById, findAll din DAO
 */
public class ProductBll {

    private ProductDAO product;

    public ProductBll(){
        product = new ProductDAO();
    }

    /**
     * se cauta un produs dupa id
     * @param ID id-ul produsul cautat
     * @return p produsul
     */
    public Product findProductById(int ID){
        Product p = (Product) product.findById(ID);
        return p;
    }

    /**
     * se cauta in baza de date, in tabelul product, toate obiectele de tipul produs
     * @return o lista de produse
     */
    public List<Product> findAll(){
        List<Product> products = product.findAll();
        return products;
    }

    /**
     * se insereaza in baza de date, in tabelul product, produsul p
     * @param p produsul
     * @return produsul
     */
    public Product insertProduct(Product p){
        List<Product> products = product.findAll();
        return product.insert(p);
    }

    /**
     * se vor actualiza campurile unui produs daca id-ul corespunde cu id-ul produsului cautat
     * @param p produsul
     * @param id id ul produsului cautat
     */
    public void updateProduct( Product p, int id){
        Product existentProduct = product.findById(id);
        if (existentProduct != null) {
            p.setID(id);
            product.update(p);
        }
    }

    /**
     * se face stergerea produsului cu id-ul cautat din baza de date
     * @param id id-ul produsului cautat
     */
    public void deleteProduct(int id){
        Product p = product.findById(id);
        if(p != null)
            product.delete(p);
    }

    public ProductDAO getProduct() {
        return product;
    }

    public void setProduct(ProductDAO product) {
        this.product = product;
    }

}
