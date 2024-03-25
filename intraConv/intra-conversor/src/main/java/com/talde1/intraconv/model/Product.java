package com.talde1.intraconv.model;

import javax.json.JsonObject;

import org.hibernate.annotations.ColumnTransformer;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/*SELECT t.name->>'es_ES' as name, COALESCE(t.list_price, 0.00) as price, COALESCE(t.Id, q.quantity, 0) as stock, t.Id FROM product_template 
t JOIN stock_quant q ON q.product_id = t.Id WHERE q.inventory_date IS NOT NULL;
*/
@Entity
@Table(name="product_template")
public class Product {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name", columnDefinition = "jsonb")
    @ColumnTransformer(write = "?::jsonb")
    private String product_name;
    @Column(name = "list_price")
    private float product_price;

    @Transient
    JsonObject nameAsJson;
    @Transient
    String nameSpanish;
    @Transient
    String nameEnglish;

    @Column(name = "categ_id")
    int categ_id = 1;
    @Column(name = "uom_id")
    int uom_id = 1;
    @Column(name = "uom_po_id")
    int uom_po_id = 1;
    @Column(name = "detailed_type")
    String detailed_type = "product";
    @Column(name = "sale_line_warn")
    String sale_line_warn = "no-message";
    @Column(name = "tracking")
    String tracking = "none";
    @Column(name = "purchase_line_warn")
    String purchase_line_warn = "no-message";
    @Column(name = "base_unit_count")
    float base_unit_count = 0.0f;
    
    /*@OneToOne
    @JoinTable(name = "stock_quant", )
    private int stock_quantity;  Probatu quantity barik, eta gero egin INNER JOIN-a anotazioan  */

    public Product() {
        
    }

    public Product(int id,JsonObject nameAsJson, float product_price) {
        this.id = id;
        this.product_price = product_price;
        this.nameAsJson = nameAsJson;
    }

    public Product(int id, String product_name, float product_price) {
        this.id = id;
        this.product_name = product_name;
        this.product_price = product_price;
        /*
        String[] names = getProductNames(product_name);
        this.nameEnglish = names[0];
        this.nameSpanish = names[1];
        */
        //this.stock_quantity = stock_quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    /*public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }*/


    @Override
    public String toString() {
        return "Product [id=" + id + ", product_price=" + product_price + ", nameEnglish=" + nameEnglish
                + ", nameSpanish=" + nameSpanish + "]";
    }


    /*
    public String[] getProductNames(JsonObject jObj){
        String engName = this.product_name.getString("en_US");
        String espName = this.product_name.getString("es_ES");

        String[] names = new String[2];
        names[0] = engName;
        names[1] = espName;
        return names;
    }

    public JsonObject setProductName(String[] names){
        JsonObject jObj = Json.createObjectBuilder()
            .add("en_US", names[0])
            .add("es_ES", names[1])
            .build();
        
        return jObj;
    }
    */

    public String getNameSpanish() {
        return nameSpanish;
    }
    public void setNameSpanish(String nameSpanish) {
        this.nameSpanish = nameSpanish;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }
}
