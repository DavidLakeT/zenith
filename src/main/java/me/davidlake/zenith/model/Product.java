package me.davidlake.zenith.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "products")
@Accessors(chain = true)
@Getter
@Setter
@FilterDefs({
	@FilterDef(name = "minPriceFilter",
		parameters = {
			@ParamDef(name="minPriceParam", type=Double.class)
        }
	),
    @FilterDef(name = "maxPriceFilter",
    parameters = {
        @ParamDef(name="maxPriceParam", type=Double.class)
    }
    ),
	@FilterDef(name = "colorFilter",
		parameters = {
			@ParamDef(name="colorParam", type=String.class)
        }
	),
    @FilterDef(name = "brandFilter",
    parameters = {
        @ParamDef(name="brandParam", type=String.class)
    }
    ),
    @FilterDef(name = "freeShippingFilter",
    parameters = {
        @ParamDef(name="freeShippingParam", type=Boolean.class)
    }
    )
})
@Filters({
	@Filter(name = "minPriceFilter",
            condition = ":minPriceParam is null or price >= :minPriceParam"),
    @Filter(name = "maxPriceFilter",
        condition = ":maxPriceParam is null or price <= :maxPriceParam"),
    @Filter(name = "colorFilter",
            condition = "color = :colorParam"),
    @Filter(name = "brandFilter",
            condition = "brand = :brandParam"),
    @Filter(name = "freeShippingFilter",
            condition = "free_shipping = :freeShippingParam")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "freeShipping")
    private boolean freeShipping;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private double price;
}